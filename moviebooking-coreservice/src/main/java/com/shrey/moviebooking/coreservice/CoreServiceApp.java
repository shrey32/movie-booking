package com.shrey.moviebooking.coreservice;

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
public class CoreServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(CoreServiceApp.class, args);
	}

}
