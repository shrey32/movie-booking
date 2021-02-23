package com.shrey.moviebooking.theatreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.Theatre;

/**
 * 
 * @author Shrey
 *
 */
public interface TheatreServiceImpl {

	Theatre add(Theatre theatre);
	
	Optional<Theatre> findById(Long theatreId);

	boolean deleteById(Long theatreId);

	List<Theatre> findAllByAddressId(Long addressId);
}
