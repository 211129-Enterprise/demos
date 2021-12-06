package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
 * Java Bean
 * 
 */


public class Student implements Serializable  {
	
	// 1000 - everytime a new student is created this value increases by 1;
	private static int GLOBAL_ID = 1000;
	
	private String firstName;
	private String lastName;
	private int gradeYear; // 1. Freshman, 2 Sophomore
	private String studentId; // we have to concatenate the grade year plus an auto generated ID
	// Every student has a list of courses that they take
	
	private List<Course> courses = new ArrayList<Course>(); //every time we instantiate a new Student obj
                                                            //they'll have an empty course list
	private double tuitionBalnce = 0; // here we're initializing the balance
	
	// constructor will be firstname, lastname, gradeyear
	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentId();
		
		// when we call the constructor, let's sysout the instance variables
		System.out.println(firstName + " " + lastName + " " + gradeYear);
		
	}
	
	// it will auto-increment some value
	private void setStudentId() {
		GLOBAL_ID++; // globalId = globlaId + 1
		this.studentId = gradeYear + " " + GLOBAL_ID; // Necessary to concatenate so as not to mathematically add
		
	}
	
	public void enroll() {
		
		// add a course 
		
		// increase the student's tuition balance
		
	}
	
	
	
	
	
	

		// add toString() hashcode() and equals()
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentId=" + studentId + ", courses=" + courses + ", tuitionBalnce=" + tuitionBalnce + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(courses, firstName, gradeYear, lastName, studentId, tuitionBalnce);
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
				&& Double.doubleToLongBits(tuitionBalnce) == Double.doubleToLongBits(other.tuitionBalnce);
	}
													
	
	
	
	
	
}
