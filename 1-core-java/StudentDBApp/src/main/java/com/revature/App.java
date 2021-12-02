package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

public class App {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}

	public static void run() {
		// step 1. ask how many students to enter

		System.out.println("how many students are you entering into the system?");

		// step 2. grab the capacity that the user entered and build an array to hold
		// student

		int numOfStudents = scan.nextInt();

		Student[] students = new Student[numOfStudents];

		// step 3. make a for loop to iterate over each empty student object within the
		// instantiated array

		for (int i = 0; i < students.length; i++) {
			System.out.println("please enter the first name");
			String firstName = scan.next();

			System.out.println("please enter the last name");
			String lastName = scan.next();

			System.out.println("What's the student's grade year:\n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior");

			int gradeYear = 0;
			boolean isValidInput = false;

			while (!isValidInput) {

				try {
					 gradeYear = scan.nextInt();
					 UtilityMethods.validateGradeYear(gradeYear);
					 isValidInput = true;
				} catch (NotAGradeYearException e) {
					System.out.println(e.getMessage());
				} catch(InputMismatchException e) {
					System.out.println("please enter a valid number");
				} finally {
					scan.nextLine();
				}

			}

			// for each element ask the user for firstname lastname and gradeyear
			Student s = new Student(firstName, lastName, gradeYear);

			students[i] = s;
			// for each empty element call the student contructor
		}

		for (Student s : students) {
			System.out.println(s.toString());
			s.enroll();
		}
	}

}
