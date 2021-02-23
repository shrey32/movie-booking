package com.shrey.moviebooking.movieservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.model.MovieCast;
import com.shrey.moviebooking.movieservice.repository.MovieCastRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service()
@Qualifier("movieCastService")
public class MovieCastServiceImpl implements CommongMappingService<MovieCast> {

	private static final Logger logger = LoggerFactory.getLogger(MovieCastServiceImpl.class);

	private MovieCastRepository movieCastRepository;

	@Autowired
	public MovieCastServiceImpl(MovieCastRepository movieCastRepository) {
		this.movieCastRepository = movieCastRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public MovieCast add(MovieCast movieCast) {
		logger.info("Saving movie to cast mapping " + movieCast);
		return this.movieCastRepository.save(movieCast);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MovieCast> findAllByMovieId(Long movieId) {
		return this.movieCastRepository.findAllByMovieId(movieId);
	}

}
