package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.revature.util.ConnectionPool;

/**
 * To understand what's going on in this demo, go here:
 * 
 * https://mobisoftinfotech.com/resources/blog/understanding-db-connection-pools-essential-knowledge-for-web-developers/
 */


// if you want o get really ahead start looking into what hibernate is -> Spring Data
// Hibernate uses Hikari...Hikari is like Apache Commons DBCP, which is a Connection Pooling library

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		
		ResultSet rs = null;
		Connection connObj = null;
		PreparedStatement pstmtObj = null;
		ConnectionPool jdbcObj = new ConnectionPool();
		
		
		// surround ebverything ins atry/catch
		try {
			
			DataSource dataSource = jdbcObj.setUpPool();
			
			// this is intializing the pool and setting it up with the amount of connections we specified
			
			
			jdbcObj.printDbStatus();
			
			// get the connection (from the pool)
			System.out.println("==============Making a new connection Object for a DB operation!===========");
			connObj = dataSource.getConnection();
			
			// print the dbStatus()
			jdbcObj.printDbStatus();
			
			// use the fetched connection to execute a query (like select * from heroes)
			pstmtObj = connObj.prepareStatement("SELECT * FROM heroes");
			
			rs = pstmtObj.executeQuery();
			// iterate over the result set returned
			while(rs.next()) {
				System.out.println("Hero name is " + rs.getString("hero_name"));
			}
			
			jdbcObj.printDbStatus();
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			System.out.println("\n================REALEASING THE DB CONNECTION OBJECT BACK TO THE POOL");
			connObj.close(); // close the specific connection so it can be sent back to the pool
			// this sends the connection to an IDLE state....it can be used again
		}
		
		jdbcObj.printDbStatus();

	}

}
