package com.sasidhar.express_movies.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	private String movieTitle;
	private LocalDate dateReleased;
	private LocalDateTime movieRunningTime;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "movieDirector", joinColumns = @JoinColumn(name = "movieId", referencedColumnName = "movieId"), inverseJoinColumns = @JoinColumn(name = "directorId", referencedColumnName = "directorId"))
	private List<Director> directors;

	public Movie() {

	}

	public Movie(Integer movieId, String movieTitle, LocalDate dateReleased, LocalDateTime movieRunningTime) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
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
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", dateReleased=" + dateReleased
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}

}
