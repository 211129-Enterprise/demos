package com.revature;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.ConnectionUtil;

public class Application {

	// This is the entry point of my application!
	public static void main(String[] args) {
		run();
		
//		ConnectionUtil.getConnection();
	}
	
	public static void run() {
		System.out.println("Welcome to the Bank!");
		
		User u = new User("PepperPots", "password!1", Role.Customer, null);
		
		UserService uservice = new UserService();
		
		uservice.register(u);
		
	}
	
}	