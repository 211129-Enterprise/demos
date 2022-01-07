package com.revature;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.models.Animal;

public class WildCardDriver {

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(12);
		list1.add(235);
		
		printList(list1);
		

		List<Animal> list2 = Arrays.asList(new Animal("Cat", 12), new Animal("Dog", 1));
		
		printList(list2);
		
		List<Double> list3 = Arrays.asList(2.09, 76.2, 11.9);
		
		add(list3);
		add(list1);
//		add(list2); because Animal doesn't extend number!
		
	}
	
	// Unbounded Wildcard specified by a (?)
	// this method takes in a list and prints it...
	private static void printList(List<?> list) { // I can pass a Vector, LinkedList, ArrayList
	
		// now I'm capable of printing ANY type of list that stores ANY type of object
		
		System.out.println(list);
		
	}
	
	// Upper Bounded Wildcard
	//extends in the context of Upper Bound Wildcards refers to a Class that either extends a superclass or implements the specified interface
	private static double add(List<? extends Number> list) {
		
		// take in a list that has numbers in it (but we don't care what type of number.. Integers, DOubles, Longs, Floats)
		// ONLY numbers, not Strings or Animal Objects.
		
		double sum = 0.0;
		for ( Number n : list ) {
			
			sum += n.doubleValue();
		}
		
		return sum;	
	}
	
	// Lower bounded wildcard exists too!
	
}
