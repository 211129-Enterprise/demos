package com.revature;

public class App {

	public static void main(String[] args) {
		
		Theatre amc = new Theatre("AMC", 8, 12);
		
		amc.getSeats();
		
//		amc.reserveSeatBruteForce("G11");
		
		amc.reserveSeatBinary("G11");

		
		// improve this algorithm by implementing a binary search - O(log n) Logarithmic Time
		
	}

}
