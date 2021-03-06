package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 * @param <T>
 */
public interface DataByScreenRepository<T> {

	List<T> findAllByScreenId(Long screenId);

}
