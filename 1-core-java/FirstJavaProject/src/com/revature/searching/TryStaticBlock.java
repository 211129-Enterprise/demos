package com.revature.searching;

public class TryStaticBlock {
	 static String name;
	
	static {
		System.out.println("here in static block from the non driver class =====>");
		
		name = "marouane";
		
		System.out.println(name + "======================================");
	}

	public static String getName() {
		return name;
	}


	
	
	
	
}
