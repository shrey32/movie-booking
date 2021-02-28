package com.shrey.moviebooking.coreservice.validation;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shrey.moviebooking.commons.exception.InvalidRequestException;
import com.shrey.moviebooking.commons.model.Event;
import com.shrey.moviebooking.commons.validator.Validator;

/**
 * 
 * @author Shrey
 *
 */
@Component
@Qualifier("eventValidator")
public class EventValidator implements Validator<Event> {

	@Override
	public boolean validate(Event event) {

		if (event == null)
			throw new InvalidRequestException("Emtpy Request Found");
		if (StringUtils.isEmpty(event.getName()))
			throw new InvalidRequestException("Name can't be empty");
		if (event.getStartTime() == null)
			throw new InvalidRequestException("Start/Release Date can't be null");
		if (new Date().before(event.getStartTime()) || new Date().equals(event.getStartTime()))
			throw new InvalidRequestException("Event Should have a Start/Release Date from Tomorrow");
		if (event.getDurationInMinutes() < 10)
			throw new InvalidRequestException("Event should have duration of more than 10 minutes");
		return true;
	}

}
