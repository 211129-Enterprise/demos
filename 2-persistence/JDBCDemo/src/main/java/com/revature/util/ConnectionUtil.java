package com.revature.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// JDBC (Java Database Connectivity) API
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	// singleton - cannot instantiate
	
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	private static Connection conn = null;
	
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		Properties prop = new Properties();
		
		String url = "";
		String username = "";
		String password = "";
		try {
			// try this if it doesn't work C:\Users\somer\projects\demos\2-persistence\JDBCDemo\src\main\resources\application.properties
//			prop.load(new FileReader("C:\\Users\\somer\\projects\\demos\\2-persistence\\JDBCDemo\\src\\main\\resources\\application.properties"));
//			
//			url = prop.getProperty("url");
//			username = prop.getProperty("username");
//			password = prop.getProperty("password");
//			try {
//				Class.forName("org.postgresql.Driver");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			Driver driver = DriverManager.getDriver("org.postgresql.Driver");
//			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=somersm", "postgres", "postgres");
			
			logger.info("Database Connection Established");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("we failed to re-use a connection");
			e.printStackTrace();
			return null;
//		} catch (FileNotFoundException e) {
//			System.out.println("cannot locate properties file");
//			// TODO Auto-generated catch block
//			logger.error("Cannot locate application.properties");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("something wrong with app.props");
//			logger.error("Something wrong with app.props file");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return conn;
	}
}
