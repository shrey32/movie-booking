package com.shrey.moviebooking.coreservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.shrey.moviebooking.coreservice.enums.TheatreStatus;

/**
 * 
 * @author Shrey
 *
 */

@Entity
@Table(name = "theatres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Theatre extends DBEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "cityId")
	private long cityId;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private TheatreStatus status = TheatreStatus.OPENED;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public TheatreStatus getStatus() {
		return status;
	}

	public void setStatus(TheatreStatus status) {
		this.status = status;
	}

}
