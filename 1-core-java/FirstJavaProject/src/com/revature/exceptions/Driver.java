package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 0;  // unchecked error, our compiler didn't notice it would not work
		
		// exception only occured at runtime = a RUNTIME EXCEPTION
		// UNCHECKED EXCEPTIONS are RUNTIME EXCEPTIONS
		
		System.out.println(divideTryCatch());
				
		System.out.println("I reached this line!!");
		
		try {
			checkAge(20);
		} catch (AgeDeniedException e) {
			System.out.println(e);
		}
		System.out.println("reached this line!");
		
	}

	/**
	 * method is static, returns and int wich is the quotient of 1 number divided by another.
	 * 
	 * takes in a dividend and a divisor
	 * 
	 */
	
	static void checkAge(int age) throws AgeDeniedException{
		
		// make sure person's age is >21
		if (age < 21) {
			
			throw new AgeDeniedException("Sorry your age is " + age + " which is less than 21");
			
		} else {
			System.out.println("Welcome");
		}
		
	}
	
	// Form of Polymorphism - overloading changing number of parameters
	static int divideTryCatch() {
		// call scan object and ask user for numbers
		
		try {
			//ask user to enter a number
			System.out.println("Enter dividend:");
			
			// store input in variable
			int x = scan.nextInt();
			
			System.out.println("enter divisor:");
			
			int y = scan.nextInt();
			// repeat
			
			// return x/y
			
			return x/y;
		} catch(ArithmeticException e) {
			
			System.out.println("Please enter a number greater than 0");
			return 0;
		} catch (InputMismatchException e){
			System.out.println("Please enter only numbers");
			return 0;
		} finally {
			scan.close();
		}
	}
	
	
	static int divide(int x, int y) {
		
//		look before you leap
		
		if(y != 0) return (x/y);
		
		return 0;
	}
	static int divideTryCatch(int x, int y) {
		
		try {
			return x/y;
		} catch (ArithmeticException e) { // in java.lang package
			// in the case that something goes wrong
			System.out.println("You can't divide by 0!");
			System.out.println(e.toString());
			return 0;
		} finally {
			// This code will Always execute regardless of exception
			System.out.println("In the finally block");
		}
		
	}
	
	
	
	
	// This method will create a file at a specified path.
	
	static void createFileCheckedException(String path, String text) {
		
		// at specified path create a file and fill with the text passed in.
		
		
		FileWriter writer;
		
		try {
			writer = new FileWriter(path, true); // true means please append text/files to the path
			writer.write(text);
			writer.close();
		} catch (IOException e) { // This exception is checked by compiler 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try(/* an object you are using to access a resource*/) {
//			// run some code
//		} catch (IOException) {
//			
//		} // don't need finally as it will close itself?
		
	}
	
	
	
	
}
