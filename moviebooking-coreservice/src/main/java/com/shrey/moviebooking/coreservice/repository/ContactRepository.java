package com.shrey.moviebooking.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.coreservice.models.Contact;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
