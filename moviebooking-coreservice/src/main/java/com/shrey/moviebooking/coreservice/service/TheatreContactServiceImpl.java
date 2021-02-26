package com.shrey.moviebooking.coreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.TheatreContact;
import com.shrey.moviebooking.coreservice.repository.TheatreContactRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class TheatreContactServiceImpl implements TheatreContactService {

	private static final Logger log = LoggerFactory.getLogger(TheatreContactServiceImpl.class);

	private TheatreContactRepository theatreContactRepository;

	@Autowired
	public TheatreContactServiceImpl(TheatreContactRepository theatreContactRepository) {
		this.theatreContactRepository = theatreContactRepository;
	}

	@Override
	public TheatreContact add(TheatreContact theatre) {
		log.info("Adding a new " + TheatreContact.class + " {" + theatre + "}");
		theatre.setCreated(new Date());
		return this.theatreContactRepository.save(theatre);
	}

	@Override
	public Optional<TheatreContact> findById(Long id) {
		log.info("finding a " + TheatreContact.class + " by Id {" + id + "}");
		return this.theatreContactRepository.findById(id);
	}

	@Override
	public boolean deleteById(Long id) {
		log.info("deleting a " + TheatreContact.class + " by Id {" + id + "}");
		this.theatreContactRepository.deleteById(id);
		return this.findById(id).isEmpty();
	}

	@Override
	public List<TheatreContact> findAllByTheatreId(Long theatreId) {
		log.info("finding all " + TheatreContact.class + " by TheatreId {" + theatreId + "}");
		return this.theatreContactRepository.findAllByTheatreId(theatreId);
	}

}
