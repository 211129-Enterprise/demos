package advantureGame;

import java.util.HashMap;
import java.util.Map;

import com.revature.annontation.Entity;

/*
 * 
 * full yy immutable classs
 * 
 * 
 */

@Entity(tableName="getExits" )
public final class Location {

	private final  int LocationId;
	private final String description;
	private final Map<String, Integer> exits;
	
	
	public Location(int localionId , String description , Map<String, Integer > exits) {
		this.LocationId = localionId;
		this.description = description;
		if(exits != null) {
			this.exits = new HashMap<String , Integer>(exits);
		}else {
			this.exits = new HashMap<String , Integer>();
		}
		this.exits.put("Q", 0);// all location objects when instatiared have Q as the quit optoon leading them to room 0
		
		
	}
	
	
	public Map<String, Integer> getExits(){
		return  new HashMap<String , Integer>(exits);
	}


	public int getLocationId() {
		return LocationId;
	}


	public String getDescription() {
		return description;
	}
	
	
	
	
}
