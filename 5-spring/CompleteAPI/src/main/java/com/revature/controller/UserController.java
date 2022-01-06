package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

// Component-> Controller -> RestController (Very specific type of SteroType Annotation)
@RestController // automatically infers that the return vlaue of all methods below will be within the HttpResponse body
@RequestMapping("/users") // all methods available at localhost:5000/users...
public class UserController {
	
	
	@Autowired
	UserService userServ;
	
	// a GET request to the above URL
	@GetMapping
	public Set<User> getAll() {
		// Spring Boot web starter has Jackson Object Mapper automatically built in so this willbe returned as JSON
		return userServ.findAll(); // findAll() from userService!
	}
	
	@GetMapping("find/{username}")  // localhost:5000/users/find/spongebob <- we extract this parameter
	public User findByUsername(@PathVariable("username") String username) {
		
		return userServ.getByUsername(username);
	}
	
	// Think of how you implement the following methods
	
	// POST - add()
	
	// GET - getById() - extract the id from the URI like in findByUsername();
	
	// DELETE - removeById() - extract the id from the URI like in findByUsername();
	
	

}
