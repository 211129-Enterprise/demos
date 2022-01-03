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
	
	public static void main(String[] args) {
		Crime c1 = new Crime("Freeze", "covering the city in ice");
		Crime c2 = new Crime("Time Manipulation", "freezing time, robbin' banks");
		
		cdao.insert(c1);
		
		cdao.insert(c2);
		
		List<Crime> crimes = new ArrayList<Crime>();
		crimes.add(c1);
		crimes.add(c2);
		
		SuperPrison arkham = new SuperPrison("Arkham Asylum", "Gotham City");

		SuperVillain joker = new SuperVillain("The joker", "evilness", 1_000_000, crimes, arkham);
		
		SuperPrisonDAO spdao = new SuperPrisonDAO();
		spdao.insert(arkham);
		
		SuperVillainDAO svdao = new SuperVillainDAO();
		svdao.insert(joker);
		
		
	}
}
