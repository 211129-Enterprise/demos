package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.CrimeDAO;
import com.revature.dao.SuperPrisonDAO;
import com.revature.dao.SuperVillainDAO;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;

public class Driver {
	
	static CrimeDAO cdao = new CrimeDAO();
	static SuperVillainDAO svdao = new SuperVillainDAO();
	static SuperPrisonDAO spdao = new SuperPrisonDAO();
	
	public static void main(String[] args) {
		System.out.println("Running our Hibernate DEMO");
		
		Crime c1 = new Crime("Freeze", "covering the city in ice");
		Crime c2 = new Crime("Time Manipulation", "freezing time, robbin' banks");
		Crime c3 = new Crime("Arson", "set a buncha stuff on fire");
		
		cdao.insert(c2);
		cdao.insert(c1);
		cdao.insert(c3);
		
		List<Crime> crimes = new ArrayList<Crime>();
		crimes.add(c1);
		crimes.add(c3);
		
		SuperPrison arkham = new SuperPrison("Arkham Asylum", "Gotham City");
		
		SuperVillain joker = new SuperVillain("The Joker", "evilness", 1_000_000.00, crimes, arkham);
		
		spdao.insert(arkham);

		svdao.insert(joker);
		
		System.out.println(svdao.selectAll());
	
	}

}
