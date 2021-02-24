package com.shrey.moviebooking.commons.dto;

import com.shrey.moviebooking.commons.model.Theatre;

import java.util.LinkedList;
import java.util.List;

import com.shrey.moviebooking.commons.model.Address;
import com.shrey.moviebooking.commons.model.Contact;

/**
 * 
 * @author Shrey
 *
 */
public class TheatreDTO {

	private Theatre theatre;
	private Address address;
	private List<Contact> contacts = new LinkedList<>();

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
