package com.sasidhar.express_movies.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasidhar.express_movies.entity.Director;
import com.sasidhar.express_movies.repository.DirectorsRepository;

@Service("directorService")
@Transactional
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	private DirectorsRepository directorsRepository;

	@Override
	public void updateDirectorDetails(String firstName, String lastName, String newAddress, Integer newContact) {
		// TODO Auto-generated method stub
		Integer rowsAffected = directorsRepository.updateDetails(newAddress, newContact, firstName, lastName);
		System.out.println("Number of rows affected: " + rowsAffected);

	}

	@Override
	public void getMoviesThroughDirectorName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		Optional<Director> director = directorsRepository.findByFirstNameAndLastName(firstName, lastName);
		if (director.isEmpty()) {
			System.out.println("Director not found");
		} else {
			director.get().getMovies().forEach(System.out::println);
		}

	}

}
