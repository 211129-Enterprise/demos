package com.revature;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Animal;

public class WildCardDriver {
	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5};
		printList(Arrays.asList(array));
		printList(Arrays.asList(new Animal("Dog", 12), new Animal("Frog", 13), new Animal("Cat", 11)));
	}
	
	// Unbounded Wildcard (?)
	private static void printList(List<?> list) {
		System.out.println(list);
	}
	
	// Bounded Wildcard
	private static double add(List<? extends Number> list) {
		double sum = 0.0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}
}
