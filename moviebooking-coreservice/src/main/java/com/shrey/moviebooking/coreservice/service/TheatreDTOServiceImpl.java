package com.shrey.moviebooking.coreservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.dto.TheatreDTO;
import com.shrey.moviebooking.commons.model.City;
import com.shrey.moviebooking.commons.model.Contact;
import com.shrey.moviebooking.commons.model.Theatre;
import com.shrey.moviebooking.commons.model.TheatreContact;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class TheatreDTOServiceImpl implements TheatreDTOService {

	private TheatreService theatreService;
	private CityService addressService;
	private ContactService contactService;
	private TheatreContactService theatreContactService;

	@Autowired
	public TheatreDTOServiceImpl(TheatreService theatreService, CityService addressService,
			ContactService contactService, TheatreContactService theatreContactService) {
		this.theatreService = theatreService;
		this.addressService = addressService;
		this.contactService = contactService;
		this.theatreContactService = theatreContactService;
	}

	@Override
	public TheatreDTO create(TheatreDTO theatreDTO) {
		// Add Address
		City address = this.addressService.add(theatreDTO.getCity());
		theatreDTO.setCity(address);

		// Add Theatre
		theatreDTO.getTheatre().setCityId(address.getId());

		Theatre theatre = this.theatreService.add(theatreDTO.getTheatre());
		theatreDTO.setTheatre(theatre);

		// Add Contact
		List<Contact> contacts = addContacts(theatre.getId(), theatreDTO.getContacts());
		theatreDTO.setContacts(contacts);

		return theatreDTO;
	}

	@Override
	public Optional<TheatreDTO> findById(Long id) {
		Optional<Theatre> optionalTheatre = this.theatreService.findById(id);

		if (optionalTheatre.isPresent()) {
			Theatre theatre = optionalTheatre.get();

			TheatreDTO theatreDTO = new TheatreDTO();

			City address = this.addressService.findById(theatre.getCityId()).get();

			List<TheatreContact> theatreContacts = this.theatreContactService.findAllByTheatreId(theatre.getId());

			for (TheatreContact theatreContact : theatreContacts) {
				Contact contact = this.contactService.findById(theatreContact.getContactId()).get();
				theatreDTO.getContacts().add(contact);
			}
			theatreDTO.setTheatre(theatre);
			theatreDTO.setCity(address);

			return Optional.of(theatreDTO);
		}

		return Optional.empty();
	}

	@Override
	public TheatreDTO update(TheatreDTO theatreDTO) {

		Optional<Theatre> optionalTheatre = this.theatreService.findById(theatreDTO.getTheatre().getId());
		if (optionalTheatre.isPresent()) {
			Theatre theatre = this.theatreService.add(optionalTheatre.get());
			// Finding Address
			City address = this.addressService.findById(theatre.getCityId()).get();

			theatreDTO.getCity().setId(address.getId());

			address = this.addressService.update(theatreDTO.getCity());

			List<TheatreContact> theatreContacts = this.theatreContactService.findAllByTheatreId(theatre.getId());

			//deleting existing
			for (TheatreContact theatreContact : theatreContacts) {
				this.theatreContactService.deleteById(theatreContact.getId());
				this.contactService.deleteById(theatreContact.getContactId());
			}

			// Updating new contacts By Adding
			List<Contact> contacts = addContacts(theatre.getId(), theatreDTO.getContacts());

			theatreDTO.setTheatre(theatre);
			theatreDTO.setCity(address);
			theatreDTO.setContacts(contacts);
		}
		return theatreDTO;
	}

	/**
	 * 
	 * @param theatreId
	 * @param contacts
	 * @return
	 */
	private List<Contact> addContacts(Long theatreId, List<Contact> contacts) {
		for (Contact contact : contacts) {
			Contact newContact = this.contactService.add(contact);
			contact.setId(newContact.getId());
			// Mapping contact to theatre
			this.theatreContactService.add(new TheatreContact(theatreId, newContact.getId()));
		}
		return contacts;
	}

}
