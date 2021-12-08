package com.revature;

import com.revature.util.ConnectionUtil;

public class Application {

	// This is the entry point of my application!
	public static void main(String[] args) {
		run();
		
		
		ConnectionUtil.getConnection();
		ConnectionUtil.getConnection();
		
		
	}
	
	public static void run() {
		System.out.println("Welcome to the Bank!");
	}
	
}	