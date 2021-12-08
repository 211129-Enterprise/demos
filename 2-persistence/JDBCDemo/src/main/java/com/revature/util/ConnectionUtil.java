package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.revature.LoggingDemo;
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
	
	
	private static Logger logger = Logger.getLogger(LoggingDemo.class);
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
				logger.error("returned to re-use a connection");
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			logger.error("we failed to re-use a connection");
			e.printStackTrace();
			return null;
		}
		
		Properties prop = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		
		// this is the NOT secure method!!
		try {
			
			prop.load(new FileReader("/Users/christianmakoma/Revature/demos/2-persistence/JDBCDemo/src/main/resources/application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			
			conn = DriverManager.getConnection(url, username, password);
			
			logger.info("Database established a connection!!!");
			
		} catch (SQLException e) {
			logger.info("SQL Exception thrown - Cannot establish DB connection");
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.info("Cannot locate application.properties");
			
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("Something went wrong with app.props file");
			e.printStackTrace();
		}
		
		return conn; // if not successful, this will be null, and we'll see the error message
	}

}
