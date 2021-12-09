package com.revature;
import org.junit.Test;

import com.revature.DAO.UserDAO;
import com.revature.Service.UserService;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;

public class UserSeriveTest {
	
	private UserService userv ;
	
	public UserDAO  mockDAO ;
	
	private User dummyUser;
	
	@Before
	public void setup() {
		userv = new UserService();
	
		mockDAO = mock(UserDAO.class);
		
		userv.udao = mockDAO; // set userService interface's DAO proprrt equal to the mocked Dao
		
		dummyUser = new User();
		
		dummyUser.setAccounts(new LinkedList<Account>());
		
		dummyUser.setId(0);
		
		
	}
	

	@Test(expected = Exception.class )
	public void testRestwhenIdgreatedThanZero() {
		dummyUser.setId(1);
		userv.register(dummyUser);	
	}
		
	
	@Test
	public void testRegisterUser_returnNewId() {
		dummyUser = new User(0, "sponge", "pass", Role.Admin , new LinkedList<Account>() );
		Random r = new Random();
		int fakePk = r.nextInt(100);
		
		when(mockDAO.insert(dummyUser)).thenReturn(fakePk );
		
		
		User registerUser = userv.register(dummyUser);
		
		assertEquals(registerUser.getId(), fakePk);
	}
	
	
	@After
	public void tearDown() {
		userv = null;
		dummyUser = null;
		mockDAO = null;
	}
		
	
}
