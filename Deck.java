/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.util.*;

public class Deck {

    // properties
    private List<Card> cards;
    int NumOfCards;

    // constructor
    public Deck(int numOfCards) {
    	if (numOfCards != 0)
    	{
    		NumOfCards = numOfCards - 1; // to account for the 0 in the beginning
    	}
    	
    	// start an empty deck
    	cards = new ArrayList<Card>(Collections.nCopies(52, null));
    	
    	// add 52 cards to the deck
    	if (NumOfCards == 51)
    	{
	        for (int s=0; s<=3; s++)
	        {
	        	for (int r=0; r<=12; r++)
	            {
	               cards.add(new Card(s,r));
	            }
	        }
    	}
    }
    
    // methods
    public Card DrawCardFromDeck() {
    	// get a random card
    	Random random = new Random();
        int index=0;

        do {
            index = random.nextInt();
        } while (cards.get(index) == null);

        // take the random card out of the deck
        Card drawThis = cards.get(index);
        cards.set(index, null);
        NumOfCards = NumOfCards - 1;
        return drawThis;
    }
    
    public void PutCardInDeck(Card putThisBack) {
    	Random random = new Random();
    	int index = 0;
    	
    	do {
    		index = random.nextInt(NumOfCards);
    	} while(cards.get(index) != null);
    	
    	// put the card back into a random place in the deck, where there was a null spot
    	cards.set(index, putThisBack);
    	NumOfCards = NumOfCards + 1;
    }
}
