package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class MovieCast {

	private long id;
	private long movieId;
	private long castId;

	public MovieCast() {
	}

	public MovieCast(long movieId, long castId) {
		this.movieId = movieId;
		this.castId = castId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public long getCastId() {
		return castId;
	}

	public void setCastId(long castId) {
		this.castId = castId;
	}

}
