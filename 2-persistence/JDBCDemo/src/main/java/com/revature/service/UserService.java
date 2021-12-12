package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;

public class UserService {
	// we will inject a DAO object into this class, so that this class can use its methods
	// DEPENDENCY INJECTION
	
	public IUserDAO udao = new UserDAO();
	
	private Logger logger = Logger.getLogger(UserService.class);
	
	
	public User register(User u) {
		
		logger.info("Registering User....");
	
		if (u.getId() != 0) {
			throw new RegisterUserFailedException("User not valid to register because id was " + u.getId() + "and not 0.");
			
			
				
			
		} 
		
		int generatedId = udao.insert(u);
		
		// is the generated Pk -1? Is it equal to the User's Id that has passed through the method.
		
		if(generatedId != -1 && generatedId != u.getId() ) {
			u.setId(generatedId);
		} else {
			throw new RegisterUserFailedException("User id was either "); // TODO
		}
		
		logger.info("Successfuly registered User with the id of " + u.getId());
		
		return u;
			
		
		
	}
}
