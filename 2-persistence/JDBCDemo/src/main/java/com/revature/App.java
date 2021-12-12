package com.revature;
import java.util.Scanner;

import com.revature.enums.Role;
import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil;

public class App {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		ConnectionUtil.getConnection();
		run();
		
	
	}
	
	public static void run() {
		System.out.println("Welcome to the Bank!");
		
		User u = new User("PepperPotts", "secretPass", Role.Customer);
		
		UserService uservice = new UserService();
		
		uservice.register(u);
	}
}
