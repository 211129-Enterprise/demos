package com.revature.adventuregame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	// this will help us when we write our exits, so we know when y ou press (for example)
	// "W" from location 1 -> will take you to location 2
	private static Scanner scan = new Scanner(System.in);
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args) {
		// instantiate all locations with their respective exits
		
		// this is location 0 - where someone goes when they press "Q"
		Location homeBase = new Location(0, "You are sitting at a computer learning Java", null);
		locations.put(0, homeBase);
		
		// this will be the hashmap that we pass into the new location object
		Map<String, Integer> tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("W", 2);
		
		// now let's instantiate the Road location (id is 1)
		Location road = new Location(1, "You are standing at the end of a road in front of a brick building", tempExit);
		// add the road to locations map
		locations.put(1, road);
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		
		Location hill = new Location(2, "You're on top of a grassy hill with a dark forest to the north.", tempExit);
		locations.put(2, hill);
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "You're in an old brick building",tempExit));
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4, "You're standing in the middle of a big green valley", tempExit));
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(5, "You're standing in a dark forest", tempExit));
				
		int loc = 1;
		
		// if the player presses Q then the location will be set to 0 and we break from the loop
		while(true) {
			
			System.out.println(locations.get(loc).getDescription());
			
			if (loc == 0) {
				break;
			}
			
			System.out.println("The available exits are:\n");
			
			// capture the exits, and iterate through the key sets (list N, E, S, W)
			Map<String, Integer> exits = locations.get(loc).getExits();
			// Print out the available exits:
			
			for (String exit: exits.keySet()) {
				
				String direction = "";
				
				switch (exit) {
					case "N":
						direction = "North";
						break;
					case "S":
						direction = "South";
						break;
					case "E":
						direction = "East";
						break;
					case "W":
						direction = "West";
						break;
					case "Q":
						direction = "Quit";
						break;
				}
				
				System.out.println(direction);
			}
			
			System.out.println("Where would you like to go?");
			String direction = scan.next().toUpperCase();
				
			switch (direction) {
				case "NORTH":
					direction = "N";
				case "SOUTH":
					direction = "S";
				case "EAST":
					direction = "E";
				case "WEST":
					direction = "W";
				case "QUIT":
					direction = "Q";
			}
			
			
			if (exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else {
				System.out.println("You start walking, but you suddenly black out.\nWhen you wake up...");
			}
			
		}
		

	}

}
