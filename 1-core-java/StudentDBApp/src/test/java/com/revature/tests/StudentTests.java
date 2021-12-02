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
	public static void setUpBeforeClass() {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		
	}
	
	@Before 
	public void setUp() {
		
		courses = new ArrayList<Course>();
		c1 = new Course("English 101");
		c2 = new Course("Biology 400");
		
		courses.add(c1);
		courses.add(c2);
	}
	
	@After
	public void tearDown() {
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
		
		assertEquals(sum, 5);
	}
	
	@Test
	public void testWhenInstatiateStudent_thenAssignUniqueGlobalId() {
		dummyStudent = new Student("John", "Doe", 4);
		
		String actualId = dummyStudent.getStudentId();
		String expectedId = "41001";
		assertEquals(expectedId, actualId);
	}

}
