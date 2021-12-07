package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection conn = null;
	/*
	 * Singleton Class - allows only ONE instance of this class to exist at a time
	 * 
	 * You cannot instantiate this class like other classes.
	 * 
	 * In order to dettatch the instance, in this case the instance will represent a
	 * CONNECTION, you need to call the getInstance() method... getConnection().
	 */
	
	//The constructor is private to prevent multiple instantiations of the class
	private ConnectionUtil() {
		super();
	}
	
	
	/*
	 * The following method is designed to return the ONE instance
	 * of this class if it exists or instantiate it if it doesn't.
	 */
	public static Connection getConnection() {
		
		// Check if there is an instance
		try {
			if(conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=dbname", //JDBC url format
				username = "postgres",
				password = "postgres";
		
		//This is the NOT SAFE FOR WORK method!!
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection attempt successful!");
			
		} catch (SQLException e) {
			System.out.println("Connection attempt failed!");
			e.printStackTrace();
		}
		
		return conn; //If not successful, this will be null and we'll see the error message.
	}
	
}
