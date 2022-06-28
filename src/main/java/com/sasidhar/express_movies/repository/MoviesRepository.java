package com.sasidhar.express_movies.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sasidhar.express_movies.entity.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {

	@Query("from Movie m where m.movieTitle=?1")
	public Optional<Movie> findByMovieTitle(String title);

	@Query("from Movie m where m.movieTitle like CONCAT('%',?1,'%')")
	public List<Movie> findByMovieTitleLike(String title);

	@Modifying
	@Query("update Movie m set m.dateReleased=?2 where m.movieTitle=?1")
	public Integer updateReleaseDateWithMovieTitle(String title, LocalDate date);

	@Modifying
	@Query("delete from Movie m where m.movieTitle=?1 ")
	public Integer deleteByMovieTitle(String title);

}
