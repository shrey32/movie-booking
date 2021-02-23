package com.shrey.moviebooking.commons.model;

/**
 * 
 * @author Shrey
 *
 */
public class MovieCategory {

	private long id;
	private long movieId;
	private long categoryId;

	public MovieCategory() {
	}

	public MovieCategory(long movieId, long categoryId) {
		this.categoryId = categoryId;
		this.movieId = movieId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

}
