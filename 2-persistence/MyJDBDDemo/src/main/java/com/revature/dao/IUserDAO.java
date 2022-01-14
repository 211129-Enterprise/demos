package com.revature.dao;

import java.util.List;

import com.revature.models.User;

/*The DAO (or Data layer) of our project consists of the dao interface which will outline the crud methods we'll be using on our concrete classes
 *Against the database
 *
 *Create
 *Read
 *Update
 *Delete
 */

public interface IUserDAO {
	//insert a user and return the integer key the database produces
	int insert(User u);
	
	//read
	User findById(int id);
	User findByUsername(String username);
	List<User> findAll();
	
	//update
	boolean update(User u);
	
	//delete
	boolean delete(int id);
	
}
