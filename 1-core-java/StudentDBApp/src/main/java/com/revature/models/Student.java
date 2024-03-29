package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// Java Bean
public class Student implements Serializable {

	// 1000 - everytime a new student is created this value increases by 1;
	public static int GLOBAL_ID = 1000;
	private static Scanner scan = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private int gradeYear; // 1 - Freshman, 2 - Sophomore
	private String studentId; // we have to concatenate the gradeyear plus an autogenerated ID
	// Every student has a list of courses that they take
	private List<Course> courses = new ArrayList<Course>(); // everytime we instantiate a new Student obj
													// they'll have an empty course list
	
	private double tuitionBalance = 0; // here we're intiializing the balance

	// constructor will be Firstname, lastname, gradeyear
	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentId();
		
		// when we call the constructor, let's sysout the instnace variables
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);
	}
	
	// it will auto-increment some value, 
	private void setStudentId() {
		GLOBAL_ID++; // globalId = globalId + 1;
		this.studentId = gradeYear + "" + GLOBAL_ID; // necessary to concatenate so as not to mathematically add
	}
	
	public void enroll() {
		
		// step 1. Create an empty arraylist of courses to add
		List<Course> coursesToAdd = new ArrayList<Course>();
		
		// step 2. open up a while loop and have the user click q to quit
		boolean isDone = false;
		
		while (!isDone) { // isDone == false
			
			// step 3. prompt the user to enter a course name
			System.out.println("Enter the name of a course to enroll in:");
			
			// step 3a. capture that string in an String variable called name
			String courseName = scan.next(); // we need to create a scanner in this class
			
			if (!courseName.equalsIgnoreCase("q")) { // if the user puts in an uppercase Q? equals ignore case can handle it
					
				// step 4. use that name to build a course Object
				Course course = new Course(courseName);
				
				// step 4a add it to the courses to add list
				coursesToAdd.add(course);
				
				// step 5. increase the Student's balance property by 600 per course
				tuitionBalance += Course.COST_OF_COURSE; // tution balance is equal to tution balance + the static cost of course (600)
				
				scan.nextLine(); // this is necessary to repeat the loop
				
			} else { // else if they wrote "q"
				
				System.out.println("===== quitting program =====");
				isDone = true;
			}
		
			
		}
		
		// step 6. set the student's course list equal to the course list that we create here
		this.courses = coursesToAdd; // this means the courses list 
		
		// step 7. print it all out!
		System.out.println("ENROLLED IN " + courses.toString());
		
	}
	
	// view balance
	public void viewBalance() {
		System.out.println("Your balance is equal to " + tuitionBalance);
	}
	
	
	// pay tution
	public void payTuition() {
		
		viewBalance();
		
		// 1. prompt enter payment amount
		System.out.println("Please enter a payament amount");
		
		// 2. capture the amount as a double
		double payment = scan.nextDouble();
		
		// 3.  subtract the amount that we capture from the objects tuition
		tuitionBalance -= payment;
		
		// 4.  print out thank you and show the payment amount again
		System.out.println("Thank you for your payment of " + payment);
		
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

	// add toString() HashCode() & Equals()
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
