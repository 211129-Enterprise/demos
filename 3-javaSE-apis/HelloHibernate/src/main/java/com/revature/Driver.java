package com.revature;

import com.revature.dao.CrimeDAO;
import com.revature.models.Crime;

public class Driver {
	
	static CrimeDAO cdao = new CrimeDAO();

	public static void main(String[] args) {
		System.out.println("Running our Hibernate Demo ");
		
		Crime c1 = new Crime("Freeze", "covering the city in ice");
		Crime c2 = new Crime("Time Manipulation", "freezing time, robbin' banks");
		
		// as of now make sure you're only mapping the Crime model, not the others because we haven't created them
		cdao.insert(c1);
		cdao.insert(c2);

	}

}
