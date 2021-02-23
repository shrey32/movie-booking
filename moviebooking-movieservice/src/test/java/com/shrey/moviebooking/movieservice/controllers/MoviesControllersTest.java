package com.shrey.moviebooking.movieservice.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shrey.moviebooking.commons.model.Movie;

/**
 * 
 * @author Shrey
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MoviesControllersTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void findMovieByIdTest() {
		ResponseEntity<Movie> merchantResponse = this.restTemplate
				.getForEntity("http://localhost:" + port + "/movieservice/movies/1", Movie.class);
		assertThat(merchantResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(merchantResponse).isNotNull();
		assertThat(merchantResponse.getBody().getName()).isNotNull();
	}

	@Test
	public void findAllMoviesTest() {
		ResponseEntity<Movie[]> merchantResponse = this.restTemplate
				.getForEntity("http://localhost:" + port + "/movieservice/movies", Movie[].class);
		assertThat(merchantResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(merchantResponse).isNotNull();
		assertThat(merchantResponse.getBody().length).isGreaterThan(1);
	}

	@Test
	public void createNewMovieTest() {
		ResponseEntity<Movie> merchantResponse = this.restTemplate.postForEntity("http://localhost:" + port + "/movieservice/movies",
				getDummyMovie(), Movie.class);
		assertThat(merchantResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(merchantResponse).isNotNull();
		assertThat(merchantResponse.getBody().getId()).isNotNull().isGreaterThan(0);
	}

	@Test
	public void deleteMovieByIdTest() {
		this.restTemplate.delete("http://localhost:" + port + "/movieservice/movies/1");
		ResponseEntity<Movie> merchantResponse = this.restTemplate
				.getForEntity("http://localhost:" + port + "/movies/1", Movie.class);
		assertThat(merchantResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	private Movie getDummyMovie() {
		Movie movie = new Movie();
		movie.setName("Movie Name");
		movie.setDescription("Test Merchant Description");
		return movie;
	}

}
