package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/*
	 * the pupose of the hibernate 
	 * 
	 * is to handle startup (db) annd access hiberante's
	 * 
	 * 
	 * 
	 */
	
	private static Session ses; // this is like the connection interface from JDBC
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	
	public static Session getSession() { //similar to getConnection();
	
		if(ses == null) {
			ses = sf.openSession();
		}
		return ses;
	}
	
	
	// this method will close an active session
	public static void  closeSes() {
		
		/*
		 * when we close a session
		 * 
		 * 
		 */
		
		
		ses.close();
	}
	
	
	
	
	
}
