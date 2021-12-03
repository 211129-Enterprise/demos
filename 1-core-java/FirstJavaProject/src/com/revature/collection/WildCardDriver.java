package com.revature.collection;

import java.util.LinkedList;
import java.util.List;

/*
 * 
 * 
 * 
 * 
 */

public class WildCardDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new LinkedList<>();
		list.add(12);
		list.add(30);
		WildCardDriver.printList(list);
		

	}
	
	
	// unbounded wild card specified by (?)
	private static void printList (List<?> list) {
		System.out.println(list);
	}
	
	// upper Bounded Wildcard 
	
	// only allow arrgument that extands Number 
	private static double add(List<? extends Number> list) {
		
		double sum = 0.0 ;
		for(Number n: list) {
			sum+= n.doubleValue();
		}
		
		return sum;
	}
	
	// lower bounded WildCard exist too ;
	
	     
	
	
}
