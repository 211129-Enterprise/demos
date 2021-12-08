package com.revature;

import com.revature.util.ConnectionUtil;

public class App {
	public static void main(String[] args) {
		run();
		
		ConnectionUtil.getConnection();
	}
	
	public static void run() {
		System.out.println("Welcome to the Bank!");
	}
}
