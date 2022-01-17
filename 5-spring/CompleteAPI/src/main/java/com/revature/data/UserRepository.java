package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{ // JPA extends PagingAndSortingRepository which extends CrudRepo

	// automatically remember  that Spring Data JPA
	Optional<User> findByUsername(String username); // property expressions! Srping Data JPA infers the SQL statement
	
	public List<User> findByOrderByLastName();
	
	// TODO: modify this so that it returns either boolean or PK of the user deleted.
//	public void deleteById(int id);
	
	@Query("FROM User WHERE email LIKE %:pattern")
	public List<User> findByEmailContains(String pattern); // johnsmi -> returns John Smith's User obj based on the full email johnSmith@mail.com
	
	// findById();
	
}
