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

@RestController // automatically infers that the return value of all methods below will be within the HttpResponse body
@RequestMapping("/users") // all methods available at localhost:5000/users
public class UserController {

	@Autowired
	UserService uServ;
	
	// a get request to the above URL
	@GetMapping
	public Set<User> getAll() {
		// Spring Boot web starter has Jackson Object Mapper automatically built in so this will be returned as JSON
		return uServ.findAll();
	}
	
	@GetMapping("/find/{username}")  // localhost:5000/users/find/spongebob 
	public ResponseEntity<User> fetchByUsername(@PathVariable("username") String username) {
		
		return ResponseEntity.ok(uServ.getByUsername(username));
	}
	
	// Think of how you implement hte following methods
	// Post - add()
	@PostMapping("/new")		
	public ResponseEntity<User> registerNewUser(@Valid @RequestBody User u) { // valid annotation ensures we can only accept a VALID user object
		
		// will return the newly added User object in JSON
		return ResponseEntity.ok(uServ.add(u));
	}
	
	// GET - getById() - extract id from URI like in findByUsername();
	@GetMapping("/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable("id")int id) {
		return ResponseEntity.ok(uServ.getById(id));
	}
	
	// Delete - remove()
	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id")int id) {
		uServ.remove(id);
	}
	
	// PUT/PATCH - for update
	//
}
