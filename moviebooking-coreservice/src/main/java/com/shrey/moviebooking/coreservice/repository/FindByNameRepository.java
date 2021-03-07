package com.shrey.moviebooking.coreservice.repository;

import java.util.Optional;

/**
 * 
 * @author Shrey
 *
 */
public interface FindByNameRepository<T> {

	Optional<T> findByName(String name);
	
}
