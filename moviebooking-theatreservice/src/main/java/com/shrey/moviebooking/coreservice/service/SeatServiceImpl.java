package com.shrey.moviebooking.coreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.Seat;
import com.shrey.moviebooking.coreservice.repository.SeatRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class SeatServiceImpl implements SeatService {

	private static final Logger log = LoggerFactory.getLogger(SeatServiceImpl.class);

	private SeatRepository seatRepository;

	@Autowired
	public SeatServiceImpl(SeatRepository screenRepository) {
		this.seatRepository = screenRepository;
	}

	@Override
	public Seat add(Seat seat) {
		log.info("Adding new " + Seat.class + " {" + seat + "}");
		seat.setCreated(new Date());
		return this.seatRepository.save(seat);
	}

	@Override
	public Optional<Seat> findById(Long seatId) {
		log.info("Finding " + Seat.class + "by Id {" + seatId + "}");
		return this.seatRepository.findById(seatId);
	}

	@Override
	public boolean deleteById(Long seatId) {
		log.info("Deleting " + Seat.class + "by Id {" + seatId + "}");
		this.seatRepository.deleteById(seatId);
		return this.findById(seatId).isEmpty();
	}

	@Override
	public List<Seat> findAllByTheatreId(Long theatreId) {
		log.info("Finding All " + Seat.class + "by TheatreId {" + theatreId + "}");
		return this.seatRepository.findAllByTheatreId(theatreId);
	}

	@Override
	public List<Seat> findAllByScreenId(Long screenId) {
		log.info("Finding All " + Seat.class + "by ScreenId {" + screenId + "}");
		return this.seatRepository.findAllByScreenId(screenId);
	}

}
