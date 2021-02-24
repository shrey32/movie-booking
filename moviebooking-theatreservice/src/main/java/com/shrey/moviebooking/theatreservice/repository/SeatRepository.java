package com.shrey.moviebooking.theatreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Seat;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface SeatRepository
		extends JpaRepository<Seat, Long>, DataByTheatreRepository<Seat>, DataByScreenRepository<Seat> {

}
