package com.sasidhar.express_movies.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovieDTO {
	private Integer movieId;
	private String movieTitle;
	private LocalDate dateReleased;
	private LocalDateTime movieRunningTime;

	public MovieDTO() {

	}

	public MovieDTO(String movieTitle, LocalDate dateReleased, LocalDateTime movieRunningTime) {
		super();
		this.movieTitle = movieTitle;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}

	public MovieDTO(Integer movieId, String movieTitle, LocalDate dateReleased, LocalDateTime movieRunningTime) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public LocalDate getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(LocalDate dateReleased) {
		this.dateReleased = dateReleased;
	}

	public LocalDateTime getMovieRunningTime() {
		return movieRunningTime;
	}

	public void setMovieRunningTime(LocalDateTime movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieTitle=" + movieTitle + ", dateReleased=" + dateReleased
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}

}
