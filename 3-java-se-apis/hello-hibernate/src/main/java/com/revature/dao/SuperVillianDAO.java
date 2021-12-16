package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.SuperVillian;
import com.revature.util.HibernateUtil;


/*
 * THREE DIFFERENT WAYS TO WRITE QUERIES IN HIBERNATE
 * 	- HQL | Hibernate Query Language
 * 	- Criteria Api
 * 	- Native SQL
 */

public class SuperVillianDAO {
	
	public int insert(SuperVillian svill) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		
		int pk = (int) ses.save(svill);
		
		
		tx.commit();
		return pk; // Return the auto-generated PK
	}
	
	
	
	// Select all
	public List<SuperVillian> selectAll(){
		
		// HQL - Hibernate Query Language
		Session ses = HibernateUtil.getSession();
		
		/*
		 * HQL - Hibernate Query Language
		 * Think of it like a combination of SQL and OOP
		 */
		List<SuperVillian> villList = ses.createQuery("from SuperVillian", SuperVillian.class).list();
		// HQL will return instances of the SuperVillian.java class
		
		return villList;
	}
	
	
	public SuperVillian selectByName(String name) {
		
		Session ses = HibernateUtil.getSession();
		
		// Native SQL Querying
		//SuperVillian vill = (SuperVillian) ses.createNativeQuery("SELECT * FROM super_villians WHERE svill_name = '" + name + "'", SuperVillian.class);
		
		
		// Criteria API
		//SuperVillian vill = (SuperVillian) ses.createCriteria(SuperVillian.class).add(Restrictions.like("svill_name", name));
		
		
		// HQL (Hibernate Query Language)
		SuperVillian vill = (SuperVillian) ses.createQuery("from SuperVillian where name = '" + name + "'", SuperVillian.class );
		
		return vill;
	}
	
	
	public void updte(SuperVillian vill) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(vill);
		
		tx.commit();
	}

}
