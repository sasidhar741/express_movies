package com.sasidhar.express_movies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sasidhar.express_movies.entity.Director;

@Repository
public interface DirectorsRepository extends JpaRepository<Director, Integer> {

	@Modifying
	@Query("update Director d set d.address=?1, d.mobileNumber=?2 where d.firstName=?3 and d.lastName=?4")
	Integer updateDetails(String address, Integer mobileNUmber, String firstName, String lastName);

	Optional<Director> findByFirstNameAndLastName(String firstName, String lastName);

}
