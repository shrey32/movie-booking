package com.shrey.moviebooking.bookingservice.validation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shrey.moviebooking.commons.dto.BookingDTO;
import com.shrey.moviebooking.commons.exception.InvalidBookingException;
import com.shrey.moviebooking.commons.validator.Validator;

/**
 * 
 * @author Shrey
 *
 */
@Component
@Qualifier("bookingDTOValidator")
public class BookingDTOValidator implements Validator<BookingDTO> {

	@Override
	public boolean validate(BookingDTO bookingDTO) {

		if (bookingDTO.getBooking() == null)
			throw new InvalidBookingException("No or Empty Booking Found");
		if (bookingDTO.getBooking().getAmount() <= 0)
			throw new InvalidBookingException("Booking Amount is Invalid");
		if (bookingDTO.getBookedSeats().isEmpty())
			throw new InvalidBookingException("Booking should have one or more seats");
		return true;
	}

}
