package com.shrey.moviebooking.theatreservice.repository;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 * @param <T>
 */
public interface DataByTheatreRepository<T> {

	List<T> findByAllByTheatreId(Long theatreId);

}
