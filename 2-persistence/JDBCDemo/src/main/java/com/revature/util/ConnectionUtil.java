package com.revature.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// JDBC (Java Database Connectivity) API
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	// singleton - cannot instantiate
	
	private static Connection conn = null;
	
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				
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
			prop.load(new FileReader("C:\\Users\\somer\\projects\\demos\\2-persistence\\JDBCDemo\\src\\main\\resources\\application.properties"));
			
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("cannot locate properties file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("something wrong with app.props");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
