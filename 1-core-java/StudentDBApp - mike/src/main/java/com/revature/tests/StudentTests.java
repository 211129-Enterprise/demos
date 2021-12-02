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

public class StudentTests {
	
	// dummy objects (stubs)
	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Setting up the test suite......");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Tearing down after test suite....");
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up...");
		
		courses = new ArrayList<Course>();
		
		c1 = new Course("English 101");
		c2 = new Course("Biology 400");
		
		courses.add(c1);
		courses.add(c2);
		
	}
	
	@After
	public void tearDown() {
		System.out.println();
		
		Student.GLOBAL_ID = 1000;
		
		c1 = null;
		c2 = null;
		
		courses = null;
		
		dummyStudent = null;
	}
	
	@Test
	public void testThisisWorking() {
		int x = 2;
		int y = 3;
		int sum = (x+y);
		
		assertEquals(sum, 5);
	}
	
	@Test
	public void testWhenInstantiateStudent_thenAssignUniqueGlobalId() {
		dummyStudent = new Student("John", "Doe", 4); // id should equal 41001
		String actualId = dummyStudent.getStudentId();
		String expectedId = "41001";
		
		assertEquals(expectedId, actualId);
	}
	
	@Test
	public void testStudentObjEquality() {
		dummyStudent = new Student("Bob", "Smith", 1);
		Student anotherStudent = new Student("Bob", "Smith", 1);
		
		dummyStudent.setStudentId("0");
		anotherStudent.setStudentId("0");
		
		assertTrue(dummyStudent.equals(anotherStudent));
	}
	
	@Test(expected=NotAGradeYearException.class)
	public void testBadGradeYearExceptionIsThrown() {
		int badGradeYear = -1;
		
		UtilityMethods.validateGradeYear(badGradeYear);
	}

}
