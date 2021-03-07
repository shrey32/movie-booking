package com.shrey.moviebooking.bookingservice.controllers;

import java.util.Optional;

import javax.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.moviebooking.bookingservice.service.BookingDTOService;
import com.shrey.moviebooking.bookingservice.service.BookingService;
import com.shrey.moviebooking.bookingservice.dto.BookingDTO;
import com.shrey.moviebooking.bookingservice.models.Booking;
import com.shrey.moviebooking.commons.validator.Validator;

/**
 * 
 * @author Shrey
 *
 */
@RestController()
@RequestMapping("/bookingservice/bookings")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookingsController {

	private static final Logger log = LoggerFactory.getLogger(BookingsController.class);

	@Autowired
	private BookingDTOService bookingDTOService;

	@Autowired
	private BookingService bookingServie;

	@Autowired
	private Validator<BookingDTO> bookingDTOValidator;

	@PostMapping
	public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody Optional<BookingDTO> optionalBookingDTO) {
		if (optionalBookingDTO.isEmpty())
			return new ResponseEntity<BookingDTO>(HttpStatus.BAD_REQUEST);

		BookingDTO bookingDTO = optionalBookingDTO.get();

		log.info("Request arrived to create new Booking " + bookingDTO);

		this.bookingDTOValidator.validate(bookingDTO);

		log.info("booking validated " + bookingDTO);

		bookingDTO = this.bookingDTOService.create(bookingDTO);

		return new ResponseEntity<BookingDTO>(bookingDTO, HttpStatus.CREATED);
	}

	@GetMapping("/details/{bookingId}")
	public ResponseEntity<BookingDTO> bookingDetails(@PathVariable Long bookingId) {
		log.info("finding booking details for booking id {" + bookingId + "}");
		Optional<BookingDTO> optionalBookingDTO = this.bookingDTOService.findById(bookingId);
		if (optionalBookingDTO.isEmpty())
			return new ResponseEntity<BookingDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<BookingDTO>(optionalBookingDTO.get(), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public List<Booking> bookingsByUserId(@PathVariable Long userId) {
		log.info("finding bookings for user {" + userId + "}");
		return this.bookingServie.findByUserId(userId);
	}

	@GetMapping("/theatre/{theatreId}")
	public List<Booking> bookingsByTheatreId(@PathVariable Long theatreId) {
		log.info("finding bookings for Theatre {" + theatreId + "}");
		return this.bookingServie.findByTheatreId(theatreId);
	}

	@PatchMapping("/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
		log.info("cancelling bookings bookingId {" + bookingId + "}");
		Optional<Booking> optionalBooking = this.bookingServie.cancelBooking(bookingId);
		if (optionalBooking.isEmpty())
			return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Booking>(optionalBooking.get(), HttpStatus.OK);
	}

}
