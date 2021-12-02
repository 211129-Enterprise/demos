package com.revature;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.models.Student;

public class App {

	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// This will be the entry point of the application
		
		run();
		
	}
	
	public static void run() {
	
		/**
		 * step 1. prompt user for how many students
		 * 
		 * step 2. grab capacity that user entered and build an array to hold student objects
		 * 
		 * step 3. make a for loop to iterate over each empty student object within the instantiated array
		 * 
		 * for each element ask user for first name, last name, and grade year
		 * 
		 * for each empty element call the student constructor with the data provided.
		 * 
		 * 
		 */
		
		System.out.println("How many students are you entering into the DB? ");
		int numOfStudents = scan.nextInt();
		
		Student[] newStudents = new Student[numOfStudents];
		
		System.out.println("THis is what is inside the students array: " + numOfStudents + " places entered");
		System.out.println(Arrays.toString(newStudents));
		
		for (int i = 0; i < numOfStudents; i++) {
			
			System.out.println("Please enter the first name");
			String firstName = scan.next();
			
			System.out.println("Please enter the last name");
			String lastName = scan.next();
			
			System.out.println("Please enter the fist name:\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");
			int gradeYear = scan.nextInt();
			
			Student s = new Student(firstName, lastName, gradeYear);
			newStudents[i] = s;
		}
		
		System.out.println("THis is what is inside the students array: " + numOfStudents + " places entered");
//		System.out.println(Arrays.toString(newStudents));
		
		for( Student s : newStudents) {
			
			// s represents the individual student object within the array
			System.out.println(s.toString());
		}
		
		
	}

}
