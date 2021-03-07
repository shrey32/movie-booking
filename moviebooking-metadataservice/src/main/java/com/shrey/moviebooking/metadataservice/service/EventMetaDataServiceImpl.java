package com.shrey.moviebooking.metadataservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.metadataservice.models.EventMetaData;
import com.shrey.moviebooking.metadataservice.repository.EventMetaDataRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class EventMetaDataServiceImpl implements EventMetaDataService {

	private static final Logger log = LoggerFactory.getLogger(EventMetaDataServiceImpl.class);

	private EventMetaDataRepository eventsMetaDataRepository;

	@Autowired
	public EventMetaDataServiceImpl(EventMetaDataRepository eventsMetaDataRepository) {
		this.eventsMetaDataRepository = eventsMetaDataRepository;
	}

	@Override
	public EventMetaData add(EventMetaData eventMetaData) {
		log.info("Adding " + EventMetaData.class + " {" + eventMetaData + "}");
		Optional<EventMetaData> found = this.findByEventId(eventMetaData.getEventId());
		if (found.isPresent()) {
			log.info(EventMetaData.class + "Already Exist For EventId {" + found.get().getEventId() + "}, Deleting first");
			this.eventsMetaDataRepository.deleteByEventId(found.get().getEventId());
		}
		return this.eventsMetaDataRepository.save(eventMetaData);
	}

	@Override
	public Optional<EventMetaData> findByEventId(Long eventId) {
		log.info("Finding " + EventMetaData.class + " by eventId {" + eventId + "}");
		return this.eventsMetaDataRepository.findByEventId(eventId);
	}

}
