package com.shrey.moviebooking.movieservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.model.MovieLanguage;
import com.shrey.moviebooking.movieservice.repository.MovieLanguageRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
@Qualifier("movieLanguageService")
public class MovieLanguageServiceImpl implements CommongMappingService<MovieLanguage> {

	private static final Logger logger = LoggerFactory.getLogger(MovieLanguageServiceImpl.class);

	private MovieLanguageRepository movieLanguageRepository;

	@Autowired
	public MovieLanguageServiceImpl(MovieLanguageRepository movieLanguageRepository) {
		this.movieLanguageRepository = movieLanguageRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public MovieLanguage add(MovieLanguage movieLanguage) {
		logger.info("Saving movie to language mapping " + movieLanguage);
		return this.movieLanguageRepository.save(movieLanguage);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MovieLanguage> findAllByMovieId(Long movieId) {
		return this.movieLanguageRepository.findAllByMovieId(movieId);
	}

}
