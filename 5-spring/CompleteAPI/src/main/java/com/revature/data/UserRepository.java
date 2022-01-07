package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	// automatically remember
	Optional<User> findByUsername(String username);
	
	public List<User> findByOrderByLastName();
	
//	// TODO: modify this so that it returns either boolean or PK of the user deleted
//	public void deleteById(int id);
	
	@Query("From User WHERE email LIKE %:pattern")
	public List<User> findByEmailContains(String pattern); //johnsmi -> returns John's user object based on full email
	
}
