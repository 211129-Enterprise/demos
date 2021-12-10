package com.revature.service;

import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.IAccountDAO;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountService {

	// Inject the AccountDAO object on which this class depends
	private IAccountDAO adao = new AccountDAO();
	
	private static Scanner scan = new Scanner(System.in);

	public Account openAccount(User u) {

		// Prompt the user to enter an inital deposit amount
		System.out.print("Please enter your initial deposit amount\n >");
		
		// Capture that value
		double deposit = scan.nextDouble();

		// Instantiate an account with the initial deposit
		Account a = new Account(0, deposit, u.getId(), true);

		// Call the insert method and return the primary key
		int pk = adao.insert(a);

		// Set the instantiated Account's Id = to the PK
		a.setId(pk);

		// Return the fully initialized account
		return a;
	}

	public void viewAllAccountsByOwner(int accOwnerId) {

		for (Account a : adao.findByOwner(accOwnerId)) {
			System.out.println(a);
		}
	}
	
	public void deposit(double depositAmount, int acc_owner_id) {
		
		// Have the logic to query the correct account
		// Update the balance there
		
	}
}
