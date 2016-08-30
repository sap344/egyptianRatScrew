/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.util.*;

public class Game {
	
	// properties
	private static Deck middlePile = new Deck(52);
	private static Deck user_1_Pile = new Deck(52);
	private static Deck user_2_Pile = new Deck(52);
	private static List<Card> slapRuleTracker = new ArrayList<Card>();
	
	// constructor
	public Game() {
		
		// shuffle cards in main deck (middle pile)
		
		
		// distribute cards to user and computer
		
	}
	
	// methods
	public Card User_1_FlipsCard() {
		Card flippedCard = null;
		
		return flippedCard;
	}
	
	public Card User_2_FlipsCard() {
		Card flippedCard = null;
		
		return flippedCard;
	}
	
	public void User_1_SlapsPile() {
		// is called when the user hit his/her slap key
		// checkSlapRule
		// if true give the slapper the middle pile, else give the opponent the middle pile
	}
	
	public void User_2_SlapsPile() {
		// is called when the user hit his/her slap key
		// checkSlapRule
		// if true give the slapper the middle pile, else give the opponent the middle pile
	}
	
	public void NewGame() {
		// reset all decks and call constructor again to distribute cards
	}
	
	public String EndGame() {
		String winner = ""; // whichever user has the most points (total card value), wins!
		return winner;
	}
	
	private boolean checkSlapRule() {
		boolean isSlapperValid = true; // give the slapper the middle pile

		return isSlapperValid;
	}
	
	private int calculatePoints(Deck countThisPile) {
		int points = 0;
		
		return points;
	}
	
	private void shuffle(Deck shuffleDeck) {
		
	}
}
