package com.shrey.moviebooking.commons.model;

import com.shrey.moviebooking.commons.enums.ContactType;

/**
 * 
 * @author Shrey
 *
 */
public class Contact {

	private long id;
	private ContactType contactType = ContactType.MOBILE;
	private String number;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
