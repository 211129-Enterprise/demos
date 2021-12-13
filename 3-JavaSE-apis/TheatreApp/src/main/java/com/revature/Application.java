package com.revature;

public class Application {

	public static void main(String[] args) {
		
		Theatre amc = new Theatre("AMC", 8, 12);
		
		amc.getSeats();
		
		amc.reserveSeatBruteForce("G11");
		amc.reserveSeatBinary("G11");
		
		
		
	}
	
}
