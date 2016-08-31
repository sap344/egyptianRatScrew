///*
//* Shreya Patel
//* sap344@drexel.edu
//* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
//*/
//
//import java.io.Console;
//import java.util.*;
//
//public class Game {
//	
////	// properties
////	private static Deck middlePile = new Deck(52);
////	private static Deck user1Pile = new Deck(0);
////	private static Deck user2Pile = new Deck(0);
////	private static List<Card> slapRuleTracker = new ArrayList<Card>();
////	
////	// constructor
////	public Game() {
////		
////		// -- put 26 shuffled cards into the user1's pile
////		for (int i = 0; i< 26; i++)
////		{
////			Card c = middlePile.DrawCardFromDeck();
////			user1Pile.AddToNewDeck(c);
////		}
////		// -- put the other shuffled 26 in user2's pile
////		for (int i = 0; i< 26; i++)
////		{
////			Card c = middlePile.DrawCardFromDeck();
////			user2Pile.AddToNewDeck(c);
////		}
////	}
////	
////	// methods
////	public Card User_1_FlipsCard() {
////		Card flippedCard = user1Pile.DrawCardFromDeck();
////		return flippedCard;
////	}
////	
////	public Card User_2_FlipsCard() {
////		Card flippedCard = user2Pile.DrawCardFromDeck();
////		return flippedCard;
////	}
////	
////	public void User_1_SlapsPile() {
////		// is called when the user hit his/her slap key
////		// if valid slapRule give the slapper the middle pile, else give the opponent the middle pile
////		if (checkSlapRule())
////		{
////			int total = middlePile.GetNumberOfCardsInDeck();
////			int n = 0;
////			for (; n <= total; n++)
////			{
////				Card c = middlePile.DrawCardFromDeck();
////				user1Pile.PutCardInDeck(c);
////			}
////		}
////		else
////		{
////			int total = middlePile.GetNumberOfCardsInDeck();
////			int n = 0;
////			for (; n <= total; n++)
////			{
////				Card c = middlePile.DrawCardFromDeck();
////				user2Pile.PutCardInDeck(c);
////			}
////		}
////	}
////	
////	public void User_2_SlapsPile() {
////		// is called when the user hit his/her slap key
////		// if valid slapRule give the slapper the middle pile, else give the opponent the middle pile
////		if (checkSlapRule())
////		{
////			int total = middlePile.GetNumberOfCardsInDeck();
////			int n = 0;
////			for (; n <= total; n++)
////			{
////				Card c = middlePile.DrawCardFromDeck();
////				user2Pile.PutCardInDeck(c);
////			}
////		}
////		else
////		{
////			int total = middlePile.GetNumberOfCardsInDeck();
////			int n = 0;
////			for (; n <= total; n++)
////			{
////				Card c = middlePile.DrawCardFromDeck();
////				user1Pile.PutCardInDeck(c);
////			}
////		}
////	}
////	
////	public void NewGame() {
////		// reset all decks and call constructor again to distribute cards
////		user1Pile = new Deck(0);
////		user2Pile = new Deck(0);
////		middlePile = new Deck(52);
////		new Game(); // CHECK THIS and make sure its okay
////	}
////	
////	public String EndGame() {
////		String winner = "";
////		int user1Pts = calculatePoints(user1Pile);
////		int user2Pts = calculatePoints(user2Pile);
////		
////		if (user1Pts > user2Pts)
////		{
////			winner = "User1 wins!";
////		}
////		else if (user1Pts < user2Pts)
////		{
////			winner = "User2 wins!";
////		}
////		else
////		{
////			winner = "Tie!";
////		}
////		
////		return winner;
////	}
////	
////	private boolean checkSlapRule() {
////		boolean isSlapperValid = true; // give the slapper the middle pile
////
////		return isSlapperValid;
////	}
////	
////	private int calculatePoints(Deck countThisPile) {
////		int points = 0;
////		
////		return points;
////	}
////	
////	private void p(String print) {
////		System.out.println(print);
////	}
//}
