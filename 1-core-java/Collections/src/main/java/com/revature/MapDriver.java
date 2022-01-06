package com.revature;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.Animal;

public class MapDriver {
<<<<<<< HEAD
	// The map interface does NOT extend the iterable interface or Collection interface
	// It is still a data structure (considered part of the collections framework
	public static void main(String[] args) {
		//build a programming language dictionary with a key (word) and a value (definition)
		Map<String, String> languages = new HashMap<String, String>();
		
		//Hashmap versus TreeMap
		//HashMaps allow storing at most 1 null key
		//TreeMap doesnt allow a null key, but may allow a null value
		
		//use .put() method to insert data into a map
		languages.put("Java", "a high level comiled OO, platform independent language.");
		languages.put("Python", "an interpreted OOP language.");
		languages.put("Javascript", "Interpreted, multi-paradigm languages that runs in a browser or node.js");
		
		/*
		 * You may not have duplicate keys but may have duplicate values
		 */
		//retrieve value from a map, it operates in O(1) because you call a key.
		languages.get("Java");
		languages.put("Javascript", "NOT Java..."); //replaces previous key/value
		
		//we want to iterate over all keys
		//HashMaps maintain natural order of all keys
		for (String key: languages.keySet()) {
			System.out.println(key);
		}
		//same thing for value sets
		for (String value: languages.values()) {
			System.out.println(value);
		}
		//iterate over entire entry set
		for (Map.Entry<String, String> entry : languages.entrySet()) {
			System.out.println(entry);
			System.out.println("=====================");
		}
		//array as the value
		Map<Integer, int[]> crazyMap = new HashMap<Integer, int[]>();
		
		// we want to iterate over all the KEYS 
				// HashMaps maintain natural order of all keys
				for (String key : languages.keySet()) {
					System.out.println(key);
				}
				
				// returns the values in the lexographic order of keys (natural order for Strings)
				for (String value : languages.values()) {
					System.out.println(value);
				}
				
				
				// iterate over the ENTIRE entry set (print out keys and values)
				for (Map.Entry<String, String> entry : languages.entrySet()) {
					
					System.out.println(entry); // "key=value"
					System.out.println("==================");
				}
				
				// Animal
				// Each Animal has some type of unique Id that's an long 3748327489247289473L
				Map<Long, Animal> zooDB = new HashMap<Long, Animal>();
				
				// retrieve the animal record
				Animal penguin = zooDB.get(651111L);
				
				penguin.setAge(14);
				Animal replacement = new Animal("Penguin2", 15);
				// now you can replace the value in the Map
				
				zooDB.put(651111L, replacement); // now you're replaceing that object
				
				// use it for data validation....so if the entered value
				
				zooDB.put(null, new Animal("Unknown Species", 0));
	}
=======
	
	// The Map interface does NOT extend the iterable interface (or Collection interface)
	// It is a still a data structure (so considered part of the Collections Framework)
	
	public static void main(String[] args) {
		
		// build a programming language dictionary with a key (word) and a value (definition)
		Map<String, String> languages = new HashMap<String, String>();
		
		// HashMap vs TreeMap
		// HashMaps allow storing at most 1 null key
		// TreeMap doesn't allow a null key, but may allow a null value
		
		// use .put() method to insert data into a map
		languages.put("Java", "a high-level compiled OO, platform independent language");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "interpreted, multi-paradigm languages that runs in a browser or Node.js");
		
		/**
		 * You may not have duplicate keys, but you can have duplicate values
		 */
		
		// retrieve a value from a Map, it operates in O(1) because you call the key
		languages.get("Java");
		
		String newValue = languages.get("JavaScript") + "ABC";
		
		languages.put("JavaScript", newValue); // replaces previous key/value pair
		
		Map<Integer, String> randomMap = new HashMap<Integer, String>();
		for (int i : randomMap.keySet()) {
			System.out.println(i);
		}
		
		// You totally can add an array since it's a container object
		Map<Integer, int[]> crazyMap = new HashMap<Integer, int[]>();
		
		
		// we want to iterate over all the KEYS 
		// HashMaps maintain natural order of all keys
		for (String key : languages.keySet()) {
			System.out.println(key);
			
		}
		
		// returns the values in the lexographic order of keys (natural order for Strings)
		for (String value : languages.values()) {
			System.out.println(value);
			
		}
		
		
		// iterate over the ENTIRE entry set (print out keys and values)
		for (Map.Entry<String, String> entry : languages.entrySet()) {
			
			System.out.println(entry); // "key=value"
			System.out.println("==================");
			
		}
		
		// Animal
		// Each Animal has some type of unique Id that's an long 3748327489247289473L
		Map<Long, Animal> zooDB = new HashMap<Long, Animal>();
		
		// retrieve the animal record
		Animal penguin = zooDB.get(651111L);
		
		penguin.setAge(14);
		Animal replacement = new Animal("Penguin2", 15);
		// now you can replace the value in the Map
		
		zooDB.put(651111L, replacement); // now you're replaceing that object
		
		// use it for data validation....so if the entered value
		
		zooDB.put(null, new Animal("Unknown Species", 0));
	
		
		
		
		
		
		
		
		
		
	}

>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
}
