package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.CrimeDAO;
import com.revature.DAO.SuperPrisonDAO;
import com.revature.DAO.SuperVillanDAO;
import com.revature.models.Crime;
import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;

public class Driver {
	
	static CrimeDAO cdao = new CrimeDAO();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Running Our Hibernate Demo");
		
		Crime c1 = new Crime("Freeze", "covering the city in ice");
		Crime c2 = new Crime("Time Manipulation", "fixing time");
		Crime c3 = new Crime("Arson", "setting the city ablaze");
		
		
		List<Crime> crimes = new ArrayList<>();
		
		
		cdao.insert(c1);
		cdao.insert(c2);
		
		crimes.add(c1);
		crimes.add(c2);
		crimes.add(c3);
		
		SuperPrison arkham = new SuperPrison("prison1", "location1");
		
		SuperVillain joker = new SuperVillain("The joker", "evillness", 1_000_000, crimes, arkham);
		
		// let's add all to the DB
		
		SuperPrisonDAO spdoa = new SuperPrisonDAO();
		
		 spdoa.insert(arkham);
		
		
		 SuperVillanDAO svdao = new SuperVillanDAO(); 
		 svdao.insert(joker);
		
		System.out.println( svdao.selectAll());
	}

}
