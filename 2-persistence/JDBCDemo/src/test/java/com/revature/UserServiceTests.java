package com.revature;

import static org.mockito.Mockito.mock;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.service.UserService;

public class UserServiceTests {
	
	private UserService userv;
	
	// declare the dependencies

	private UserDAO mockDao;
	
	// how to mock a private dependency?
	// reflection is an advanced concept 
	
	private User dummyUser;
	
	@Before // before every test is run
	public void setup() {
		userv = new UserService();
		mockDao = mock(UserDAO.class);
		
		userv.udao = mockDao;
		
		dummyUser = new User();
		
		dummyUser.setAccounts(new LinkedList<Account>());
		dummyUser.setId(0);
		
		
	}
	
	@After
	public void teardown() {
		userv = null;
		dummyUser = null;
		mockDao = null;
	}
	
	@Test(expected=RegisterUserFailedException.class)
	public void testRegisterUser_isGreatThanZero_throwsException() {
		dummyUser.setId(1);
		userv.register(dummyUser);
	}
	
}
