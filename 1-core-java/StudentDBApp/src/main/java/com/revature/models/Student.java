package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Student implements Serializable {

	public static int GLOBAL_ID = 1000;

	private static Scanner scan = new Scanner(System.in);

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;

	// List is an special interface that defines a data structure
	private List<Course> courses = new ArrayList<Course>();

	private double tuitionBalance = 0;

	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;

		setStudentId();

		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);
	}

	private void setStudentId() {
		GLOBAL_ID++;
		this.studentId = gradeYear + "" + GLOBAL_ID;
	}

	public void enroll() {
		// step 1. create an empty arrayList of courses to add
		List<Course> coursesToAdd = new ArrayList<Course>();
		// step 2. open up a while loop and have the user click q to quit
		boolean isDone = false;

		while (!isDone) {
			// step 3. prompt the user to enter a course name
			System.out.println("enter the name of a course to enroll in");
			String courseName = scan.next();

			if (!courseName.equals("q")) {
				// step 4. use that name to build a course Object
				Course course = new Course(courseName);
				coursesToAdd.add(course);
				// step 5. increase the Student's balance field
				tuitionBalance += Course.COST_OF_COURSE;

				scan.nextLine(); // this is necessary to repeat the loop
			} else {
				System.out.println("=====quiting program=====");
				isDone = true;
			}

			// step 6. set the student's course list equals to the course list that we
			// create here
			this.courses = coursesToAdd;
			// step 7. print it all out
			System.out.println("ENROLLED IN" + courses.toString());
		}

	}
	
	public void viewBalance() {
		System.out.println("your balance is equal to" + this.tuitionBalance);
	}
	
	public void payTuition() {
		viewBalance();
		
		// 1.) prompt enter payment amount
		System.out.println("please enter a payment amount");
		// 2.) capture the amount as a double
		double payment = scan.nextDouble();
		// 3.) substract the amount that we capture from the object tuition
		tuitionBalance -= payment;
		// 4.) print out the thank you and show the payment amount again
		System.out.println("Thank you for your payment of " + payment);
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

}
