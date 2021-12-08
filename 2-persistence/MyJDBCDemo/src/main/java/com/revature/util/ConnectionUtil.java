package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 
 * JDBC (Java Database Connectivity) - it is an API included in the JRE
 * in the form of the java.sql package that is used to manage a connection
 * to a database along with querying the database, and performing CRUD operations.
 * 
 */


public class ConnectionUtil {
	// instantiate a Logger for this Class and bind it at the static level (Class scope)
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	private static Connection conn = null;
	
	/**
	 * Singleton class allows only ONE instance of this class
	 * to exist at a time.
	 * 
	 * You cannot instantiate this class like other classes.
	 * 
	 * In order to fetch the instance (in this case the instance represents a connection)
	 * you need to call the getInstance() method...getConnection().
	 */
	
	// the constructor is private to prevent multiple instantiation of the Class.
	private ConnectionUtil() {
		super();
	}
	
	/*
	 * The following method is designed to return the ONE instance of this
	 * Class if it exists, or instantiate it if it doesn't.
	 */
	
	public static Connection getConnection() {
		
		// check if there is an instance
		try {
			if (conn != null && !conn.isClosed()) {
				logger.info("Returned reused connection object");
				return conn;
			}
		} catch (SQLException e) {
			logger.error("Failed to reuse a connection");
			e.printStackTrace();
			return null;
		}
		
		// this class is instantiated to read from a properties file
		Properties prop = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		// this is the NOT secure method!!
		try {
			prop.load(new FileReader("C:\\Users\\kphu\\Desktop\\projects\\demos\\2-persistence\\MyJDBCDemo\\src\\main\\resources\\application.properties"));
			
			url = prop.getProperty("url"); // this is retrieving the value of the "url" key in application.properties file
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			/**
			 * When the getConnection() method is called, the DriverManager (class from the JDBC API - java.sql)
			 * will attempt to locate a suitable driver amongst those loaded at initialization.
			 */
			
			conn = DriverManager.getConnection(url, username, password);
			logger.info("Database Connection Established");

		} catch (SQLException e) {
			logger.error("SQL Exception thrown - Cannot establish DB connection");
//			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			logger.error("Cannot locate application.properties file");
//			e.printStackTrace();
		} catch (IOException e) {
			logger.error("There's something wrong with application.properties file");
//			e.printStackTrace();
		}
		return conn;
	}
}
