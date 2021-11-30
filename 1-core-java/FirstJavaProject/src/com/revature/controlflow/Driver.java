package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		/**
		 * if/else
		 * if/else if
		 * ternary operator
		 */

		int temp = 31;
		
		if (temp < 32) {
			System.out.println("It's below freezing");
		}else {
			System.out.println("It's not below freezing");
		}
		
		System.out.println((temp < 32) ? "It's below freezing" : "It's not below freezing"); // output varies based on condition This is an example of a ternary operator 
		
		String statement;
		
		statement = (temp < 32) ? "It's below freezing" : "It's not below freezing"; //value varies based on condition This is an example of a ternary operator
		
		System.out.println(statement); 
		
		int counter = 10;
		
		while (counter > 0) {
			System.out.println("The counter's Value is " + counter);
			counter--;
		}
		
		// ask user to enter number of birth month, use birth month to deduce the name of the month 
//		
		Scanner scan = new Scanner(System.in);
//		System.out.println("Please enter the number of your birth month:");
//		int month = scan.nextInt();
//		
//		
//		switch (month) {
//		case 1:
//			System.out.println("January");
//			break;
//		case 2:
//			System.out.println("February");
//			break;
//		case 3:
//			System.out.println("March");
//			break;
//		case 4:
//			System.out.println("April");
//			break;
//		case 5:
//			System.out.println("May");
//			break;
//		case 6:
//			System.out.println("June");
//			break;
//		}
//		String monthName;
//		switch (month) {
//		case 1:
//			monthName = "January";
//			break;
//
//		}
		
		for (int a = 0; a < 10; a++) {

			System.out.println("Count is at " + (a+1));
		}
		
		System.out.println("give me a word!");
		String word = scan.nextLine();
		for (int a = 0; a < word.length(); a++ ) {
			
			System.out.println(word.charAt(a));
		}
		
	}


}
