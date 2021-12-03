package com.revature;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.Animal;

public class MapDriver {

	// The map interface does NOT extend the iterable interface (or Collection Interface)
	// It is still a data structure (so considered part of the Collections Framework)
	//
	// (We'll go over maps more thoroughly later on in week 3)
	
	public static void main(String[] args) {
	
		//Build a programming language dictionary with a key (word) and a value (definition)
		Map<String, String> languages = new HashMap<String, String>();
		
		
		// 			HashMap vs TreeMap
		//
		// HashMaps allow storing at MOST ONE NULL KEY
		//
		// TreeMap does NOT ALLOW NULL KEY but MAY ALLOW A NULL VALUE
		
		// Use .put() method to insert data into a map
		languages.put("Java", "a high-level compiled OO, platform independent language");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "an interpreted multi-paradigm language runs in a browser or Node.js");
		
		
		/**
		 * You may not have duplicate keys, but you can have duplicate values
		 * 
		 */
		
		//When you retrieve a value from a map, it operates in O(1) because you call the key
		languages.get("Java");
		languages.put("JavaScript", "NOT Java..."); //replaces previous key / value pair
		
		Map<Integer, String> randomMap = new HashMap<Integer, String>();
		for(Integer i : randomMap.keySet()) {
			
			System.out.println(i);
			
		}
		
		// You can add an array
		Map<Integer, int[]> crazyMap = new HashMap<Integer, int[]>();
		
		
		
		String newValue = languages.get("JavaScript") + "ABC";
		String prevKey = languages.put("Java", languages.get("JavaScript")); //replaces previous key/value pair
		
		// Say we want to iterate over all the KEYS
		// HashMaps maintain NATURAL ORDER of all keys
		for(String key : languages.keySet()) {
			
			System.out.println(key);
		
		}
		
		//Could do same thing for value set.
		//Returns the values in the lexographic order
		//of keys (natural order for Strings)
		for(String value : languages.values()) {
			
			System.out.println(value);
		
		}
		
		//iterate over the ENTIRE entry set (print out keys and values)
		for(Map.Entry<String, String> entry : languages.entrySet()) {
			
			System.out.println(entry); //"key=value"
			System.out.println("================================");
			
		}
		
		//Animal
		//Each animal has some type of unique ID that's a long data type (e.g. 3795598235925329871578629 )
		Map<Long, Animal> zooDB = new HashMap<Long, Animal>();
		
		//Retrieve the animal record
		Animal penguin = zooDB.get(65111L);
		penguin.setAge(14);
		Animal replacement = new Animal("Penguin2", 15);
		//Now you can replace that value in the map
		
		zooDB.put(65111L, replacement); //Now you're replacing that object
		
		//use a null for data validation...
		zooDB.put(null, new Animal("Unknown Species", 0));
	}
	
}
