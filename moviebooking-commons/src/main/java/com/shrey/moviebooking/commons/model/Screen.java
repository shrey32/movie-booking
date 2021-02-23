package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class Screen extends DBEntity{

	private long id;
	private long theatreId;
	private int capacity;

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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
