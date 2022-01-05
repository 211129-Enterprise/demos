package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceTests {
	
	private EmployeeDAO mockdao;
	private EmployeeService eserv;
	
	@Before // before every test case
	public  void setup() {
		
		mockdao = mock(EmployeeDAO.class);
		eserv = new EmployeeService(mockdao); // constructor injection
		
	}
	
	@After
	public void teardown() {
		mockdao = null;
		eserv = null;
	}
	
	// Happy Path Scenario - test we get an expected result when things go RIGHT
	
	@Test
	public void testConfirmLogin_success() {
		
		// we createa a fake DB of Employee objects
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(23, "Clint", "Barton", "Hawkeye", "arrows");
		
		// add those employee objects to a list
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		// when the mockdao's findAll() method is called, it returns our dummy list (list of stubs)
		when(mockdao.findAll()).thenReturn(dummyDb);
		/**
		 *  Above we intercept the data that would otherwise be returned from the database.
		 *  
		 *  The EmployeeService's confirmLogin method CALLS the DAO....
		 *  specifically, it calls the findAll() method.
		 */
		
		// use an assert equals on the eserv.confirmLogin method that we return the right user
		
		// WHEN we call confirm login with username Hawkeye and password arrows, we return Employee e2		
		assertEquals(e2, eserv.confirmLogin("Hawkeye", "arrows"));
	}
	
	@Test
	public void testConfirmLogin_fail() {
		
		// we createa a fake DB of Employee objects
		Employee e1 = new Employee(3, "Scott", "Lang", "Antman", "bugs");
		Employee e2 = new Employee(23, "Clint", "Barton", "Hawkeye", "arrows");
		
		// add those employee objects to a list
		List<Employee> dummyDb = new ArrayList<>();
		dummyDb.add(e1);
		dummyDb.add(e2);
		
		// when the mockdao's findAll() method is called, it returns our dummy list (list of stubs)
		when(mockdao.findAll()).thenReturn(dummyDb);
		
		
		// We want to test that when we try to confirm login for Haweye with the WRONG
		// password, it returns null
		assertNull(eserv.confirmLogin("Hawkeye", "arrow")); // alt + shift + x, t runns JUnit tests
	}
}





