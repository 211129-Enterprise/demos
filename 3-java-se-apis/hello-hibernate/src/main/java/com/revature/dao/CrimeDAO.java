package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDAO {

	public int insert(Crime crime) {
		
		// Capture a session
		Session ses = HibernateUtil.getSession();
		
		// Transaction is uniquely from HIBERNATE
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(crime); // The save() method returns the Primary Key
		
		tx.commit();
		
		return pk; // We return the generated Primary Key that the DB provides for us
	}
}
