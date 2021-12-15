package com.revature.adventuregame;

import java.util.HashMap;
import java.util.Map;

/*
 * Making it FINAL because...
 *  + We CANNOT extend this class any further
 *  + We want it to be FULLY IMMUTABLE so that some third-party
 *    location can't modify the location instances.
 */
public final class Location {
	
	// We can't change any of the properties
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits; // String is cardinal direction and integer is locationId of where that exit leads
	
	
	// We'll instantiate our location objects at runtime
	public Location(int locationId, String description, Map<String, Integer> exits) {
		
		this.locationId = locationId;
		this.description = description;
		
		// Are we passing through a not null map?
		if(exits != null) {
			this.exits = new HashMap<String, Integer>(exits);
		} else {
			this.exits = new HashMap<String, Integer>();
		}
		
		this.exits.put("Q", 0); // All location objects, when instantiated have 'Q' as the quit option leading them to room 0
	}
	
	
	
	// When we create a getter for the exits list,
	// we'll create a copy of references that point
	// to the objects in the original exits map.
	public Map<String, Integer> getExits(){
		
		// Returns a shallow copy
		return new HashMap<String, Integer>(exits);
		
	}



	public int getLocationId() {
		return locationId;
	}



	public String getDescription() {
		return description;
	}
	
	

	
}
