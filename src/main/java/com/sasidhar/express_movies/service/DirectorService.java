package com.sasidhar.express_movies.service;

public interface DirectorService {
	public void updateDirectorDetails(String firstName, String lastName, String newAddress, Integer newContact);

	public void getMoviesThroughDirectorName(String firstName, String lastName);

}
