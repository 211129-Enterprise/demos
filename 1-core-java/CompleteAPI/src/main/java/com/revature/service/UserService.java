package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.UserRepository;
import com.revature.exception.UserNotFoundException;
import com.revature.model.User;

public class UserService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepository userRepo;
	
	@Transactional(readOnly=true)
	public Set<User> findAll() {
		return userRepo.findAll().stream().collect(Collectors.toSet());
	}
	
	@Transactional(readOnly=true)
	public User getByUsername(String username) {
		return userRepo.findByUsername(username).orElseThrow(() -> new UserNotFoundException("No user found with username  " + username));
	}
	
	@Transactional(readOnly=true)
	public User getById(int id) {
		return userRepo.getById(id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User add(User u) {
		
		User returnedUser = userRepo.save(u);
		if (returnedUser.getId() > 0) {
			log.info("Successfully returned user with id {}", returnedUser.getId());
		}
		return userRepo.save(u);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void remove(int id) {
		userRepo.deleteById(id);
	}
}
