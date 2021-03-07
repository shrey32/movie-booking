package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public interface FindByMovieRepository<T> {

	List<T> findAllByMovieId(Long movieId);
	
}
