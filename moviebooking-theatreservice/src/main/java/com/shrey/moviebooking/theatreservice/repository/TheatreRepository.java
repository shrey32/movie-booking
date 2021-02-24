package com.shrey.moviebooking.theatreservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Theatre;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

	List<Theatre> findAllByAdressId(Iterable<Long> ids);

}
