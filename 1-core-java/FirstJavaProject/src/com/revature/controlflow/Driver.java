package com.revature.controlflow;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
//		int temp = 31;
//		
//		if (temp <32) {
//			System.out.println("It's under freezing");
//		} else {
//			System.out.println("Its not under freezing");
//		}
		
		// TERNARY OPERATOR
		
//		System.out.println((temp < 32) ? "Its under freezing" : "Its not under freezing");
//		String statement; // declating variable
//		statement = (temp <32) ? "Its under freezing" : "Its not under freezing"; // initalazing is based on a condiiton
//		System.out.println(statement);
		
		// Do While
//		do {
//			System.out.println("TEST");
//		}while(false);

		
		// while loop
		
//		int counter = 10;
//		while (counter < 0)
//			System.out.println("Counter's value is: " + counter);
//			counter --;
//			
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a word");
		String word = scan.nextLine();
		
		for (int i = 0 ; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}	
			
	}
	
}
