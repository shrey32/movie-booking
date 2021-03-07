package com.shrey.moviebooking.coreservice.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.moviebooking.coreservice.dto.EventDTO;
import com.shrey.moviebooking.coreservice.enums.EventType;
import com.shrey.moviebooking.coreservice.models.Event;
import com.shrey.moviebooking.coreservice.service.EventDTOService;
import com.shrey.moviebooking.coreservice.service.EventMetaDataService;
import com.shrey.moviebooking.coreservice.service.EventService;
import com.shrey.moviebooking.coreservice.validation.EventDTOValidator;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/coreservice/events")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventsController {

	private static final Logger log = LoggerFactory.getLogger(EventsController.class);

	@Autowired
	private EventService eventService;

	@Autowired
	private EventDTOService eventDTOService;

	@Autowired
	private EventMetaDataService eventMetaDataService;

	@Autowired
	private EventDTOValidator eventDTOValidator;

	@PostMapping
	public ResponseEntity<EventDTO> create(@Valid @RequestBody Optional<EventDTO> eventDTO) {
		if (eventDTO.isEmpty())
			return new ResponseEntity<EventDTO>(HttpStatus.BAD_REQUEST);

		log.info("Request to create new Event Arrived");

		this.eventDTOValidator.validate(eventDTO.get());

		Map<String, Object> metadata = eventDTO.get().getEventMetaData();

		EventDTO newEvent = this.eventDTOService.add(eventDTO.get());

		metadata = eventMetaDataService.add(newEvent.getEvent(), metadata);

		newEvent.setEventMetaData(metadata);

		return new ResponseEntity<EventDTO>(newEvent, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Event> update(@Valid @RequestBody Optional<Event> event) {
		if (event.isEmpty() || event.get().getId() <= 0)
			return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);

		log.info("Request to update Event Arrived event id {" + event.get().getId() + "}");

		Event newEvent = this.eventService.add(event.get());

		return new ResponseEntity<Event>(newEvent, HttpStatus.OK);
	}

	@GetMapping("/cityId}")
	public List<Event> getAllEventsByCity(@PathVariable long cityId) {
		List<Event> events = this.eventService.findAllByCityId(cityId);
		log.info("Event List size is " + events.size() + ", for city Id " + cityId);
		return events;
	}

	@GetMapping("/city/{cityId}/{eventType}")
	public List<Event> getAllEventsByCity(@PathVariable long cityId, @PathVariable EventType eventType) {
		List<Event> events = this.eventService.findAllByCityIdAndEventType(cityId, eventType);
		log.info("Event List size is " + events.size() + ", for city Id " + cityId + " and event Type " + eventType);
		return events;
	}

}
