package com.revature.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

// Component-> Controller -> RestController (Very specific type of SteroType Annotation)
@RestController // automatically infers that the return value of all methods below will be within the HttpResponse body
@RequestMapping("/users") // all methods available at localhost:5000/api/users...
@CrossOrigin(origins = "*") // this exposes this controller to all ports
public class UserController {
	
	
	@Autowired
	UserService userServ;
	
	// a GET request to the above URL
	@GetMapping
	public ResponseEntity<Set<User>> getAll() {
		// Spring Boot web starter has Jackson Object Mapper automatically built in so this willbe returned as JSON
		return ResponseEntity.ok(userServ.findAll()); // findAll() from userService!
	}
	
	@GetMapping("/find/{username}")  // localhost:5000/users/find/spongebob <- we extract this parameter
	public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
		
		return ResponseEntity.ok(userServ.getByUsername(username));
	}
	
	// Think of how you implement the following methods
	
	// POST - add()
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User u) { // valid annotation ensures that we can only accept a VALID user object
		// will return the newly added User object in JSON
		return ResponseEntity.ok(userServ.add(u)); 
	}
	
	// GET - getById() - extract the id from the URI like in findByUsername();
	@GetMapping("/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
		
		return ResponseEntity.ok(userServ.getById(id));
	}
	
	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") int id) {
		userServ.remove(id);
	}
}
