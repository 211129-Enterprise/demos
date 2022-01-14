package com.revature;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to the theater");
		
		Theatre amc = new Theatre("Meme Stock", 10, 20);
		
		amc.getSeats();
		
		amc.reserveSeatBruteForce("A03");
		amc.reserveSeatBinary("D12");
	}

}
