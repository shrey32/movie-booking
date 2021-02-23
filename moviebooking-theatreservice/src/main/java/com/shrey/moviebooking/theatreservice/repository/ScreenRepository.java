package com.shrey.moviebooking.theatreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Screen;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long>, DataByTheatreRepository<Screen> {

}
