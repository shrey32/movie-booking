package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.Seat;

/**
 * 
 * @author Shrey
 *
 */
public interface SeatService {

	Seat add(Seat seat);

	Optional<Seat> findById(Long seatId);

	boolean deleteById(Long seatId);

	List<Seat> findAllByScreenId(Long screenId);

	List<Seat> findAllByTheatreId(Long theatreId);

}
