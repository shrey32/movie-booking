package com.shrey.moviebooking.coreservice.service;

import java.util.Map;
import java.util.Optional;

import com.shrey.moviebooking.coreservice.models.Event;

/**
 * 
 * @author Shrey
 *
 */
public interface EventMetaDataService {

	Map<String, Object> add(Event event, Map<String, Object> eventMetaData);

	Optional<Map<String, Object>> findByEventId(Long eventId);
}
