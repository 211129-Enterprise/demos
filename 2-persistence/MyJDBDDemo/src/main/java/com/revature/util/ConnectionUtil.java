package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;



/*A singleton class may only have one instance exist at any one time
 * 
 * You canot instatiate this class like other classes
 * 
 * In order to fetch the instance (in this case a connection) you will need to call the getInstance() method... getConnection()
 * */

public class ConnectionUtil {
	private static Connection conn = null;
	
	private ConnectionUtil() {//The constructor is private to precent multiple instantiations of the class
		
		
	}
	
	public static Connection getConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		//This class is instantiated to read from a properties file
		Properties prop = new Properties(); //import from java.util
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			prop.load(new FileReader("C:\\Users\\haugh\\Documents\\Work\\Revature\\Project\\demos\\1-core-java\\MyJDBDDemo\\src\\main\\resources\\application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("user");
			password = prop.getProperty("password");
			
			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Established connection!");
		} catch (SQLException e) {
			//TODO logger.error("Failed to establish db connection");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
		
	}
}
