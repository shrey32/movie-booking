package com.shrey.moviebooking.commons.model;

import java.util.Date;

import com.shrey.moviebooking.commons.enums.ShowStatus;

/**
 * 
 * @author Shrey
 *
 */
public class Show {

	private long id;
	private long theatreId;
	private long screenId;
	private long movieId;
	private Date startTime;
	private double price;
	private ShowStatus status = ShowStatus.TO_BE_STARTED;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ShowStatus getStatus() {
		return status;
	}

	public void setStatus(ShowStatus status) {
		this.status = status;
	}

}
