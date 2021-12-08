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
 * This Class be instantiated in the Service layer to perform all DB operations
 * regarding user objects
 * 
 * this class will incorporate all persistence logic.
 * 
 */

public class UserDAO implements IUserDAO {

	private static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public int insert(User u) {
		// Step 1. Capture a DB connection by calling ConnectionUtil getConnection()
		// method.
		Connection conn = ConnectionUtil.getConnection(); // COnnection Interface comes from JDBC API

		// Step 2. Generate a SQL Statement like INSERT INTO users (username, pwd, role)
		// VALUES (?, ? ,?)...
		String sql = "INSERT INTO kennyp.users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING users.id";
		// we will provide a value for the ? marks in the statement

		// Step 2b. Use a prepared Statement to do this to avoid SQL injection
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			// complex process to set the values we're inserting into the DB = to the pops
			// of the User Object
			stmt.setString(1, u.getUsername()); // first argument (1) points to which number of ? marks in the prepared
												// statement
			stmt.setString(2, u.getPwd());

			// we will have to transpose a java enum type to a RDBMS enum type
			stmt.setObject(3, u.getRole(), Types.OTHER);
			// Use a ResultSet to extract the Primary key from the User Object that was
			// persisted
			ResultSet rs; // import form JDBC API java.sql

			if ((rs = stmt.executeQuery()) != null) {

				// if we return data, we can iterate over it with a cursor
				rs.next();

				// we need to capture the first column of data returned (which is the id of the
				// returned User object)
				int id = rs.getInt(1); // get the Integer of column 1.

				// log if it was successful
				logger.info("returned User id #" + id);

				return id;

			}

		} catch (SQLException e) {
			logger.error("Unable to insert User - SQL exception thrown");
			e.printStackTrace();
		}

		// return -1 if unsuccessful, other return the PK of the persisted User Object
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
	public boolean delete(User u) {
		// TODO Auto-generated method stub
		return false;
	}
}
