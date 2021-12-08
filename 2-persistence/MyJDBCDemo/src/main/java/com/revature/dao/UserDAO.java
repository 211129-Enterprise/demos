package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/**
 * This class will be instantiated in the Service layer to perform all DB
 * operations regarding User objects
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
		Connection conn = ConnectionUtil.getConnection();// Connection Interface comes from JDBC API

		// Step 2. Generate a SQL statement like INSERT INTO users (username, pwd, role)
		// Values (?,?,?)...
		String sql = "INSERT INTO users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING users.id";
		// We will provide a value for the ? marks in the statement
		try {
			// Step 2b. Use a prepared Statement to avoid SQL injection
			PreparedStatement stmt = conn.prepareStatement(sql);

			// complex process to set the values we're inserting into the DB = to the pops
			// of the User object
			stmt.setString(1, u.getUsername());// The first argument (1) points to which number of ? marks in the
												// prepared statement statement
			stmt.setString(2, u.getPassword());

			// We will have to transpose a java enum type to a RDBMS enum type
			stmt.setObject(3, u.getRole(), Types.OTHER);

			// Use a ResultSet to extract the Primary Key from the User Object that was
			// Persisted
			ResultSet rs;// import from JDBC API java.sql - ResultSet allows us to iterate over returned
							// data

			if ((rs = stmt.executeQuery()) != null) {

				// if we return data, we can iterate over it with a cursor
				rs.next();

				// We need to capture the first column of data returned (which is the ID of the
				// returned User object)
				int id = rs.getInt(1); // get the Integer of column #1.

				// Log if it was successful
				logger.info("returned User with id #" + id);

				return id;

			}

		} catch (SQLException e) {
			logger.error("Unable to insert User - SQL exception thrown");
			e.printStackTrace();

		}

		// return -1 if unsuccessful, otherwise return the PK of the persisted User object
		// Our DB can't produce a negative, so this indicated that something went wrong

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
	public List<User> findAll() {
		// TODO Auto-generated method stub
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
