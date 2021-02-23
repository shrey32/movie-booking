package com.shrey.moviebooking.movieservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.model.Cast;
import com.shrey.moviebooking.movieservice.repository.CastRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
@Qualifier("castService")
public class CastServiceImpl implements MovieDetailsService<Cast> {

	private static final Logger logger = LoggerFactory.getLogger(CastServiceImpl.class);

	private CastRepository castRepository;

	@Autowired
	public CastServiceImpl(CastRepository castRepository) {
		this.castRepository = castRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Cast add(Cast cast) {
		logger.info("Adding a new cast ==>" + cast);
		return this.castRepository.save(cast);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cast> findById(long id) {
		logger.info("finding cast by id ==>" + id);
		return this.castRepository.findById(id);
	}

}
