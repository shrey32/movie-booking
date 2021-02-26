package com.shrey.moviebooking.theatreservice.controllers;

import java.util.List;
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

import com.shrey.moviebooking.commons.dto.TheatreDTO;
import com.shrey.moviebooking.commons.model.Theatre;
import com.shrey.moviebooking.theatreservice.service.TheatreDTOService;
import com.shrey.moviebooking.theatreservice.service.TheatreService;
import com.shrey.moviebooking.theatreservice.validation.TheatreDTOValidator;

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

	@Autowired
	private TheatreDTOService theatreDTOService;

	@Autowired
	private TheatreService theatreService;

	@Autowired
	private TheatreDTOValidator theatreDTOValidator;

	@PostMapping
	public ResponseEntity<TheatreDTO> create(@Valid @RequestBody Optional<TheatreDTO> theatreDTO) {
		if (theatreDTO.isEmpty())
			return new ResponseEntity<TheatreDTO>(HttpStatus.BAD_REQUEST);

		log.info("Request arrived to create new Theatre");
		TheatreDTO theatreDTObj = theatreDTO.get();

		theatreDTOValidator.validate(theatreDTObj);

		log.info("Request to create new Theatre is validated");

		theatreDTObj = theatreDTOService.create(theatreDTObj);

		return new ResponseEntity<TheatreDTO>(theatreDTObj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<TheatreDTO> update(@Valid @RequestBody Optional<TheatreDTO> theatreDTO) {
		if (theatreDTO.isEmpty())
			return new ResponseEntity<TheatreDTO>(HttpStatus.BAD_REQUEST);

		log.info("Request arrived to update existing Theatre");
		TheatreDTO theatreDTObj = theatreDTO.get();

		theatreDTOValidator.validate(theatreDTObj);

		log.info("Request to update existing Theatre is validated");

		theatreDTObj = theatreDTOService.update(theatreDTObj);

		return new ResponseEntity<TheatreDTO>(theatreDTObj, HttpStatus.OK);
	}

	@GetMapping("/city/{cityId}")
	public List<Theatre> findAllByCityId(@PathVariable Long cityId) {
		log.info("Request arrived to find all the theatres by CityId {" + cityId + "}");
		return this.theatreService.findAllByCityId(cityId);
	}

}
