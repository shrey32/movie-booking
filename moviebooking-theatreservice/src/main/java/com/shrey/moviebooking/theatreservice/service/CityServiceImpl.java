package com.shrey.moviebooking.theatreservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.moviebooking.commons.model.City;
import com.shrey.moviebooking.theatreservice.repository.CityRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class CityServiceImpl implements CityService {

	private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

	private CityRepository cityRepository;

	@Autowired
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public City add(City city) {
		log.info("Adding new " + City.class + " {" + city + "}");
		city.setCreated(new Date());
		return this.cityRepository.save(city);
	}

	@Override
	public Optional<City> findById(Long id) {
		log.info("finding " + City.class + " By Id {" + id + "}");
		return this.cityRepository.findById(id);
	}

	@Override
	public boolean deleteById(Long id) {
		log.info("Deleting " + City.class + " By Id {" + id + "}");
		this.cityRepository.deleteById(id);
		return this.findById(id).isEmpty();
	}

	@Override
	public City update(City city) {
		log.info("Updating " + City.class + " {" + city + "}");
		Optional<City> optionalcity = this.findById(city.getId());
		if (optionalcity.isPresent()) {
			log.info("Found " + City.class + " {" + city.getId() + "}");
			city.setId(optionalcity.get().getId());
			city.setCreated(optionalcity.get().getCreated());
			city.setUpdated(new Date());
			return this.add(city);
		}
		return null;
	}

	@Override
	public List<City> findAllByName(String city) {
		log.info("finding All " + City.class + " By city {" + city + "}");
		return this.cityRepository.findAllByName(city.trim());
	}

	@Override
	public List<City> findAllByPincode(String pincode) {
		log.info("finding All " + City.class + " By pincode {" + pincode + "}");
		return this.cityRepository.findAllByPincode(pincode.trim());
	}

	@Override
	public List<City> findAll() {
		log.info("finding All " + City.class);
		return this.cityRepository.findAll();
	}

}
