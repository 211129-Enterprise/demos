package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;

public class UserService {
	
	private Logger logger = Logger.getLogger(UserService.class);
	
	// we will inject a DAO object into this class, so that this class can use its methods
	// DEPENDENCY INJECTION
	private IUserDAO udao = new UserDAO();
	

	public User register(User u) {
		
		logger.info("Registering User....");
		
		// maybe it checks that the User has an id of 0 BEFORE trying to register it
		if (u.getId() != 0) {
			//  All User objects that HAVEN'T been persisted to the DB have an id of 0
			throw new RegisterUserFailedException("User not valid to register because Id was " + u.getId() + " and not 0.");
			// let's make a custom exception called RegisterUserFailed Exception to specify what went wrong...
		}
		
		// if the User's id IS 0.. call on the DAO to insert the object
		int generatedId = udao.insert(u); // this returns the primary key of the inserted User
		
		// is the generate Pk -1? is it equal to the User's Id that was passed thru the method?
		if (generatedId != -1 && generatedId != u.getId()) {
			u.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("User's Id was either -1 or did not change after insertion into DB"); 
		}
		
		logger.info("Successfully registered User with the id of " + u.getId());
		return u;
	}
	
	public void listAllAccounts() {
		
		// return all the user accounts that exist in the DB
		
	}
	

}
