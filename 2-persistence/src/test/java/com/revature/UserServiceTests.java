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


/* AIM FOR 80% TEST COVERAGE OF SERVICE LAYER */
// TEST EVERY METHOD
public class UserServiceTests {

	// Declare a variable to point at the class to be tested
	private UserService userv;

	// Declare the depdencies of the class to be tested
	private UserDAO mockDao;

	// How to mock a private dependency?

	private User dummyUser;

	@Before // Before every test is run
	public void setup() {

		userv = new UserService();
		mockDao = mock(UserDAO.class); // Replication of the UserDAO class

		userv.udao = mockDao; // Set the UserService instance's DAO properties equal to the mock DAO

		// Setup a stub
		dummyUser = new User();
		dummyUser.setAccounts(new LinkedList<Account>());
		dummyUser.setId(0); // We're pretending as if we made this user from the console.
	}

	@After // After every test is run
	public void teardown() {

		userv = null;
		dummyUser = null;
		mockDao = null;
	}

	// Every time we register a user, we return the PK that's generated in the DB
	@Test
	public void testRegisterUser_returnsNewPkAsId() {

		dummyUser = new User(0, "SpingeBill", "pass", Role.Admin, new LinkedList<Account>());

		// randomly generate a number which we'll pretend that the DB generated
		Random r = new Random();

		int fakePK = r.nextInt(100);

		// We're going to program the User Service's DAO to return the fake PK when the
		// insert method is called
		when(mockDao.insert(dummyUser)).thenReturn(fakePK); // When/Then Pattern in Mockito

		// The returned user of our register method should have the ID that's returned
		// by the insert() method on the Dao
		User registeredUser = userv.register(dummyUser);
		
		//assertEquals: is the ID of the registered user equal to the fake PK that we generated?
		assertEquals(registeredUser.getId(), fakePK);
	}

	@Test(expected = RegisterUserFailedException.class)
	public void testRegisterUser_idIsGreaterThanZero_throwsException() {

		// Create a User object
		dummyUser.setId(1);

		// Then call the service layer and register it
		userv.register(dummyUser); // This should throw an exception
	}

}
