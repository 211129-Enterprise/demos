package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.revature.data.AddressRepository;
import com.revature.data.UserRepository;
import com.revature.exception.UserNotFoundException;
import com.revature.model.User;

@Service
public class UserService {
	
	/**
	 * @Transactional on Service methods:
	 * 				  In the case that multiple dao methods were
	 *                being called, we want to make sure that those methods are
	 *                fired against the DB in one unit of work (transaction).
	 */
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	AddressRepository addressRepo;
	
	// why a Set? no duplicates!
	@Transactional(readOnly=true)
	public Set<User> findAll() {
		// return from the UserRepository the findAll() method but Stream it to a set
		return userRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	@Transactional(readOnly=true)
	public User getByUsername(String username) {
		// add a logging statement to check that username isn't empty
		// or maybe surround with try-catch statement
		
		return userRepo.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("No user found with username " + username));
	}
	
	
	@Transactional(readOnly=true)
	public User getById(int id) {
		
		if (id <= 0) {
			log.warn("Id cannot be Zero: {}", id);
			return null;
		}
		return userRepo.getById(id);
	}
 	
	// add() - return the User with it's ID
	// Every time this method is invoked I want to begin a new transaction
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User add(User u){
		
		User returnedUser = userRepo.save(u);	
		if (returnedUser.getId() > 0) {
			log.info("Successfully returned User with id {}", returnedUser.getId());
		} else {
			log.warn("Could not add user with username {}", u.getUsername());
		}
		// as long as the User's addresses are NOT null, add each addres by calling the save() method from the AddressRepository
		if (u.getAddresses() != null) {
			u.getAddresses().forEach(a -> addressRepo.save(a)); // you need to autowire an address repository into this service layer
		}
		
		return returnedUser;
	}
	
	@Transactional(propagation=Propagation.REQUIRED) // defaults setting of transactions in Spring
	public void remove(int id) { // JpaRespoitory is an interfaces that EXTENDS CrudRepository
		userRepo.deleteById(id);
	}
	
}
