package com.shrey.moviebooking.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shrey.moviebooking.gateway.filters.ErrorFilter;
import com.shrey.moviebooking.gateway.filters.PostFilter;
import com.shrey.moviebooking.gateway.filters.PreFilter;
import com.shrey.moviebooking.gateway.filters.RouteFilter;

/**
 * 
 * @author Shrey
 *
 */
@Configuration
public class MovieBookingGatewayConfig {

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
