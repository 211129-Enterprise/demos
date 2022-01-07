package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{ // JpaRepository extends CrudRepository
	
	// Automatically remember that Spring Data JPA
	Optional<User> findByUsername(String username);
	
	public List<User> findByOrderByLastName();
	
//	// TODO: Modify this so that it returns either boolean or PK of user deleted
//	public void deleteById(int id);
	
	@Query("FROM User WHERE email LIKE %:pattern")
	public List<User> findByEmailContains(String pattern); // johnsmith -> returns John Smith's user object based on full email johnsmith@email.tld

	// findById(); // Already created by Spring Tools
}
