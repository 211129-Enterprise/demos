package com.revature.service;

import com.revature.dao.IUserDAO;
import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.User;

public class UserService {
	
	//Creating a UserDAO object of type IUserDao
	private IUserDAO udao = new UserDAO();
	
	public User register(User u) {
		if (u.getId() != 0) {
			throw new RuntimeException("User is not valid to register because ID is not 0");
			
		}
		
		int generatedID = udao.insert(u);
		
		if (generatedID != -1 && generatedID != u.getId()) {
			u.setId(generatedID);
		}
		else {
			throw new RegisterUserFailedException("User not valid to register because ID was -1 or matched an existing id");
		}
		
		return u;
		
	}
	

}
