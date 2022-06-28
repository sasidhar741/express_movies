package com.sasidhar.express_movies.service;

import java.time.LocalDate;
import java.util.List;

import com.sasidhar.express_movies.dto.DirectorDTO;
import com.sasidhar.express_movies.dto.MovieDTO;

public interface MovieService {

	public void addMovieAndDirector(MovieDTO movieDTO, List<DirectorDTO> directorDTOs);

	public void getMovie(String title);

	public void getDirectorDetailsThroughMovieTitle(String movieTitle);

	public void getAllMovies();

	public void updateReleaseDate(String movieTitle, LocalDate updatedReleaseDate);

	public void deleteMovie(String title);

}
