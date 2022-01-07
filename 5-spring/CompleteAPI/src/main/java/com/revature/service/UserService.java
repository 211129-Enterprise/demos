package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.UserRepository;
import com.revature.exception.UserNotFoundException;
import com.revature.model.User;

@Service
public class UserService {
	
	/**
	 * @Transactional on Service methods:
	 * 				  In the case that multiple dao methods were
	 * 				  being called, we want to make sure tha thtose methods
	 * 				  are fired against the DB in one unit of work (transaction).
	 */
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository userRepo;
	
	// why a Set? no duplicates
	@Transactional(readOnly=true)
	public Set<User> findAll() {
		// return from the UserRepository the findAll() method but Stream it to a set
		return userRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	@Transactional(readOnly=true)
	public User getByUsername(String username) {
		
		// add a logging statement to check that a username isn't empty
		// or try-catch
		
		return userRepo.findByUsername(username).orElseThrow(() -> new UserNotFoundException("No user found with username" + username));
	}
	
	// getById()
	@Transactional(readOnly=true)
	public User getById(int id) {
		
		if (id < 1) {
			log.warn("Id cannot be Zero: {}", id);
			return null;
		}
		
		return userRepo.getById(id);
	}
	
	// add() - return the User with its ID
	// Every time this method is invoked, I want to begin a new transaction
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User add(User u) {
		
		User returnedUser = userRepo.save(u);
		if (returnedUser.getId() > 0 ) {
			log.info("Successfully returned User with id {}", returnedUser.getId());
		} else {
			log.warn("Could not add user with username {}", u.getUsername());
		}
		
		return returnedUser;
	}
	
	// remove()
	@Transactional(propagation=Propagation.REQUIRED)
	public void remove(int id) {
		userRepo.deleteById(id);
	}
	
	
}
