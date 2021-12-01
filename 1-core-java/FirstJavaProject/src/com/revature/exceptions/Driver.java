package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int x = 10;
		int y = 0; // our compiler never told us that something would go wrong
		
		// the Exception only occurred at runtime - a RUNTIME EXCEPTION
		// UNCHECKED EXCEPTIONS are RUNTIME EXCEPTIONS
		
		System.out.println(divideTryCatch());
		
		System.out.println("I reached this line!");
		
		createFileCheckedException("something", "something");
		
		try {
			checkAge(20);
		} catch (AgeDeniedException e) {
			System.out.println(e);
		}
		
		System.out.println("Reached this line...");

		
	}
	
	static void checkAge(int age) {
		
		// make sure that the person's age is > 21
		if (age < 21) {
			throw new AgeDeniedException("Sorry, you're age is " + age + " which is under 21.");
		} else {
			System.out.println("Welcome!");
		}
		
		// if the age is under 21, we throw exception
		
		
		
	}
	
	// Polymorphism - overloading changing the number of parameters
	static int divideTryCatch() {
		
		//we will call the scan object and ask the user for integers
		
		try {
			
			// ask the user to enter a number
			System.out.println("Enter a dividend");
			// store the input to a variable
			int x = scan.nextInt();
			//repeat the process
			System.out.println("Enter a divisor");
			// store the input to a variable
			int y = scan.nextInt();
			
			return x/y;
			
		} catch(ArithmeticException e) {
			System.out.println("Please enter a number greater than 0");
			return 0;
			
		} catch(InputMismatchException ex) {
			System.out.println("You must enter an integer...");
			return 0;
		} finally {
			scan.close();
		}
		
	}
	
	
	// this method is static, returns an int which is the quotient of 1 number divided by another.
	static int divide(int x, int y) {
		
		// look before you leap
		if (y != 0) { // ! flips logic
			return (x / y);
		}
		
		return 0;
	}
	
	static int divideTryCatch(int x, int y) {
		
		try {
			return x/y;
		} catch (ArithmeticException e) { // java.lang package
			// in the case that we catch that exception
			System.out.println("You can't divide by zero!");
			System.out.println(e.toString());
			return 0;
		} finally {
			// this code will ALWAYS run (regardless of whether there's an exception)
			System.out.println("In the finally block");
		}
		
		
	}
	
	// this method will create a file at a specified path
	static void createFileCheckedException(String path, String text) {
		
		// at the specified path, we'll create a file and fill it with the text passed through
		FileWriter writer; // java.io
		
		try { 
			writer = new FileWriter(path, true); // true means please append text/files to the path
			writer.write(text);
			writer.close();
		} catch (IOException e) { // this is a CHECKED exception. Our compiler detects that something COULD go wrong at compile time, so it
			// forces us to handle it.
			e.printStackTrace();
		} 

//	try with resources will automatically close all resources you're using
//	try (an object you're using to access a resource) {
//		run some code
//	} catch(IOException) {
//		
//	}
		
	}
	
	
	
	
	
	
	
}
