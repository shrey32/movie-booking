package com.shrey.moviebooking.coreservice.dto;

import com.shrey.moviebooking.coreservice.models.Theatre;

import java.util.LinkedList;
import java.util.List;

import com.shrey.moviebooking.coreservice.models.City;
import com.shrey.moviebooking.coreservice.models.Contact;

/**
 * 
 * @author Shrey
 *
 */
public class TheatreDTO {

	private Theatre theatre;
	private City city;
	private List<Contact> contacts = new LinkedList<>();

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
