package com.shrey.moviebooking.namingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Shrey
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class MovieBookingNamingServerApp {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingNamingServerApp.class, args);
	}

}
