package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.coreservice.enums.EventType;
import com.shrey.moviebooking.coreservice.models.Event;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface EventsRepository extends JpaRepository<Event, Long>, DataByCityRepository<Event> {

	List<Event> findAllByCityIdAndEventType(Long cityId, EventType eventType);

}
