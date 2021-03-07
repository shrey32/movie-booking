package com.shrey.moviebooking.coreservice.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.coreservice.dto.TheatreDTO;
import com.shrey.moviebooking.coreservice.models.City;
import com.shrey.moviebooking.coreservice.models.Contact;
import com.shrey.moviebooking.coreservice.models.Show;
import com.shrey.moviebooking.coreservice.models.Theatre;
import com.shrey.moviebooking.coreservice.models.TheatreContact;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class TheatreDTOServiceImpl implements TheatreDTOService {

	private TheatreService theatreService;
	private CityService cityService;
	private ContactService contactService;
	private ShowService showService;
	private TheatreContactService theatreContactService;

	@Autowired
	public TheatreDTOServiceImpl(TheatreService theatreService, CityService cityService, ContactService contactService,
			TheatreContactService theatreContactService, ShowService showService) {
		this.theatreService = theatreService;
		this.cityService = cityService;
		this.contactService = contactService;
		this.theatreContactService = theatreContactService;
		this.showService = showService;
	}

	@Override
	public TheatreDTO create(TheatreDTO theatreDTO) {
		// Add Address
		City city = this.cityService.add(theatreDTO.getCity());
		theatreDTO.setCity(city);

		// Add Theatre
		theatreDTO.getTheatre().setCityId(city.getId());

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

			City city = this.cityService.findById(theatre.getCityId()).get();

			List<TheatreContact> theatreContacts = this.theatreContactService.findAllByTheatreId(theatre.getId());

			for (TheatreContact theatreContact : theatreContacts) {
				Contact contact = this.contactService.findById(theatreContact.getContactId()).get();
				theatreDTO.getContacts().add(contact);
			}
			theatreDTO.setTheatre(theatre);
			theatreDTO.setCity(city);

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
			City city = this.cityService.findById(theatre.getCityId()).get();

			theatreDTO.getCity().setId(city.getId());

			city = this.cityService.update(theatreDTO.getCity());

			List<TheatreContact> theatreContacts = this.theatreContactService.findAllByTheatreId(theatre.getId());

			// deleting existing
			for (TheatreContact theatreContact : theatreContacts) {
				this.theatreContactService.deleteById(theatreContact.getId());
				this.contactService.deleteById(theatreContact.getContactId());
			}

			// Updating new contacts By Adding
			List<Contact> contacts = addContacts(theatre.getId(), theatreDTO.getContacts());

			theatreDTO.setTheatre(theatre);
			theatreDTO.setCity(city);
			theatreDTO.setContacts(contacts);
		}
		return theatreDTO;
	}

	@Override
	public List<Theatre> findAllByCityAndEvent(Long cityId, Long eventId) {
		List<Theatre> theatresByCity = this.theatreService.findAllByCityId(cityId);
		List<Theatre> theatresByCityAndEvent = new LinkedList<>();
		for (Theatre theatre : theatresByCity) {
			List<Show> show = this.showService.findAllByEventIdAndTheatreId(eventId, theatre.getId());
			if (!show.isEmpty())
				theatresByCityAndEvent.add(theatre);
		}
		return theatresByCityAndEvent;
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
