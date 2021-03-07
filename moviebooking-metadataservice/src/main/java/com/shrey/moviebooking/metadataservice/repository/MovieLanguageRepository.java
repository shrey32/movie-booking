package com.shrey.moviebooking.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.MovieLanguage;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface MovieLanguageRepository
		extends FindByMovieRepository<MovieLanguage>, JpaRepository<MovieLanguage, Long> {

}