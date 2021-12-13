package com.revature.dao;

import java.util.List;

import com.revature.models.User;

/**
 * The DAO (or DATA layer of our project consists of DAO interface
 * which outlines the CRUD methods we'll be using our DAO concrete class to perform 
 * against our database.
 *
 * CRUD - create, read, update, delete
 */

public interface IUserDAO {
	
	// Here we outline all of the methods that the DAO Implentation Class must implement to perform
	// the following CRUD methods on User Objects only 

	
	// Insert a User object, and return the primary key that the DB generates
	int insert(User u);
	
	// Read: return 1, return all 
	
	
	User findById(int id); // return the User object associated with that PK in the DB
	User findByUsername(String username); // return the User object in the DB that has that unique username
	List<User> findAll(); // returns a List of all User objects in the database;
	
	// Update: 
	boolean update(User u); // update that object in the DB and return true if it was updated successfully or false if there was a problem
	
	// Delete: 
	boolean delete(int id); // take in the id of the User we want to delete in the DB
	
}
