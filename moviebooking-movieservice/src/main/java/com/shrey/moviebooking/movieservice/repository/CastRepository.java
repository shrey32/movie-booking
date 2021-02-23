package com.shrey.moviebooking.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Cast;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface CastRepository extends JpaRepository<Cast, Long>{

}
