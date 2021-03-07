package com.shrey.moviebooking.coreservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.coreservice.dto.EventDTO;
import com.shrey.moviebooking.coreservice.models.City;
import com.shrey.moviebooking.coreservice.models.Event;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class EventDTOServiceImpl implements EventDTOService {

	private EventService eventService;
	private CityService cityService;

	@Autowired
	public EventDTOServiceImpl(EventService eventService, CityService cityService) {
		this.eventService = eventService;
		this.cityService = cityService;
	}

	@Override
	public EventDTO add(EventDTO eventDTO) {
		City city = this.cityService.add(eventDTO.getCity());
		Event event = eventDTO.getEvent();
		event.setCityId(city.getId());
		event = this.eventService.add(event);
		eventDTO.setCity(city);
		eventDTO.setEvent(event);
		return eventDTO;
	}

	@Override
	public Optional<EventDTO> findById(Long id) {
		Optional<Event> event = this.eventService.findById(id);
		if (event.isPresent()) {
			EventDTO eventDTO = new EventDTO();
			City city = this.cityService.findById(event.get().getCityId()).get();
			eventDTO.setEvent(event.get());
			eventDTO.setCity(city);
			return Optional.of(eventDTO);
		}
		return Optional.empty();
	}

}
