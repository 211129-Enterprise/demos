package com.revature;

import java.util.Scanner;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.UserService;

public class App {
	
	static Scanner scan = new Scanner(System.in);

	// This is the entry point of my application!
	public static void main(String[] args) {
		
		run();

	}
	
	public static void run() {
		
		System.out.println("Welcome to the Bank!");
		
		System.out.println("Press 1 if you'd like to register");
		
		int input = scan.nextInt();

		if (input == 1) {
			
			
			String username = scan.next();
		
			User u = new User(username, "secretPass", Role.Customer, null);
				
			UserService uservice = new UserService();
			
			uservice.register(u);
		
		}

	}

}
