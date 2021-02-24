package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class TheatreContact extends DBEntity {

	private Long id;
	private Long theatreId;
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
