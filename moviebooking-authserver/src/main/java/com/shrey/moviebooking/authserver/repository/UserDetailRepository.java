package com.shrey.moviebooking.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrey.moviebooking.authserver.models.User;

import java.util.Optional;

/**
 * 
 * @author Shrey
 *
 */
public interface UserDetailRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String name);

}