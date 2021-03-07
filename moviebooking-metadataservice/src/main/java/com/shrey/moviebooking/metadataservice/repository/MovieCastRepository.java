package com.shrey.moviebooking.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.MovieCast;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface MovieCastRepository extends FindByMovieRepository<MovieCast>, JpaRepository<MovieCast, Long> {

}
