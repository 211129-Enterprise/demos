package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;

public class UserService {
	
	private Logger logger = Logger.getLogger(UserService.class);
	
	// We will inject a DAO object into this class, so that this class can use its methods
	// DEPENDENCY INJECTION
	public IUserDAO udao = new UserDAO();
	
	
	public User register(User u) {
		
		logger.info("Registering user...");
		
		//Maybe it checks that the user has an id of 0 BEFORE trying to register it
		if(u.getId() != 0) {
			//All User Objects that HAVEN'T been persisted to the DB have an id of 0
			//throw new RuntimeException(); //Best to create a custom exception to specify what exactly went wrong
			throw new RegisterUserFailedException("User not valid to register because ID was " + u.getId() + " and NOT 0");
		}
		
		// If the User's ID is 0... Call on the DAO to insert the object
		int generatedId = udao.insert(u); // This returns the primary key of the inserted user
		
		//Is the generated PK -1? Is it equal to the user's Id that was passed through the method?
		if(generatedId != -1 && generatedId != u.getId()) {
			
			u.setId(generatedId);
			
		} else {
			throw new RegisterUserFailedException("User's Id was either -1 or did not change after insertion into DB"); //We need to change this to be a custom exception
			
		}
		
		logger.info("Successfully registered User with the id of " + u.getId());
		
		return u;
	}
	
	public void listAllAccounts() {
		
		// return all the user accounst that exist in the DB
		for(User u : udao.findall()) {
			System.out.println(u);
		}
		
		// Java 8 addition is the forEach() loop
		List<User> users = udao.findall();
		users.forEach( u -> System.out.println(u) ); // Using a lambda ( -> ) to define functionality
		
	}
	
	public User login(String username, String password) {
		
		// Call our DAO's findByUserName() method to return the users from the DB
		User returnedUser = udao.findByUsername(username);
		
		if(returnedUser.getPassword() == password) {
			
			System.out.println("SUCCESSFULLY LOGGED IN!");
			return returnedUser;
		}
			
		// Otherwise if the password is not equal to the queried user
		return null;
	}
}
