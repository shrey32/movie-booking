package com.shrey.moviebooking.coreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.Show;
import com.shrey.moviebooking.coreservice.repository.ShowRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class ShowServiceImpl implements ShowService {

	private static final Logger log = LoggerFactory.getLogger(ShowServiceImpl.class);

	private ShowRepository showRepository;

	@Autowired
	public ShowServiceImpl(ShowRepository screenRepository) {
		this.showRepository = screenRepository;
	}

	@Override
	public Show add(Show show) {
		log.info("Adding new " + Show.class + " {" + show + "}");
		show.setCreated(new Date());
		return this.showRepository.save(show);
	}

	@Override
	public Optional<Show> findById(Long showId) {
		log.info("Finding " + Show.class + "by Id {" + showId + "}");
		return this.showRepository.findById(showId);
	}

	@Override
	public boolean deleteById(Long showId) {
		log.info("Deleting " + Show.class + "by Id {" + showId + "}");
		this.showRepository.deleteById(showId);
		return this.findById(showId).isEmpty();
	}

	@Override
	public List<Show> findAllByTheatreId(Long theatreId) {
		log.info("Finding All " + Show.class + "by TheatreId {" + theatreId + "}");
		return this.showRepository.findAllByTheatreId(theatreId);
	}

	@Override
	public List<Show> findAllByScreenId(Long screenId) {
		log.info("Finding All " + Show.class + "by ScreenId {" + screenId + "}");
		return this.showRepository.findAllByScreenId(screenId);
	}

}
