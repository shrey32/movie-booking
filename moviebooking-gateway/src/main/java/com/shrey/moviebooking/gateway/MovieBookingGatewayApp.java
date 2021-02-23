package com.shrey.moviebooking.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @author Shrey
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MovieBookingGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingGatewayApp.class, args);
	}

}
