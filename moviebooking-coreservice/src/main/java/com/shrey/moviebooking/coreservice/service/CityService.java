package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.City;

/**
 * 
 * @author Shrey
 *
 */
public interface CityService {

	City add(City city);

	Optional<City> findById(Long id);

	boolean deleteById(Long id);

	City update(City city);

	List<City> findAll();

	List<City> findAllByName(String name);

	List<City> findAllByPincode(String pincode);
}
