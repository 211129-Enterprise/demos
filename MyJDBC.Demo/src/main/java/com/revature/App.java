package com.revature;

import com.revature.Service.UserService;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utilt.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();

	}
	
	
	public static void run() {
		System.out.println("welcome to the bank from here at the second time");
		User u = new User("Pepperpot", "secretPass", Role.Customer, null);
		
		UserService servie = new UserService();
		
		servie.register(u) ;
	}

	
	
	
}
