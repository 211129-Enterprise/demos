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
//		add(list2; //Doesn't work because Animal DOESN'T extend number!
	}
	
	
	//Unbounded wildcard specified by <?>
	//This method takes in a list and prints it...
	private static void printList(List<?> list) { //Using list, I can now pass any implementation of list like
												  //a LinkedList, Vector, ArrayList, etc
												  //
												  // Using the "?" I am now capable of printing ANY type of list
												  // that stores ANY type of object
		
		System.out.println(list);
	}
	
	//Upper bounded wildcard
	//Extends in the context of upper bound wildcards refers to a class that EITHER extends a superclass
	//OR implements the specified interface
	private static double add(List<? extends Number> list) {
		
		//take in a list that has numbers in it (but we don't care what TYPE of number... e.g. ints, longs, doubles, etc)
		//ONLY numbers though, NOT Strings or Animal objects
		double sum = 0.0;
		for(Number n : list) {
			
			sum += n.doubleValue();
		}
	
		return sum;
	}
}
