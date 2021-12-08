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
 *JDBC (Java Database Connectivity) - it is an API included in the JRE
 *in the form of the java.sql package that is used to manage a connection
 *to a database along with querying the database, and performing CRUD operations
 *
 */

public class ConnectionUtil {
	
	//instantiate a logger for this class and bind it at the static level (class scope)
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);//import from org.apache.log4j
	private static Connection conn = null;
	/**
	 * Singlton class allows only ONE instance of this class to exist at a time
	 * 
	 * YTou cannot instantiate this class like other classes
	 * 
	 * In order to detch the instance (in this case the instance will represent a CONNECTION)
	 * you need to call getINstance() method...getConnection().
	 */
	
	//The constructor is private to prevent multiple instantiations of the class
	private ConnectionUtil() {
		super();
	}
	/**
	 * THe following method is designed to return the ONE instance of this
	 * class if it exists, or instantiate it if it doesn't 
	 */
	public static Connection getConnection() {//This is similar to getInstance()
		
		//check if there is an instance
		try {
			if (conn!= null && !conn.isClosed()) {	
				logger.info("returned re-used connection object");
				return conn;
			}
		} catch (SQLException e) {
			logger.error("We failed to reuse a connection");
			e.printStackTrace();
			return null;
		}
		
		//This class is instantiated to read from a properties file
		Properties prop = new Properties();//imported from java.util
		
		String url = "";
		String username = "";
		String password = "";
		
		
		//This is the NOT secure method!!
		try {
			
			//I right clicked on the application.properties > went to properties then copy/pasted the exact location of the file
			prop.load(new FileReader("C:\\Users\\peckj\\OneDrive\\Desktop\\demos\\2-persistence\\MyJDBCDemo\\src\\main\\resources\\application.properties"));
			
			url = prop.getProperty("url"); //This is retrieving the value of the 'url' key in the application.properties file
			username = prop.getProperty("username");
			password = prop.getProperty("password");//You can create an environment variable instead of setting it up like this
			
			/**
			 * When the getConnection() method is called, the DriverManager (class from the JDBC API -java.squl)
			 * Will attempt to locate a suitable driver amongst those loaded initialization
			 */
			
			conn = DriverManager.getConnection(url, username, password);
			
			logger.info("Database Connection Established");
			
		} catch (SQLException e) {
			logger.error("SQL exception thrown - Cannot establish DB connectionn");
	//		e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.error("Cannot locate application.properties file");
	//		e.printStackTrace();
		} catch (IOException e) {
			logger.error("Something wrong with app.props file");
		//	e.printStackTrace();
		}
		
		return conn;//if not successful, this will be null, and we'll see the error message
		
	}
}
