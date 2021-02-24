package com.shrey.moviebooking.theatreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.Show;

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
	
}
