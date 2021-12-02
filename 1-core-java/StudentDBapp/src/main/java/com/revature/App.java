package com.revature;


import java.util.Arrays;
import java.util.Scanner;

import com.revature.Exception.NoGradeYearException;
import com.revature.models.Student;
import com.revature.util.UtilityMethod;

public class App {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// this the entry point ; 
	run();	
	}
	
	
	public static void run() {
		
		System.out.println("Enter Number of students");
		
		int numOfStudent = scan.nextInt();
		
		
		Student[] students = new Student[numOfStudent];
		
	System.out.println(Arrays.toString(students));
		
		for(int i=0 ; i< students.length ; i++) {
			System.out.println("please enter the first name ");
			String firstName = scan.next();
			System.out.println("please enter the last name");
			String lastNameString = scan.next();
			
			System.out.println("what's the student's year: \n1 -FReshman \n2 - second year \n3 - junior \n4 - senior");
			
			boolean isValidIput = false ; 
			int gradeYear = 0;
			
			while(!isValidIput) {
				
				try {
					
				 gradeYear = scan.nextInt();
				UtilityMethod.validateGradYear(gradeYear);
				isValidIput = true;
				}catch (NoGradeYearException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
				finally {
				scan.nextLine();
			}
			
		}
			
			Student s = new Student(firstName, lastNameString, gradeYear);
			
			students[i] = s;
			
			
		}
		
//		System.out.println(Arrays.toString(students));
		
		for(Student s : students) {
			System.out.println(s.toString());
			s.enroll();
		}
		
		
	}
	
	
	
	
}
