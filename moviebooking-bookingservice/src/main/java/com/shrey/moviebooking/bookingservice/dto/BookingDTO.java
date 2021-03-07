package com.shrey.moviebooking.bookingservice.dto;

import java.util.LinkedList;

import java.util.List;

import com.shrey.moviebooking.bookingservice.models.BookedSeat;
import com.shrey.moviebooking.bookingservice.models.Booking;

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
