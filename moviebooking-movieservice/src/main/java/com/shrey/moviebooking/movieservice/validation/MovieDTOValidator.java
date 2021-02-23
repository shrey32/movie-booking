package com.shrey.moviebooking.movieservice.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shrey.moviebooking.commons.dto.MovieDTO;
import com.shrey.moviebooking.commons.exception.InvalidMovieRequestException;
import com.shrey.moviebooking.commons.model.Cast;
import com.shrey.moviebooking.commons.validator.Validator;

@Component
@Qualifier("movieDTOValidator")
public class MovieDTOValidator implements Validator<MovieDTO> {

	@Override
	public boolean validate(MovieDTO movieDTO) {

		if (movieDTO == null) {
			throw new InvalidMovieRequestException("Request is empty");
		}
		if (movieDTO.getMovie() == null) {
			throw new InvalidMovieRequestException("Movie Not Found in Request, Add a valid Movie");
		}
		if (movieDTO.getCast().isEmpty()) {
			throw new InvalidMovieRequestException("Movie Cast is Empty, Add Cast");
		}
		if (movieDTO.getLanguages().isEmpty()) {
			throw new InvalidMovieRequestException("No Movie Language Found, Add atleast 1 Language");
		}
		if (movieDTO.getCategories().isEmpty()) {
			throw new InvalidMovieRequestException("Movie doesn't belong to any category, add atleast one category");
		}
		if (StringUtils.isEmpty(movieDTO.getMovie().getName())) {
			throw new InvalidMovieRequestException("Movie name can't be empty!");
		}
		if (movieDTO.getMovie().getDurationInMinutes() < 10) {
			throw new InvalidMovieRequestException("Movie duration should be more than 10 minutes!");
		}
		if (movieDTO.getMovie().getReleaseDate() == null) {
			throw new InvalidMovieRequestException("Release Date is invalid or empty");
		}
		for (Cast cast : movieDTO.getCast()) {
			if (StringUtils.isEmpty(cast.getName()))
				throw new InvalidMovieRequestException("One or more cast name is invalid or empty!");
		}

		return true;
	}

}
