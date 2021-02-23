package com.shrey.moviebooking.theatreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Contact;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
