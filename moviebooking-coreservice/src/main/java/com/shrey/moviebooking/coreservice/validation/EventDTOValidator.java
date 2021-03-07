package com.shrey.moviebooking.coreservice.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shrey.moviebooking.coreservice.dto.EventDTO;
import com.shrey.moviebooking.commons.exception.InvalidRequestException;
import com.shrey.moviebooking.commons.utils.DateUtils;
import com.shrey.moviebooking.commons.validator.Validator;

/**
 * 
 * @author Shrey
 *
 */
@Component
@Qualifier("eventDTOValidator")
public class EventDTOValidator implements Validator<EventDTO> {

	@Override
	public boolean validate(EventDTO event) {

		if (event.getEvent() == null)
			throw new InvalidRequestException("Emtpy Request Found");
		if (StringUtils.isEmpty(event.getEvent().getName()))
			throw new InvalidRequestException("Name can't be empty");
		if (event.getEvent().getStartDate() == null)
			throw new InvalidRequestException("Start/Release Date can't be null");
		if (DateUtils.timeAfterMinutes(0).isAfter(event.getEvent().getStartDate())
				|| DateUtils.timeAfterHours(0).equals(event.getEvent().getStartDate()))
			throw new InvalidRequestException("Event Should have a Start/Release Date from Tomorrow");
		if (event.getEvent().getDurationInMinutes() < 10)
			throw new InvalidRequestException("Event should have duration of more than 10 minutes");
		if (StringUtils.isEmpty(event.getCity().getName()))
			throw new InvalidRequestException("Event City Not Found");

		return true;
	}

}
