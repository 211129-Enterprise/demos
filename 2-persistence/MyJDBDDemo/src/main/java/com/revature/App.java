package com.revature;

import com.revature.util.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to the bank");//Entry point of application
		ConnectionUtil.getConnection();
		
	}

}
