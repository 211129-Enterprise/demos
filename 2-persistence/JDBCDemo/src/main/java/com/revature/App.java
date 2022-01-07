package com.revature;

import java.util.LinkedList;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class App {
	
	static Scanner scan = new Scanner(System.in);

	// This is the entry point of my application!
	public static void main(String[] args) {
		
		run();


	}
	
	public static void run() {
		
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! If you're an existing Customer and you'd like to login, please press 1 \n If you're a new Customer please press 2");
		
		// capture the input  of the user
		int input = scan.nextInt();
		
		// make sure you're accounting for exeptions that could occur when a user DOESN'T enter 1 or 2
		
		if (input == 1) {
			
			// call the login method from the UserService
			System.out.println("Please enter your username");
			String username = scan.next();
		
			System.out.println("Please enter your password");
			String password = scan.next();
			
			User loggedInUser = userv.login(username, password);
			
			// set up some logic here to continue some operations 
			
			// offer a menu where you ask if they want to review their accounts, etc....
			// make a deposit, a withdrawal 
			
			// maybe you want to ask  the user would you like to view all your accounts?

		} else if (input == 2) {
			
			System.out.println("Enter the username you'd like to sign up with");
			String username = scan.next();
			
			System.out.println("Enter a secure password");
			String password = scan.next();
			
			User u = new User(0, username, password, Role.Customer, new LinkedList<Account>());
			
			userv.register(u);
			
			System.out.println("reigstered user " + u);
			
			// from there do what you want
			
		}
		
		
		
		
	}

}
