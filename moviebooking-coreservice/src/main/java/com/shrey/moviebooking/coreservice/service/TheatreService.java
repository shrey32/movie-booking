package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.coreservice.models.Theatre;

/**
 * 
 * @author Shrey
 *
 */
public interface TheatreService {

	Theatre add(Theatre theatre);
	
	Optional<Theatre> findById(Long theatreId);

	boolean deleteById(Long theatreId);
	
	List<Theatre> findAllByCityId(Long cityId);
	
	
}
