package com.revature;

import com.revature.Theatre.Seat;

public class App {
	public static void main(String[] args) {
		Theatre amc = new Theatre("AMC", 8, 12);
		
		amc.getSeats();
		
		amc.reserveSeatBinary("G11");
		//improve the algorithm by implementing a binary search - O(log n) Logarithmic Time
		//amc.reserveSeatBruteForce("G11");  This one takes longer.
		
	}
	
	
	
	
}
