package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Flight;
import com.revature.util.HibernateUtil;

public class FlightDAO {
	
	public int insert(Flight flight) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		 int pk = (int) ses.save(flight);
		
		tx.commit();
		
		return pk;
	}

}
