package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

//make it bean

public class Student implements Serializable {
	public static int GLOBAL_ID = 1000 ;
	
	public static Scanner scan = new Scanner(System.in);
	
	private String firstName ;
	private String lastName ; 
	private int gradeYear;
	private String studentId; 
	private List <Course> courses = new ArrayList<Course>();
	
	private double tuitionBalance = 0;

	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentId();
		
		// when we call let sysout
		
		System.out.println(firstName + " " + lastName + " "+ gradeYear + " " + studentId);
	}
	
	private void setStudentId() {
		GLOBAL_ID++ ;
		this.studentId = gradeYear + "" + GLOBAL_ID ;
		
	}
	
	public void enroll() {
		
		
		
		List<Course> coursesToAdd  = new ArrayList<Course>();
		
		boolean isDone = false;
		
		while( !isDone ) {
			
			System.out.println("Enter the name of course to enroll in: ");
			
			String courseName = scan.next();
			
			if(!courseName.equalsIgnoreCase("q")) {
				Course course = new Course(courseName);
				
				
				coursesToAdd.add(course);
				
				tuitionBalance+= Course.COST_OF_COURSE ;
				
				scan.nextLine(); // to complete the loop ;
				
				
			}else {
				System.out.println("====== quiting program =======");
				
				isDone = true;
				
			}
			
		}
		
		this.courses =coursesToAdd ;
		
		System.out.println("enrolled  in " + courses.toString());
	}
	
	
	
	public void viewBalance() {
		System.out.println("your balance is  "+  this.tuitionBalance);
	}
	
	public void payTuition() {
		viewBalance();
		
	
		System.out.println("please enter a payment amount");
		
		double amount = scan.nextDouble();
		
		this.tuitionBalance -= amount ;
		
		System.out.println("Thank you for you payment " +  amount);
		
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
