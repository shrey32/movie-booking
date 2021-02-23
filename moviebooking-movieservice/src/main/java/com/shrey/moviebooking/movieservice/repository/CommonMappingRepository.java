package com.shrey.moviebooking.movieservice.repository;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public interface CommonMappingRepository<T> {

	List<T> findAllByMovieId(Long movieId);
	
}
