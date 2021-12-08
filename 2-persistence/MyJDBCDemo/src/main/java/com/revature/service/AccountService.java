package com.revature.service;

import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.IAccountDAO;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountService {

	//inject the AccountDAO object on which this class depends
	private IAccountDAO adao = new AccountDAO();
	
	private static Scanner scan = new Scanner(System.in);
	
	public Account openAccount(User u) {
		
		//prompt the user to enter an intial deposit amount
		System.out.println("Please enter your initial deposit amount");
		
		//capture that value
		double deposit = scan.nextDouble();
		//instantiate an Account with the initial deposit
		Account a = new Account(0, deposit, ugetId(), true);
		
		//call the insert method and return PK
		int pk = adao.insert(a);
		
		//Set the instantiated Account's Id = to the PK
		a.setId(pk);
		
		
		//return the fully initialized account
		return a;
		
	}
	
	
	
	
	public void viewAllAccountsByOwner(int accOwnerId) {
		for (Account a : adao.findByOwner(accOwnerId)) {
			System.out.println(a);
		}
	}
	
}
