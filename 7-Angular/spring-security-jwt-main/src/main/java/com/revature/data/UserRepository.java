package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByUsername(String username);

}
