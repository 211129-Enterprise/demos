package com.revature.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

/**
 * COnnection Pooling means that connections are REUSED rather than created
 * each time a connection is requested.
 * 
 * In order to facilitate connection reuse, a memory cache of database connections
 * called a CONNECTION POOL, is maintained by a connection pooling module 
 * as a layer on top of any standard JDBC driver product.
 * 
 *
 */


// think about this as our ConnectionUtil.java...but on steroids.....
// we need to use a special library that gives the ability to create a POOL of connections, so that we can 
// perform multiple operations on the database at once 
public class ConnectionPool {
	
	/**
	 * We will use this class to supply general database vredentials and attain 
	 * an object called GenericObjectPool
	 * 
	 * gPool is a special object that holds all the connections to our databse at once
	 * 
	 * Having a connection pool drastically increases performance whenever  we perform a CRUD operation
	 * on the Database 
	 */
	
	// if you were doing this in your own project, or in a REAL application, use the applications.properties file
	// and the Properties object in Java which you use to READ from that file and supply the credentials
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String JDBC_DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	static final String JDBC_USER = "postgres";
	static final String JDBC_PASS = "postgres";
	
	// REMEMBER you typically add the above ^ properties to an application.properties file which you .gitgnore!!!!
	
	
	private static GenericObjectPool gPool = null;
	
	// Apache Cmmons dbcp gives us the functionality to create a connection pool.  But we have to do so
	// by using its specific class and functionality called GenericObjectPool.
	
	public DataSource setUpPool () throws Exception {
	// We use the DataSource Interface to create a connection object that participates in Connection Pooling
		
		Class.forName(JDBC_DRIVER);
		
		// create an instnace of the GenericObjectPOol that holds our Pool of connection objects
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);
		
		// Create a connectionFacotry object which will be used by the pool object to creats the connections (which are all objects)
		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
		

		// Create a PoolableConnectionFactory that will wrap around the Connection
		// Object created by the above connectionFactory
		// in order to add pooling functionality.
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		
		return new PoolingDataSource(gPool);
	}
	
	
	public GenericObjectPool getConnectionPool() {
		return gPool;
	}
	
	// for our own benefitlet's create a method to print the connection pool status
	public void printDbStatus() {
		
		System.out.println("Max: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() +
				"; Idle: " + getConnectionPool().getNumIdle());
	}
	
	
	
	
	
	

}
