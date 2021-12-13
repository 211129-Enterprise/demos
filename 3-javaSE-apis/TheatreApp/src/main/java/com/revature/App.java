package com.revature;

public class App {

	public static void main(String[] args) {
		
		Theatre amc = new Theatre("AMC", 8, 12);
		
		amc.getSeats();
		
		amc.reserveSeatBruteForce("A03");

		// improve this algorithm by implementing a binary search - O(log n) Logarithmic Time
		
		
	}

}
