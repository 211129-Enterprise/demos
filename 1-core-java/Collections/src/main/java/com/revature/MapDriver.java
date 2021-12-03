package com.revature;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.Animal;

public class MapDriver {

	// The Map interface does NOT extend the Iterable interface (or Collections interface)
	// It is still a data structure (so considered part of the Collections Framework)
	
	public static void main(String[] args) {
		
		// build a programming language dictionary with a key (word) and a value (definition)
		Map<String, String> languages = new HashMap<String, String>();
		
		// HashMap vs TreeMap
		// HashMaps allow storing at MOST 1 null key
		// TreeMap does not allow a null key but may allow a null value
		
		// use .put() method to insert data into a map
		languages.put("Java", "a high-level compiled OO, Platform Independent Language");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "interpreted, multi-paradigm language runs in aa browser or Node.js");
	
		/**
		 * You may not have duplicate keys, but you can have duplicate values.
		 */
		
		// retrieve a value from a Map, it operates in O(1) because you call the key
		languages.get("Java");
		
		String newValue = languages.get("JavaScript") + "ABC";
		
		languages.put("JavaScript", newValue); // replaces previous key/value pair	
		
		Map<Integer, String> randomMap = new HashMap<Integer, String>();
		for (Integer i : randomMap.keySet()) {
			System.out.println(i);
		}
		
		// you totally can add an array as values
		Map<Integer, int[]> crazyMap = new HashMap<Integer, int[]>();
		
	
		// we want to iterate over all the KEYS
		// HashMaps maintain natural order of all keys
		for (String key : languages.keySet()) {
			System.out.println(key);
			
		}
		
		// returns values in the lexographic order of keys (natural order for Strings)
		for (String value : languages.values()) {
			System.out.println(value);
				
		}
		
		for (Map.Entry<String, String> entry : languages.entrySet()) {
			
			System.out.println(entry);
			System.out.println("=================");
			
		}
		
		// Animal
		// Each Animal has some type of unique ID that's a long 472103958712039487239L
		Map<Long, Animal> zooDB = new HashMap<Long, Animal>();
		
		// retrieve the animal record
		Animal penguin = zooDB.get(6511111L);
		
		penguin.setAge(14);
		Animal replacement = new Animal("Penguin2", 15);
		// now you can replace that value in the Map
		
		zooDB.put(651111L, replacement); // now you're replacing that object
		
		// use it for data validation.. so if the entered value 
		
		zooDB.put(null, new Animal("unknown Species", 0));
		
	}
	
}
