package com.shrey.moviebooking.commons.model;

import com.shrey.moviebooking.commons.enums.TheatreStatus;

/**
 * 
 * @author Shrey
 *
 */
public class Theatre extends DBEntity {

	private long id;
	private String name;
	private long cityId;
	private TheatreStatus status = TheatreStatus.OPENED;

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

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public TheatreStatus getStatus() {
		return status;
	}

	public void setStatus(TheatreStatus status) {
		this.status = status;
	}

}
