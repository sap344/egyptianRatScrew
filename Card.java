/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

public final class Card {

	// properties
	private final int Suit;
	private final int Rank;
	private SuitMap suitMap = new SuitMap();
	private RankMap rankMap = new RankMap();
	
	
	// constructor
	public Card (int suit, int rank) {
		this.Suit = suit;
		this.Rank = rank;
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
		return rankMap.getString(this.Rank);
	}
	
	public String getSuitString() {
		return suitMap.getString(this.Suit);
	}
	
	public String getCardString() {
		String cardString = rankMap.getString(this.Rank) + " of " + suitMap.getString(this.Suit);
		return cardString;
	}
	
	public String getCardImageFile() {
		String cardKey = "";
		
		switch(this.Rank) {
			case 0  : cardKey = "a";
					  break;
			case 10 : cardKey = "j";
					  break;
			case 11 : cardKey = "q";
					  break;
			case 12 : cardKey = "k";
					  break;
			default : cardKey = String.valueOf(this.Rank + 1);
					  break;
		}
		
		switch(this.Suit) {
			case 0 : cardKey = "images/" + cardKey + "s.gif";
					 break;
			case 1 : cardKey = "images/" + cardKey + "c.gif";
					 break;
			case 2 : cardKey = "images/" + cardKey + "d.gif";
					 break;
			case 3 : cardKey = "images/" + cardKey + "h.gif";
					 break;
			default : cardKey = "images/b.gif";
					  break;
		}
		
		return cardKey;
	}
}
