package com.shrey.moviebooking.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.MovieCategory;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface MovieCategoryRepository
		extends CommonMappingRepository<MovieCategory>, JpaRepository<MovieCategory, Long> {

}
