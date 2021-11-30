package com.revature.controlFlow;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
	/**
	 * if
	 * else if
	 * ternary operator
	 */
	Scanner getTemp = new Scanner(System.in);
		
	System.out.print("What's the tempature:");
	int temp = getTemp.nextInt();
	System.out.println();
	
	if (temp < 32) {
		System.out.println("It's freezing.");
	}
	else if (temp == 32) {
		System.out.println("It's thirty-two degrees.");
	}
	else {
		System.out.println("It's not freezing.");
	}
	
	//Ternary Operator
	System.out.println((temp < 32 ) ? "It's freezing" : "It's not freezing");//Allows for short true-false operations.
	
	String statement;
	
	statement = (temp < 32) ? "It's freezing" : "It's not freezing";//Initializing based on a condition
	
	//Do-while loops execute and then check the condition
	do {
		
	} while (false);
	
	//While loops check the condition and then execute
	int n = 10;
	
	while (n > 0){
	 System.out.println(n);
	 n--;
	}
	
	System.out.print("Who's you favorite charachter:");
	String testString = getTemp.next();
	System.out.println();
	
	switch (testString) {//Switches may use any data type 
		case "Kirk":
			System.out.println("Captain");
			break;
		case "Spock":
			System.out.println("Logical");
			break;
		default:
			System.out.println("He's dead Jim");
	}
	
	for (int i = 0; i < testString.length(); i++) {
		System.out.println(testString.charAt(i));
	}
	
}
}
