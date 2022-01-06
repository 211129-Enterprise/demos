package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController // Automatically infers that the return value of all methods will be within the HttpResponse body
@RequestMapping("/users") // All methods will be available at localhost:5000/users...
public class UserController {
	
	@Autowired
	UserService userServ;
	
	
	// A GET request to the above URL
	@GetMapping
	public Set<User> getAll(){
		
		// Spring Boot web starter has Jackson Object Mapper automatically built in so this will be returned as a JSON
		return userServ.findAll(); //findAll() from userService!
	}
	
	@GetMapping("find/{username}") // localhost:5000/users/spongebob <- We can extract this parameter
	public User findByUsername(@PathVariable("username") String username) {
		
		return userServ.getByUsername(username);
				
	}
	
	
	// Think of how you would implement the following methods:
	// POST - add()
	// GET - getById() - extract the ID from the URI like in findByUsername();
	// DELETE - removeById() - extract the id from the URI like in findByUsername();
}
