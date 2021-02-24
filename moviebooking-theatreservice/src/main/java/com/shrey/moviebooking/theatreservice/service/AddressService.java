package com.shrey.moviebooking.theatreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.model.Address;

/**
 * 
 * @author Shrey
 *
 */
public interface AddressService {

	Address add(Address address);

	Optional<Address> findById(Long id);

	boolean deleteById(Long id);

	Address update(Address address);
	
	List<Address> findAllByCity(String city);
	
	List<Address> findAllByPincode(String pincode);
}
