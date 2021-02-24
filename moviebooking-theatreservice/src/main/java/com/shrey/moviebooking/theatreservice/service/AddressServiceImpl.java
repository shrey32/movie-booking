package com.shrey.moviebooking.theatreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.Address;
import com.shrey.moviebooking.theatreservice.repository.AddressRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	private AddressRepository addressRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public Address add(Address address) {
		log.info("Adding new " + Address.class + " {" + address + "}");
		address.setCreated(new Date());
		return this.addressRepository.save(address);
	}

	@Override
	public Optional<Address> findById(Long id) {
		log.info("finding " + Address.class + " By Id {" + id + "}");
		return this.addressRepository.findById(id);
	}

	@Override
	public boolean deleteById(Long id) {
		log.info("Deleting " + Address.class + " By Id {" + id + "}");
		this.addressRepository.deleteById(id);
		return this.findById(id).isEmpty();
	}

	@Override
	public Address update(Address address) {
		log.info("Updating " + Address.class + " {" + address + "}");
		Optional<Address> optionalAddress = this.findById(address.getId());
		if (optionalAddress.isPresent()) {
			log.info("Found " + Address.class + " {" + address.getId() + "}");
			address.setId(optionalAddress.get().getId());
			address.setCreated(optionalAddress.get().getCreated());
			address.setUpdated(new Date());
			return this.add(address);
		}
		return null;
	}

	@Override
	public List<Address> findAllByCity(String city) {
		log.info("finding All " + Address.class + " By city {" + city + "}");
		return this.addressRepository.findAllByCity(city.trim());
	}

	@Override
	public List<Address> findAllByPincode(String pincode) {
		log.info("finding All " + Address.class + " By pincode {" + pincode + "}");
		return this.addressRepository.findAllByPincode(pincode.trim());
	}

}
