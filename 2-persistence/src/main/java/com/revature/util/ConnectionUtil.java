package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	
	// Instantiate a logger for this class and bind it at the static level (class scope)
	private static Logger logger = Logger.getLogger(ConnectionUtil.class); //import org.apache.log4j.Logger;
	
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
	public static Connection getConnection() { //Similar to getInstance()
		
		// Check if there is an instance
		try {
			if(conn != null && !conn.isClosed()) {
				logger.info("Returned re-used connection object");
				return conn;
			}
		} catch (SQLException e) {
			logger.error("We failed to re-use a connection");
			e.printStackTrace();
			return null;
		}

		
//
//		//This is the NOT SAFE FOR WORK method:		
//		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=dbname", //JDBC url format
//				username = "postgres",
//				password = "postgres";
//		
		
		
		//This class is instantiated to read from a properties file
		Properties prop = new Properties(); // Imported from java.util
		
		try {
			prop.load(new FileReader(""));
			
			String url = prop.getProperty("url"),
					username = prop.getProperty("username"),
					password = prop.getProperty("password");
			
			
			// When the getConnection() method is called, the DriverManager — class from the JDBC API, java.sql
			// — will attempt to locate a suitable driver amongst those loaded during initialization.
			conn = DriverManager.getConnection(url, username, password);
			
			logger.info("Connection attempt successful!");
			
		} catch (SQLException e) {
			logger.error("Connection attempt failed!");
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			logger.error("Cannot locate application.properties file!");
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			logger.error("Issue with application.properties file!");
			e.printStackTrace();
		}
		
		return conn; //If not successful, this will be null and we'll see the error message.
	}
	
}
