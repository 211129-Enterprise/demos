package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;
/*
 * JDBC API main Classes and Interfaces:
 * https://www.tutorialspoint.com/what-are-the-main-classes-and-interfaces-of-jdbc
 * 
 * (1) DriverManager class
 * 	- This class manages the JDBC drivers.
 * 	- Some static methods, such as getConnection() that we use to connect to a DB
 * 	- Used to obtain a Connection
 * 
 * (2) Connection Interface
 * 	- Represents a Connection to our DB
 * 	- Has methods to obtain Statements
 * 	- This interface provides methods such as close(), commit(), rollback(), 
 * 		createStatement(), prepareCall(), prepareStatement(), setAutoCommit() setSavepoint() etc.
 * 
 * (3) Statement Interface
 * 	- Represents a static SQL statement that will be performed against the DB
 * 	- There are sub-interfaces for specific use-cases
 * 		- PreparedStatement Interface 
 * 			- CallableStatement Interface
 * 	- Have methods to obtain ResultSets
 * 
 * (4) ResultSet Interface
 * 	- Represents data obtained from the DB
 * 	- Follows an "Iterator" structure
 * 		- Is pointing to individual rows
 * 		- Invoke the .next() method to step forward
 * 		- Starts at the position BEFORE the first row
 * 	- Has methods to obtain data from individual columns for that row
 * 		- getInt()
 * 		- getString()
 * 
 * (5) CallableStatement Interface
 * 	- Using an object of this interface you can execute stored procedures. 
 * 	- Methods include prepareCall()
 * 	- A stored procedure is a prepared SQL code that you can save, so the code can be reused over and over again.
 */


/**
 * This class be instantiated in the Service layer to perform all DB operations
 * regarding User objects
 * 
 * This class will incorporate all persistence logic.
 *
 */
public class UserDAO implements IUserDAO {

	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public int insert(User u) {

		// Step 1. Capture a DB connection by calling the ConnectionUtil getConnection()
		// method.
		Connection conn = ConnectionUtil.getConnection(); // Connection Interface comes from JDBC API

		// Step 2. Generate a SQL statment like INSERT INTO users (username, pwd, role) VALUES (?, ?, ?)...
		String sql = "INSERT INTO users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING users.id";
		// we will provide a value for the ? marks in the statement using stmt.setString()...

		try {
			// Steb 2b. Use a prepared Statement to do this to avoid SQL injection
			PreparedStatement stmt = conn.prepareStatement(sql);

			// start process to set the values we're inserting into the DB = to the pops of
			// the User object
			stmt.setString(1, u.getUsername()); // the first argument (1) points to which number of ? marks in the
												// prepared statement statement
			stmt.setString(2, u.getPassword());

			// we wil have to transpose a java enum type to a RDBMS enum type - this is an
			// easy work around
			stmt.setObject(3, u.getRole(), Types.OTHER);

			// Use a ResultSet to extract the Primary Key from the User Object that was
			// persisted
			ResultSet rs; // import from JDBC API java.sql - ResultSet allows us to iterate over returned
							// data

			if ((rs = stmt.executeQuery()) != null) {

				// if we return data, we can iterate over it with a cursor
				rs.next();

				// we need to capture the first column of data returned (which is the ID of the
				// returned User object)
				int id = rs.getInt(1); // get the Integer of column #1.

				// log if it was successful
				logger.info("returned User with id #" + id);

				return id;
			}

		} catch (SQLException e) {
			logger.error("Unable to insert User - SQL exception thrown");
			e.printStackTrace();
		}

		// return - 1 if unsuccessful, other return the PK of the persisted User object
		// Our DB can't produce a negative, so this indicates that something went wrong
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
	public List<User> findAll() { // return both user info AND account info associated with the user

		// empty list to store User objects
		List<User> allUsers = new LinkedList<User>();
		
		// try / catch with the connection
		try (Connection conn = ConnectionUtil.getConnection()) {

			// create statment
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT users.id, users.username, users.pwd, users.user_role, accounts.id AS account_id, accounts.balance, \r\n" + 
					"accounts.active \r\n" + 
					"	FROM users\r\n" + 
					"	LEFT JOIN users_accounts_jt ON users.id = users_accounts_jt.acc_owner\r\n" + 
					"	LEFT JOIN accounts ON accounts.id = users_accounts_jt.account";
			
			// grab user data from each row
			ResultSet rs = stmt.executeQuery(sql);
			
			// iterate through the table of data returned
			while (rs.next())  {
				
				// grab id, username, password, role,
				
				// create accont obj
				
				// id, balance, isActive
				
				
			}
			
			
			
			// grab account data
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		
		
		return null;
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
