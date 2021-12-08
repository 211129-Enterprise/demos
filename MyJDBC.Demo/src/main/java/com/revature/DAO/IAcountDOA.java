package com.revature.DAO;

import java.util.List;

import com.revature.models.Account;

public interface IAcountDOA {
	
	int insert(Account a);
	List<Account> findAll();
	Account findBYId(int id);
	List<Account> findByOwner(int accOwnerId);
	
	boolean update(Account a);
	boolean delete(int id);
	

}
