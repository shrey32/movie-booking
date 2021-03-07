package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.coreservice.enums.EventType;
import com.shrey.moviebooking.coreservice.models.Event;

/**
 * 
 * @author Shrey
 *
 */
public interface EventService {

	Event add(Event event);

	Optional<Event> findById(Long id);

	boolean deleteById(Long id);

	List<Event> findAllByCityId(Long cityId);

	List<Event> findAllByCityIdAndEventType(Long cityId, EventType eventType);
}
