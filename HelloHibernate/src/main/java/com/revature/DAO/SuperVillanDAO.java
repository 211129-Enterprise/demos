package com.revature.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

/*
 * 3 diffrent ways to write complex queries 
 * 
 * HQL Hibernate Query Language 
 * 
 * Critiria API
 * 
 * NATIVE SQL
 * 
 * 
 */

public class SuperVillanDAO {

	
	public int insert(SuperVillain joker) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(joker);
		
		tx.commit();
		
		return pk;
	}
	
	public List<SuperVillain> selectAll(){
		
		Session ses = HibernateUtil.getSession();
		
		/*
		 * HPQ 
		 * 
		 */
		
		 List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class ).list();
		 
		 return villList;
		
	}
	
	public SuperVillain selectByName(String name) {
		Session ses = HibernateUtil.getSession();
		/*
		 * Using Native SQL
		 */
		
//		SuperVillan vill = ses.createNamedQuery("SELECT * FROM super_villains where sbill_name "+ name + " " + SuperVillain.class);
		
		/*
		 * Criteria API  
		 * 
		 * SuperVillain vill = ses.createCriteria(SuperVillain).add(Restrictions.like("svill_name", name));
		 */
		
		
		
		/*
		 * HQL
		 * 
		 */
		SuperVillain vill = (SuperVillain) ses.createQuery("from SuperVillain where name = ''" + name + "''", SuperVillain.class);
		
		
		return vill;
	}
	
	
	public void update(SuperVillain vill) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(vill);
		
		tx.commit();
		
		
	}
	
	
	
}
