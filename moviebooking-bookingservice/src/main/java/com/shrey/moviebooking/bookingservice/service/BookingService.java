package com.shrey.moviebooking.bookingservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.bookingservice.models.Booking;

/**
 * 
 * @author Shrey
 *
 */
public interface BookingService {

	Booking create(Booking booking);

	Optional<Booking> findById(Long id);

	boolean deleteById(Long id);

	Optional<Booking> cancelBooking(Long bookingId);

	List<Booking> findByUserId(Long userId);
	
	List<Booking> findByTheatreId(Long theatreId);
}
