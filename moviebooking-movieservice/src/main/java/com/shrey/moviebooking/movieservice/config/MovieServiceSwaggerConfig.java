package com.shrey.moviebooking.movieservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Shrey
 *
 */
@Configuration
@EnableSwagger2
public class MovieServiceSwaggerConfig {

	@Value("${swagger.host.url}")
	private String hostUrl;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).host(hostUrl).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.shrey.moviebooking.movieservice.controllers"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Movie Service API").description("Movie Service API reference for developers")
				.version("0.1").build();
	}

}
