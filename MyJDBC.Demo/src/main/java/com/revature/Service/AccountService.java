package com.revature.Service;

import com.revature.DAO.AccountDAO;
import com.revature.DAO.IAcountDOA;
import com.revature.models.Account;
import com.revature.models.User;

public class AccountService {

	private IAcountDOA adoa = new AccountDAO();
	
	public void viewAllAccountsByOwner(int accOwnedId) {
		for(Account a: adoa.findByOwner( accOwnedId) ){
			System.out.println(a);
		}
		
		
//		Account openAccount(User u) {
//			
//			return null;
//		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
