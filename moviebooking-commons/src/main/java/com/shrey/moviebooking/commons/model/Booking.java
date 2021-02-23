package com.shrey.moviebooking.commons.model;

import com.shrey.moviebooking.commons.enums.BookingStatus;

/**
 * 
 * @author Shrey
 *
 */
public class Booking extends DBEntity{

	private long id;
	private long theatreId;
	private long screenId;
	private long showid;
	private long userId;
	private double amount;
	private BookingStatus status = BookingStatus.UNBOOKED;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getShowid() {
		return showid;
	}

	public void setShowid(long showid) {
		this.showid = showid;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

}
