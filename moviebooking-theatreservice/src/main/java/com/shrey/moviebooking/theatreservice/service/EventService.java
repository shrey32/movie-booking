package com.shrey.moviebooking.theatreservice.service;

import java.util.List;
import java.util.Optional;

import com.shrey.moviebooking.commons.enums.EventType;
import com.shrey.moviebooking.commons.model.Event;

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
