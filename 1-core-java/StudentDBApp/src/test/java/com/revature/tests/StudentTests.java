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

public class StudentTests {
	
	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	@BeforeClass
	public static void setUp1() {
		System.out.println("Setting up the test suite....");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Tearing down after test suite.");
	}
	
	@Before // 
	public void setUp() {
		System.out.println("Setting up...");
		
		courses = new ArrayList<Course>();
		
		c1 = new Course("English 101");
		c2 = new Course("Biology 101");
		
		courses.add(c1);
		courses.add(c2);
	}
	
	@After
	public void tearDown() {
		System.out.println();
		
		c1 = null;
		c2 = null;
		
		courses = null;
		dummyStudent = null;
	}
	
	@Test
	public void testThisIsWorking() {
		
		int x = 2;
		int y = 3;
		
		int sum = (2 + 3);
		
		System.out.println("the sum is " + sum);
		
		assertEquals(sum, 5);
	}
	
	@Test
	public void testWhenInstatiateStudent_thenIncrementGlobalId() {
		dummyStudent = new Student("John", "Doe", 4);
		
		String actualId = dummyStudent.getStudentId();
		
		String expectedId = "41001";
		
		assertEquals(expectedId, actualId);
	}
	
	
}
