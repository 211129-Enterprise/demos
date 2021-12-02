package com.revature;

import java.util.Arrays;
import java.util.Scanner;

import com.revature.models.Student;

public class App {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Entry Point
		run();
	}
	
	public static void run() {
		// Prompt user for how many students to enter
		System.out.println("How many student are entering into the database?");
		
		// Build array to store user objects
		int numOfStudents = scan.nextInt();
		Student[] students = new Student[numOfStudents];
		
		// Instantiate the empty student objects in the array
		for(int i = 0; i < students.length; i++) {
			System.out.println("Please enter first ame: ");
			String firstName = scan.next();
			
			System.out.println("Please enter last name: ");
			String lastName = scan.next();
			
			System.out.println("Enter the student's grade year:\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");
			int gradeYear = scan.nextInt();
			
			Student s = new Student(firstName, lastName, gradeYear);
			
			students[i] = s;
		}
		
		System.out.println("Student array: ");
		System.out.println(Arrays.toString(students));
		
		
	}

}
