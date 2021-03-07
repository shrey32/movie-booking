package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public interface DataByEventRepository<T> {

	List<T> findAllByEventId(Long eventId);
	
}
