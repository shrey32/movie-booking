package com.shrey.moviebooking.metadataservice.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.shrey.moviebooking.metadataservice.enums.ResourceType;

/**
 * 
 * @author Shrey
 *
 */
public interface ImageUploadService {

	Optional<String> upload(Long eventId, String eventName, ResourceType resourceType, MultipartFile file);

}
