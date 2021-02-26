package com.shrey.moviebooking.commons.model;

import com.shrey.moviebooking.commons.enums.EventType;

/**
 * 
 * @author Shrey
 *
 */
public class Movie extends Event {

	public Movie() {
		this.eventType = EventType.MOVIE;
	}

}
