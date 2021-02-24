package com.shrey.moviebooking.theatreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.TheatreContact;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface TheatreContactRepository extends JpaRepository<TheatreContact, Long>,DataByTheatreRepository<TheatreContact> {

}
