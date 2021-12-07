package com.revature.abstraction;

import java.util.LinkedList;
import java.util.Queue;

public class Driver {

	

	Queue<Animal> animalQ = new LinkedList<>();
	
	

	 
	
	public static void main(String[] args) {
		Cat anCat = new Cat();
		System.out.println(anCat);
	}
	
}
