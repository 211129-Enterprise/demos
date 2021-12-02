package com.revature.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Course;
import com.revature.models.Student;

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
	
	
	
	
	
	

}