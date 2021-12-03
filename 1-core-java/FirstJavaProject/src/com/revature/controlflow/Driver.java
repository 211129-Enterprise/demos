package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		/**
		 * if / else
		 * if / else if
		 * ternary operator
		 */
		
		int temp = 31;
		
		if (temp < 32) {
			System.out.println("It's under freezing");
		} else if ( temp == 32) {
			System.out.println("It's 32 degrees");
		} else {
			System.out.println("It's another temp");
		}
		
		// TERNARY OPERATOR - returns tru or false based on a condition
		System.out.println((temp < 32) ? "It's under freezing" : "It's not under freezing");
		
		String fruit; // declaring the variable 
		
		fruit = (temp < 32) ? "apple" : "orange"; // initializing it based on a condition
	 //                      // if the () condition is true, fruit = "apple"
		
		System.out.println(fruit);
		
		// do while
		do {
			
			System.out.println("In the do while loop");
			
		} while (false);
		
		
		// while (assess condition first, then run some code
		
			int counter = 10;
			
			while (counter > 0) {
				System.out.println("counter's value is: " + counter);
				counter --; // when the counter hits zero 
			}
		
		
		// prompt the user to enter the number of their birth month
			System.out.println("Enter your birth month: ");
			
			Scanner scan = new Scanner(System.in); // ctrl + shift + o will auto import that really fast
			
			int monthNum = scan.nextInt();
			
		// we'll use birth year to deduce the month of the year as a string
			
			switch(monthNum) {
		
			case 6: 
				System.out.println("June");
				break;
			case 7:
				System.out.println("July");
				break;
			default:
				System.out.println("Sorry lazy dev cal doesn't have your month");
			}
			
			String monthName;
			
			switch(monthNum) {
			
			case 6: 
				monthName = "June";
				break;
			case 7:
				System.out.println("July");
				break;
			default:
				System.out.println("Sorry lazy dev cal doesn't have your month");
			}

//			for (statemen1; statement2; statement3) {
//				// some code to execute
//			}
			
			/*
			 * Statement 1 is where to begin
			 * statement 2 is a condition that determines whether to keep going
			 * Statement 3 is executed everytime (after) the code block executes
			 */
			
			for (int i = 0; i < 10; i++) {
				System.out.println("the value of i is " + i);
			}
			
			System.out.println("Please enter a word");
			String word = scan.next();
			
			// enhance for loop
			for (String c : word.split("")) { // word.split("") = an array ["a", "p", "p"}
				System.out.println(c);
			}
			
			
			// create a for loop to print out each letter of the word.
			for (int i=0; i < word.length(); i++) {
				System.out.println(word.charAt(i));
				
			}
			
				
	}
	 static String dBayMonth(String monthNum) {
		 
		 switch(monthNum) {
		 case "six": case "seven":
			 return "June or July";
		 case "nine":
			 return "July";
		default:
			return "no month, sorry";
		 }
		 
	 }
	
	
	

}
