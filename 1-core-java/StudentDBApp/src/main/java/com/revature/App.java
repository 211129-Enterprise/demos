package com.revature;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

public class App {

	private static Scanner scan = new Scanner(System.in); //Command + Shift + O
	
	public static void main(String[] args) {
		
		// This will be entry point of the app
		run();

	}
	
	public static void run() {
		// Step 1. Prompt the user how many students to enter
		System.out.print("How many students are you entering into the DB?\n > ");
		
		
		// Step 2. grab the capacity that the user entered and build an array to hold student objects
		int numOfStudents = scan.nextInt();
		
		Student[] students = new Student[numOfStudents];
		
		// Printing out the student array toString() BEFORE we start to initialize it
		System.out.println("\nThis is what's inside the students array with " + numOfStudents + " places:");
		System.out.println(Arrays.toString(students) + "\n");
		
		
		// Step 3. make a for loop to iterate over each *empty* student object within the instantiated array
		//		   and for each element, ask the user for first name, last name, and grade year. Then, for
		//	 	   each empty element, call the student constructor.
		for(int i = 0; i < students.length; i++) {
			
			System.out.print("Please enter the first name:\n > ");
			String firstName = scan.next();
			
			System.out.print("\nPlease enter the last name:\n > ");
			String lastName = scan.next();
			
			System.out.print("\nPlease enter the grade year:\n 1 - Freshman\n 2 - Sophomore\n 3 - Junior\n 4 - Senior\n\n > ");
			int gradeYear = 0;
			boolean isValidInput = false;
			
			while(!isValidInput) {
				try {
					gradeYear = scan.nextInt(); //In the case that we don't have an integer, we need to catch InputMismatch exception
					UtilityMethods.validateGradeYear(gradeYear); //This extends input mismatch
					
					//We'd only reach this line if none of the above threw an exception
					isValidInput = true;
				
				} catch (NotAGradeYearException e) {
					System.out.println(e.getMessage());
				
				} catch (InputMismatchException ex) {
					System.out.print("Please enter a valid number:\n > ");
				
				} finally {
					scan.nextLine(); //This allows us to repeat the loop if necessary
				}
			}
			

			
			
			Student s = new Student(firstName, lastName, gradeYear);
			
			//Assign index i to the new student object within the student's array
			students[i] = s;
		}
		
		// Printing out the student array toString() AFTER we start to initialize it
		System.out.println("\nThis is what's inside the students array with " + numOfStudents + " places:");
//		System.out.println(Arrays.toString(students) + "\n"); // Utility arrays class provides us utility methods to manipulate arrays
		
		//For each student object within the student array, call sysout student.toString()
		for (Student s : students) {
			
			//S represents the individual student object within the array we're iterating over
			System.out.println(s.toString());
			s.enroll();
		}
		
	}

}
