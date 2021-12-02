package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {
	
	
	private static int GLOBAL_ID = 1000;
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	
	// List is an special interface that defines a data structure
	private List<Course> courses = new ArrayList<Courses>();
	
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
		this.studentId = gradeYear + "" + GLOBAL_ID;
	}
	
	public void enroll() {
		
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
