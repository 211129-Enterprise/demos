package com.revature.scanner;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// prompt the user to enter their name
		System.out.println("Please enter your name!"); // sysout + ctrl + space (command if you're on map)
		
		// capture the users input and save it to a variable called name
		String name = scan.nextLine();
		
		// ask the user for their age
		
		System.out.println("What's your age?");
		
		int age = scan.nextInt();
		
		System.out.println("Your name is " + name + " and you are " + age + " years old");
		
		// in 100 years you will be __ years old
		
		int futureAge = getFutureAge(age);
		
		System.out.println("In 100 years you will be " + futureAge);
		
		scan.close();
		
		
		
		// print back the name and age of the user!
		
		// deamon thread
	}
	
	// method: getFutureAge - takes in an age and returns an integer value that is = tpo current age + 100 years
	
	public static int getFutureAge(int currentAge) {
		
		return currentAge + 100;
	}
}
