package com.shrey.moviebooking.movieservice;

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
public class MovieServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApp.class, args);
	}

}
