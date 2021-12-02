package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Set;

import com.revature.models.Animal;

public class CollectionDriver {

	public static void main(String[] args) {
		
		/*
		 * List (Interface)
		 * 
		 * A list is an ordered collection
		 * list contains duplicate 
		 * it inhirite some basic operation form collection interface ;
		 * 
		 * retrival - with O(1) with .get() method
		 * inseration / removal - O(n);
		 * 
		 * LinkedList
		 * retrival is O(n);
		 * insertion/deletion is O(1);  
		 * 
		 * 
		 */
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers = new LinkedList<Integer>();
		
		List<Animal> animals = new ArrayList<Animal>();
		
		Animal a1 = new Animal("tiger", 12);
		Animal a2 = new Animal("dog", 10);
		Animal a3 = new Animal("tiger", 12);
		
		animals.add(a1);
		animals.add(a2);
		animals.add(a3);
		
		for(Animal animal : animals) {
		System.out.println(animal.getName());	
		}
		
		Animal secondAnimal = animals.get(2);
		
		System.out.println(secondAnimal);
		
		
		Set<Animal> animalSet = new HashSet<Animal>();
		
		animalSet.add(a1);
		animalSet.add(a2);
		animalSet.add(a3);
		
		if(!animalSet.add(a3)) {
			System.out.println("here deplicarte");
		}
		
		System.out.println(animalSet);
		
		for(Animal a: animalSet) {
			System.out.println(a1.getName());
		}
		
		
		
		
	}
	
	
}
