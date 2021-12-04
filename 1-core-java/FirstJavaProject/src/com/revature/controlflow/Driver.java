package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		/**
		 * if / else
		 * if / else if
		 * ternary operator
		 * 
		 */
		
		int temp =31;
		
		if (temp < 32) {
			System.out.println("It's under freezing");
		}else if (temp == 32) {
			System.out.println("It's 32 degrees");
		}else {
			System.out.println("It's another temp");
		}
		
		// TERNARY OPERATOR returns true or false based on a condition
		System.out.println((temp < 32)  ? "It's under freezing" : "It's not under freezing");
		
		String fruit; // declaring the variable
		
		fruit = (temp < 32) ? "apple" : "orange"; // Initializing it based on a condition
													// if the () condition is true fruit = "apple"
		
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
			System.out.println("Enter your birth month ");
			
			Scanner scan = new Scanner(System.in); // ctrl + shift + o will auto import that really fast
			
			int monthNum = scan.nextInt();
			
			// we'll use birth year to reduct the month of the year as a string
			
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
				monthName = "June;";
				System.out.println("June");
				break;
				
			case 7:
				System.out.println("July");
				break;
				
			default:
				System.out.println("Sorry lazy dev cal doesn't have your month");
				
				// for (statement1; statement2; statement3;) {
				//some code to execute
				//}
				
				
				//statement 1 is where to begin
				//Statement 2 is a condition that determines whether to keep going
				//Statement 3 is executed every time (after) the code block executes
				
				
				for (int i = 0; i < 10; i++) {
					System.out.println("The value of i is " + i);
					
				}
				
					System.out.println("Please enter a word");
					String word = scan.next();
					
					//create a for loop to print out each letter of the word.
					for (int i = 0; i < word.length(); i++) {
					System.out.println(word.charAt(i));
				}
				
				
				
			}	
											
			
	}
	
		static String dBayMonth(int monthNum) {
			
			switch(monthNum) {
			case 6:
				return "June";
			case 7:
				return "July";
			default:
				return "no month, sorry";				
		}

			
			
	}
}
