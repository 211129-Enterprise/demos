package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.openmbean.OpenDataException;
// Java Bean
public class Student implements Serializable {
	
	
	private static int GLOBAL_ID = 1000;
	
	private static Scanner scan = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private int gradeYear; // 1 - freshman, 2 Sophomore, etc.
	private String studentId; // String because we will have to concatenate the gradeYear plus an automatially generated id
	//each student has a list of courses they are enrolled in
	private List<Course> courses = new ArrayList<Course>();
	
	private double tuitionBalance = 0; // initializing balance
	
	
	// constructor will be first name, last name, grade year
	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
	
		setStudentId();
		// when we call the constructor, lets syso the instance variables
		
		System.out.println(this.firstName + " " + this.lastName + " " + this.gradeYear + " " + this.studentId);
	}
	
	// method will auto increment some value
	private void setStudentId() {
		GLOBAL_ID++;
		this.studentId = (gradeYear + "" + GLOBAL_ID); // necessary to concat so as not to mathematically add it
	}

	public void enroll() {
		// step 1 create empty arrayList of courses to add
		List<Course> coursesToAdd = new ArrayList<Course>();
		// open a while loop, quit on pressing q
		boolean isDone = false;
		while(!isDone) { // exclamation in front means not
			
			// prompt user to enter course name
			System.out.println("Enter the name of a course to enroll in:");
			String courseName = scan.next();
			if (!courseName.equalsIgnoreCase("q")) { // if user puts an uppercase Q due to capslock or something
				// use that name to make a course object
				Course course = new Course(courseName);
				// add course object to arrayList
				coursesToAdd.add(course);
				// increase tuitionBalance
				tuitionBalance += Course.COST_OF_COURSE;
				
				scan.nextLine(); // necessary to repeat the loop - scanner can be hard?
				
			}else { // if q was entered then quit program
				System.out.println("----- quitting -----");
				isDone = true;
			}
		}
		// apply the course list to the student's course list
		this.courses = coursesToAdd; // applies
		
			//print all enrolled courses
					System.out.println("Enrolled IN: " + courses.toString());
			// return new balance
		
	}
	
	public void viewBalance() {
		System.out.println("Your Balance is: " + tuitionBalance);
	}
	
	public void payTuition() {
		
		viewBalance();
		
		// prompt enter payment amount
		System.out.println("Please enter a payment amount: ");
		// capture amount as double
		double payment = scan.nextDouble();
		// subtract amount captured from tuitionBalance
		tuitionBalance -= payment;
		// print thank you and show the payment amount again
		System.out.println("Thank you for your payment of " + payment);
		viewBalance();
	}
	
	// OVERRIDES OF TOSTRING AND HASH AND EQUALS
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentId=" + studentId + ", courses=" + courses + ", tuitionBalance=" + tuitionBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + gradeYear;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tuitionBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gradeYear != other.gradeYear)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (Double.doubleToLongBits(tuitionBalance) != Double.doubleToLongBits(other.tuitionBalance))
			return false;
		return true;
	}
	
	

	
	
	
}
