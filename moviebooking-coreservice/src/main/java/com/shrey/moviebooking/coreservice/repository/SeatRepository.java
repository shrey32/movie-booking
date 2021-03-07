package com.shrey.moviebooking.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.coreservice.models.Seat;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface SeatRepository
		extends JpaRepository<Seat, Long>, DataByTheatreRepository<Seat>, DataByScreenRepository<Seat> {

}
