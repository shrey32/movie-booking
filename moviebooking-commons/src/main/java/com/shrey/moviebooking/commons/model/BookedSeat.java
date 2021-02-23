package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class BookedSeat extends DBEntity {

	private long id;
	private long bookingId;
	private long seatId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getSeatId() {
		return seatId;
	}

	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}

}
