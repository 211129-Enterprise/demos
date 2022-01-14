package com.revature.scanner;

<<<<<<< HEAD
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Scanner is the reference variable, the type of of object. 
		//The user is prompted to enter their name
		System.out.println("Please enter your name:");
		
		//The input is captured by a variable called name
		String name = scan.next();
		
		//The user is prompted to enter their age
		System.out.println("Please enter your age");
		
		//The input is captured to a variable called age
		int age = scan.nextInt();
		
		//The name and age of the user are printed
		System.out.println("Your name is "+name+" and you are "+age+" years old.");
		
		//The age of the user in 100 years is printed
		System.out.println("Your age in one hundred years will be "+getFutureAge(age));
		
		//Close the scanner to help prevent memory leakage.
		scan.close();
	}
	
	//A method is a function that belongs to a specific class
	//A public method may be accessed by any package
	//A static method may be called without an instance of the class
	//int is the return type value
	public static int getFutureAge(int currentAge) {
		return currentAge + 100;
	}

=======
import java.util.Scanner; // this is in the JRE!

public class Driver {

	
	public static void main(String[] args) { 
		
		Scanner scan = new Scanner(System.in);
		
		// prompt the user to enter their name
		System.out.println("Please enter your name!"); // sysout + ctrl + space (command if you're on map) 
		
		// capture the users input and save it to a variable called name
		String name = scan.nextLine();
		
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
	
>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
}
