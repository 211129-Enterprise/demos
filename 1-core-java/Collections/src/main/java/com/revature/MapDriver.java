package com.revature;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> languages = new HashMap<String, String>();
		
		// HashMap vs TreeMap
		// Hashmaps allow storing at most 1 null key
		// TreeMap doesn't allow a null key, but may allow a null value
		
		// use .put() method to insert data into a map
		
		languages.put("java", "a high level compiled OO, platform independent language");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "interpreted, multi-paradigm language");
		
		
		for (String key : languages.keySet()) {
			System.out.println(key);
		}
		
		for (String value : languages.values()) {
			System.out.println(value);
		}
		
		// Iterate over the ENTIRE entry set
		for (Map.Entry<String, String> entry : languages.entrySet()) {
			System.out.println(entry);
			System.out.println("===========");
		}
		
	}

}
