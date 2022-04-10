package com.java.exercise51;

/*
Edit the code by following the steps in the description
*/

import java.util.HashMap;
import java.util.Map;

//public class Location {
final public class Location {

//	final int locationID;
	final private int locationID;
//	public String description;
	final private String description;
//	protected Map<String, Integer> exits;
	final private Map<String, Integer> exits;

	public Location(int locationID, String description, Map<String, Integer> exits) {
		this.locationID = locationID;
		this.description = description;
//		this.exits = new HashMap<String, Integer>(exits);
		this.exits = (exits != null) ? new HashMap<String, Integer>(exits) : new HashMap<String, Integer>();
		this.exits.put("Q", 0);
	}

//	public void addExit(String direction, int location) {
//		exits.put(direction, location);
//	}

//	public void setLocationID(int locationID) {
//		this.locationID = locationID;
//	}

	public int getLocationID() {
		return locationID;
	}

//	public void setDescription(String description) {
//		this.description = description;
//	}

	public String getDescription() {
		return description;
	}

//	public void setExits(Map<String, Integer> exits) {
//		this.exits = exits;
//	}

	public Map<String, Integer> getExits() {
//		return exits;
		return new HashMap<String, Integer>(exits);
	}

}
