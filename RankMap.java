/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.util.HashMap;

public class RankMap {
	
	// properties
	public static HashMap<Integer,String> rankMap = new HashMap<Integer,String>();
	
	// constructor
	public RankMap() {
		rankMap.put(0, "Ace");
		rankMap.put(1, "Two");
		rankMap.put(2, "Three");
		rankMap.put(3, "Four");
		rankMap.put(4, "Five");
		rankMap.put(5, "Six");
		rankMap.put(6, "Seven");
		rankMap.put(7, "Eight");
		rankMap.put(8, "Nine");
		rankMap.put(9, "Ten");
		rankMap.put(10, "Jack");
		rankMap.put(11, "Queen");
		rankMap.put(12, "King");
	}
	
	// methods
	public String getString(int value) {
		return rankMap.get(value);
	}
}
