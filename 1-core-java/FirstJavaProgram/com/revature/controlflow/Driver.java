package com.revature.controlflow;

public class Driver {

	public static void main(String[] args) {
		/*
		 *  if / else
		 *  if / else if
		 *  ternary operator
		 */

		int temp = 31;
		
		//TRADITIONAL CONDITIONAL
		if(temp < 32) {
			System.out.println("It's under freezing");
		} else if(temp == 32){
			System.out.println("It's at freezing");
		} else {
			System.out.println("It's above freezing");
		}
		
		
		
		//TERNARY OPERATOR - returns ture or false based on a condition
		System.out.println( (temp < 3) ? "It's Freezing" : "It's not under freezing");
		
		String statement; //declaring variable
		
		statement = (temp < 32) ? " x " : " y "; //initializing it based on a condition
		
	}

}
