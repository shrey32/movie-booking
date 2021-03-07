package com.shrey.moviebooking.metadataservice.service;

import java.util.Optional;

import com.shrey.moviebooking.metadataservice.models.EventMetaData;

/**
 * 
 * @author Shrey
 *
 */
public interface EventMetaDataService {

	EventMetaData add(EventMetaData eventMetadata);

	Optional<EventMetaData> findByEventId(Long eventId);

}
