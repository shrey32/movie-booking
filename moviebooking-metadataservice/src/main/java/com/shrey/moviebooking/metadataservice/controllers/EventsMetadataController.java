package com.shrey.moviebooking.metadataservice.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.moviebooking.metadataservice.models.EventMetaData;
import com.shrey.moviebooking.metadataservice.service.EventMetaDataService;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/metadataservice/events")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventsMetadataController {

	private static final Logger log = LoggerFactory.getLogger(EventsMetadataController.class);

	@Autowired
	private EventMetaDataService eventMetaDataService;

	@PostMapping
	public ResponseEntity<EventMetaData> addEventMetaData(@Valid @RequestBody Optional<EventMetaData> eventMetaData) {
		log.info("Request to Add " + EventMetaData.class + " Arrived");
		if (eventMetaData.isEmpty())
			return new ResponseEntity<EventMetaData>(HttpStatus.BAD_REQUEST);

		EventMetaData metadata = eventMetaData.get();

		log.info(EventMetaData.class + "{ " + metadata + "}");

		metadata = eventMetaDataService.add(metadata);

		return new ResponseEntity<EventMetaData>(metadata, HttpStatus.OK);
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<EventMetaData> getMetaDataByEventId(@PathVariable long eventId) {
		log.info("finding movie by {" + eventId + "}");
		Optional<EventMetaData> metadata = this.eventMetaDataService.findByEventId(eventId);
		if (metadata.isPresent()) {
			log.info("Event MetaData found!!! {" + metadata.get() + "}");
			return new ResponseEntity<EventMetaData>(metadata.get(), HttpStatus.OK);
		}
		return new ResponseEntity<EventMetaData>(HttpStatus.NOT_FOUND);
	}

}
