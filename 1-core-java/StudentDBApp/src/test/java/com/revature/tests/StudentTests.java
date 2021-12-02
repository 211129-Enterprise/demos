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
 *  This is a Test Suite (a grouping of unit tests relating to one class)
 */
public class StudentTests {

	// dummy objects (stubs) - static so they can be repeatedly used
	static Student dummyStudent;
	static Course c1, c2;
	static ArrayList<Course> courses;
	
	
	
	@BeforeClass // This method runs BEFORE all of the individual tests are run
	public static void setUpBeforeClass() {
		
		System.out.println("Setting up the test suite...");
		
	}
	
	
	@AfterClass // This method runs AFTER all of the individual tests are run
	public static void tearDownAfterClass() {
		
		System.out.println("Tearing down after test suite...");
		
	}
	
	
	@Before //before EACH unit test runs
	public void setup() {
		
		System.out.println("Setting up...");
		
		courses = new ArrayList<Course>();
		
		c1 = new Course("English 101");
		c2 = new Course("Biology 101");
		
		courses.add(c1);
		courses.add(c2);
		
	}
	
	
	@After //after EACH unit test runs
	public void tearDown() {
		System.out.println("Tearing down...");
				
		c1 = null;
		c2 = null;
		
		courses = null;
		
		dummyStudent = null;
		
		Student.GLOBAL_ID = 1000;		
	}
	
	
	//Before each test, we need to annotate it with @Test
	@Test
	public void testThisIsWorking() { //Important to Maven to begin method name with "test"
		int x = 2, y = 3, sum = (x + y);
		
		System.out.println("The sim is " + sum);
		
		//We're assorting that the actual value is equal to what I expect
		assertEquals(sum, 5);//assertion
	}
	
	@Test
	public void testWhenInstantiateStudent_thenAssignGlobalId() {
		
		dummyStudent = new Student("John", "Doe", 4); //Instantiating Senior named John Doe
		//When we instantiate the student, IF our constructor is working properly, his ID
		//should be "41001"
		
		String actualId = dummyStudent.getStudentId();
		String expectedId = "41001";
		
		assertEquals(expectedId, actualId);
		
	}
	
	// assertTrue()
	//
	// Checking: Is it indeed true that our hashCode() and equals() methods
	// 			 are working? Would two students with the same properties
	//			 return true if they were compared like this:
	//
	//			 assertTrue(student1.equals(student2));
	@Test
	public void testStudentObjEquality() {
		
		dummyStudent = new Student("Bob", "Smith", 1);
		Student anotherStudent = new Student("Bob", "Smith", 1);
		
		// If you output both, they will have different student ids.. one will be 1001 and other would be 1002
		//but you can set them as a constant because otherwise the grade year will be different
		dummyStudent.setStudentId("0");
		anotherStudent.setStudentId("0");
		
		assertTrue(dummyStudent.equals(anotherStudent));
		
		
	}
	
	// We want to test that when someone enters a grade that's below 0 or above 4,
	// it throws a not grade exception.
	@Test(expected=NotAGradeYearException.class)
	public void testBadGradeYearExceptionIsThrown(){
		
		int badGradeYear = -1;
		//we're testing our utility method that takes in a grade year and checks it
		
		UtilityMethods.validateGradeYear(badGradeYear);
		//If this method throws an exception, then the test will pass
	}
	
	

}
