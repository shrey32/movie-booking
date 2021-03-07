package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.coreservice.dto.TheatreDTO;
import com.shrey.moviebooking.coreservice.models.Theatre;

/**
 * 
 * @author Shrey
 *
 */
public interface TheatreDTOService {

	TheatreDTO create(TheatreDTO theatreDTO);

	Optional<TheatreDTO> findById(Long id);

	TheatreDTO update(TheatreDTO theatreDTO);
	
	List<Theatre> findAllByCityAndEvent(Long cityId,Long eventId);
}
