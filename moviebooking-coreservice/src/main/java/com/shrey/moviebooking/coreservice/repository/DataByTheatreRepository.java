package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 * @param <T>
 */
public interface DataByTheatreRepository<T> {

	List<T> findAllByTheatreId(Long theatreId);

}
