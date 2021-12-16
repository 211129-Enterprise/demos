package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperPrison;
import com.revature.models.SuperVillian;
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
		
		// We don't need a transaction since we're just querying data from the DB
		Session ses = HibernateUtil.getSession();
		
		// Session method - we are invoking a simple query to return an object of 
		// type SuperPrison with the PK that was specified from them SuperPrison table.'
		SuperPrison sp = ses.get(SuperPrison.class, id);
		
		return sp;
	}
	
	
	
	
	
	public List<SuperPrison> selectAll(){
		
		Session ses = HibernateUtil.getSession();

		List<SuperPrison> spList = ses.createQuery("from SuperPrison", SuperPrison.class).list();
		
		return spList;
	}
	
	
}
