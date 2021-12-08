package com.revature.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Account;
import com.revature.utilt.ConnectionUtil;

public class AccountDAO  implements IAcountDOA{

	@Override
	public int insert(Account a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		// instintiate a linkedList to store all the accounts the we retrive
		
		List <Account > accList = new LinkedList<>();
		Connection conn =  ConnectionUtil.getConnection() ;
		
		//obtain a connection to th db
		
		try {
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM accounts";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				
				int id = rs.getInt("id"); // in postgresSQL ;
				
				double balance = rs.getDouble("balance");  // row in the table ;
				
				int accOwnerId = rs.getInt("acc_owner");
				
				boolean isActive = rs.getBoolean("acc_owner");
				
				
				Account a = new Account(id , balance, accOwnerId, isActive);
				
				accList.add(a);
				
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// create a statement to excutes agiant 
		
		//
		return accList;
		
		// open a while lop to gather th properties of all objects returned 
		
	
		
		
	}

	@Override
	public Account findBYId(int id) {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	@Override
	public List<Account> findByOwner(int accOwnerId) {
		// TODO Auto-generated method stub
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
