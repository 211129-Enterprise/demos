package com.revature.scanner;

import java.util.Scanner; // this is in the JRE!!

public class Driver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// prompt the user to enter their name
		System.out.println("Please enter your name!");
		
		// capture the users input and save it to a variable called name
		String name = scan.nextLine();
		
		// ask the user for their age
		System.out.println("What is your age?");
		
		//save the age to an INT variable
		int age = scan.nextInt();
		
		// print back the name and age of the user!
		System.out.println("Your name is " + name + " and you are " + age + " years old");
		
		// In 100 years you will be ___ years old
		
//		int futureAge = getFutureAge(age);
		
		System.out.println("In 100 years you will be " + getFutureAge(age));
		
		scan.close();
	
	}
	
	//method : getFutureAge - takes in an age ad returns an integer value that is == too currentAge + 100 years
	
	public static int getFutureAge(int currentAge) {
		
		return currentAge + 100;
	}
	
}
