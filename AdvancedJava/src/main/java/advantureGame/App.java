package advantureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
	
	private static Map<Integer , Location> locations = new HashMap<>();
	
	public static void main(String[] args) {
		
		Location homeBase = new Location(0, "You are setting at a compture",  null);
		locations.put(0, homeBase);
		
		HashMap<String, Integer>	temExit = new HashMap<>();
		
		temExit.put("N", 5);
		temExit.put("E", 3);
		temExit.put("W", 2);
		temExit.put("S", 4);
		
		Location road = new Location(1, "You are standing at the end of a road",temExit );
		
		
		locations.put(1, road);
		temExit =  new HashMap<>();
		temExit.put("N", 5);
		
		Location hill = new Location(2, "You are at a grassy hill", temExit);
		
		
		locations.put(2, hill);
		
		temExit =  new HashMap<>();
		temExit.put("W", 1);
		locations.put(2, new Location(3, "You are in old brick building", temExit));
		
		temExit =  new HashMap<>();
		temExit.put("W", 1);
		temExit.put("W", 2);
		
		locations.put(2, new Location(4, "You are standing in the middle of a valley", temExit));
		
		temExit =  new HashMap<>();
		temExit.put("S", 1);
		temExit.put("W", 2);
		
		locations.put(2, new Location(5, "You are standing in a dark forest", temExit));
		
		Scanner scann = new Scanner(System.in);
		int loc = 1;
			while(true) {
				
				System.out.println(locations.get(loc).getDescription());
				
				if(loc ==0) {
					break;
			}
				
				System.out.println("the available exists are :");
				
				Map<String, Integer> exits = locations.get(loc).getExits();
				
				
				for(String exit : exits.keySet()) {
					System.out.println(exit + ", ");

		
				}
				System.out.println("where woulod you like to go? ");
				if(exits.containsKey(loc)) {
					loc = exits.get(scann);
					}else {
						System.out.println("thats not possible exist");
					}
				}
				
				
				
		
}
}