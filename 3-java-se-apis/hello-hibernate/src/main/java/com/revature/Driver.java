package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDAO;
import com.revature.dao.SuperPrisonDAO;
import com.revature.dao.SuperVillianDAO;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillian;

public class Driver {

	static CrimeDAO cdao = new CrimeDAO();
	
	public static void main(String[] args) {
		System.out.println("Running our Hibernate Demo...");
		
		Crime c1 = new Crime("Freeze", "Blue screen of death for city");
		Crime c2 = new Crime("Time Manipulation", "Freexing time, brobbin' bahnks");
		Crime c3 = new Crime("Arson", "Making that city lit, son!");
		
		cdao.insert(c1);
		cdao.insert(c2);
		cdao.insert(c3);

		List<Crime> crimes = new ArrayList<Crime>();
		crimes.add(c1);
		crimes.add(c3);
		
		SuperPrison arkham = new SuperPrison("Arkham Asylum", "Gotham City");
		
		SuperVillian joker = new SuperVillian("Mr. The Joker", "Evilness", 1_000.00, crimes, arkham);
		
		SuperPrisonDAO spdao = new SuperPrisonDAO();
		spdao.insert(arkham);
		
		SuperVillianDAO svdao = new SuperVillianDAO();
		svdao.insert(joker);
		
		System.out.println( spdao.selectAll() );
		System.out.println( svdao.selectAll() );
	}

}
