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

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	
	// Why a set? No duplicates!
	@Transactional(readOnly=true)
	public Set<User> findAll(){
		
		// return from the UserRepository the findAll() method but Stream it to a set
		return userRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	
	// findByUsername()
	@Transactional(readOnly=true)
	public User getByUsername(String username) {
		
		// Add a logging statement to check that the user name isn't empty
		// or maybe surround with try-catch statement
		
		return userRepo.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("No user found with username " + username));
	}
	
	
	// getById()
	@Transactional(readOnly=true)
	public User getById(int id) {
	
		if(id <= 0) {
			log.warn("Id cannot be Zero: {}", id);
			return null;
		}
		
		return userRepo.getById(id);
	}
	
	
	// add() -> return the user with its ID
	// Everytime this method is invoked,
	// we want to begin a new transaction
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User add(User u) {
		
		User returnedUser = userRepo.save(u);
		
		// Log whether service layer method worked properly
		if(returnedUser.getId() > 0) {
			log.info("Successfully returned User with id #{}", returnedUser.getId());
		} else {
			log.info("Could not add user with username {}", u.getUsername());
		}
		
		// As long as the user's addresses are NOT null, add each address by 
		// calling the save method on it from the AddressRepository
		if(u.getAddresses() != null) {
			u.getAddresses().forEach(a -> addressRepo.save(a)); // You need to autowire and address repository into this service layer
		}
		
		
		return returnedUser;
	}
	
	
	// remove()
	@Transactional(propagation=Propagation.REQUIRED) // Default setting of transactions in spring
	public void remove(int id) { // JpaRepository is an interface that EXTENDS CrudRepository
		userRepo.deleteById(id);
	}
	
	
}
