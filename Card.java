/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

public class Card {

	// properties
	private static int Suit;
	private static int Rank;
	
	// constructor
	public Card (int suit, int rank) {
		this.setSuit(suit);
		this.setRank(rank);
	}
	
	// methods
	// --getters
	public int getSuit() {
		return Suit;
	}
	
	public int getRank() {
		return Rank;
	}
	
	public String getRankString() {
		return RankMap.getString(Card.Rank);
	}
	
	public String getSuitString() {
		return SuitMap.getString(Card.Suit);
	}
	
	public String getCardString() {
		String cardString = RankMap.getString(Card.Rank) + " of " + SuitMap.getString(Card.Suit);
		return cardString;
	}
	
	public String getCardImageFile() {
		String cardKey = String.valueOf(Card.Rank);
		switch(Card.Suit) {
			case 0 : cardKey.concat("s.gif");
					 break;
			case 1 : cardKey.concat("c.gif");
					 break;
			case 2 : cardKey.concat("d.gif");
					 break;
			case 3 : cardKey.concat("h.gif");
					 break;
			default : cardKey = "b.gif";
					  break;
		}
		
		return cardKey;
	}
	
	// --setters
	private void setRank(int rank) {
		Card.Rank = rank;
	}
	
	private void setSuit(int suit) {
		Card.Suit = suit;
	}
}
