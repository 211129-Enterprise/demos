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

	//This is the entry point of my application!
	public static void main(String[] args) {
		
//		run();
		
//		ConnectionUtil.getConnection();
//		
//		//Return the re-used connection object
//		ConnectionUtil.getConnection();
		
//		UserService userv = new UserService();
//		userv.listAllAccounts();
		
		run();

	}
	
	//Static because it doesn't need to be instantiated
	public static void run() {
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		
		
		System.out.println("Welcome! If you're an existing customer and\n"
							+ "you'd like to login, please press 1\n"
							+ "If you're a new customer please press 2.");
		
		//Capture the input of the user
		int input = scan.nextInt();
		
		// Make sure you're accounting for exceptions that could occur when a user doesn't enter 1 or 2
		
		if(input == 1) {
			//call login method from the UserService
			System.out.println("Please enter your username");
			String username = scan.next();
			
			System.out.println("Please enter your password");
			String password = scan.next();
			
			userv.login(username, password);
			
			User loggedInUser = userv.login(username, password);
			
			//set up some logic here to continue some operations
			// Maybe ask the user what they'd like to do (e.g. check their options)
		} else if (input == 2) {
			
			System.out.println("Enter the username you'd like to sign up with");
			
			String username = scan.next();
			String password = scan.next();
			
			User u = new User(0, username, password, Role.Customer, new LinkedList<Account>());
			
			userv.register(u);
			
			System.out.println("Registered user " + u);
			
			//From there, do what you want with the user
		} else {
			System.out.println("Invalid input");
		}
		
		
// OLD APPROACH ////////////////////////////////////////////////////////////////
//		System.out.print("Welcome to The Bank!\n" +
//							"Press '1' to login\n > ");
//		
//		String input = scan.nextLine();
//		
//		if( input.equals("1")) {
//			User u = new User("PepperPotts", "secretPass", Role.Customer, null);
//			
//			UserService uservice = new UserService();
//			
//			uservice.register(u);
//		}
////////////////////////////////////////////////////////////////////////////////

	}

}
