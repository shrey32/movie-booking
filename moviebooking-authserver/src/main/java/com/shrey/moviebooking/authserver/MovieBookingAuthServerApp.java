package com.shrey.moviebooking.authserver;


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
public class MovieBookingAuthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(MovieBookingAuthServerApp.class, args);
        System.out.println("Authorization server started....");
    }

}
