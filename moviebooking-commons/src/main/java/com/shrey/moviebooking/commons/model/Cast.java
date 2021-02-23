package com.shrey.moviebooking.commons.model;

import com.shrey.moviebooking.commons.enums.MovieCastRole;

/**
 * 
 * @author Shrey
 *
 */
public class Cast {

	private long id;
	private String name;
	private String image;
	private MovieCastRole movieCastRole;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MovieCastRole getMovieCastRole() {
		return movieCastRole;
	}

	public void setMovieCastRole(MovieCastRole movieCastRole) {
		this.movieCastRole = movieCastRole;
	}

}
