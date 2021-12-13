package com.revature;

import java.util.LinkedList;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class Application {
	
	static Scanner scan = new Scanner(System.in);
	

	// This is the entry point of my application!
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! If you're an existing Customer and you'd like to log in, please press 1.\nIf you're a new customer, please press 2.");
		
		// capture the input of the user
		int input = scan.nextInt();
		
		// make sure to account for exceptions that occur when a user doesn't enter 1 or 2.
		
		if (input == 1) {
			
			// call the login method from UserServices
			System.out.println("Please enter your username");
			String username = scan.next();
			System.out.println("Please enter your password");
			String password = scan.next();
			
			User loggedInUser = userv.login(username, password);
			
			// Menu Options
			// make a deposit, open account, withdraw, transfer, close account
			
			// maybe ask to view all accounts
			
		} else if (input == 2) {
			System.out.println("Please enter the username you'd like to sign up with");
			String username = scan.next();
			System.out.println("Please enter a password");
			String pwd = scan.next();
			
			User u = new User(0, username, pwd, Role.Customer, new LinkedList<Account>());
			
			userv.register(u);
			
			System.out.println("Registered user " + u);
		}
		
	}
	
}	