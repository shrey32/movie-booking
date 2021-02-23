package com.shrey.moviebooking.bookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrey.moviebooking.commons.model.BookedSeat;

/**
 * 
 * @author Shrey
 *
 */
public interface BookedSeatRepository extends JpaRepository<BookedSeat, Long> {

	List<BookedSeat> findAllByBookingId(Long bookingId);
	
}
