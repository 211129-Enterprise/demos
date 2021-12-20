package com.revature.dao;

import java.util.List;

import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;

/*
 * The DAO (or data layer or our project consists of DAO interface
 * which outlines the CRUD methods we'll be using our DAO concrete class to perform
 * against our database.
 * 
 * CRUD - create, read, update, delete 
 */

public interface IUserDAO {
	
	//Here we outline all of  the method that the SAO implementation 
	
	
	//Insert a User object, and return the primary key that the DB generates.
	int insert(Customers c);
	
				//Read: return 1, return all
				Customers findCustomersById(int id); //return the User object associated with the PK in the DB
				Customers findCustomersByUsername(String username); //return the User object in the DB that has that unique username
				List<Customers> findAll(boolean b); //returns a list of all User objects in the database;
				
				//Update:
				boolean update(Customers i); //update that object in the DB and return true if it was updated successfully or false if there was a problem
	
				boolean delete(Customers c); //take in the id of the User we want to delete in the DB

	int insert(Employee e);
	
				Employee findEmployeeById(int id); //return the User object associated with the PK in the DB
				Employee findEmployeeByUsername(String username); //return the User object in the DB that has that unique username
	
				//Update:
				Employee update(Employee e); //update that object in the DB and return true if it was updated successfully or false if there was a problem
	
				boolean delete(Employee e); //take in the id of the User we want to delete in the DB

	int insert(Administrator a);
	
				Administrator findAdministratorById(int id); //return the User object associated with the PK in the DB
				Administrator findAdministratorByUsername(String username); //return the User object in the DB that has that unique username
	
				//Update:
				Administrator update(Administrator a); //update that object in the DB and return true if it was updated successfully or false if there was a problem
	
				boolean delete(Administrator a);

	
				
}
