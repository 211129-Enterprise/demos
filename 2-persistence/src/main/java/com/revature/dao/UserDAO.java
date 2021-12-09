package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/**
 * This class will be instantiated in the Service layer to perform all DB
 * operations regarding User objects.
 * 
 * This class will incorporate all persistence logic
 */
public class UserDAO implements IUserDAO {

	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public int insert(User u) {
		
		// STEP 1: Capture a DB connection by calling the ConnectionUtil getConnection()
		// method.
		Connection conn = ConnectionUtil.getConnection(); // Connection Interface comes from JDBC

		// STEP 2: Generate a SQL statement like INSERT INTO users (username, password,
		// role) VALUES (?, ?, ?)
		String sql = "INSERT INTO users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING users.user_id";

		try {
			// STEP 2b: Use a prepared Statement to avoid SQL Injection
			PreparedStatement stmt = conn.prepareStatement(sql);

			// start process to set the values we're inserting into the DB = to the props of
			// the User Object
			stmt.setString(1, u.getUsername()); // The first argument (1) points to which number of ? marks in the
												// prepared statement
			stmt.setString(2, u.getPassword());

			// We'll have to transpose a Java enum type to a RDBMS enum type
			stmt.setObject(3, u.getRole(), Types.OTHER);

			// Use a ResultSet to extract the Primary Key from the User Object that was
			// persisted.
			ResultSet rs; // Import from JDBC API java.sql - ResultSet allows us to iterate over retrieved
						  // data

			if ((rs = stmt.executeQuery()) != null) {
				// If we return data, we can iterate over it with a cursor
				rs.next();

				// We need to capture the first column of data returned (which is the ID of the
				// returned user object)
				int id = rs.getInt(1); // Get the integer of column #1

				// log if it was successful
				logger.info("Returned User ID #" + id);

				return id;
			}
		} catch (SQLException e) {
			logger.error("Unable to insert user - SQL exception thrown.");
		}

		// Return -1 if unsuccessful, otherwise return the PK of the persisted User object
		// Our DB can't produce a negative, so this indicates that something went wrong.
		return -1;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override 
	public List<User> findall() {

		//empty list to store User objects
		List<User> allUsers = new LinkedList<User>();
		
		// try / catch with the connection
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//Create statement
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT users.id, users.username, users.pwd, users.user_role, accounts.id AS account_id, accounts.balance, accounts.active\n"
					+ "	FROM aaronm.users\n"
					+ "	LEFT JOIN aaronm.users_accounts_jt ON users.id = users_accounts_jt.acc_owner\n"
					+ "	LEFT JOIN aaronm.accounts ON accounts.id = users_accounts_jt.account;";
			
			// grab user data from each row
			ResultSet rs = stmt.executeQuery(sql);
			
			// Iterate through the table of the data returned
			while(rs.next()) {
				
				//grab id, username, and password, role
				int id = rs.getInt("id");
				String username = rs.getString("username"),
						password = rs.getString("pwd");
				
				Role role = Role.valueOf(rs.getString("user_role"));
				
				int accId = rs.getInt("account_id");
				double balance = rs.getInt("balance");
				boolean isActive = rs.getBoolean("active");
				
				
				// if the account ID is zero, that means that the user doesn't have an account
				if(accId == 0) {
					
					allUsers.add( new User(id, username, password, role, new LinkedList<Account>()) );
					
				} else {
					
					// Remember: "id" below represents the User's ID which is the owner Id
					int ownerId = id;
					Account a = new Account( accId, balance, ownerId, isActive );
					
					// Next week (Week 3) we'll go in depth into the String API
					List<User> potentialOwners = allUsers.stream()
												.filter((u) -> u.getId() == ownerId)
												.collect(Collectors.toList());
					
					if(potentialOwners.isEmpty()) {
						List<Account> ownedAccounts = new LinkedList<Account>();
						ownedAccounts.add(a);
						
						User u = new User(ownerId, username, password, role, ownedAccounts);
						
						allUsers.add(u);
					} else {
						// The owner of this account already exists
						User u = potentialOwners.get(0);
						
						// This is the logic that enables us to capture multiple accounts that belong to one person
						List<Account> ownedAccs = u.getAccounts();
						ownedAccs.add(a);
						u.setAccounts(ownedAccs);
					}
					
				}
				
			}
			
		} catch (SQLException e) {
			logger.warn("SQL Exception thrown - Can't retrieve all users from DB");
			e.printStackTrace(); // This will give you a good idea of EXACTLY what is going on
		}
		
		
		return allUsers; // Return null if there are no users
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
