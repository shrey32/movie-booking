package com.shrey.moviebooking.bookingservice.service;

import java.util.Optional;

import com.shrey.moviebooking.bookingservice.dto.BookingDTO;

/**
 * 
 * @author Shrey
 *
 */
public interface BookingDTOService {

	BookingDTO create(BookingDTO bookingDTO);

	Optional<BookingDTO> findById(Long id);
}
