package com.revature;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

public class App {
<<<<<<< HEAD
	
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		run();
		
	}
	
	public static void run() {
		//step 1. prompt the user how many students to enter.
		System.out.println("How many students are you entering into the Database?");
		//step 2. grab the capacity that the user entered and build an array to hold student objects
		int numOfStudents =scan.nextInt();
		Student[] students = new Student[numOfStudents];
		//let's print out student array just to see what's inside.
		System.out.println("This is the number os students array with " + numOfStudents + " places.");
		System.out.println(Arrays.toString(students));
		
		//step 3. make a for loop to iterate over each *empty* student object within the instantiated array
		for (int i=0; i< students.length; i++) {
			
			// for each element ask the user for firstName, lastname, and gradeyear.
			System.out.println("Please enter the first name.");
			String firstName =scan.next();
			
			System.out.println("Please enter the last name.");
			String lastName =scan.next();
			
			System.out.println("Enter a student's grade year:\n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior");
			
			int gradeYear=0;
			boolean isValidInput = false;
			while (!isValidInput) {
				try {
					gradeYear =scan.nextInt();
					UtilityMethods.validateGradeYear(gradeYear);
					isValidInput = true;
				} catch (NotAGradeYearException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException ex) {
					System.out.println("Please enter a valid number.");
				} finally {
					scan.nextLine();
				}
			}
			
			
			
			//...for each empty element call the student constructor.
			Student s = new Student(firstName, lastName, gradeYear);
			students[i]=s;
		}
		//checking the array AFTER the initialization. 
		System.out.println("This is the number os students array with " + numOfStudents + " places.");
		//System.out.println(Arrays.toString(students));
		for (Student s: students) {
			//s represents the individual student object within the array we iterating over.
			System.out.println(s.toString());
			s.enroll();
		}
	}
=======

	private static Scanner scan = new Scanner(System.in); // ctrl + shift + o
	
	public static void main(String[] args) {
		
		run();

	}
	
	public static void run() {
		
		// step 1. prompt the user how many students to enter
		System.out.println("How many students are you entering into the DB?");
		
		// step 2. grab the capacity that the user entered and build an array to hold student objects
		int numOfStudents = scan.nextInt(); // 
		
		Student[] students = new Student[numOfStudents]; // [ __ __ __ ] 
		
		// let's print out the student array toString() BEFORE we start intialize it
		System.out.println("This is what's inside the students array with " + numOfStudents + " places.");
		System.out.println(Arrays.toString(students));
		
		
		// step 3. make a for loop to iterate over each *empty* student object within the instantiated array
		for (int i=0; i < students.length; i++) {
		
			// for each element ask the user for firstname, last name, and grade year
			System.out.println("Please enter the first name");
			String firstName = scan.next();
			
			System.out.println("Please enter the last name");
			String lastName = scan.next();
			
			System.out.println("Enter the student's grade year:\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");
			
			int gradeYear = 0;
			boolean isValidInput = false;
			
			while (!isValidInput) {
			
				try {
					gradeYear = scan.nextInt(); // in the case that we don't have an integer, we need to  catch InputMistmath exception
					UtilityMethods.validateGradeYear(gradeYear);  // if the integer is greater than 4 or less than 0 
					
					// we would only reach this line if none of the above lines threw an exception
					isValidInput = true;
				} catch (NotAGradeYearException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException ex) {	
					System.out.println("Please enter a valid number");
				} finally {
					scan.nextLine(); // this allows us to repeat the loop if necessary
				}
			}
			
			// for each empty element call the student constructor. because we have the data to fill the constructor
			Student s = new Student(firstName, lastName, gradeYear);
			
			// assign index i to the new Student object within the students array.
			students[i] = s;
		}
		
		// let's print out the student array toString() AFTER we initialize it
		System.out.println("This is what's inside the students array with " + numOfStudents + " places.");
//		System.out.println(Arrays.toString(students)); // Arrays class provides us utility methods to manipulate arrays
		
		//for each Student object within the Student array, call sysout(student.toString());
		for (Student s : students) {
			// s represents the individual Student Object within the array we're iterating over
			System.out.println(s.toString());
			s.enroll();
		}
		
	}

	
	
>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	
	
}
