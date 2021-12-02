package com.revature;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

public class App {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		run();

	}
	
	public static void run() {
		
		String firstName;
		String lastName;
		int gradeYear = 0;
		
		// step 1: prompt the user how many students to enter
		System.out.println("How many students are you entering into the system?");
		
		// step 2: grab the capacity that the user entered and build an array to hold student objects.
		int numOfStudents = scan.nextInt();
		Student[] students = new Student[numOfStudents];
		
		// step 3: make a for loop to iterate over each empty student object within the instantiated array
		for (int i = 0; i < students.length; i++) {
			// for each element ask the user for firstName, lastName, and grade year
			System.out.println("Enter first name:");
			firstName = scan.next();
			
			System.out.println("Enter last name:");
			lastName = scan.next();
			
			System.out.println("Enter grade year:\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");
			
			boolean isValidInput = false;
			while(!isValidInput) {
				
				try {
					gradeYear = scan.nextInt();
					UtilityMethods.validateGradeYear(gradeYear);
					isValidInput = true;
				} catch (NotAGradeYearException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException ex) {
					System.out.println("Please enter a valid number");
				} finally {
					scan.nextLine();
				}
				
			}
			
			
			
			
			// for each empty element call the student constructor
			Student s = new Student(firstName, lastName, gradeYear);
			
			students[i] = s;
		}
		
		System.out.println("This is what's inside the students array with " + numOfStudents + " places.");
//		System.out.println(Arrays.toString(students));
		
		for (Student s : students) {
			System.out.println(s);
			s.enroll();
		}
	
		
		
		
	}

}
