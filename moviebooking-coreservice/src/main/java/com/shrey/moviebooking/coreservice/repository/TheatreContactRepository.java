package com.shrey.moviebooking.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.coreservice.models.TheatreContact;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface TheatreContactRepository extends JpaRepository<TheatreContact, Long>,DataByTheatreRepository<TheatreContact> {

}
