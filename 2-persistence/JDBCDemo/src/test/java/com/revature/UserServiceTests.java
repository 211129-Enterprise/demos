package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.UserService;

public class UserServiceTests {
	
	// declare a variable to point ot the clas to be tested
	private UserService userv;
	
	// declare the dependencies of the class to be tested
	private UserDAO mockDao;
	
	// how to mock a private dependency? 
	
	private User dummyUser;
	
	@Before // before every test is run 
	public void setup() {
		
		userv = new UserService();
		mockDao = mock(UserDAO.class); 
		
		userv.udao = mockDao; // set the UserService instance's DAO property equal to the mocked Dao
		
		// setup a stub
		dummyUser = new User();
		dummyUser.setAccounts(new LinkedList<Account>());
		dummyUser.setId(0); // we're pretending as if this User was generated from the Console.
		
	}
	
	@After
	public void teardown() {
		
		userv = null;
		dummyUser = null;
		mockDao = null;	
	}
	
	// every time we register a user, we return the PK that's generated in the DB
	
	@Test
	public void testRegisterUser_returnsNewPkAsId() {
		dummyUser = new User(0, "spongebob", "pass", Role.Admin, new LinkedList<Account>());
		
		// randomly generate a number which we'll pretend that the DB generated
		Random r = new Random();
		int fakePk = r.nextInt(100);
		
		// we're going to program the UserService's dao to return the fake PK when the the insert method is called
		when(mockDao.insert(dummyUser)).thenReturn(fakePk); 
		
		
		// the retunred user of our register method SHOULD have the id that's retunred by the insert() method on the dao
		User registeredUser = userv.register(dummyUser);
		
		// assertequals: is the ID of the registered user equal to the fakePk that we generated?
		assertEquals(registeredUser.getId(), fakePk);
	}
	
	
	
	@Test(expected=RegisterUserFailedException.class)
	public void testRegisterUser_IdIsGreaterThanZero_throwsException() {
		
		dummyUser.setId(1);
		
		userv.register(dummyUser); // this should throw an exception		
	}
	
	

}
