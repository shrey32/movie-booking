package com.shrey.moviebooking.movieservice.repository;

import java.util.Optional;

/**
 * 
 * @author Shrey
 *
 */
public interface FindByNameRepository<T> {

	Optional<T> findByName(String name);
	
}
