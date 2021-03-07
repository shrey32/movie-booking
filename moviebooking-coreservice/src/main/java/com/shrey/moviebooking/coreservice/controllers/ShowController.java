package com.shrey.moviebooking.coreservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.moviebooking.coreservice.models.Show;
import com.shrey.moviebooking.coreservice.service.ShowService;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/coreservice/theatres")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShowController {

	private static final Logger log = LoggerFactory.getLogger(ShowController.class);

	@Autowired
	private ShowService showService;

	@GetMapping("/event/{eventId}/theatreId")
	private List<Show> findAllByEventIdAndTheatreId(@PathVariable Long eventId,@PathVariable Long theatreId) {
		log.info("Request arrived to find all the shows by EventId {" + eventId + "} And TheatreId {"+theatreId+"}");
		return this.showService.findAllByEventIdAndTheatreId(eventId, theatreId);
	}
}
