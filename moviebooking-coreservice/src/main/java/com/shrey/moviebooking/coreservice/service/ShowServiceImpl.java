package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.coreservice.models.Show;
import com.shrey.moviebooking.commons.utils.DateUtils;
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
		show.setCreated(DateUtils.dbAuditDateTime());
		return this.showRepository.save(show);
	}

	@Override
	public Optional<Show> findById(Long showId) {
		log.info("Finding " + Show.class + " by Id {" + showId + "}");
		return this.showRepository.findById(showId);
	}

	@Override
	public boolean deleteById(Long showId) {
		log.info("Deleting " + Show.class + " by Id {" + showId + "}");
		this.showRepository.deleteById(showId);
		return this.findById(showId).isEmpty();
	}

	@Override
	public List<Show> findAllByTheatreId(Long theatreId) {
		log.info("Finding All " + Show.class + " by TheatreId {" + theatreId + "}");
		List<Show> shows = this.showRepository.findAllByTheatreId(theatreId);
		return filterShowsByDate(shows);
	}

	@Override
	public List<Show> findAllByScreenId(Long screenId) {
		log.info("Finding All " + Show.class + " by ScreenId {" + screenId + "}");
		List<Show> shows = this.showRepository.findAllByScreenId(screenId);
		return filterShowsByDate(shows);
	}

	@Override
	public List<Show> findAllByEventIdAndTheatreId(Long eventId, Long theatreId) {
		log.info("Finding All " + Show.class + " by EventId {" + eventId + "} and TheatreId {" + theatreId + "}");
		return this.filterShowsByDate(this.showRepository.findAllByEventIdAndTheatreId(eventId, theatreId));
	}

	@Override
	public List<Show> findAllByEventId(Long eventId) {
		log.info("Finding " + Show.class + " by EventId {" + eventId + "}");
		return this.filterShowsByDate(this.showRepository.findAllByEventId(eventId));
	}

	private List<Show> filterShowsByDate(List<Show> shows) {
		return shows.stream().filter(ShowServiceImpl::isPastDatedShow).collect(Collectors.toList());
	}

	private static boolean isPastDatedShow(Show show) {
		return DateUtils.timeAfterHours(2).isBefore(show.getStartTime());
	}

}
