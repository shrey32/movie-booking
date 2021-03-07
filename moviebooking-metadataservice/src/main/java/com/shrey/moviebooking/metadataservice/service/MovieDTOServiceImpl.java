package com.shrey.moviebooking.movieservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.dto.MovieDTO;
import com.shrey.moviebooking.commons.model.Cast;
import com.shrey.moviebooking.commons.model.Category;
import com.shrey.moviebooking.commons.model.Language;
import com.shrey.moviebooking.commons.model.Movie;
import com.shrey.moviebooking.commons.model.MovieCast;
import com.shrey.moviebooking.commons.model.MovieCategory;
import com.shrey.moviebooking.commons.model.MovieLanguage;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class MovieDTOServiceImpl implements MovieDTOService {

	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieDetailsService<Cast> castService;

	@Autowired
	private MovieDetailsService<Language> languageService;

	@Autowired
	private MovieDetailsService<Category> categoryService;

	@Autowired
	private CommongMappingService<MovieCast> movieCastService;

	@Autowired
	private CommongMappingService<MovieLanguage> movieLanguageService;

	@Autowired
	private CommongMappingService<MovieCategory> movieCategoryService;

	@Override
	@Transactional
	public MovieDTO add(MovieDTO movieDTO) {
		Movie movie = this.movieService.add(movieDTO.getMovie());

		// saving casts
		for (Cast cast : movieDTO.getCast()) {
			Cast insertedCast = this.castService.add(cast);
			cast.setId(insertedCast.getId());
			this.movieCastService.add(new MovieCast(movie.getId(), insertedCast.getId()));
		}

		// saving Languages
		for (Language language : movieDTO.getLanguages()) {
			Language insertedLanguage = this.languageService.add(language);
			language.setId(insertedLanguage.getId());
			this.movieLanguageService.add(new MovieLanguage(movie.getId(), insertedLanguage.getId()));
		}

		// saving Categories
		for (Category category : movieDTO.getCategories()) {
			Category insertedCategory = this.categoryService.add(category);
			category.setId(insertedCategory.getId());
			this.movieCategoryService.add(new MovieCategory(movie.getId(), insertedCategory.getId()));
		}

		movieDTO.setMovie(movie);

		return movieDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MovieDTO> findById(Long id) {
		Optional<Movie> optionalMovie = this.movieService.findById(id);
		if (optionalMovie.isEmpty())
			return Optional.empty();
		MovieDTO movieDTO = new MovieDTO();
		Movie movie = optionalMovie.get();

		// get casts
		List<MovieCast> movieCasts = this.movieCastService.findAllByMovieId(movie.getId());
		for (MovieCast movieCast : movieCasts) {
			Optional<Cast> cast = this.castService.findById(movieCast.getCastId());
			if (cast.isPresent())
				movieDTO.getCast().add(cast.get());
		}

		// get languages
		List<MovieLanguage> movieLanguages = this.movieLanguageService.findAllByMovieId(movie.getId());
		for (MovieLanguage movieLanguage : movieLanguages) {
			Optional<Language> language = this.languageService.findById(movieLanguage.getLanguageId());
			if (language.isPresent())
				movieDTO.getLanguages().add(language.get());
		}

		// get Categories
		List<MovieCategory> movieCategories = this.movieCategoryService.findAllByMovieId(movie.getId());
		for (MovieCategory movieCategory : movieCategories) {
			Optional<Category> category = this.categoryService.findById(movieCategory.getCategoryId());
			if (category.isPresent())
				movieDTO.getCategories().add(category.get());
		}

		movieDTO.setMovie(movie);
		return Optional.of(movieDTO);
	}

}
