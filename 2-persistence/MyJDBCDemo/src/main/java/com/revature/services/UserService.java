package com.revature.services;

import org.apache.log4j.Logger;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;

public class UserService {
	
	private Logger logger = Logger.getLogger(UserService.class);
	
	/** 
	 * we will inject a DAO object into this class, so that this class can use its methods
	 * DEPENDENCY INJECTION
	 */
	IUserDAO udao = new UserDAO();
	
	public User register(User u) {
		
		logger.info("Registering User...");
		
		// maybe it checks that the User has an id of 0 BEFORE trying to register it
		if (u.getId() != 0) {
			// All user objects that haven't been persisted to the DB have an id of 0
			throw new RegisterUserFailedException("User not valid to register because ID was " + u.getId() + " and not 0.");
			
			// let's make a custom exception called RegisterUserFailedException...	
			
		}
		
		// if the User's id IS 0...
		int generatedId = udao.insert(u); // this returns the primary key of the inserted User
		
		// is the generate pk -1? is it equal to the User's Id that was passed through the method?
		if (generatedId != -1 && generatedId != u.getId()) {
			
			u.setId(generatedId);
			
		} else {
			throw new RegisterUserFailedException("User's Id was either -1 or did not change after insertion into DB");
			
		}
		
		logger.info("Successfully registered User with the id of " + u.getId());
		
		
		return u;
		
	}
	
}
