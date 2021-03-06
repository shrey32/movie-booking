package com.shrey.moviebooking.coreservice.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shrey.moviebooking.coreservice.dto.TheatreDTO;
import com.shrey.moviebooking.coreservice.enums.ContactType;
import com.shrey.moviebooking.commons.exception.InvalidRequestException;
import com.shrey.moviebooking.coreservice.models.Contact;
import com.shrey.moviebooking.commons.utils.MovieBookingUtility;
import com.shrey.moviebooking.commons.validator.Validator;

/**
 * 
 * @author Shrey
 *
 */
@Component
@Qualifier("theatreDTOValidator")
public class TheatreDTOValidator implements Validator<TheatreDTO> {

	@Override
	public boolean validate(TheatreDTO theatreDTO) {

		if (theatreDTO == null)
			throw new InvalidRequestException("Empty request found!");
		if (theatreDTO.getTheatre() == null)
			throw new InvalidRequestException("No Theatre Found in the request");
		if (theatreDTO.getCity() == null)
			throw new InvalidRequestException("Theatre Address is not found");
		if (StringUtils.isEmpty(theatreDTO.getTheatre().getName()))
			throw new InvalidRequestException("No Theatre Name is not found");
		if (theatreDTO.getContacts().isEmpty())
			throw new InvalidRequestException("No Theatre Contact, Add atleast one Contact");
		if (StringUtils.isEmpty(theatreDTO.getCity().getName()))
			throw new InvalidRequestException("Theatre City Name is blank!");
		if (StringUtils.isEmpty(theatreDTO.getCity().getCountry()))
			throw new InvalidRequestException("Theatre Country is blank!");
		if (StringUtils.isEmpty(theatreDTO.getCity().getPincode()))
			throw new InvalidRequestException("Theatre Pincode is blank!");

		for (Contact contact : theatreDTO.getContacts()) {
			if (StringUtils.isEmpty(contact.getContact()))
				throw new InvalidRequestException("One or More contacts have empty fields!");
			if (ContactType.EMAIL == contact.getContactType() && MovieBookingUtility.isValidEmail(contact.getContact()))
				throw new InvalidRequestException("Invalid email address!");
			if (ContactType.MOBILE == contact.getContactType()
					&& MovieBookingUtility.isValidMobileNumber(contact.getContact()))
				throw new InvalidRequestException("Invalid Mobile address!");
		}

		return true;
	}

}
