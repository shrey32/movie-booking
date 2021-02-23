package com.shrey.moviebooking.movieservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.model.Language;
import com.shrey.moviebooking.movieservice.repository.LanguageRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
@Qualifier("languageService")
public class LanguageServiceImpl implements MovieDetailsService<Language> {

	private static final Logger logger = LoggerFactory.getLogger(LanguageServiceImpl.class);

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageServiceImpl(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Language add(Language language) {
		logger.info("Adding a new cast ==>" + language);
		return this.languageRepository.save(language);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Language> findById(long id) {
		logger.info("finding cast by id ==>" + id);
		return this.languageRepository.findById(id);
	}

}
