package com.shrey.moviebooking.coreservice.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.moviebooking.commons.model.Show;

@RestController()
@RequestMapping("/theatreservice/shows")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShowController {

	private static final Logger log = LoggerFactory.getLogger(ShowController.class);

	
	
	

}
