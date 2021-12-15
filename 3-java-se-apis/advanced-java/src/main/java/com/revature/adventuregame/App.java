package com.revature.adventuregame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	
	// This will help us specify when we write our exits, so we know that when you press a key,
	// it will take you to the correct location (e.g. W from location 1 will go to location 2)
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Instantiate all locations with their respective exits
		
		// This is location 0 - Where someone goes when they enter "Q" for quit
		Location homeBase = new Location(0, "You are sitting at a computer learning Java", null);
		locations.put(0, homeBase);
		
		// This will be the hashmap that we pass into the new location object
		Map<String, Integer> tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("W", 2);
		
		// Now let's instantiate the ROAD location (id is 1)
		Location road = new Location(1, "You are standing at the end of a road in front of a brick building.", tempExit);
		
		// add the Road to our locations map
		locations.put(1, road);
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		Location hill = new Location(2, "You're on top of a grassy hill with a dark forest off to the north.", tempExit);
		locations.put(2, hill);
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "You're in an old brick building or something... IDK.", tempExit));
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4, "You're standing in the middle of a big green valley with a bag of chicken nuggets.", tempExit));
	
		tempExit = new HashMap<String, Integer>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(5, "You're in a dark forest... and what not.", tempExit));
		
		int loc = 1;
		
		
		while(true) {
			
			
			System.out.println(locations.get(loc).getDescription());
			
			
			// Loop keeps going unless player presses "Q" to quit
			// which below sets the location to zero to signify
			// the loop should be broken.
			if(loc == 0) {
				break;
			}
			
			
			
			System.out.println("The available exits are:");
			
			// Capture the available exits
			// Iterate through the keysets (list N, E, S, W)
			Map<String, Integer> exits = locations.get(loc).getExits();
			
			// Print out the available exits
			for(String exit : exits.keySet()) {
				System.out.print(exit + ", ");
			}
			
			System.out.print("Where would you like to go?\n > ");
			
			String direction = scan.nextLine().toUpperCase();
			
			
			/*
			 * OPTIONAL to make it a better game:
			 * > Take in input and allow players to say things like:
			 * "run north" and it will still capture the "N" and make them
			 * change their location to the new location object.
			 */
			
			if(exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else {
				System.out.println("That's not a posssible exit");
			}
			
		}
		
		
		

	}

}
