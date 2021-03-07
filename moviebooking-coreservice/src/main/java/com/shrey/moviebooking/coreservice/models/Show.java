package com.shrey.moviebooking.coreservice.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shrey.moviebooking.coreservice.enums.ShowStatus;

/**
 * 
 * @author Shrey
 *
 */
@Entity
@Table(name = "shows")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show extends DBEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "theatreId")
	private long theatreId;

	@Column(name = "screenId")
	private long screenId;

	@Column(name = "eventId")
	private long eventId;

	@Column(name = "startTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
	private LocalDateTime startTime;

	@Column(name = "price")
	private double price;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ShowStatus status = ShowStatus.TO_BE_STARTED;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}

	public long getScreenId() {
		return screenId;
	}

	public void setScreenId(long screenId) {
		this.screenId = screenId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ShowStatus getStatus() {
		return status;
	}

	public void setStatus(ShowStatus status) {
		this.status = status;
	}

}
