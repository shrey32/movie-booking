package com.shrey.moviebooking.coreservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Shrey
 *
 */

@Entity
@Table(name = "theatrecontacts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheatreContact extends DBEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "theatreId")
	private Long theatreId;

	@Column(name = "contactId")
	private Long contactId;

	public TheatreContact(Long theatreId, Long contactId) {
		this.theatreId = theatreId;
		this.contactId = contactId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

}
