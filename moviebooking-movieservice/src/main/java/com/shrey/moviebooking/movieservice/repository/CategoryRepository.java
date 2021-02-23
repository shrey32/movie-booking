package com.shrey.moviebooking.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrey.moviebooking.commons.model.Category;

/**
 * 
 * @author Shrey
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
