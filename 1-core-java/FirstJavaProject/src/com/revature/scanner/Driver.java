package com.revature.scanner;

import java.util.Scanner; // this is in the JRE ; 

public class Driver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Prompt the user to enter their name;
		
		System.out.println("Please enter your name: ");
		
		String name = scanner.nextLine();
		
		System.out.println("please enter your age:");
		
		int Age = scanner.nextInt();
		
		
		// Capture the users input and save to a variable called me;
		
		System.out.println("Your Name is "+ name + "Your age is " + Age);

		
		System.out.println("In 100 years you will be "+ Driver.getFutureAge(Age));
		
		scanner.close(); 
		
		// for saving the memory and avoid memory leaks;
		 
	}
	
	
	public static int getFutureAge(int currentAge ) {
		
		return currentAge+100;
		
	}
	
}
