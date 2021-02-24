package com.shrey.moviebooking.theatreservice.service;

import java.util.Optional;

import com.shrey.moviebooking.commons.dto.TheatreDTO;

/**
 * 
 * @author Shrey
 *
 */
public interface TheatreDTOService {

	TheatreDTO create(TheatreDTO theatreDTO);

	Optional<TheatreDTO> findById(Long id);

	TheatreDTO update(TheatreDTO theatreDTO);
}
