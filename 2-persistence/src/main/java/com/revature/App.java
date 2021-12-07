package com.revature;

import com.revature.util.ConnectionUtil;

public class App {

	//This is the entry point of my application!
	public static void main(String[] args) {
		
		run();
		
		ConnectionUtil.getConnection();

	}
	
	//Static because it doesn't need to be instantiated
	public static void run() {
		System.out.println("Welcome to The Bank!");
	}

}
