package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Course;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

/**
 * This is a Test Suite (a grouping of unit tests relating to one class)
 */
public class StudentTests {
	
	// dummy objects (stubs) - why are these static? So I can repeatedly use
	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	
	@BeforeClass // this method runs before all of the individual tests are run
	public static void setUpBeforeClass() {
		
		System.out.println("Setting up the test suite....");
		
	}
	
	@AfterClass // this method runs after all of the individual tests are run
	public static void tearDownAfterClass() {
		
		System.out.println("Tearing down after test suite");
		
	}
	
	@Before // before EACH unit test runs
	public void setUp() {
		
		System.out.println("Setting up...");
		
		courses = new ArrayList<Course>();
		
		c1 = new Course("English 101");
		c2 = new Course("Biology 400");
		
		courses.add(c1);
		courses.add(c2);
		
	}
	
	@After // after each test runs
	public void tearDown() {
		
		System.out.println();
		
		c1 = null;
		c2 = null;
		
		courses = null;
		dummyStudent = null;
		
		Student.GLOBAL_ID = 1000;
		
	}
	
	
	@Test
	public void testThisisWorking() {
		
		int x = 2;
		int y = 3;
		
		int sum = (x + y);
		
		System.out.println("The sum is " + sum);
		
		// we're asserting that the actual value is equal to what I expect
		assertEquals(sum, 5); // assertion
	}
	
	@Test
	public void testWhenInstantiateStudent_thenAssignUniqueGlobalId() {
		
		dummyStudent = new Student("John", "Doe", 4); // senior
		// when we instantiate the student, IF our constructor is working properly,
		// his id should be "41001"
		
		String actualId = dummyStudent.getStudentId(); // I must create a getter method
		String expectedId = "41001";
		
		assertEquals(expectedId, actualId);
	}
	
	// assertTrue
	// checking: is it indeed tru that our hashCode() and equals() mehtods are working and 2 sutdents with the same properties would return 
	// true if they were compared like this 
	
	// assertTrue(student1.equals(student2));
	
	@Test
	public void testStudentObjEquality() {
		
		dummyStudent = new Student("Bob", "Smith", 1);
		Student anotherStudent = new Student("Bob", "Smith", 1);
		
		System.out.println(dummyStudent); // both will have diff id's 1002
		System.out.println(anotherStudent); // this will be 1003
		
		// Here I'm setting this as a constanct (because otherwise this studentID will be different
		dummyStudent.setStudentId("0");
		anotherStudent.setStudentId("0");
		
		assertTrue(dummyStudent.equals(anotherStudent));
		
	}
	
	// We want to test that when someone enters a grade that's belo 0 or above 4, it throws a
	// not a grade exception
	@Test(expected=NotAGradeYearException.class)
	public void testbadGradeYearExceptionIsThrown() {
		
		int badGradeYear = -1;
		// we're testing our utility method that takes in a grade year and checks it
		
		UtilityMethods.validateGradeYear(badGradeYear);
		// if this method throws an exception then the test passes
	}
}
