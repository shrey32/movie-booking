package com.shrey.moviebooking.theatreservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.Address;
import com.shrey.moviebooking.commons.model.Theatre;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class TheatreByAddressServiceImpl implements TheatreByAddressService {

	private AddressService addressService;
	private TheatreService theatreService;

	@Autowired
	public TheatreByAddressServiceImpl(TheatreService theatreService, AddressService addressService) {
		this.addressService = addressService;
		this.theatreService = theatreService;
	}

	@Override
	public List<Theatre> findAllTheatreByAddress(String address) {

		List<Address> addressByCity = this.addressService.findAllByCity(address);
		List<Address> addressByPincode = this.addressService.findAllByPincode(address);

		List<Long> idList = ids(addressByCity);
		idList.addAll(ids(addressByPincode));

		Iterable<Long> idIterable = idList;

		return this.theatreService.findAllByAdressId(idIterable);
	}

	private List<Long> ids(List<Address> addresses) {
		return addresses.stream().map(Address::getId).collect(Collectors.toList());
	}

}
