package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

public class ConnectionUtil {
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);

	private static String JDBC_DRIVER = "org.postgresql.Driver";
	private static String JDBC_DB_URL = "";
	private static String JDBC_USER = "";
	private static String JDBC_PASS = "";
	private static Properties prop = new Properties(); // imported from java.util
	static {
		try {

			prop.load(new FileReader("src\\main\\resources\\application.properties"));
			JDBC_DB_URL = prop.getProperty("url");
			JDBC_USER = prop.getProperty("username");
			JDBC_PASS = prop.getProperty("password");
			System.out.println("Connection Established!!!!");
		} catch (FileNotFoundException e) {
			logger.error("Cannot locate application.properties file");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Something wrong with app.props file");
			e.printStackTrace();
		}
	}

	private static GenericObjectPool gPool = null;

	public DataSource setUpPool() throws Exception {

		Class.forName(JDBC_DRIVER);

		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);

		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);

		@SuppressWarnings("unused")
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);

		return new PoolingDataSource(gPool);
	}

	public static GenericObjectPool getConnectionPool() {
		return gPool;
	}

	public void printDbStatus() {

		System.out.println("Max: " + getConnectionPool().getMaxActive() + "; Active: "
				+ getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	}

}