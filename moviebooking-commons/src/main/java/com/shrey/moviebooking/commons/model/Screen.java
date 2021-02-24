package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class Screen extends DBEntity {

	private long id;
	private String name;
	private long theatreId;
	private long screenId;
	private int capacity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
