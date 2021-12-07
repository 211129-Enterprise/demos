package com.revature.util;
// JDBC (Java Database Connectivity) API
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		
		String url = "jbdc:postgresql://localhost:5432/postgres?currentSchema=somersm";
		
		try {
			conn = DriverManager.getConnection(url, "postgres", "postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
