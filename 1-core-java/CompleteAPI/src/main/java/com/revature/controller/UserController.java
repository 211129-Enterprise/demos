package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@GetMapping
	public Set<User> getAll() {
		return userServ.findAll();
	}
	
	@GetMapping("find/{username}")
	public User findByUsername(@PathVariable("username") String username) {
		return userServ.getByUsername(username);
		
	}
}
