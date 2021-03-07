package com.shrey.moviebooking.coreservice.service;

import java.util.Optional;

import com.shrey.moviebooking.coreservice.dto.EventDTO;

/**
 * 
 * @author Shrey
 *
 */
public interface EventDTOService {

	EventDTO add(EventDTO eventDTO);

	Optional<EventDTO> findById(Long id);
}
