package com.shrey.moviebooking.theatreservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Address;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAllByCity(String city);

	List<Address> findAllByPincode(String pincode);

}
