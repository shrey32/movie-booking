package com.shrey.moviebooking.coreservice.service;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.shrey.moviebooking.coreservice.models.Event;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class EventMetaDataServiceImpl implements EventMetaDataService {

	private static final Logger log = LoggerFactory.getLogger(EventMetaDataServiceImpl.class);

	private EurekaClient eurekaClient;
	private RestTemplate restTemplate;

	@Value("${moviebooking.metadata.service}")
	private String employeeSearchServiceId;

	@Autowired
	public EventMetaDataServiceImpl(EurekaClient eurekaClient, RestTemplate restTemplate) {
		this.eurekaClient = eurekaClient;
		this.restTemplate = restTemplate;
	}

	@Override
	public Map<String, Object> add(Event event, Map<String, Object> eventMetaData) {
		log.info("{" + event.getId() + "," + event.getName() + "} saving EventMetaData ");
		eventMetaData.put("eventId", event.getId());
		eventMetaData.put("name", event.getName());
		eventMetaData.put("durationInMinutes", event.getDurationInMinutes());

		Application application = eurekaClient.getApplication(employeeSearchServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String uploadURL = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/"
				+ "metadataservice/image";
		log.info("{" + event.getId() + "," + event.getName() + "} Upload URL " + uploadURL);

		if (eventMetaData.containsKey("posterURL") && eventMetaData.get("posterURL") != null) {
			log.info("{" + event.getId() + "," + event.getName() + "} Uploading Poster Image ");
			byte[] posterByteArray = (byte[]) eventMetaData.get("posterURL");
			String posterURL = new StringBuilder(uploadURL).append("/").append(event.getId()).append("/")
					.append(event.getName()).append("/").append("POSTER").toString();
			String uploadedResourceURL = uploadImage(posterURL, posterByteArray, "POSTER");
			eventMetaData.put("posterURL", "");
			if (uploadedResourceURL != null)
				eventMetaData.put("posterURL", uploadedResourceURL);
		}

		if (eventMetaData.containsKey("thumbnailURL") && eventMetaData.get("thumbnailURL") != null) {
			log.info("{" + event.getId() + "," + event.getName() + "} Uploading Thumbnail Image ");
			byte[] thumbnailByteArray = (byte[]) eventMetaData.get("thumbnailURL");
			String thumbnailURL = new StringBuilder(uploadURL).append("/").append(event.getId()).append("/")
					.append(event.getName()).append("/").append("THUMBNAIL").toString();
			String uploadedResourceURL = uploadImage(thumbnailURL, thumbnailByteArray, "THUMBNAIL");
			eventMetaData.put("thumbnailURL", "");
			if (uploadedResourceURL != null)
				eventMetaData.put("thumbnailURL", uploadedResourceURL);
		}

		if (eventMetaData.containsKey("trailerURL") && eventMetaData.get("trailerURL") != null) {
			log.info("{" + event.getId() + "," + event.getName() + "} Uploading Trailer Image ");
			byte[] trailerByteArray = (byte[]) eventMetaData.get("trailerURL");
			String thumbnailURL = new StringBuilder(uploadURL).append("/").append(event.getId()).append("/")
					.append(event.getName()).append("/").append("TRAILER").toString();
			String uploadedResourceURL = uploadImage(thumbnailURL, trailerByteArray, "TRAILER");
			eventMetaData.put("trailerURL", "");
			if (uploadedResourceURL != null)
				eventMetaData.put("trailerURL", uploadedResourceURL);
		}

		String metadataURL = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/"
				+ "/metadataservice/events";

		log.info("{" + event.getId() + "," + event.getName() + "} MetaData URL " + metadataURL);

		ParameterizedTypeReference<Map<String, Object>> responseType = new ParameterizedTypeReference<Map<String, Object>>() {
		};
		RequestEntity<Map<String, Object>> request = RequestEntity.post(URI.create(metadataURL)).body(eventMetaData);

		return this.restTemplate.exchange(request, responseType).getBody();

	}

	@Override
	public Optional<Map<String, Object>> findByEventId(Long eventId) {
		log.info("{" + eventId + "} finding EventMetaData ");
		try {
			Application application = eurekaClient.getApplication(employeeSearchServiceId);
			InstanceInfo instanceInfo = application.getInstances().get(0);
			String metadataURL = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/"
					+ "metadataservice/events/" + eventId;
			log.info("{" + eventId + "} Upload URL " + metadataURL);
			ParameterizedTypeReference<Map<String, Object>> responseType = new ParameterizedTypeReference<Map<String, Object>>() {
			};
			RequestEntity<Void> request = RequestEntity.get(URI.create(metadataURL)).build();
			Map<String, Object> metadata = this.restTemplate.exchange(request, responseType).getBody();
			return Optional.of(metadata);
		} catch (Exception e) {
			log.info("Exception while finding EventMetaData ", e);
		}
		return Optional.empty();
	}

	/**
	 * 
	 * @param url
	 * @param resourceData
	 * @param type
	 * @return
	 */
	private String uploadImage(String url, byte[] resourceData, String type) {
		try {
			RequestEntity<byte[]> request = RequestEntity.post(URI.create(url)).body(resourceData);
			String uploadedResourceURL = this.restTemplate.exchange(request, String.class).getBody();
			log.info("Uploaded Resource To "+uploadedResourceURL);
			return uploadedResourceURL;
		} catch (Exception e) {
			log.error("Exception while uploading the resource ", e);
		}
		return null;
	}

}
