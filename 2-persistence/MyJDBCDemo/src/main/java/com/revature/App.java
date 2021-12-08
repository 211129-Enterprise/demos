package com.revature;

import com.revature.util.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		run();
	}

	private static void run() {
		System.out.println("Welcome to the Bank!");
		ConnectionUtil.getConnection();
	}
}
