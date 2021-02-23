package com.shrey.moviebooking.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Shrey
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class BookingServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApp.class, args);
	}

}
