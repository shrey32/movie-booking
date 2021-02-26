package com.shrey.moviebooking.coreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.Theatre;
import com.shrey.moviebooking.coreservice.repository.TheatreRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class TheatreServiceImpl implements TheatreService {

	private static final Logger log = LoggerFactory.getLogger(TheatreService.class);

	private TheatreRepository theatreRepository;

	@Autowired
	public TheatreServiceImpl(TheatreRepository theatreRepository) {
		this.theatreRepository = theatreRepository;
	}

	@Override
	public Theatre add(Theatre theatre) {
		log.info("Adding a new " + Theatre.class + " {" + theatre + "}");
		theatre.setCreated(new Date());
		Optional<Theatre> optionalTheatre = this.findById(theatre.getId());
		if (optionalTheatre.isPresent()) {
			log.info("Updating existing " + Theatre.class + " {" + theatre + "}");
			Theatre found = optionalTheatre.get();
			theatre.setId(found.getId());
			theatre.setCreated(found.getCreated());
			theatre.setUpdated(new Date());
		}
		return this.theatreRepository.save(theatre);
	}

	@Override
	public Optional<Theatre> findById(Long theatreId) {
		log.info("finding a " + Theatre.class + " by Id {" + theatreId + "}");
		return this.theatreRepository.findById(theatreId);
	}

	@Override
	public boolean deleteById(Long theatreId) {
		log.info("deleting a " + Theatre.class + " by Id {" + theatreId + "}");
		this.theatreRepository.deleteById(theatreId);
		return this.findById(theatreId).isEmpty();
	}

	@Override
	public List<Theatre> findAllByCityId(Long cityId) {
		log.info("finding all " + Theatre.class + " by City Id {" + cityId + "}");
		return this.theatreRepository.findAllByCityId(cityId);
	}

}
