package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class MovieLanguage {

	private long id;
	private long movieId;
	private long languageId;

	public MovieLanguage() {
	}

	public MovieLanguage(long movieId, long languageId) {
		this.movieId = movieId;
		this.languageId = languageId;
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

	public long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(long languageId) {
		this.languageId = languageId;
	}

}
