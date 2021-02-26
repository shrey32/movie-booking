package com.shrey.moviebooking.coreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.Screen;
import com.shrey.moviebooking.coreservice.repository.ScreenRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class ScreenServiceImpl implements ScreenService {

	private static final Logger log = LoggerFactory.getLogger(ScreenServiceImpl.class);

	private ScreenRepository screenRepository;

	@Autowired
	public ScreenServiceImpl(ScreenRepository screenRepository) {
		this.screenRepository = screenRepository;
	}

	@Override
	public Screen add(Screen screen) {
		log.info("Adding new " + Screen.class + " {" + screen + "}");
		screen.setCreated(new Date());
		return this.screenRepository.save(screen);
	}

	@Override
	public Optional<Screen> findById(Long screenId) {
		log.info("Finding " + Screen.class + "by Id {" + screenId + "}");
		return this.screenRepository.findById(screenId);
	}

	@Override
	public boolean deleteById(Long screenId) {
		log.info("Deleting " + Screen.class + "by Id {" + screenId + "}");
		this.screenRepository.deleteById(screenId);
		return this.findById(screenId).isEmpty();
	}

	@Override
	public List<Screen> findAllByTheatreId(Long theatreId) {
		log.info("Finding All " + Screen.class + "by TheatreId {" + theatreId + "}");
		return this.screenRepository.findAllByTheatreId(theatreId);
	}

}
