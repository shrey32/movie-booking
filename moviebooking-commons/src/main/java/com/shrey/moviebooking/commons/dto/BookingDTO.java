package com.shrey.moviebooking.commons.dto;

import java.util.LinkedList;

import java.util.List;

import com.shrey.moviebooking.commons.model.BookedSeat;
import com.shrey.moviebooking.commons.model.Booking;

/**
 * 
 * @author Shrey
 *
 */
public class BookingDTO {

	private Booking booking;

	List<BookedSeat> bookedSeats = new LinkedList<>();

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<BookedSeat> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<BookedSeat> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

}
