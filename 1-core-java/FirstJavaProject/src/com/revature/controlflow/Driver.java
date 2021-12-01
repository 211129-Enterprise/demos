package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		int temp = 11;
		
		if(temp < 32) {
			System.out.println("It's under freezing");
		}
		else {
			System.out.println("It's not under freezing");
		}
		
		System.out.println((temp < 32) ? "It's under freezing" : "It's not under freezing");
		
		do {
			System.out.println("In the do while loop");
		} while(false);
		
		int counter = 5;
		while(counter > 0) {
			System.out.println(counter);
			counter--;
		}
		
		System.out.println("Enter your birth month: ");
		
		Scanner scanner = new Scanner(System.in);
		int monthNum = scanner.nextInt();
		
		switch(monthNum) {
		case 6:
			System.out.println("June");
			break;
		case 7:
			System.out.println("July");
			break;
		default:
			System.out.println("None");
		}
		
		
		System.out.println("Please enter a word");
		String word = scanner.next();
		for(int i = word.length()-1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		}
	}
	
	static String dBayMonth(int monthNum) {
		switch(monthNum) {
		case 6:
			return "June";
		case 7:
			return "July";
		default:
			return "";
		}
	}
}
