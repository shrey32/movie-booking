package com.shrey.moviebooking.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.coreservice.models.Theatre;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>, DataByCityRepository<Theatre> {

}
