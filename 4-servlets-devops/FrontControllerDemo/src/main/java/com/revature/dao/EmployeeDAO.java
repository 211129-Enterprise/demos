package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDAO {

	public int insert(Employee e) {
		
		// Grab the session object
		Session ses = HibernateUtil.getSession(); // Session in the context of JDBC connection
		
		// begin a tx
		Transaction tx = ses.beginTransaction(); // import Transaction from Hibernate, NOT the JPA
		
		// capture the pk returned from save()
		int pk = (int) ses.save(e);
		
		// commit the tx
		tx.commit();
		
		// return the pk
		return pk;
	}
	
	public List<Employee> findAll(){
		
		// grab the session
		Session ses = HibernateUtil.getSession();
		
		// make a HQL statement to return all records from the Employee table - mix of SQL & OOP
		List<Employee> emps = ses.createQuery("from Employee", Employee.class).list();
		
		// there's also Criteria API & Native SQL are other ways to write complex queries
		
		// return that list
		return emps;
	}
	
	public boolean update(Employee e) {
		return false;
	}
	
	public boolean delete(Employee e) {
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
