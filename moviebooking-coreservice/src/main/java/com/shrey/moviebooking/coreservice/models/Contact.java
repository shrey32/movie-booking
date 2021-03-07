package com.shrey.moviebooking.coreservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shrey.moviebooking.coreservice.enums.ContactType;

/**
 * 
 * @author Shrey
 *
 */
@Entity
@Table(name = "contacts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact extends DBEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "contactType")
	@Enumerated(EnumType.STRING)
	private ContactType contactType = ContactType.MOBILE;

	@Column(name = "contact")
	private String contact;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
