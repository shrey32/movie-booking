package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

/**
 * 
 * @author Shrey
 *
 * @param <T>
 */
public interface DataByCityRepository<T> {

	List<T> findAllByCityId(Long cityId);

}
