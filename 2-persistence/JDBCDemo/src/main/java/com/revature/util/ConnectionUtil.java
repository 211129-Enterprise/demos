package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
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
		
		// this class is instantiated to read from a properties file 
		Properties prop = new Properties(); // imported from java.util
		
		String url = "";
		String username = "";
		String password = "";
		
		// this is the NOT secure method!!
		try {
			
			// I right clicked on the application.properties > went to properties than copy/pasted the exact location of the file
			prop.load(new FileReader("C:\\Users\\SophieGavrila\\Desktop\\demos\\2-persistence\\JDBCDemo\\src\\main\\resources\\application.properties"));
			
			url = prop.getProperty("url"); // this is retrieving the value of the "url" key in application.properties file
			username =  prop.getProperty("username");
			password = prop.getProperty("password");
			
			/**
			 * When the getConnection() method is called, the DriverManager (class from the JDBC API - java.sql) 
			 * will attempt to locate a suitable driver amongst those loaded initialization.
			 */
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("You established a connection!!!");
		} catch (SQLException e) {
			System.out.println("Cannot establish DB connection");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot locate application.properties file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Something wrong with app.props file");
			e.printStackTrace();
		}
		
		return conn; // if not successful, this will be null, and we'll see the error message
	}

}
