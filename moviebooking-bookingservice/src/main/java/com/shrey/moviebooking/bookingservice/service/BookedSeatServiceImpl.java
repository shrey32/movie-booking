package com.shrey.moviebooking.bookingservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.bookingservice.repository.BookedSeatRepository;
import com.shrey.moviebooking.bookingservice.models.BookedSeat;
import com.shrey.moviebooking.commons.utils.DateUtils;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class BookedSeatServiceImpl implements BookedSeatService {

	private static final Logger log = LoggerFactory.getLogger(BookedSeatServiceImpl.class);

	private BookedSeatRepository bookedSeatRepository;

	@Autowired
	public BookedSeatServiceImpl(BookedSeatRepository bookedSeatRepository) {
		this.bookedSeatRepository = bookedSeatRepository;
	}

	@Override
	@Transactional
	public BookedSeat create(BookedSeat bookedSeat) {
		log.info("Adding a new BookSeat " + bookedSeat);
		bookedSeat.setCreated(DateUtils.dbAuditDateTime());
		return this.bookedSeatRepository.save(bookedSeat);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<BookedSeat> findById(Long id) {
		log.info("finding a new BookSeat by Id {" + id + "}");
		return this.bookedSeatRepository.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public boolean deleteById(Long id) {
		log.info("deleting bookedseat by id {" + id + "}");
		this.bookedSeatRepository.deleteById(id);
		Optional<BookedSeat> deleted = this.findById(id);
		return deleted.isEmpty();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BookedSeat> findAllByBookingId(Long bookingId) {
		log.info("finding all BookSeat by BookingId {" + bookingId + "}");
		return this.bookedSeatRepository.findAllByBookingId(bookingId);
	}

}
