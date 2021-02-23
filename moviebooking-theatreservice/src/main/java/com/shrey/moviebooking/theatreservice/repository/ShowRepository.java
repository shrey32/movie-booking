package com.shrey.moviebooking.theatreservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Show;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface ShowRepository extends JpaRepository<Show, Long>, DataByTheatreRepository<Show> {

	Optional<Show> findByScreenId(Long screenId);

}
