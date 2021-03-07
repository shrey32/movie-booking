package com.shrey.moviebooking.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.coreservice.models.Screen;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long>, DataByTheatreRepository<Screen> {

}
