package com.revature.controlflow;

import java.util.Scanner;

public class Drive {
	public static void main(String[] args) {
		/**
		 * if /else
		 * if /else if
		 * ternary operator
		 */
		
		int temp = 31;
		
		if (temp < 32 ) {
			System.out.println("its freezing");
		} else {
			System.out.println("not freezing");
		}
		
		// TERNARY OPERATOR
		// only works for two conditions 
		System.out.println((temp < 32) ? "Its freezing" : "Its not freezing");
		
		String statment; // declaring and initiliazation if true
		
		statment = (temp < 32) ? "Its freezing" : "Its not freezing"; // if is the first line, else is the second line
		
		System.out.println("statment");
		
		// do while loops
		do {
			System.out.println("in the do while loop");
		} while (false); // this will never run
		
		// while loop
			int counter = 10;
			while (counter > 0) {
				System.out.println("counter is " + counter);
				counter --;
		}
		
			
		// SWITCH STATMENTS IN JAVA	
		// prompt user to enter birth month
		System.out.println("what is your birth month number?");
		Scanner scan = new Scanner(System.in);
		int monthNum = scan.nextInt();
		switch(monthNum) {
		case 6:
			System.out.println("June"); // could also be a return method
			break;
		case 7:
			System.out.println("July"); // return string
			break;
		default:
			System.out.println("nothing");
			break;
		}
	// for loops
		// where to begin, how long to go, executed every time after the code runs
		for (int i = 0; i < 10; i ++) {
			System.out.println(i);
		}
		
		String test = "lots of text";
		System.out.println("print each character: ");
		for(int i = 0; i < test.length(); i ++) {
			System.out.println(test.charAt(i));
		}
		//enhanced for loop
		
	}
}






