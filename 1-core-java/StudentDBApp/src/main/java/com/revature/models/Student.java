package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

	private static int GLOBAL_ID = 1000;
	private static Scanner scan = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	
	private List<Course> courses = new ArrayList<Course>();
	
	private double tuitionBalance = 0;

	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentId();
		
		System.out.println(firstName + " " + lastName + " " + gradeYear);
	}
	
	private void setStudentId() {
		GLOBAL_ID++;
		studentId = gradeYear + "" + GLOBAL_ID;
	}
	
	public void enroll() {
		List<Course> coursesToAdd = new ArrayList<Course>();
		boolean isDone = false;
		
		while(!isDone) {
			System.out.println("Enter course name: ");
			String courseName = scan.next();
			if(courseName == "q") break;
			
			Course course = new Course(courseName);
			coursesToAdd.add(course);
			tuitionBalance += Course.COST_OF_COURSE;	
			
			scan.nextLine();
		}
		
		this.courses = coursesToAdd;
		System.out.println("Enrolled in: " + courses.toString());
	}
	
	public void viewBalance() {
		System.out.println("Balance: " + tuitionBalance);
	}
	
	public void payTuition(int amount) {
		viewBalance();
		
		System.out.println("Enter payment amount: ");
		double payment = scan.nextDouble();
		tuitionBalance -= payment;
		System.out.println("Thanks for payment amount of " + payment);
		
		viewBalance();
	}

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
