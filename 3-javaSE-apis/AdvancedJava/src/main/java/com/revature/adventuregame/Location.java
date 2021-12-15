package com.revature.adventuregame;

import java.util.HashMap;
import java.util.Map;

/*
 * Location is a fully immutable class so that third party plug-ins
 * cannot modify the Location instances of their game-maps. 
 */
public final class Location {
	
	// we can't change any of the properties after instantiation
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits; // String is cardinal direction, and Integer is locationId of where that exit leads

	public Location(int locationId, String description, Map<String, Integer> exits) {
		
		this.locationId = locationId;
		this.description = description;
		
		if (exits != null) {
			this.exits = new HashMap<String, Integer>(exits);
		} else {
			this.exits = new HashMap<String, Integer>();
		}

		this.exits.put("Q", 0); // all location objects when instantiated have Q as the quit option, leading them to room 0 (exit)
	}
	
	/*
	 * Instead of returning the real exits Map, we are creating a new HashMap
	 * The reason we're doing this is so that the calling program
	 * can't actually effect the real exits Map (we're creating a copy of references
	 * that point to the objects in the original Map)
	 * 
	 * When you call getExits(), it will be an immutable object,
	 * but you can still access all of the date within the HashMap returned
	 * (This data is, of course, references to the key-value pairs/EXITS)
	 */
	public Map<String, Integer> getExits() {
		
		/**
		 *  Shout out Zak: think of sending someone a PDF of your word doc to view (which they can't edit),
		 *  but not the actual word doc itself, (which they could edit). 
		 */
		return new HashMap<String, Integer>(exits);
	}

	/**
	 * I don't want to actually return the REAL set of exits!
	 * Because that would allow to calling program the ability 
	 * to change the map keys/value's.
	 * 
	   	public Map<String, Integer> getExits() {
			
			return exits;
			
		}	
		
	 * 
	 */

	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}
}
