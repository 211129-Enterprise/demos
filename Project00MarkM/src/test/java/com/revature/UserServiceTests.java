package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.classes.Administrator;
import com.revature.classes.Customers;
import com.revature.dao.UserDAO;
import com.revature.exceptions.RegisterUserFailedException;
import com.revature.service.UserService;
import com.revature.util.Role;

public class UserServiceTests {
	private UserService userv;
	private UserDAO mockDAO;
	private Customers dummyUser;
	
	@Before
	public void setup() {
		userv = new UserService();
		mockDAO = mock(UserDAO.class);
		userv.DAO = mockDAO; 
		dummyUser = new Customers(0, "mark", "t", "martin", 2, 630, "456253489", "mark", "marty", true);
		dummyUser.setRole(Role.Customers);
		//id, firstName, middleInitial, lastName, accountRanking, creditCheck, socialSecurity, userName, passWord, active
		//dummyUser.setAccounts(new LinkedList<Account>());
		dummyUser.setId(0);
	}
	
	@After
	public void teardown() {
		userv = null;
		dummyUser = null;
		mockDAO = null;
	}
	@Test
	public void testRegisterUser_returnsNewPkAsId() {
		dummyUser = new Customers();
		Random r = new Random();
		int fakePk = r.nextInt(100);
		when(mockDAO.insert(dummyUser)).thenReturn(fakePk);
		Customers registeredUser = userv.register(dummyUser);
		assertEquals(registeredUser.getId(), fakePk);
	}
	@Test(expected=RegisterUserFailedException.class)
	public void testRegisterUser_isGreaterThanZero_ThrowsException() {
		dummyUser.setId(1);
		userv.register(dummyUser);		
	}
//	@Test
//	public void testWhenCustomersLogInFailsPassword() {
//		
//		String fakePk = ("tacos");
//		when(mockDAO.findCustomersByUsername("mark")).thenReturn(dummyUser);
//		Customers loggedInUser = userv.loginCustomers("mark", "arty");
//		assertEquals(loggedInUser.getId(), fakePk);
//	}
//	@Test
//	public void testWhenCustomersLogInFailsRole() {
//		when(mockDAO.findCustomersByUsername("mark")).thenReturn(dummyUser);
//		Administrator loggedInUser = userv.loginAdministrator("mark", "marty");
//		assertEquals(loggedInUser, null);
//	}
	
}
