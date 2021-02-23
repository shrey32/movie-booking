package com.shrey.moviebooking.movieservice.service;

import java.util.Optional;

/**
 * 
 * @author Shrey
 *
 * @param <T>
 */
public interface MovieDetailsService<T> {

	T add(T t);
	
	Optional<T> findById(long id);
	
}
