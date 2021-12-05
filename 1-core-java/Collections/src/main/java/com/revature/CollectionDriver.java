package com.revature;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.revature.models.Animal;

public class CollectionDriver {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		
		Animal a1 = new Animal("Tiger", 12);
		Animal a2 = new Animal("Dog", 12);
		Animal a3 = new Animal("Tiger", 12);
		
		animals.add(a1);
		animals.add(a2);
		animals.add(a3);
		
		for(Animal a : animals) {
			System.out.println(a.getName());
		}
		
		Set<Animal> animalSet = new HashSet<Animal>();
		
		animalSet.add(a1);
		animalSet.add(a2);
		if(!animalSet.add(a3)) System.out.println("Duplicate");
	
		for(Animal a : animalSet) {
			System.out.println(a.getName());
		}
		
		
		Queue<Animal> animalQueue = new LinkedList<Animal>();
		System.out.println("-----------Queues-----------");
		animalQueue.add(a1);
		animalQueue.add(a2);
		animalQueue.add(a3);
		
		while (!animalQueue.isEmpty()) {
			System.out.println(animalQueue.poll());
		}
		
	}
	
	
}
