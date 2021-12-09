package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.AccountDAO;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.AccountService;

public class AccountServiceTests {
	private AccountService aservice;
	
	private AccountDAO mockdao;
	
	@Before
	public void setup() {
		
		aservice = new AccountService();
		
		mockdao = mock(AccountDAO.class);
	
		aservice.adao = mockdao;
	}
	
	@After
	public void teardown() {
		aservice = null;
		mockdao = null;
	}
	
	
	
	@Test
	public void testFindByOwnerId_returnAccountList() {
		
		// create a new list of accounts to be in possession of a new user that we create
		List<Account> bobsAccounts = new LinkedList<Account>();
		
		Account a = new Account(1, 500, false);
		Account b = new Account(2, 600, true);
		bobsAccounts.add(a);
		bobsAccounts.add(b);
		
		User bob = new User(4, "bob", "secretpass", Role.Customer, bobsAccounts);
		
		// when we call our mockdao findByOwner (bobsid...) it returns the list of bobs accounts
		
		int bobsId = bob.getId();
		
		
		when(mockdao.findByOwner(bobsId)).thenReturn(bobsAccounts);
		
		// we have toi go to the Account Service and write this method ourselves
		List<Account> returnedAccounts = aservice.findByOwner(bobsId);
		
		// expected, actual
		assertEquals(bobsAccounts, returnedAccounts);		
	}
	
}
