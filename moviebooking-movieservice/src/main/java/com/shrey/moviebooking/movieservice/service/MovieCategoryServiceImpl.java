package com.shrey.moviebooking.movieservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.model.MovieCategory;
import com.shrey.moviebooking.movieservice.repository.MovieCategoryRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
@Qualifier("movieCategoryService")
public class MovieCategoryServiceImpl implements CommongMappingService<MovieCategory> {

	private static final Logger logger = LoggerFactory.getLogger(MovieCategoryServiceImpl.class);

	private MovieCategoryRepository movieCategoryRepository;

	@Autowired
	public MovieCategoryServiceImpl(MovieCategoryRepository movieCategoryRepository) {
		this.movieCategoryRepository = movieCategoryRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public MovieCategory add(MovieCategory movieCategory) {
		logger.info("Saving movie to language mapping " + movieCategory);
		return this.movieCategoryRepository.save(movieCategory);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MovieCategory> findAllByMovieId(Long movieId) {
		return this.movieCategoryRepository.findAllByMovieId(movieId);
	}

}
