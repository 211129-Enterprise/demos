package com.revature.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Prompt User for name.
		System.out.print("Please enter your name: ");
		
		//capture input in variable called name.
		String name = scan.nextLine();
		
		System.out.println("");
		//ask user for age.
		System.out.print("Please enter your age: ");
		int age = scan.nextInt();
		
		System.out.println("");
		// print name and age.
		System.out.println("Thank you " + name + " you have indicated that you are " + age + " Years old.");
		
		// print future age.
		// int futureAge = getFutureAge(age);
		System.out.println("In 100 years you will be " + getFutureAge(age) +".");
		
		scan.close();
	}

	// method: getFutureAge return int of age in 100 years = current age + 100 
	public static int getFutureAge(int currentAge) {
		return currentAge + 100;
	}
}
