package com.revature.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int x = 10;
		int y = 0;
		
		// the Exception only occurred at runtime - a RUNTIME EXCEPTION
		// UNCHECKED EXCEPTIONS are RUNTIME EXCEPTIONS
		
		System.out.println(divideTryCatch());

	}
	
	static int divideTryCatch() {
		
		// OVERLOADING
		// we will call the scanner object to prompt user for two integers to divide
		try {
			// ask the user to enter a number
			System.out.println("Enter dividend.");
			
			// store the input to a variable
			int x = scan.nextInt();
			
			// repeat for divisor
			System.out.println("Enter divisor.");
			
			// store the input to a variable
			int y = scan.nextInt();
			
			return x / y;
		
		} catch (ArithmeticException e) {
			// in the case that we catch that exception
			System.out.println("You can't divide by 0!");
			System.out.println(e.toString());
			return -1;
		} catch (InputMismatchException ex) {
			System.out.println("Please enter an integer!");
			System.out.println(ex.toString());
			return -1;
		}	finally {
			scan.close();
		}
	}
	
	static int divide(int x, int y) {
		
		if (y != 0) {
			return x / y;
		}
		
		return 0;
	}
	
	static int divideTryCatch(int x, int y) {
		
		try {
			return x / y;
		} catch (ArithmeticException e) {
			// in the case that we catch that exception
			System.out.println("You can't divide by 0!");
			System.out.println(e.toString());
			return -1;
		} finally {
			// this block always runs regardless of error catch
			System.out.println("In the finally block.");
		}
	}

}
