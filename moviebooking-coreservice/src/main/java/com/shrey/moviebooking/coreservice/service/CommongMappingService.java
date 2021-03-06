package com.shrey.moviebooking.coreservice.service;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 * @param <T>
 */
public interface CommongMappingService<T> {

	T add(T movieCast);

	List<T> findAllByMovieId(Long movieId);

}
