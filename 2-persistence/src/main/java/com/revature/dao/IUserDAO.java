package com.revature.dao;

import java.util.List;

import com.revature.models.User;

/**
 * The DAO — or DATA layer of our project — consists of DAO interface
 * which outlines the CRUD — Create Read Update Delete — methods we'll
 * be using our DAO concrete class to perform.
 */
public interface IUserDAO {
	
	/* Here we outline all of the methods that the
	 * DAO Implementation Class must implement to perform
	 * the following CRUD methods on User Objects only
	 */
	
	//Insert a User object and return the primary key that the DB generates
	int insert(User u);
	
	//Read: return 1, return all
	User findById(int id); //return the User object associated with that PK, Primary Key, in the DB
	User findByUsername(String username); //return the User object in the DB that has that unique username
	List<User> findall(); // returns a List of all user objects in the DB
	
	// Update:
	boolean update(User u); //Update that object in the DB and return true if updated successfully otherwise false
	
	//Delete:
	boolean delete(int id); // Take in the ID of the User we want to delete in the DB.
	
	
}
