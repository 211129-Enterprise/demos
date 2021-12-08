package com.revature.utilt;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
/*
 * JDVX (JAVA Database connectivity) it is an api 
 * 
 * 
 */
import java.sql.SQLException;
import java.util.Properties;

import javax.print.attribute.standard.JobOriginatingUserName;

import org.apache.log4j.Logger;




public class ConnectionUtil {


	
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	private static   Connection conn = null;
	
	/*
	 * singleton class ==> exists only one time
	 * 
	 * In order to fetch the instance we need to call getInstance ..
	 * 
	 * 
	 * 
	 */
	
	
	// to prevent multiple instations of the class
	private  ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {
		// check if an instance existe 
		try {
		if(conn != null && !conn.isClosed()) {
			
		}
		}catch (SQLException e) {
			
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		
//		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=marouane";
		
		
		/*
		 * my local url 
		 * 	String url = "jdbc:postgresql://localhost:5433/postgres?currentSchema=public"
		 */
		
		Properties prop = new Properties();
		
		String url="";
		String username="";
		String passwrod = "";
		

		
		try {
			
			// enter the full location ;
			
			prop.load(new FileReader("../MyJDBC.Demo\\src\\main\\resources\\application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			passwrod= prop.getProperty("password");
			
			
			Connection conn = DriverManager.getConnection(url, username, passwrod );
			logger.info("Data base Connection establish");
			return conn ;
			
			
		} catch (SQLException | IOException e) {
			
			// TODO: handle exception   
			logger.error("Cannot establish connection");
			System.out.println("Cannit establish db connection");
			e.printStackTrace();
		}
		
		return conn;
	
		
	}
}
