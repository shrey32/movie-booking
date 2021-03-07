package com.shrey.moviebooking.metadataservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.metadataservice.models.EventMetaData;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface EventMetaDataRepository extends MongoRepository<EventMetaData, Long> {

	Optional<EventMetaData> findByEventId(Long eventId);

	void deleteByEventId(Long eventId);
}
