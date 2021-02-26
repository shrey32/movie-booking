package com.shrey.moviebooking.theatreservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.moviebooking.commons.model.City;
import com.shrey.moviebooking.theatreservice.service.CityService;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/theatreservice/cities")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {

	private static final Logger log = LoggerFactory.getLogger(CityController.class);

	@Autowired
	private CityService cityService;

	@GetMapping
	public List<City> getAllCities() {
		List<City> cities = this.cityService.findAll();
		log.info("City List size " + cities.size());
		return cities;
	}

}
