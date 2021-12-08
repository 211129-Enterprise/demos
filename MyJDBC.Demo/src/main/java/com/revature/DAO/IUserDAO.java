package com.revature.DAO;

import java.util.List;

import com.revature.models.User;

/*
 * the DAO (or DATA layer of our project consist of DAO
 * 
 * 
 * CRUD
 * 
 */

public interface IUserDAO {
	//Insert
	int insert(User u);
	
	
	
	// read
	User findByID(int id); 
	
	
	User findByUserName(String username);
	
	
	List<User> findAll();
	
	
	//Update 
	
	boolean Update(User u); 
	
	// delete 
	
	boolean delete(int id);
	
	
}
