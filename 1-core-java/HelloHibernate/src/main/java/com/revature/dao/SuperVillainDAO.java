package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

//Three different ways to write complex queries 

//HQL - Hibernate Query Language
//Criteria API
//Native SQL

public class SuperVillainDAO {
	public int insert(SuperVillain svill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(svill);
		
		tx.commit();
		return pk;
	}
	
	// select all 
	public List<SuperVillain> selectAll() {
		//HQL - Hibernate Query Language
		Session ses = HibernateUtil.getSession();
		
		/*
		 * HQL Hibernate Query Language
		 * Combo of SQL and OOP
		 * 
		 */
		
		List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		
		return villList;
	}
	
	public SuperVillain selectByName(String name) {
		Session ses = HibernateUtil.getSession();
//		NATIVE SQL Querying
//		SuperVillain vill = ses.createNativeQuery("SELECT * FROM super_villains WHERE svill_name = " + name ' + supervillain.class")
		// Criteria API
		SuperVillain vill = (SuperVillain) ses.createCriteria(SuperVillain.class).add(Restrictions.like("svill_name", name));
		return vill;
		
//		SuperVillain vill = ses.createQuery("from SuperVillain where name = ")
	}
	
	public void update(SuperVillain vill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(vill);
		
		tx.commit();
	}
}
