package com.shrey.moviebooking.bookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Booking;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByUserId(Long userId);

	List<Booking> findByTheatreId(Long theatreId);

}
