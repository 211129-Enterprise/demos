package com.revature.scanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Scanner is the reference variable, the type of of object. 
		//The user is prompted to enter their name
		System.out.println("Please enter your name:");
		
		//The input is captured by a variable called name
		String name = scan.next();
		
		//The user is prompted to enter their age
		System.out.println("Please enter your age");
		
		//The input is captured to a variable called age
		int age = scan.nextInt();
		
		//The name and age of the user are printed
		System.out.println("Your name is "+name+" and you are "+age+" years old.");
		
		//The age of the user in 100 years is printed
		System.out.println("Your age in one hundred years will be "+getFutureAge(age));
		
		//Close the scanner to help prevent memory leakage.
		scan.close();
	}
	
	//A method is a function that belongs to a specific class
	//A public method may be accessed by any package
	//A static method may be called without an instance of the class
	//int is the return type value
	public static int getFutureAge(int currentAge) {
		return currentAge + 100;
	}

}
