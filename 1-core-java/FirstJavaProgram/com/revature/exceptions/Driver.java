package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	private static Scanner scan =new Scanner(System.in);
	
	public static void main(String[] args) {  //main method
		int x= 10;
		int y = 0; 
		// int y = 0; //cannot divide by 0. Will be an exception
		//The exception only occurred at runtime - a RUNTIME exception
		//our compiler never told us that something would go wrong.
		System.out.println(divideTryCatch());
		System.out.println("I reached this line!");
	}
	//---------------------------------------------------------------------------------------
	//polymorphism - overloading changing number of parameters
	static int divideTryCatch() { 
		//we will call the scanner object
		try {
			//ask the user to enter a number
			System.out.println("Enter a dividend");
			//store the variable
			int x =scan.nextInt();
			//repeat the process
			System.out.println("Enter a dividend");
			int y =scan.nextInt();
			return x/y;
		} catch (ArithmeticException e) {
			System.out.println("Please enter a number greater than 0");
			return 0;
		} finally {
			scan.close(); //close your resources
		}
	}
	//----------------------------------------------------------------------------------------
	//this method is static, returns an int which is the quotient of 1 number 
	//divided by another.
	static int divide(int x, int y) {
		
		//int quotient = x/y;
		if (y != 0) {    //you use this as an exception handling. If y does not equal 0.
			return x/y;
		}
		return 0;
	}
	//----------------------------------------------------------------------------------------
	static int divideTryCatch(int x, int y) {
		try {
			return x/y;
		} catch (ArithmeticException e) { //java.lang package (shift spacebar)
			System.out.println("You can't divide by 0!!!!");
			System.out.println(e.toString());
			return 0;
		} catch(InputMismatchException e) {
			 System.out.println("You must input a number!");
			 return 0;
		} catch (Exception ex) {
			System.out.println("Please put in a real number.");
			return 0;
		} finally {
			//this code will always execute regardless if there's an exception.
			System.out.println("In the finally block");		
		}	
	}
	//----------------------------------------------------------------------------------------
	//this method will create a file at a specific path
	static void createFileCheckedException(String path, String text) {
		//at the specified path we'll create a file and fill it with the text passed through
		FileWriter writer; //import
		
		try {
			writer =new FileWriter(path, true); //true means please append text/files to the path
			writer.write(text);
			writer.close();
		} catch(IOException e) { //CHECKED exception (compiler is aware of that -javac compiler)
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
