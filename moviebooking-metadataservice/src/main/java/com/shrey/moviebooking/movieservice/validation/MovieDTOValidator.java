package com.shrey.moviebooking.movieservice.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shrey.moviebooking.commons.dto.MovieDTO;
import com.shrey.moviebooking.commons.exception.InvalidRequestException;
import com.shrey.moviebooking.commons.model.Cast;
import com.shrey.moviebooking.commons.validator.Validator;

@Component
@Qualifier("movieDTOValidator")
public class MovieDTOValidator implements Validator<MovieDTO> {

	@Override
	public boolean validate(MovieDTO movieDTO) {

		if (movieDTO == null) {
			throw new InvalidRequestException("Request is empty");
		}
		if (movieDTO.getMovie() == null) {
			throw new InvalidRequestException("Movie Not Found in Request, Add a valid Movie");
		}
		if (movieDTO.getCast().isEmpty()) {
			throw new InvalidRequestException("Movie Cast is Empty, Add Cast");
		}
		if (movieDTO.getLanguages().isEmpty()) {
			throw new InvalidRequestException("No Movie Language Found, Add atleast 1 Language");
		}
		if (movieDTO.getCategories().isEmpty()) {
			throw new InvalidRequestException("Movie doesn't belong to any category, add atleast one category");
		}
		if (StringUtils.isEmpty(movieDTO.getMovie().getName())) {
			throw new InvalidRequestException("Movie name can't be empty!");
		}
		if (movieDTO.getMovie().getDurationInMinutes() < 10) {
			throw new InvalidRequestException("Movie duration should be more than 10 minutes!");
		}
		if (movieDTO.getMovie().getReleaseDate() == null) {
			throw new InvalidRequestException("Release Date is invalid or empty");
		}
		for (Cast cast : movieDTO.getCast()) {
			if (StringUtils.isEmpty(cast.getName()))
				throw new InvalidRequestException("One or more cast name is invalid or empty!");
		}

		return true;
	}

}
