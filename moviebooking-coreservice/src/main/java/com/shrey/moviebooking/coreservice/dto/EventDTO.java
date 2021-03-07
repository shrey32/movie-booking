package com.shrey.moviebooking.coreservice.dto;

import java.util.HashMap;
import java.util.Map;

import com.shrey.moviebooking.coreservice.models.City;
import com.shrey.moviebooking.coreservice.models.Event;

/**
 * 
 * @author Shrey
 *
 */
public class EventDTO {

	private Event event;
	private City city;
	private Map<String, Object> eventMetaData = new HashMap<>();

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Map<String, Object> getEventMetaData() {
		return eventMetaData;
	}

	public void setEventMetaData(Map<String, Object> eventMetaData) {
		this.eventMetaData = eventMetaData;
	}

}
