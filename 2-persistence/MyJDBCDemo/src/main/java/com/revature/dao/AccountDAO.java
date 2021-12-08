package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAO implements IAccountDAO{

	
	private static Logger logger = Logger.getLogger(AccountDAO.class);
	
	
	@Override
	public int insert(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override //That query may look like SELECT * FROM accounts;
	public List<Account> findAll() {
		
		//instantiate an LinkedList to store all of the account objects that we retrieve
		List<Account> accList = new LinkedList<Account>();
		
		//obtain a connection to the db
		try (Connection conn = ConnectionUtil.getConnection()){
			
			//create a statement to execute against the DB
			Statement stmt = conn.createStatement();
			
			
			String sql = "SELECT * FROM accounts";
			
			//execute the query against the DB
			ResultSet rs = stmt.executeQuery(sql);
			
			//We will retrieve all of the data queried! So we'll need a result set obj to iterate through it
			while(rs.next()) { //ONly return true as long as there is more data to iterate over
				// Open a while loop to gather the properties of all objects return
				
				//gather the id of the accounts
				int id = rs.getInt("id");//capturing the value of the value in the column named 'id' in PostgreSQL
				double balance = rs.getDouble("balance");//You could also have put 2 as the second column that we're extracting data from
				int accOwnerId = rs.getInt("acc_owner");
				boolean isActive = rs.getBoolean("active");
				//gather balance
				
				//instantiate Account obj
				Account a = new Account(id, balance, accOwnerId, isActive);
				
				//add obj to List
				accList.add(a);
				//what happens if there is an Account object with an id., but no Balance and NO account owner id?
				
			}
			
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all Accounts from the DB due to SQL exception");
			e.printStackTrace();
		}
		
		
		//return the List
		
		
		
		
		
		
		
		return accList;
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByOwner(int accOwnerId) {
		return null;
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
