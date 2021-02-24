package com.shrey.moviebooking.theatreservice.service;

import java.util.List;

import com.shrey.moviebooking.commons.model.Theatre;

/**
 * 
 * @author Shrey
 *
 */
public interface TheatreByAddressService {

	List<Theatre> findAllTheatreByAddress(String address);

}
