package com.revature.scanner;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// prompt user to enter name
		System.out.println("Enter name: ");
		
		// capture the users input and save as a variable called name
		String name = scan.nextLine();
		
		// ask user for their age
		System.out.println("Enter age: ");
		
		// capture users input and save as a varaiable called age
		int age = scan.nextInt();
		
		// print back name and age of user
		System.out.println("Your name is " + name + " and your age is " + age);
		
		// In 100 years, you will be x years old
		int futureAge = getFutureAge(age);
		
		System.out.println("In 100 years, you will be " + futureAge);
		
		scan.close();
	}
	
	// method: getFutureAge - takes in an age and returns an integer value that is = currentAge + 100
	public static int getFutureAge(int currentAge) {
		
		return currentAge + 100;
		
	}

}
