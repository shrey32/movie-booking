package com.shrey.moviebooking.movieservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.Movie;

/**
 * 
 * @author Shrey
 *
 */
public interface MovieService {

	Movie add(Movie movie);

	boolean delete(Long id);

	Optional<Movie> findById(Long id);

	List<Movie> findAll();
}
