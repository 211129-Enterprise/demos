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
		
		List<Animal> list2 = Arrays.asList(new Animal("Cat", 12), new Animal("Cat", 1));
		
		printList(list2);
		
//		add(list3);
		
		add(list1);
		
//		add(list2) can't do this because list2 has Animal in it which does not extend Number 
		
		
	}
	
	// this method takes in a list and prints it.....
	
	private static void printList(List<?> list) {
		System.out.println(list);
	}
	
	
	// upper bounded Wildcard 
	
	private static double add(List<? extends Number> list) {
		double sum = 0.0;
		
		for (Number n : list) {
			sum += n.doubleValue();
		}
		
		return sum;
	}
}
