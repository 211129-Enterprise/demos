package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAO implements IAccountDAO{
	
	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public int insert(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Account> findAll() { // Query may look like "SELECT * FROM accounts"
		// Instantiate a LinkedList to store all of the account objects that we retrieve
		List<Account> accList = new LinkedList<Account>();
		
		// Obtain a connection to the DB - try w/ resources
		try(Connection conn = ConnectionUtil.getConnection()){
			
			// Create a statement to execute against the DB
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM accounts";
			
			// Execute the query against the DB
			ResultSet rs = stmt.executeQuery(sql);
			
			
			// Open a while loop to gather the properties of all objects returned
			// We will retrieve all of the data queried! So we'll need a result set obj to iterate through it
			while(rs.next()) {//RS returns false at the end of the row of data it returns
							  //RS only returns true as long as there is more data to iterate over
				
				// gather the id of the accounts, balance, accowner, and isactive
				int id = rs.getInt("accounts_id"); //Capturing the value of the value in the column named "accounts_id" from the DB
				double balance = rs.getDouble("account_balance"); //You could also have put 2 as the second column that we're extracting data from
				int accOwnerId = rs.getInt("account_owner");
				boolean isActive = rs.getBoolean("active");
				
				// instantiate account object
				Account a = new Account(id, balance, accOwnerId, isActive);
				
				//add object to List
				accList.add(a);
				
			}
			
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all accounts from the DB due to SQL Exception");
			e.printStackTrace();
		}
		

		
		//Return the List
		return accList;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByOwner(int userId) {

		List<Account> ownedAccounts	= new LinkedList<Account>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT accounts.id, accounts.balance, accounts.active FROM sophiag.accounts\r\n" + 
					"	INNER JOIN users_accounts_jt \r\n" + 
					"		ON accounts.id = users_accounts_jt.account 	\r\n" + 
					"			WHERE users_accounts_jt.acc_owner = ?;"; 
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// how do we set the ?
			stmt.setInt(1, userId); 
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				double balance = rs.getDouble("balance");
				boolean isActive = rs.getBoolean("active");
				
				Account a = new Account(id, balance, userId, isActive);
				
				// in the case that there are duplicates, DON'T add them to the arraylist
				if(!ownedAccounts.contains(a)) {
					ownedAccounts.add(a);
				}	
			}

		} catch (SQLException e) {
			logger.warn("Failed to retrieve all accounts owned by user with id " + userId);
			e.printStackTrace();
		}
		
		return ownedAccounts;
		
	}

	@Override
	public boolean update(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
