package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
	
		int x = 10, y = 0; //Zero throws a runtime exception
		//UNCHECKED EXCEPTIONS are RUNTIME EXCEPTIONS
		
		System.out.println( divideTryCatch(x, y) );
		System.out.println( "SUCCESS! I reached this line of code!" );
		
//		//IF throws was used it'd look like this:
//		try {
//			createFileCheckedException("something", "something");
//		} catch (IOException e) { //CHECKED exception (Compiler is aware of that - javac compiler)
//			e.printStackTrace();
//		}
		
		createFileCheckedException("Something", "Something");
		try {
			checkAge(20);
		} catch (AgeDeniedException e) {
			System.out.println(e);
		}
		
		
		System.out.println("SUCCESS! The program continues...");
		

	}

	static void checkAge(int age) {
		//Make sure that person's age is > 21
		//If age is under 21, we throw an exception.
		if(age < 21) {
			throw new AgeDeniedException("Sorry your age is " + age + " which is under 21.");		
		} else {
			System.out.println("Welcome!");
		}
		
	}
	
	//This method is static, returns an int which is the quotient of one
	//number divided by another
	static int divide(int x, int y) {
		
		//Look before you leap method:
		if(y != 0) { //Bang operator flips logic
			return x / y;
		}
		
		return 0;
		//NOT IDEAL as it could involve excessive conditionals	
	}
	
	//Polymorphism - overloading / changing the number of parameters
	static int divideTryCatch() {
		//We will call the scanner object and ask the user for integers
		try{
			//Ask the user to enter a number
			System.out.print("Enter a dividend: ");
			
			//Store the input to a variable
			int x = scan.nextInt();
			
			//Repeat the process
			System.out.print("Enter a divisor: ");
			int y = scan.nextInt();
			
			//Try to return the division
			return (x / y);
			
		} catch(ArithmeticException e) {
			
			System.out.println("Please enter a number greater than 0");
			return 0;
			
		} finally {
			//Close our resources
			scan.close();
		}
	}
	
	static int divideTryCatch(int x, int y) {
		//"Easier to ask for forgiveness than permission" method:
		try {
			return (x/y);
			
		} catch (ArithmeticException e) {//"ArithmeticException taken from the java.lang package
			System.out.println("You can't divide by zero!!!");
//			System.out.println(e.getStackTrace()); //returns object itself
			System.out.println(e.toString()); //Shows the exception
			return 0;
			
		} catch(InputMismatchException ex) { //"InputMismatchException" needs to be imported from java.util
			System.out.println("You must enter an integer...");
			return 0;
			
//		} catch(Exceptions) { //Super class that catches ALL exceptions
			
		} finally {
			//This code will ALWAYS run regardless of whether there's an exception
			System.out.println( "In the Finally block" );
			
			//May be used for resource management like closing a scanner or closing a file
		}
	}
	
	
	//This method will create a file at a specified path
	static void createFileCheckedException(String path, String text) { //throws IOException { //Indicates method is capable of throwing an IO Exception but still needs to be handled
		
		
		//At the specified path, we'll create a file and fill it with text passed through
		FileWriter writer;
		
		try {
			writer = new FileWriter(path, true); //True means please append text/files to the path
			writer.write(text);
			writer.close();
					
		} catch (IOException e) { //CHECKED exception (Compiler is aware of that - javac compiler)
								  //Our compiler detects that something could go wrong so it FORCES us to handle it
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
//	//Also there exists a try with resources will automatically close all resources you're using
//	try( /* An object you're using to access a resource */ ){
//		//Run some code
//	} catch (IOException) {
//		
//	}
}
