package com.revature.collection;

import java.security.KeyStore.Entry;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MapDriver {
	
	private static final boolean String = false;

	public static void main(String[] args) {
		
		//  this not a map ;
		List<Integer> nums  = new Vector<Integer>();
		 nums.add(1);
		 nums.add(2);
		 nums.add(23);
		 
		 
		 Map<String, String> languages = new HashMap<>();
		 
		 languages.put("java", "is OOP");
		 languages.put("Python", "is inertrepted OOP");
		 languages.put("JS", "ABC");
		 languages.put(null, "null value");
		 languages.put("java", "new java");
		 System.out.println(languages);
		 
		 for(String key: languages.keySet()) {
			 System.out.println(key);
		 }
		
		 for(String value: languages.values()) {
			 System.out.println(value);
		 }
			
		 for( Map.Entry<String, String> k: languages.entrySet() ) {
			 System.out.println(k);
		 }
		 
		  
	}

	
	
	
	
}
