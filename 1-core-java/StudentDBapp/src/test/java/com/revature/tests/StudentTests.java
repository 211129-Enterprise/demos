package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.Exception.NoGradeYearException;
import com.revature.models.Course;
import com.revature.models.Student;
import com.revature.util.UtilityMethod;

public class StudentTests {
	
	static Course c1 ;
	static Course c2 ;
	static Student dummyStudent;
	static ArrayList<Course> courses ;
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("setting up the test suite ...");
	}
	
	
	@AfterClass 
	
	public static void afterClassMethod() {
		System.out.println("tests are done ");
	}
	
	
	
	
	@Before
	public void setUpBeforeEachTest() {
		System.out.println("setting up");
		c1 = new Course("English 101");
		c2 =new  Course("Biology 400"); 
		courses = new ArrayList<Course>();
		courses.add(c1);
		courses.add(c2);
	}
	
	@After
	
	public  void tearDownAfterEachClass() {
		System.out.println("tearing down");
		c1 = null;
		c2 = null ;
		courses = null ;
		Student.GLOBAL_ID = 1000 ;
	}
	
	
	@Test
	public  void testThisisWorking() {
		int x = 2;
		int y =3 ;
		
		int sum = (x + y);
		
//		System.out.println("the sum is "+ sum);
		
		assertEquals(sum, 5); // assertion ;	
	}
	
	@Test 
	public void testWhenInsiateStudent_incrmentId() {
		dummyStudent = new Student("Jhon ", "Doe", 4);
		
		String actualIdString = dummyStudent.getStudentId() ;
		String expectedString = "41001";
		
		assertEquals(expectedString ,actualIdString );
		
	}
	
	
	@Test

	public void testStudentObjEquality() {
		dummyStudent = new Student("smith", "bob", 1);
		Student anotherStudent = new Student("smith", "bob", 1);
		
		dummyStudent.setStudentId("0");
		anotherStudent.setStudentId("0");
		
		System.out.println(dummyStudent);
		System.out.println(anotherStudent);
		
		assertTrue(dummyStudent.equals(anotherStudent));
		
//		assertEquals(dummyStudent, anotherStudent);
		
		
	}
	
	// when I expect an exception 
	
	@Test(expected =NoGradeYearException.class ) 
	public void testExcpetionOfGradYear() {
		
		int BadGradYear = -1 ;
		
		UtilityMethod.validateGradYear(BadGradYear);
		
	}
	
	
	
}
