package com.shrey.moviebooking.bookingservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.BookedSeat;

/**
 * 
 * @author Shrey
 *
 */
public interface BookedSeatService {

	BookedSeat create(BookedSeat bookedSeat);

	Optional<BookedSeat> findById(Long id);

	boolean deleteById(Long id);

	List<BookedSeat> findAllByBookingId(Long bookingId);
}
