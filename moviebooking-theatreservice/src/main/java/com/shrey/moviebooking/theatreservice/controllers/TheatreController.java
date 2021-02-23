package com.shrey.moviebooking.theatreservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/theatreservice/theatres")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TheatreController {

	private static final Logger log = LoggerFactory.getLogger(TheatreController.class);
	
}
