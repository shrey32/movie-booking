package com.shrey.moviebooking.coreservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.coreservice.models.Show;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface ShowRepository extends JpaRepository<Show, Long>, DataByTheatreRepository<Show>,
		DataByScreenRepository<Show>, DataByEventRepository<Show> {

	List<Show> findAllByEventIdAndTheatreId(Long eventId, Long theatreId);

}
