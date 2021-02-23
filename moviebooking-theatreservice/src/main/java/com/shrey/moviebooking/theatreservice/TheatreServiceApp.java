package com.shrey.moviebooking.theatreservice;

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
public class TheatreServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(TheatreServiceApp.class, args);
	}

}
