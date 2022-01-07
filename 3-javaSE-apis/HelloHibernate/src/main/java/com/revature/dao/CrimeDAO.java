package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDAO {
	
	public int insert(Crime crime) {
		
		// capture a session
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(crime); // the save() method returns the Primary Key
		
		tx.commit();
		
		return pk; // we return the generated primary key
	}
	
}
