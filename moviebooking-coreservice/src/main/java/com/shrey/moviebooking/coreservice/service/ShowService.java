package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.coreservice.models.Show;

/**
 * 
 * @author Shrey
 *
 */
public interface ShowService {

	Show add(Show show);

	Optional<Show> findById(Long showId);

	boolean deleteById(Long showId);

	List<Show> findAllByScreenId(Long screenId);
	
	List<Show> findAllByTheatreId(Long theatreId);
	
	List<Show> findAllByEventId(Long eventId);
	
	List<Show> findAllByEventIdAndTheatreId(Long eventId, Long theatreId);
}
