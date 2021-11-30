package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp = 31;
		
		if (temp < 32) {
			System.out.println("It's under freezing");
		} else {
			System.out.println("It's not under freezing");
		} 
		
		System.out.println((temp < 32) ? "It's under freezing" : "It's not under freezing");
		
		String statement; // declaring the variable
		
		statement = (temp < 32) ? "It's under freezing" : "It's not under freezing";
		
		System.out.println(statement);
		
		do {
			System.out.println("In the do while loop");
		} while (false);
			
		int counter = 10;
		
		while (counter > 0) {
			System.out.println("counter's value is: " + counter);
			counter --;
		}
			
		System.out.println("Enter your birth month: ");
		
		Scanner scan = new Scanner(System.in); // ctrl + shift + o to auto import 
		
		int monthNum = scan.nextInt();
		
		switch(monthNum) {
		case 6:
			System.out.println("June");
			break;
		case 7:
			System.out.println("July");
			break;
		default:
			System.out.println("Sorry lazy dev cal doesn't have your month");
		}
		
//		String monthNum;
//		
//		
//		switch(monthNum) {
//		case 6:
//			System.out.println("June");
//			break
//		case 7:
//			System.out.println("July");
//			break
//		default:
//			System.out.println("Sorry lazy dev cal doesn't have your month");
//		}
		
		System.out.println("Please enter a word");
		String word = scan.nextLine();
		
		
		
		
		for (int i = 0; i< word.length(); i++) {
			System.out.println(word.charAt(i));
		}
	}

}
