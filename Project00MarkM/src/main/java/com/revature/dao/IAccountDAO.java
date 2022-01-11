package com.revature.dao;

import java.util.List;
import java.util.Random;

import com.revature.accounts.Checking;
import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.classes.Employee;

public interface IAccountDAO {
	//Checking ================================================================================================
	Customers insert(Checking i, Customers p);
	Employee insert2(Checking i, Employee f);
	Administrator insert3(Checking i, Administrator r);
	
	//list 3 methods
	List<Checking> findAll();
	Checking findById(int id);
	List<Checking> findByOwner(String i); //a user can have many accounts
		//a class i.e like CheckingAccount which extends Account may still be stored in this list
		//because it's a sub-type.
	
	//list 3 methods
	boolean transfer(int id1, int id2, double transfer);
	double update(double balance, int id);
	boolean delete(int id);
	boolean approve(int id);
	boolean deny(int id);
	
	
	static String Number() {
		int min = 10000000;
		int max = 99999999;
		Random r = new Random();
		int randomNumber = r.nextInt((max + 1 - min) + min);
		String str = String.valueOf(randomNumber);
		return str;
	}
}	
