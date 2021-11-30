package com.revature.scanner;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("What is your name?");
		String name = scan.nextLine();
		System.out.println("How old are you?");
		int age = scan.nextInt();
		System.out.println("Your name is " + name + " and you are " + age + " years old");
		
		int futureAge = getFutureAge(age);
		System.out.println("In 100 years you will be " + futureAge + " years old.");
		scan.close();
		
	}
	public static int getFutureAge(int currentAge) {
		return currentAge +100;
		
	}
}
