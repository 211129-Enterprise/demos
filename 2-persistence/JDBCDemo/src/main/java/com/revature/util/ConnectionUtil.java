package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * JDBC (Java Database Connectivity) - it is an API included in the JRE
 * in the form of the java.sql package that is used to manage a connection
 * to a database along with querying the database, and performing CRUD operations.
 *
 */

public class ConnectionUtil {
	
	private static Connection conn = null;
	/**
	 * Singleton class allows only ONE instance of this class
	 * to exist at a time.
	 * 
	 * You cannot instantiate this calss like other classes.
	 * 
	 * In order to detch the instance (in this case the instance will represent a CONNECTION)
	 * you need to call the getInstance() method...getConnection().
	 */
	
	// the constructor is private to preventmultiple instantiations of the class
	private ConnectionUtil() {
		super();
	}
	
	/*
	 * The following method is designed to return the ONE instance of this
	 * class if it exists, or instantite it if it doesn't
	 */
	public static Connection getConnection() {
		
		// check if there is an instance
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=sophiag";
		String username = "postgres";
		String password = "postgres";
		
		// this is the NOT secure method!!
		try {
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("You established a connection!!!");
		} catch (SQLException e) {
			System.out.println("Cannot establish DB connection");
			e.printStackTrace();
		}
		
		return conn; // if not successful, this will be null, and we'll see the error message
	}

}
