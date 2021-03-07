package com.shrey.moviebooking.metadataservice.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 
 * @author Shrey
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = { "com.shrey.moviebooking.metadataservice.repository" })
public class MetaDataServiceConfig {

}