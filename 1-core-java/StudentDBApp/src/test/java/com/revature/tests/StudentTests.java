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

/* 
 * This is a test suite (a grouping of unit tests relating to one class)
 */
public class StudentTests {
	
	//dummy objects (stubs)
	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	@BeforeClass //This method runs before all the individuals tests are run.
	public static void setUpBeforeClass() {
		System.out.println("Setting up this test suite......");
	}
	
	@AfterClass 
	public static void tearDownAfterClass() {
		System.out.println("Tearing down the after test suite.");
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up....");
		courses = new ArrayList<Course>();
		c1 = new Course("English 101");
		c2 = new Course("Biology 400");
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
		Student.GLOBAL_ID = 1000;
	}
	
	@Test
	public void testThisIsWorking() {
		int x=2;
		int y=3;
		int sum= (x + y);
		System.out.println("This test is working 1.");
		//we're asserting that the actual value is equal to what I expect.
		assertEquals(sum, 5);
	}
	
	@Test
	public void testWhenInstantiateStudent_ThenAssignUniqueGlobalId() {
		dummyStudent = new Student("John", "Doe", 4); //senior
		//when we instantiate the student properly IF our constructor is working 
		//properly, his id should be 41001.
		
		String actualId = dummyStudent.getStudentID();
		String expectedId= "41001";
		assertEquals(expectedId, actualId);
	}
	
	@Test
	public void testStudentObjEquality() {
		dummyStudent = new Student("Bob", "Smith", 1);
		Student anotherStudent = new Student("Bob", "Smith", 1);
		
		System.out.println(dummyStudent); //both will have diff ID's
		System.out.println(anotherStudent); // this will be 1003
		
		//here she's setting student id's equal to 0 to run this test.
		dummyStudent.setStudentID("0");
		anotherStudent.setStudentID("0");
		
		assertTrue(dummyStudent.equals(anotherStudent));
	}
	
	//We want to test that when someone entrs a grade thats below 0 or above 4, it 
	//throws not a grade exception.
	@Test(expected = NotAGradeYearException.class)
	public void testbadGradeYearExceptionIsThrown() {
		int badGradeYear = -1;
		//We're testing out utility method.
		UtilityMethods.validateGradeYear(badGradeYear);
		//If this throws an exception, this passes the test.
	}
	
	
}
