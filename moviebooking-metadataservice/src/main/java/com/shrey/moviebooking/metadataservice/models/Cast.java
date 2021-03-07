package com.shrey.moviebooking.metadataservice.models;

import com.shrey.moviebooking.metadataservice.enums.CastType;

/**
 * 
 * @author Shrey
 *
 */
public class Cast {

	private String firstName;
	private String lastName;
	private String imageURL;
	private CastType type;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public CastType getType() {
		return type;
	}

	public void setType(CastType type) {
		this.type = type;
	}

}
