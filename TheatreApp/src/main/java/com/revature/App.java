package com.revature;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Theatre amcTheatre = new Theatre("AMC", 8, 12);
		amcTheatre.getSeats();
		
//		amcTheatre.reserveSeatBruteForce("H12");
		
		amcTheatre.reserveSeatBinary("H12");
		
		// improve this by binary search
	}

}