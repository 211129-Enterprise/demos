package com.revature.adventuregame;

import java.util.HashMap;
import java.util.Map;

/**
 * We are making a fully immutable class.
 * Meaning that, some third party plugin can't modify the location instances.
 */
public final class Location {
	
	// we can't change any of the properties after instanitation
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits; // String is cardinal direction, and Integer is locationId of where that exit leads
	
	// We'll instantiate our Location objects at runtime
	public Location(int locationId, String description, Map<String, Integer> exits) {
		
		this.locationId = locationId;
		this.description = description;
		
		// are we passing through a not null map?
		if (exits != null) {
			this.exits = new HashMap<String, Integer>(exits);
		} else {
			this.exits = new HashMap<String, Integer>();
		}

		this.exits.put("Q", 0); // all location objects when instantiated have Q as the quit option, leading them to room 0
	}

	// I don't want to actually return the REAL set of exits!
//	public Map<String, Integer> getExits() {
//		return exits;
//	}
	
	// getter for the exits list
	// create a copy of references that point to the objects in the original exits map
	// but the calling program is incapapable of modifying the original data structure that the returned Map is a copy of
	public Map<String, Integer> getExits() {
		
		// return a shallow copy
		// shout out Zak: think of sending soimeone a PDF of your word doc to view, but not the actual word doc itself, which they could edit
		return new HashMap<String, Integer>(exits);
	}

	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}
}
