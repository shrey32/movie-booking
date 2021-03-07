package com.shrey.moviebooking.metadataservice.models;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Shrey
 *
 */
@Document(collection = "#{@environment.getProperty('mongodb.collectionName')}")
@CompoundIndex(def = "{'eventId':1, 'name':1, 'type':1}", name = "id_name_type_index", unique = true, background = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventMetaData {

	@Id
	private ObjectId id;
	@Indexed(name = "compositeId_index", unique = true, background = true)
	private Long eventId;
	private String name;
	private int durationInMinutes;
	private String description;
	private String type;
	private String posterURL;
	private String thumbnailURL;
	private String trailerURL;
	private List<String> languages = new LinkedList<>();
	private List<Cast> casts = new LinkedList<>();
	private Rating rating;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	public String getTrailerURL() {
		return trailerURL;
	}

	public void setTrailerURL(String trailerURL) {
		this.trailerURL = trailerURL;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<Cast> getCasts() {
		return casts;
	}

	public void setCasts(List<Cast> casts) {
		this.casts = casts;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
