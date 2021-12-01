package com.revature.exceptions;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;



public class Driver {
	
	private Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 5;
		
		System.out.println(divide(num1, num2));
		
		System.out.println("I reached this line");
		
		
		
	}
		
	// this method is static return an int which is the quotient of a number divided by another
	
	
	static int divide (int x, int y) {
		
		// look before you leap
		
		if (y != 0 ) {
			return (x / y);
			
		}
		
		return 0;
		
	}
	
	static int divideTryCatch (int x, int y) {
		
		try {
			return x/y;
		} catch (ArithmeticException e) {
			System.out.println("Cant divide by zero");
			return 0;
		} finally {
			// this code will always run ( regardless whether exception occurs or not)
			// resource management can be included in finally block
			
			
		}
		
	}
	
	//polymorphism - overloading chaning number of parameters
	
	static int divideTryCatch () {
		
		// we will call scanner
		
		try {
			// ask user to enter a number
			System.out.println("Enter a dividend");
			int x = scan.nextInt();
			
			// store the input to a variable 
			System.out.println("Enter a divisor");
			int y = scan.nextInt();
			
			return (x/y);
			
			
		} catch (ArithmeticException e)  {
			System.out.println("Please enter a number other than zero");
			return 0;
			
		} catch(InputMismatchException ex) {
			// import this from java.util
			System.out.println("You must enter a number");
			return 0;
		}
		
		finally {
			scan.close();
		}
		
	}
	
	
	//this method will create a file at a specified path
	
	static void createFileCheckedException (String path, string text) {
		// at the specified path, we'll create a file and fill it with the text passed through
		
		FileWriter writer; // need to import from java.io
		
		writer = new FileWriter(path, true)
		
	}
	

}
