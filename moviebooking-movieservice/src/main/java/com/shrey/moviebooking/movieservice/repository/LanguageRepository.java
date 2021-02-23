package com.shrey.moviebooking.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Language;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
