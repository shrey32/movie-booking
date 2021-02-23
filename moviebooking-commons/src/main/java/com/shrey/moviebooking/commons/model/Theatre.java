package com.shrey.moviebooking.commons.model;

import com.shrey.moviebooking.commons.enums.TheatreStatus;

/**
 * 
 * @author Shrey
 *
 */
public class Theatre {

	private long id;
	private String name;
	private long addressId;
	private long contactId;
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

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public TheatreStatus getStatus() {
		return status;
	}

	public void setStatus(TheatreStatus status) {
		this.status = status;
	}

}
