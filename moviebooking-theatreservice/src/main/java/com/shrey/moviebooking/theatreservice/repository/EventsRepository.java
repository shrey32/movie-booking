package com.shrey.moviebooking.theatreservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.enums.EventType;
import com.shrey.moviebooking.commons.model.Event;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface EventsRepository extends JpaRepository<Event, Long>, DataByCityRepository<Event> {

	List<Event> findAllByCityIdAndEventType(Long cityId, EventType eventType);

}
