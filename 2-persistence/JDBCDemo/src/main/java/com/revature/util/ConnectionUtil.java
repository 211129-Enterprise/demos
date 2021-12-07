package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * What is JDBC?
 * 
 * JDBC (Java Database Connectivity) is the Java API that manages 
 * connecting to a database, issuing queries and commands, 
 * and handling result sets obtained from the database
 * 
 * Singleton Class is a software design pattern that ensures there will be one
 * single instance of that class.
 * 
 * -- private constructors 
 * -- static field of an instance of the class to be returned 
 * -- leverage a public static getInstance() (our getInstance method is the getConnection() method
 * 
 * The connection to our DB will be established by a singleton class which will
 * contain all the necessary driver information (jdbc url, username, password).
 */

public class ConnectionUtil {
	
	private static Connection conn = null;
	
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
		
		
		String url = "jdbc:postgresql://enterprise211129.cvtq9j4axrge.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=sophiag";
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
