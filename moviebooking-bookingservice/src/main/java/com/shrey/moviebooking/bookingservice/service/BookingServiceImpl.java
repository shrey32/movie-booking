package com.shrey.moviebooking.bookingservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.bookingservice.repository.BookingRepository;
import com.shrey.moviebooking.bookingservice.enums.BookingStatus;
import com.shrey.moviebooking.bookingservice.models.Booking;
import com.shrey.moviebooking.commons.utils.DateUtils;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);

	private BookingRepository bookingRepository;

	@Autowired
	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Booking create(Booking booking) {
		log.info("Adding a new Booking " + booking);
		booking.setCreated(DateUtils.dbAuditDateTime());
		booking.setStatus(BookingStatus.ACTIVE);
		return this.bookingRepository.save(booking);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Booking> findById(Long id) {
		log.info("Finding Booking by id {" + id + "}");
		return this.bookingRepository.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public boolean deleteById(Long id) {
		log.info("deleting Booking by id {" + id + "}");
		this.bookingRepository.deleteById(id);
		Optional<Booking> deleted = this.findById(id);
		return deleted.isEmpty();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<Booking> cancelBooking(Long bookingId) {
		log.info("Cancel an existing Booking {" + bookingId + "}");
		Optional<Booking> optionalBooking = this.findById(bookingId);
		if (optionalBooking.isPresent()) {
			log.info("Found Booking to Cancel {" + bookingId + "}");
			Booking booking = optionalBooking.get();
			booking.setUpdated(DateUtils.dbAuditDateTime());
			booking.setStatus(BookingStatus.CANCELLED);
			return Optional.of(this.create(booking));
		}
		return Optional.empty();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Booking> findByUserId(Long userId) {
		return this.bookingRepository.findByUserId(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Booking> findByTheatreId(Long theatreId) {
		return this.bookingRepository.findByTheatreId(theatreId);
	}

}
