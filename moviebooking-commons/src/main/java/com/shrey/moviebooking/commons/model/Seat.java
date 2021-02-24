package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class Seat extends DBEntity{

	private long id;
	private long screenId;
	private long theatreId;
	private String rowName;
	private int seatNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}
	
	

}
