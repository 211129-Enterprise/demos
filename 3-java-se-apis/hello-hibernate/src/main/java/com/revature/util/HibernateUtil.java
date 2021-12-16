package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/*
	 * The purpose of the HibernateUtil.java helper file
	 * is to handle startup, DB Connection, and access
	 * Hibernate's SessionFactory interface to obtain a
	 * Session Object.
	 */
	
	private static Session ses; // This is like the Connection Interface from JDBC
	
	
	/*
	 * We will use SessionFactory interface to create a configuration object which
	 * will call the .configure method to establish the connection to the DB based
	 * on the creds we supplied in that file.
	 */
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	public static Session getSession() { //Similar to getConnection()
		if(ses == null) {
			ses = sf.openSession();
		}
		
		return ses;
	}
	
	//This method will close an active session
	public static void closeSes() {
		// When we close a session, it frees up that connection
		// to the database and returns it to the connection pool
		// so that it can be used by another thread / operation.
		ses.close();
	}
}
