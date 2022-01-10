package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDAO {
	
public int insert(Customer cus) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(cus);
		
		tx.commit();
		return pk;
		
	}
	
	public List<Customer> selectAll() {
		
		Session ses = HibernateUtil.getSession();
		
		List<Customer> bookingList = ses.createQuery("from Booking", Customer.class).list();
		
		return bookingList;
	}

	
	
	public Customer selectByDate(String bookingdate) {
		
		Session ses = HibernateUtil.getSession();
		
		Customer cus = (Customer) ses.createQuery("from Booking where bookingdate = '" +bookingdate+ "'", Customer.class);
		
		return cus;
	}
	
	
	public void update(Customer cus) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(cus);
		tx.commit();
		
	}
		
	
	
	
	
	
	
	

}
