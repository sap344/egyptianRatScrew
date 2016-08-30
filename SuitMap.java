/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.util.HashMap;

public class SuitMap {
	
	// properties
	public static HashMap<Integer,String> suitMap = new HashMap<Integer,String>();
	
	// constructor
	public SuitMap() {
		suitMap.put(0, "Spades");
		suitMap.put(1, "Clubs");
		suitMap.put(2, "Diamonds");
		suitMap.put(3, "Hearts");
	}
	
	// methods
	public String getString(int value) {
		return suitMap.get(value);
	}
}
