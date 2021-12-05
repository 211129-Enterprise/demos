package com.revature;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Animal;

public class WildCardDriver {
	
	public static void main(String[] args) {
		
	
		List<Integer> list1 = new LinkedList<Integer>();
		list1.add(12);
		list1.add(235);
		
		printList(list1);
		
		List<Animal> list2 = Arrays.asList(new Animal("Cat", 12), new Animal("Cat", 1));		
		
		printList(list2);
		
		List<Double> list3 = Arrays.asList(2.09, 76.2, 11.9);
		
		add(list3);
		add(list1);
//		add(list2); // because Animal doesn't extend Number!
		
	}
	
	// Unbounded Wildcard specified by (?)
	// this method takes in a list and prints it.....
	private static void printList(List<?> list) { // I can pass a Vector, I can pass a LinkedList, I can pass an ArrayList
		
		// now I'm capable of printing ANY type of List that stores ANY type of object
		
		System.out.println(list);
		
	}
	
	// Upper Bounded Wildcard
	
	// extends in the context of Upper Bound Wildcards refers to a Class that EITHER extedns a superclass OR implements the specified interface.
	private static double add(List<? extends Number> list) {
		
		// take in a list that has numbers in it (but we don't care what TYPE of number...Integers, Doubles, Longs, Floats....
		//ONLY numbers, not Strings or Animal objects
		
		double sum = 0.0;
		
		for (Number n : list ) {
			
			sum += n.doubleValue();
		}
		
		return sum;
		
	}
	
	// Lower Bounded Wildcard exists too!
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
