package com.shrey.moviebooking.movieservice.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.moviebooking.commons.dto.MovieDTO;
import com.shrey.moviebooking.commons.model.Movie;
import com.shrey.moviebooking.commons.validator.Validator;
import com.shrey.moviebooking.movieservice.service.MovieDTOService;
import com.shrey.moviebooking.movieservice.service.MovieService;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/movieservice/movies")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MoviesController {

	private static final Logger logger = LoggerFactory.getLogger(MoviesController.class);

	@Autowired
	private MovieDTOService movieDTOService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private Validator<MovieDTO> movieDTOValidator;

	@PostMapping
	public ResponseEntity<MovieDTO> createNewMovie(@Valid @RequestBody Optional<MovieDTO> optionalMovieDTO) {

		if (optionalMovieDTO.isEmpty())
			return new ResponseEntity<MovieDTO>(HttpStatus.BAD_REQUEST);
		MovieDTO movieDTO = optionalMovieDTO.get();
		
		this.movieDTOValidator.validate(movieDTO);

		movieDTO = movieDTOService.add(movieDTO);

		return new ResponseEntity<MovieDTO>(movieDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
		logger.info("finding movie by {" + id + "}");
		Optional<Movie> movie = this.movieService.findById(id);
		if (movie.isPresent()) {
			logger.info("movie found!!! {" + id + "}");
			return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/details/{id}")
	public ResponseEntity<MovieDTO> getMovieDetailsById(@PathVariable long id) {
		logger.info("finding movie details by {" + id + "}");
		Optional<MovieDTO> movie = this.movieDTOService.findById(id);
		if (movie.isPresent()) {
			logger.info("movie details found!!! {" + id + "}");
			return new ResponseEntity<MovieDTO>(movie.get(), HttpStatus.OK);
		}
		return new ResponseEntity<MovieDTO>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public List<Movie> getAllMovies() {
		logger.info("finding all movies");
		List<Movie> movies = this.movieService.findAll();
		logger.info("Movie List with size {" + movies.size() + "} is returned");
		return movies;
	}

}
