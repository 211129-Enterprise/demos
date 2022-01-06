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

// Component -> Controller -> RestController (Very specific type of Stereotype Annotation)
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
	
	
	@GetMapping("/find/{username}") // localhost:5000/users/spongebob <- We can extract this parameter
	public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
		
		return ResponseEntity.ok(userServ.getByUsername(username));
				
	}
	
	
	// POST - add()
	// TODO: Add the validation dependency and include @Valid
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User u) { // Valid annotation ensures that we can only accept a VALID user object
		
		// Will return the newly added user object in JSON
		return ResponseEntity.ok(userServ.add(u));
		
	}
	
	
	// GET - getById - Extract the ID from the URI like in findByUsername();
	@GetMapping("/find/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
		
		return ResponseEntity.ok(userServ.getById(id));
		
	}
	
	
	// DELETE - removeById - extract the id from the URI like in findByUsername()
	@DeleteMapping("/delete/{id}")
	public void removeUser(@PathVariable("id") int id) {
		
		userServ.remove(id);
		
	}
	

// TODO: add the update user service method
//	// UPDATE
//	@PutMapping("update/{id}")
	
	
	
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	// D U R I N G  T H E   B R E A K
	// Think of how you would implement the following methods:
	//
	// (MY ATTEMPTS):
	//
	// POST - add()
	//	@PostMapping(value= "/users")
	//	public User addUser(@Valid @RequestBody User user) {
	//		
	//		return userServ.add(user);
	//		
	//	}
	//	
	//	
	//	// GET - getById() - extract the ID from the URI like in findByUsername();
	//	@GetMapping("/find/{id}")
	//	public User getById(@PathVariable("id") int id) {
	//		
	//		return userServ.getById(id);
	//		
	//	}
	//	
	// DELETE - removeById() - extract the id from the URI like in findByUsername();
	// // Ran out of time
	//
	// Completing the methods,
	// FIll out the application.properties to include a database - connect to H@
	// Test with PostMan
	// add custom exception handling
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	
	
	
	
}
