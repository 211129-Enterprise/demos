package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//java bean
public class Student implements Serializable {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static int GLOBAL_ID = 1000;
	
	private String firstName;
	private String lastName;
	private int gradeYear; //1=freshman, 2=softmore, etc
	private String studentID; //we are making the grade year with the number ID
	//every student hass a list of courses that they take.
	private List<Course> courses = new ArrayList<Course>();
	private double tuitionBalance = 0;
	
	
	//constructor will be Firstname, Lastname, gradeyear
	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentId();
		
		//when we call the constructor, let's sysout the instance variables.
		System.out.println(firstName + " " + lastName + " " + gradeYear + studentID +"\n");
	}
	//Set student ID method after enrollment ----------------------------------
	//it will auto-increment some value,
	private void setStudentId() {
		GLOBAL_ID++;
		this.studentID = gradeYear + "" + GLOBAL_ID;
	}
	//enroll method -------------------------------------------------------------------
	public void enroll() {
		//step 1. create an empty arraylist of courses added
		List<Course> coursesToAdd= new ArrayList<Course>();
		boolean isDone = false;
		//step 2. open up a while loop and have a user click q to quit.
		while (!isDone) {
			//step 3. prompt the user to enter a course name.
			System.out.println("Enter a course to enroll in:");
			String courseName = scan.next();
			
			if (!courseName.equalsIgnoreCase("q")) {
				//step 4. use that name to build a course Object
			Course course = new Course(courseName);
				//step 5. increase the Students balance property by 600 per course.
			coursesToAdd.add(course);
				//step 6. set the students course list equal to the course list that we create here.
			tuitionBalance += Course.COST_OF_Course;
				//step 7. print it all out.
			} else {
				System.out.println("===================quitting program===============");
				isDone = true;
			}
		
		}
		this.courses = coursesToAdd;
		System.out.println("ENROLLED IN " + courses.toString());
	}
	//tuition balance method -----------------------------------------------------
	public void viewBalance() {
		System.out.println("Your balance is equal to " + tuitionBalance);
	}
	//pay tuition method -----------------------------------------------------------
	public void payTuition () {
		viewBalance();
		System.out.println("Please enter the payment amount.");
		double payment = scan.nextDouble();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of " + payment);
		viewBalance();
	}
	
	//toString----------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentID=" + studentID + ", courses=" + courses + ", tuitionBalance=" + tuitionBalance + "]";
	}
	
	
	//getters and setters ---------------------------------------------------------------
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
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
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
	//Hashcode and equals -------------------------------------------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(courses, firstName, gradeYear, lastName, studentID, tuitionBalance);
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
				&& Objects.equals(studentID, other.studentID)
				&& Double.doubleToLongBits(tuitionBalance) == Double.doubleToLongBits(other.tuitionBalance);
	}
	
	
	
	
	
	
	
	
	
	
}




