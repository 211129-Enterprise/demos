package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDAO {
	
	int insert(Account a);
	
	
	// 3 Read Methods
	List<Account> findAll();
	Account findById(int id);
	List<Account> findByOwner(int accOwnerId); // A user can have many accounts
	// A class i.e. like CheckingAccount which extends Account may still be stored in this list
	// because it is a sub type.
	
	
	boolean update(Account a);
	boolean delete(int id);

}
