package com.shrey.moviebooking.movieservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.Movie;
import com.shrey.moviebooking.movieservice.repository.MovieRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class MovieServiceImpl implements MovieService {

	private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie add(Movie movie) {
		logger.info("Adding new Movie " + movie);
		return this.movieRepository.save(movie);
	}

	@Override
	public boolean delete(Long id) {
		logger.info("deleting Movie with id {" + id + "}");
		this.movieRepository.deleteById(id);
		return this.movieRepository.findById(id).isEmpty();
	}

	@Override
	public Optional<Movie> findById(Long id) {
		logger.info("findinf Movie with id {" + id + "}");
		return this.movieRepository.findById(id);
	}

	@Override
	public List<Movie> findAll() {
		logger.info("finding all movies");
		return this.movieRepository.findAll();
	}

}
