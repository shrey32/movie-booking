package com.shrey.moviebooking.metadataservice.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shrey.moviebooking.metadataservice.enums.ResourceType;
import com.shrey.moviebooking.metadataservice.service.ImageUploadService;

@RestController()
@RequestMapping("/metadataservice/image")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventImageUploadController {

	private static final Logger log = LoggerFactory.getLogger(EventImageUploadController.class);

	@Autowired
	private ImageUploadService imageUploadService;

	@PostMapping("/{eventId}/{eventName}/{resourceType}")
	public ResponseEntity<String> uploadEventResource(@RequestPart(value = "file") MultipartFile file, @PathVariable Long eventId,
			@PathVariable String eventName, @PathVariable ResourceType resourceType) {
		log.info("Request to upload " + resourceType + " for {" + eventId + "," + eventName + "} arrived");

		Optional<String> resourcePath = this.imageUploadService.upload(eventId, eventName, resourceType, file);

		if (resourcePath.isPresent())
			return new ResponseEntity<String>(resourcePath.get(), HttpStatus.CREATED);
		return new ResponseEntity<String>(resourcePath.get(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
