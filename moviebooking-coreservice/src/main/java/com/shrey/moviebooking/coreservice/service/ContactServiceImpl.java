package com.shrey.moviebooking.coreservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.coreservice.models.Contact;
import com.shrey.moviebooking.commons.utils.DateUtils;
import com.shrey.moviebooking.coreservice.repository.ContactRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class ContactServiceImpl implements ContactService {

	private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

	private ContactRepository contactRepository;

	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public Contact add(Contact contact) {
		log.info("Adding new " + Contact.class + " {" + contact + "}");
		contact.setCreated(DateUtils.dbAuditDateTime());
		return this.contactRepository.save(contact);
	}

	@Override
	public Optional<Contact> findById(Long id) {
		log.info("finding " + Contact.class + " By Id {" + id + "}");
		return this.contactRepository.findById(id);
	}

	@Override
	public boolean deleteById(Long id) {
		log.info("Deleting " + Contact.class + " By Id {" + id + "}");
		this.contactRepository.deleteById(id);
		return this.findById(id).isEmpty();
	}

	@Override
	public Contact update(Contact contact) {
		log.info("Updating " + Contact.class + " {" + contact + "}");
		Optional<Contact> optionalContact = this.findById(contact.getId());
		if (optionalContact.isPresent()) {
			log.info("Found " + Contact.class + " {" + contact.getId() + "}");
			contact.setId(optionalContact.get().getId());
			contact.setCreated(optionalContact.get().getCreated());
			contact.setUpdated(DateUtils.dbAuditDateTime());
			return this.add(contact);
		}
		return null;
	}

}
