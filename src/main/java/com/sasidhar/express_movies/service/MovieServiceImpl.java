package com.sasidhar.express_movies.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasidhar.express_movies.dto.DirectorDTO;
import com.sasidhar.express_movies.dto.MovieDTO;
import com.sasidhar.express_movies.entity.Director;
import com.sasidhar.express_movies.entity.Movie;
import com.sasidhar.express_movies.repository.MoviesRepository;

@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MoviesRepository moviesRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addMovieAndDirector(MovieDTO movieDTO, List<DirectorDTO> directorDTOs) {

		try {
			System.out.println("------------Inserting movie and director--------------------");
			Optional<Movie> checkMoviesExistance = moviesRepository.findByMovieTitle(movieDTO.getMovieTitle());
			boolean isMovieExist = (!checkMoviesExistance.isEmpty()) ? true : false;

			if (isMovieExist) {
				throw new Exception("Movie already exists");
			} else {
				// Insert into the database
				Movie movie = modelMapper.map(movieDTO, Movie.class);
				List<Director> directors = new ArrayList<>();
				for (DirectorDTO directorDTO : directorDTOs) {
					directors.add(modelMapper.map(directorDTO, Director.class));
				}

				movie.setDirectors(directors);
				moviesRepository.saveAndFlush(movie);

				System.out.println("INSERTION successful");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getMovie(String title) {
		// TODO Auto-generated method stub
		try {
			System.out.println("-----------Getting movies matched with title");
			List<Movie> movies = moviesRepository.findByMovieTitleLike(title);
			System.out.println("Movie matches are: ");
			for (Movie movie : movies) {
				System.out.println(movie.getMovieTitle());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void getDirectorDetailsThroughMovieTitle(String movieTitle) {
		// TODO Auto-generated method stub
		Optional<Movie> movie = moviesRepository.findByMovieTitle(movieTitle);
		if (movie.isEmpty()) {
			System.out.println("Movie is not present in the table");
		} else {
			movie.get().getDirectors().forEach(System.out::println);
		}

	}

	@Override
	public void getAllMovies() {
		// TODO Auto-generated method stub
		moviesRepository.findAll().forEach(System.out::println);

	}

	@Override
	public void updateReleaseDate(String movieTitle, LocalDate updatedReleaseDate) {
		// TODO Auto-generated method stub
		Optional<Movie> movie = moviesRepository.findByMovieTitle(movieTitle);
		if (movie.isEmpty()) {
			System.out.println("The movie not present in the table");
		} else {
			Integer rowsAffected = moviesRepository.updateReleaseDateWithMovieTitle(movieTitle, updatedReleaseDate);
			System.out.println("Number of rows affected: " + rowsAffected);
		}

	}

	@Override
	public void deleteMovie(String title) {
		// TODO Auto-generated method stub
		Optional<Movie> movie = moviesRepository.findByMovieTitle(title);
		if (movie.isEmpty()) {
			System.out.println("Movie not found");
		} else {
			Integer rowsAffected = moviesRepository.deleteByMovieTitle(title);
			System.out.println("Number of rows affected: " + rowsAffected);
		}

	}

}
