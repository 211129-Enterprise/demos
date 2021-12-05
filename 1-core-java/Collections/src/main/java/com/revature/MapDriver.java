package com.revature;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

public class MapDriver {
	public static void main(String[] args) {
		Map<String, String> languages = new HashMap<String, String>();
		
		languages.put("Java", "high-level compiled OO, platform independent language");
		languages.put("Python", "an interpreted ))P language");
		languages.put("JavaScript", "interpreted, multi-paradigm languages that runs in a browser or Node.js");
		
		for(String key : languages.keySet()) {
			System.out.println(key);
		}
		
		for(Map.Entry<String, String> entry : languages.entrySet()) {
			System.out.println(entry);
		}
	}
}
