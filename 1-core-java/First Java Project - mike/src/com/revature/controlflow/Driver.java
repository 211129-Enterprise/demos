package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		int temp = 31;
		
		if (temp < 32) {
			System.out.println("It's under freezing");
		} 
		else {
			System.out.println("It's not under freezing");
		}
		
		// TERNARY OPERATOR
//		System.out.println((temp < 32) ? "It's under freezing" : "It's not under freezing");
//		
//		
//		System.out.println("Enter your birth month: ");
//		
		Scanner scan = new Scanner(System.in);
//		
//		int monthNum = scan.nextInt();
//		String monthName;
//		
//		switch(monthNum) {
//		case 1:
//			System.out.println("January");
//			monthName = "January";
//			break;
//		case 2:
//			System.out.println("February");
//			monthName = "February";
//			break;
//		case 3,4,5:
//			System.out.println("March");
//			monthName = "March";
//			break;
//		}
		System.out.println("Please enter a word:");
		String word = scan.nextLine();
		for (int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}
		
	}

}
