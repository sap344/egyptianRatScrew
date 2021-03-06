/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.util.*;

public class Deck {

    // properties
    private final List<Card> cards;
    private int numCards;
    private int NumOfCards;

    // constructor
    public Deck(int num) {
    	if (num != 0)
    	{
    		numCards = num - 1; // to account for the 0 in the beginning
	    	this.cards = new ArrayList<Card>(52);
    		//this.cards = new Card[52];
	    	// add 52 cards to the deck
	    	if (numCards == 51)
	    	{
		        for (int s=0; s<=3; s++)
		        {
		        	for (int r=0; r<=12; r++)
		            {
		        	   Card addThisCard = new Card(s,r);
		               this.cards.add(addThisCard);
		               NumOfCards = NumOfCards + 1;
		            }
		        }
	    	}
    	}
    	else
    	{
    		// start an empty deck
    		this.cards = new ArrayList<Card>(52);
    		int i;
    		for (i = 0; i < 52; i++)
    		{
    			this.cards.add(null);
    		}
    		
    		numCards = 0;
    		NumOfCards = 0;
    	}
    }
    
    // methods
    public Card DrawCardFromDeck() {
    	// get a random card
    	Random random = new Random();
        int index=0;
        
        do {
            index = random.nextInt(52);
        } while (this.cards.get(index) == null);

        // take the random card out of the deck
        Card drawThis = this.cards.get(index);
        this.cards.set(index, null);
        numCards = numCards - 1;
        NumOfCards = NumOfCards - 1;
        return drawThis;
    }
    
    
    public void PutCardInDeck(Card putThisInDeck) {
    	Random random = new Random();
    	int index = 0;
    	
    	do {
    		index = random.nextInt(52);
    	} while(cards.get(index) != null);
    	
    	// put the card back into a random place in the deck, where there was a null spot
    	this.cards.set(index, putThisInDeck);
    	numCards = numCards + 1;
    	NumOfCards = NumOfCards + 1;
    }
    
//    public void AddToNewDeck(Card addThisCard) {
//    	this.cards.add(addThisCard);
//    	numCards = numCards + 1;
//    }
    
    public int GetNumberOfCardsInDeck() {
    	return NumOfCards;
    }
    
    public void ClearPile() {
    	this.cards.clear();
    }
}
