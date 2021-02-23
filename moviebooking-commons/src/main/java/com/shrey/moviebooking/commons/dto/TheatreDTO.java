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
	private Contact contact;
	private List<ScreenDTO> screens = new LinkedList<>();
	
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<ScreenDTO> getScreens() {
		return screens;
	}

	public void setScreens(List<ScreenDTO> screens) {
		this.screens = screens;
	}

	

}
