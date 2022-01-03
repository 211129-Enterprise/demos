package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	/**
	 * The purpose of the HibernateUtil.java Helper file 
	 * is to handle startup (Or connection) and access Hibernate's
	 * SessionFactory interface to obtain a session object.
	 */
	
	private static Session ses;
	
	private static SessionFactory sf = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
	
	public static Session getSession() {
		if (ses == null) {
			ses = sf.openSession();
		}
		return ses;
	}
	
	public static void closeSes() {
		ses.close();
	}
			
		
}
