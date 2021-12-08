package com.revature;

import java.util.Scanner;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.UserService;

public class App {
	
	static Scanner scan = new Scanner(System.in);

	//This is the entry point of my application!
	public static void main(String[] args) {
		
		run();
		
//		ConnectionUtil.getConnection();
//		
//		//Return the re-used connection object
//		ConnectionUtil.getConnection();

	}
	
	//Static because it doesn't need to be instantiated
	public static void run() {
		System.out.print("Welcome to The Bank!\n" +
							"Press '1' to login\n > ");
		
		String input = scan.next();
		
		if( input.equals("1")) {
			User u = new User("PepperPotts", "secretPass", Role.Customer, null);
			
			UserService uservice = new UserService();
			
			uservice.register(u);
		}

	}

}
