package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection conn = null;
	
	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {
		try {
			if(conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		Properties props = new Properties();		
		
		try {
			props.load(new FileReader("src\\main\\resources\\application.properties"));
			
			String url = props.getProperty("url");;
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("You established a connection!");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot establish a connection.");
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("Properties file could not be found.");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println("An error occured while reading the file.");
			e.printStackTrace();
			return null;
		}
	}
	
}
