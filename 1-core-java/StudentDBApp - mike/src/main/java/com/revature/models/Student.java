package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Student implements Serializable {
	
	// 1000 - everytime a new student is created this value increases by 1
	public static int GLOBAL_ID = 1000;
	private static Scanner scan = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private int gradeYear; // 1 - freshman, 2 - sophomore, etc.
	private String studentId;
	private List<Course> courses = new ArrayList<Course>();
	private double tuitionBalance = 0;
	
	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentID();
		
		System.out.println("Name: " + firstName + " " + lastName + " " + gradeYear + " " + studentId);
	}
	
	private void setStudentID() {
		GLOBAL_ID++;
		this.studentId = gradeYear + "" + GLOBAL_ID;
	}
	
	public void enroll() {
		
		// step 1. create an empty arrayList of courses to add
		List<Course> coursesToAdd = new ArrayList<Course>();
		
		// open up a while loop and have the user click q to quit
		boolean isDone = false;
		
		while(!isDone) {
			
			System.out.println("Enter a course to enroll in:");
			String courseName = scan.next();
			
			if (!courseName.equalsIgnoreCase("q")) {
				Course course = new Course(courseName);
			
				// add a course
				coursesToAdd.add(course);
				
				// increase the student's tuition
				tuitionBalance += Course.COST_OF_COURSE;
				
				scan.nextLine();
				
			} else {
				
				System.out.println("****** quitting program ******");
				isDone = true;
			}

		}
		
		this.courses = coursesToAdd;
		
		System.out.println("ENROLLED IN " + courses.toString());
				
	}
	
	public void viewBalance() {
		System.out.println("Your balance = " + tuitionBalance);
	}
	
	public void payTuition() {
		viewBalance();
		// 1. prompt user to enter amount
		System.out.println("Enter payment amount");
		
		// 2. capture the amount as a double
		double payment = scan.nextDouble();
		
		// 3. subtract amount captured from the objects tuition
		tuitionBalance -= payment;
		
		// 4. print out thanks and the updated payment
		System.out.println("Thank you!!");
		viewBalance();
	}

	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGradeYear() {
		return gradeYear;
	}

	public void setGradeYear(int gradeYear) {
		this.gradeYear = gradeYear;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public double getTuitionBalance() {
		return tuitionBalance;
	}

	public void setTuitionBalance(double tuitionBalance) {
		this.tuitionBalance = tuitionBalance;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentId=" + studentId + ", courses=" + courses + ", tuitionBalance=" + tuitionBalance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, firstName, gradeYear, lastName, studentId, tuitionBalance);
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
		return Objects.equals(courses, other.courses) && Objects.equals(firstName, other.firstName)
				&& gradeYear == other.gradeYear && Objects.equals(lastName, other.lastName)
				&& Objects.equals(studentId, other.studentId)
				&& Double.doubleToLongBits(tuitionBalance) == Double.doubleToLongBits(other.tuitionBalance);
	}

}
