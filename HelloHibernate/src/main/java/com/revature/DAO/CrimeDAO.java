package com.revature.DAO;

import org.hibernate.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDAO {
	
	public int insert(Crime crime) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
	int pk = 	(int) ses.save(crime);
	tx.commit();
		
		
		return pk;
	}

}
