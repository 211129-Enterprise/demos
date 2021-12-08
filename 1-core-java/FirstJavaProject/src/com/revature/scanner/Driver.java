package com.revature.scanner;

import java.util.Scanner; // this is in the JRE!

public class Driver {
<<<<<<< HEAD
	
	public static void main(String[] args) {
	
		
		Scanner scan = new Scanner (System.in);
		
		//prompt the use to enter their name
		System.out.println("please enter your name!");
=======

	
	public static void main(String[] args) { 
		
		Scanner scan = new Scanner(System.in);
		
		// prompt the user to enter their name
		System.out.println("Please enter your name!"); // sysout + ctrl + space (command if you're on map) 
>>>>>>> 0bca53b785f2de35fc67962dfe9e69979522c923
		
		// capture the users input and save it to a variable called name
		String name = scan.nextLine();
		
<<<<<<< HEAD
		// ask user for their age
		System.out.println("What's your age?");
		
		// save the age to an INT variable 
		int age = scan.nextInt();
		
		// print back the name and age of the user
		System.out.println("Your name is " + name + " and you are " + age + " years old");
		
		
		// in 100 years you will be _____ years old
		int futureAge = getFutureAge(age);
		
		System.out.println("in 100 years you will be " + futureAge + " years old ");
		
		// garbage collector; to avoid waste of memory
		scan.close();
	}
	
	public static int getFutureAge(int currentAge) {
		return currentAge + 100;
	}
=======
		// ask the user for their age
		System.out.println("What's your age?");
		
		// save the age to an INT variable
		int age = scan.nextInt();
		
		// print back the name and age of the user!
		System.out.println("Your name is " + name + " and you are " + age + " years old");
		
		// In 100 years you will be ____ years old
		
//		int futureAge = getFutureAge(age);
		
		System.out.println("In 100 years you will be " + getFutureAge(age));
		
//		scan.close();
		
	}
	
	
	// method: getFutureAge - takes in an age and returns an integer value that is = tpo currentAge + 100 years
	public static int getFutureAge(int currentAge) {
		
		return currentAge + 100;
		
	}
	
>>>>>>> 0bca53b785f2de35fc67962dfe9e69979522c923
}
