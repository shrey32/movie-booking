package com.shrey.moviebooking.metadataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Shrey
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class MetaDataServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(MetaDataServiceApp.class, args);
	}

}
