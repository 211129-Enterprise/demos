package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Account;
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
