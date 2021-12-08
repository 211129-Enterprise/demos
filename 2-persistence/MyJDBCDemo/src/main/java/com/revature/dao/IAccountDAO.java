package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDAO {

	int insert(Account a);
	
	// 3 read methods
	
	List<Account> findAll();
	Account findById(int id);
	List<Account> findByOwner(int accOwnerId);
	// a class i.e. like CheckingAccount which extends account may still be stored in this list because it's a subtype
	
	boolean update(Account a);
	boolean delete(int id);
	
}
