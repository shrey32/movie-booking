package com.shrey.moviebooking.coreservice.service;

import java.util.Optional;

import com.shrey.moviebooking.commons.model.Contact;

/**
 * 
 * @author Shrey
 *
 */
public interface ContactService {

	Contact add(Contact contact);

	Optional<Contact> findById(Long id);

	boolean deleteById(Long id);

	Contact update(Contact contact);
}
