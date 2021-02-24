package com.shrey.moviebooking.bookingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.dto.BookingDTO;
import com.shrey.moviebooking.commons.model.BookedSeat;
import com.shrey.moviebooking.commons.model.Booking;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class BookingDTOServiceImpl implements BookingDTOService {

	private BookingService bookingService;
	private BookedSeatService bookedSeatService;

	@Autowired
	public BookingDTOServiceImpl(BookingService bookingService, BookedSeatService bookedSeatService) {
		this.bookingService = bookingService;
		this.bookedSeatService = bookedSeatService;
	}

	@Override
	@Transactional
	public BookingDTO create(BookingDTO bookingDTO) {

		Booking booking = this.bookingService.create(bookingDTO.getBooking());

		// saving seats
		for (BookedSeat bookedSeat : bookingDTO.getBookedSeats()) {			
			bookedSeat.setBookingId(booking.getId());
			BookedSeat newBookedSeat = this.bookedSeatService.create(bookedSeat);
			bookedSeat.setId(newBookedSeat.getId());
		}

		bookingDTO.setBooking(booking);

		return bookingDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<BookingDTO> findById(Long id) {
		Optional<Booking> optionalBooking = this.bookingService.findById(id);
		if (optionalBooking.isPresent()) {
			BookingDTO bookingDTO = new BookingDTO();
			bookingDTO.setBooking(optionalBooking.get());
			List<BookedSeat> bookedSeats = this.bookedSeatService.findAllByBookingId(id);
			bookingDTO.setBookedSeats(bookedSeats);
			return Optional.of(bookingDTO);
		}
		return Optional.empty();
	}

}
