package com.sasidhar.express_movies;

import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

import com.sasidhar.express_movies.service.DirectorService;
import com.sasidhar.express_movies.service.DirectorServiceImpl;
import com.sasidhar.express_movies.service.MovieService;
import com.sasidhar.express_movies.service.MovieServiceImpl;

@SpringBootApplication
public class ExpressMoviesApplication {

	// Bean that helps mapping a DTO to an entity and vice versa
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication
				.run(ExpressMoviesApplication.class, args);

		MovieService movieService = (MovieServiceImpl) context.getBean("movieService");

		DirectorService directorService = (DirectorServiceImpl) context.getBean("directorService");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

		// 1. Adding new director and new movie code
//		List<DirectorDTO> directorDTOs = Arrays
//				.asList(new DirectorDTO("Sharwanandh", "S", "Hyderabad", 1234567890, "radhas@gmail.com"));
//
//		movieService.addMovieAndDirector(new MovieDTO("Radha", LocalDate.now(), LocalDateTime.now()), directorDTOs);

		// 2. Get movie matches based on the input
//		movieService.getMovie("radh");

		// 3. Get director details through Movie name
//		movieService.getDirectorDetailsThroughMovieTitle("RRR");

		// 4. Get all movies
//		movieService.getAllMovies();

		// 5. update the release date
//		movieService.updateReleaseDate("RRR", LocalDate.parse("2022-06-30", formatter));

		// 6. Delete Movie based on title
//		movieService.deleteMovie("Radha");

		// 7. update director details
//		directorService.updateDirectorDetails("Rajamouli", "ss", "Vishakapatnam", 1234567089);

//		 8. Get movies through director name
		directorService.getMoviesThroughDirectorName("Rajamouli", "ss");

//		context.close();

	}
}
