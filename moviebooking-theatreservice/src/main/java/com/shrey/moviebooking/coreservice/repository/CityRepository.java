package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.City;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findAllByName(String name);

	List<City> findAllByPincode(String pincode);

}
