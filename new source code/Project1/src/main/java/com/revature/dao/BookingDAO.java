package com.revature.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Booking;
import com.revature.util.HibernateUtil;

public class BookingDAO {
	
	public int insert(Booking book) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(book);
		
		tx.commit();
		
		return pk;
	}
	
	public Booking selectByID(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Booking book = ses.get(Booking.class, id);
		
		return book;
	}
	
}
