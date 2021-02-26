package com.shrey.moviebooking.theatreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.enums.EventType;
import com.shrey.moviebooking.commons.model.Event;
import com.shrey.moviebooking.theatreservice.repository.EventsRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class EventServiceImpl implements EventService {

	private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);

	private EventsRepository eventsRepository;

	@Autowired
	public EventServiceImpl(EventsRepository eventsRepository) {
		this.eventsRepository = eventsRepository;
	}

	@Override
	public Event add(Event event) {
		log.info("Adding new " + Event.class + " {" + event + "}");
		event.setCreated(new Date());
		Optional<Event> addedEvent = this.findById(event.getId());
		if (addedEvent.isPresent()) {
			log.info("Updating existing " + Event.class + "with id {" + event.getId() + "}");
			event.setCreated(addedEvent.get().getCreated());
			event.setUpdated(new Date());
		}
		return this.eventsRepository.save(event);
	}

	@Override
	public Optional<Event> findById(Long id) {
		log.info("finding " + Event.class + " with id {" + id + "}");
		return this.eventsRepository.findById(id);
	}

	@Override
	public boolean deleteById(Long id) {
		log.info("deleting " + Event.class + " with id {" + id + "}");
		this.eventsRepository.deleteById(id);
		return this.findById(id).isEmpty();
	}

	@Override
	public List<Event> findAllByCityId(Long cityId) {
		log.info("finding " + Event.class + " List with CityId {" + cityId + "}");
		return this.eventsRepository.findAllByCityId(cityId);
	}

	@Override
	public List<Event> findAllByCityIdAndEventType(Long cityId, EventType eventType) {
		log.info("finding " + Event.class + " List with CityId {" + cityId + "} And EventType {" + eventType + "}");
		return this.eventsRepository.findAllByCityIdAndEventType(cityId, eventType);
	}

}
