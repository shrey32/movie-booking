package com.shrey.moviebooking.movieservice.service;

import java.util.Date;
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
		logger.info("Adding a new Language ==>" + language);
		language.setCreated(new Date());
		Optional<Language> optionalLanguage = this.findByName(language.getName());
		if (optionalLanguage.isPresent()) {
			logger.info("Language Already Exists, updating");
			language.setId(optionalLanguage.get().getId());
			language.setUpdated(new Date());
			language.setCreated(optionalLanguage.get().getCreated());
		}
		return this.languageRepository.save(language);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Language> findById(long id) {
		logger.info("finding Language by id ==>" + id);
		return this.languageRepository.findById(id);
	}
	
	@Override
		public Optional<Language> findByName(String name) {
			return this.languageRepository.findByName(name);
		}

}
