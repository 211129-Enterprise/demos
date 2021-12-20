package com.revature.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperPrison;
import com.revature.util.HibernateUtil;

public class SuperPrisonDAO {
	
	public int insert(SuperPrison arkham) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(arkham);
		
		tx.commit();
		
		return pk;
		
	}
	
	
	public SuperPrison selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		// we are invoking a simple query to return an object of type superPrison
		SuperPrison sp = ses.get(SuperPrison.class, id);
		
		return sp;
		
	}
	
	
	
}
