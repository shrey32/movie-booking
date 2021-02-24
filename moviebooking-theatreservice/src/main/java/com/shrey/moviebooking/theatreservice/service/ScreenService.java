package com.shrey.moviebooking.theatreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.Screen;

/**
 * 
 * @author Shrey
 *
 */
public interface ScreenService {

	Screen add(Screen screen);

	Optional<Screen> findById(Long screenId);

	boolean deleteById(Long screenId);

	List<Screen> findAllByTheatreId(Long theatreId);
	
}
