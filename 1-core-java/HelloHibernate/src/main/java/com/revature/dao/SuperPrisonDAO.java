package com.revature.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperPrison;
import com.revature.util.HibernateUtil;

public class SuperPrisonDAO {
	public int insert(SuperPrison sp) {
		Session ses = HibernateUtil.getSession();
				
	    Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(sp);
		
		tx.commit();
		
		return pk;
	}
	
	public SuperPrison selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		SuperPrison sp = ses.get(SuperPrison.class, id);
		
		return sp;
	}
}
