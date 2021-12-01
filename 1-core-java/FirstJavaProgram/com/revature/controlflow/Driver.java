package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		/*
		 *  if / else
		 *  if / else if
		 *  ternary operator
		 */

		int temp = 31;
		
		//TRADITIONAL CONDITIONAL
			if(temp < 32) {
				System.out.println("It's under freezing");
			} else if(temp == 32){
				System.out.println("It's at freezing");
			} else {
				System.out.println("It's above freezing");
			}
		
		
		
		//TERNARY OPERATOR - returns ture or false based on a condition
			System.out.println( (temp < 3) ? "It's Freezing" : "It's not under freezing");
			
			String statement; //declaring variable
			
			statement = (temp < 32) ? " x " : " y "; //initializing it based on a condition
		
		
		
		//do while loop - always executes at least once
			do {
				System.out.println("In the do while loop");
				
			} while (false);
		
		// while - assess condition first then run code
			int counter = 10;
			
			while (counter > 0) {
				System.out.println("Counter's value is: " + counter--); //When counter hits zero, it'll stop running
			}
		
		//prompt the user to enter the number of their birth month
			System.out.print("Enter your birth month as a number: ");
			Scanner scan = new Scanner(System.in); //ctrl + shift + o will auto-import really fast (command = control on mac)
			
			int monthNum = scan.nextInt();
		
		
		//we'll use the birth year to deduce the month of the year as a string
			//SWITCHES use linear time complexity
			switch(monthNum) { //Terminal output
			
				case 6:
					System.out.println("June");
					break;
				
				case 7:
					System.out.println("July");
					break;
					
				default:
					System.out.println("Sorry, lazy dev cal doesn't have your month");
					break;
			}
			
			
			String monthName;
			
			switch(monthNum) { //Assign to variable
			
			case 6:
				monthName = "June";
				break;
			
			case 7:
				monthName = "July";
				break;
				
			default:
				monthName = "Sorry, lazy dev cal doesn't have your month";
				break;
		}
			
//			for (statement1; statement2; statement3) {
//				//some code
//			}
//			/*
//			 * statement 1 is where to begin
//			 * statement 2 is a condition that determines whether to keep going
//			 * statement 3 is executed every time (after) the code block executes
//			 */
			
			for (int i = 0; i < 10; i++) {
				System.out.println("The value of i is " + i);
			}
			
			System.out.print("Please enter a word: ");
			String word = scan.next();
			
			//ASSIGNMENT: create a loop to print out each letter of the word
			for(int i = 0; i < word.length(); i++) {
				System.out.println(word.charAt(i));
			}
			
			//Enhanced for loop
			for(String c : word.split("")) { //word.split("") = an array like ["a", "p", "p"]
				System.out.println(c);
			}
			
	}
	
	
	static String bDayMonth(int monthNum) {
		
		switch(monthNum) { //Return
		
		case 6: case 7:
			return "June or July";
		
		case 8:
			return "August";
			
		default:
			return "Sorry, lazy dev cal doesn't have your month";
		}
	}
}
