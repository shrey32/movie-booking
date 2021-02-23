package com.shrey.moviebooking.movieservice.service;

import java.util.Optional;

import com.shrey.moviebooking.commons.dto.MovieDTO;

/**
 * 
 * @author Shrey
 *
 */
public interface MovieDTOService {

	MovieDTO add(MovieDTO movieDTO);

	Optional<MovieDTO> findById(Long id);

}
