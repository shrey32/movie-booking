package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.coreservice.models.TheatreContact;

/**
 * 
 * @author Shrey
 *
 */
public interface TheatreContactService {

	TheatreContact add(TheatreContact theatreContact);

	Optional<TheatreContact> findById(Long id);

	boolean deleteById(Long id);

	List<TheatreContact> findAllByTheatreId(Long theatreId);

}
