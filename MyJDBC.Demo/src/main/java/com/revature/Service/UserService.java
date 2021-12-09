package com.revature.Service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.DAO.IUserDAO;
import com.revature.DAO.UserDAO;
import com.revature.Exceptions.RegisterUserFailedException;
import com.revature.models.User;

public class UserService {


	public 	IUserDAO  udao = new UserDAO();
	private Logger logger = Logger.getLogger(UserService.class);
	
	// we will inject a DAO object into this class ,
	
	// DEPENDENCY INJECTUON
	
	
	 public User register(User u) {
		 if(u.getId() != 0) {
			 // all user objects that Havent been persited to be the DB have an id of 0
			 logger.info("Registring User ......");
			 
			 
			 throw new RegisterUserFailedException("User not valid to register because Id was :" +u.getId() +"and not 0");
		 }
		 
		 
		 int generatedId =	udao.insert(u);
		 System.out.println(generatedId);
		 
		 if(generatedId != -1 && generatedId != u.getId()){
		 u.setId(generatedId);
		 }else {
			 throw new RegisterUserFailedException("User was either -1 or did not change in the db");
		 }
		 
		 logger.info("seccefully registred with " + u.getId());
		 
		return u;
		 
	 }

	 
		public void listAllAccounts() {
			
			for(User u : udao.findAll()) {
				
				System.out.println(u);
				
			}
			
			List <User> users = udao.findAll();
			
			
			// lamda function 
			users.forEach(u-> System.out.println(u));
			
			
			
			
		}
	
};
