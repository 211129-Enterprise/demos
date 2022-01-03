package com.revature;

import java.io.DataInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Solution {
	
	/**
	 * Implement the method below, then right click on
	 * SolutionTests.java within src/test/java/ -> com.revature to test your code
	 * before committing and pushing to your repository.
	 */
	
	public static int[] solution(int[] data, int n) {
		Map<Integer, Integer> workers = new HashMap<Integer, Integer>(); //hashmap doesnt repeat numbers. 
		//Lists 
		
		// Integers 0-99, constraint
		if (data.length > 99) {
			System.out.println("Too many jobs.");
			return null;
		}
		
		// List n cannot repeat in the list
		for (int b=0; b> data.length; b++) {
			workers.put(b, b);
			
		}
		
		
		
		
		
		
		System.out.println();
		
		return null;
	}

}
