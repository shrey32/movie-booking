package com.shrey.moviebooking.commons.dto;

import java.util.ArrayList;
import java.util.List;

import com.shrey.moviebooking.commons.model.Cast;
import com.shrey.moviebooking.commons.model.Category;
import com.shrey.moviebooking.commons.model.Language;
import com.shrey.moviebooking.commons.model.Movie;

/**
 * 
 * @author Shrey
 *
 */
public class MovieDTO {

	private Movie movie;
	private List<Cast> cast = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private List<Language> languages = new ArrayList<>();

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Cast> getCast() {
		return cast;
	}

	public void setCast(List<Cast> cast) {
		this.cast = cast;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

}
