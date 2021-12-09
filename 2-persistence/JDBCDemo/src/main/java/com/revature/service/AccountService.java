package com.revature.service;

import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.IAccountDAO;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountService {
	
	private IAccountDAO adao = new AccountDAO();
	
	private static Scanner scan = new Scanner(System.in);
	
//	public Account openAccount(User u) {
//		System.out.println("Please enter your initial deposit amount");
//		
//		double deposit = scan.nextDouble();
//		
//		Account a = new Account(0, deposit, u.getId(), true);
//				
//				int pk = adao.insert(a);
//				
//				
//	}
//	
//	public void viewAllAccountByOwner(int accOwnerId) {
//		for (Account a : adao.findByOwner(accOwnerId)) {
//			System.out.println(a);
//		}
//	}

}
