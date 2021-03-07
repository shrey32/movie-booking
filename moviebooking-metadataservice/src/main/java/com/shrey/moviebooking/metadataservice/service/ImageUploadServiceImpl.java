package com.shrey.moviebooking.metadataservice.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;


import com.shrey.moviebooking.metadataservice.enums.ResourceType;

import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.NoResponseException;

/**
 * 
 * @author Shrey
 *
 */
@Service
public class ImageUploadServiceImpl implements ImageUploadService {

	private static final Logger log = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

	private MinioClient minioClient;

	@Value("${spring.minio.bucket}")
	private String bucket;

	@Value("${spring.minio.url}")
	private String minioURL;

	@Autowired
	public ImageUploadServiceImpl(MinioClient minioClient) {
		this.minioClient = minioClient;
	}

	@Override
	public Optional<String> upload(Long eventId, String eventName, ResourceType resourceType, MultipartFile file) {
		log.info("Uploading " + resourceType + " for Event {" + eventName + "} and EventId {" + eventId + "}");
		String path = path(eventId, eventName, resourceType, file.getOriginalFilename());
		String mimeType = mimeType(resourceType);
		log.info("{" + eventId + "," + eventName + "} Image Path " + path + " and mimetype " + mimeType);
		try {
			minioClient.putObject(bucket, path, file.getInputStream(), null, null, null, mimeType);
			StringBuilder uploadedPath = new StringBuilder(minioURL).append("/").append(bucket).append("/").append(path);
			log.info("{" + eventId + "," + eventName + "} uploaded to {" + uploadedPath + "}");
			return Optional.of(uploadedPath.toString());
		} catch (InvalidKeyException | InvalidBucketNameException | NoSuchAlgorithmException | NoResponseException
				| ErrorResponseException | InternalException | InvalidArgumentException | InsufficientDataException
				| InvalidResponseException | IOException | XmlPullParserException e) {
			log.error("Error occurred while uploading Resource for {" + eventId + "," + eventName + "}", e);
		}
		return Optional.empty();
	}

	/**
	 * 
	 * @param eventId
	 * @param eventName
	 * @param resourceType
	 * @return
	 */
	private String path(Long eventId, String eventName, ResourceType resourceType, String fileName) {
		StringBuilder path = new StringBuilder(eventId + "").append("/").append(eventName).append("/").append(resourceType).append("/").append(fileName);
		return path.toString();
	}

	private String mimeType(ResourceType resourceType) {
		if (ResourceType.TRAILER == resourceType)
			return "video/mp4";
		return "image/jpeg";
	}

}
