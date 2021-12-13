package com.revature;

public class App {

	public static void main(String[] args) {
		
		Theatre amc = new Theatre("AMC", 8, 12);
		
		//amc.getSeats();
		
		//Linear Time COmplexity
//		amc.reserveSeatBruteForce("G11");
		
		// Improve this algorithm by implementing a binary search
		// O(log n) Logarithmic Time Complexity
		amc.reserveSeatBinary("G11");
		
		// Wouldn't work because the class is private.
		// Theatre.Seat mySeat = new Seat("G11");

	}

}
