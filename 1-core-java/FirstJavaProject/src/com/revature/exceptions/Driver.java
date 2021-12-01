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
		int y = 5;
		
		System.out.println(divide(x, y));
	}
	
	// Polymorphism - overloading changing number of parameters 
	static int divideTryCatch() {
		// we will call the scan object and ask the user for integers 
		try {
			System.out.println("enter a dividend");
			int x = scan.nextInt();
			System.out.println("enter a divisor");
			int y = scan.nextInt();
			
			return x/y;
		} catch(ArithmeticException e) {
			System.out.println("please enter a number greater than zero");
			return 0;
		} catch(InputMismatchException ex) {
			System.out.println("you must enter an integer");
			return 0;
		} catch(Exception ex) {
			System.out.println("some other exception");
		}finally {
		}
			scan.close();
		}
	}
	
	private static int divide(int x, int y) {
		return (x/y);
	}
	
	private int divideTryCatch(int x, int y) {
		
		try {
			return x/y;
		} catch (ArithmeticException e) { // java.lang package
			System.out.println("You can't divide by zero!!!");
			System.out.println(e.getStackTrace());
			System.out.println(e.toString());
			return 0;
		} finally {
			// this code will always execute
			System.out.println("In the finally block");
		}
	}
	
	
	// this method will create a file at a specific path
	
	static void createFileCheckedException(String path, String text) throws IOException {
		// at the specified path, we'll create a file and fill it with the text passed through
		FileWriter writer; // java.io
		
		try {
		writer = new FileWriter(path, true);
		writer.write(text);
		writer.close();
		} catch (IOException e) { // checked exception (compiler is aware of that javac compiler)
			e.printStackTrace();
		} finally {
			
		}
		
		// try with resources
		
		try () {
			
		}
		
		
	}

}
