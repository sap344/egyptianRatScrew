/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.awt.event.*;

public class CardGame_ViewController {
	
	 private CardGame_View view;
	 private Game model;
	 
	 public CardGame_ViewController(CardGame_View _view, Game _model) {
		 this.view = _view;
		 this.model = _model;
		 
		 // match up listeners
		 this.view.addNewGameListener(new NewGameListener());
		 this.view.addEndGameListener(new EndGameListener());
		 this.view.addUser1SlapKeyListener(new User1SlapKeyListener());
		 this.view.addUser2SlapKeyListener(new User2SlapKeyListener());
		 this.view.addUser1FlipCardKeyListener(new User1FlipCardKeyListener());
		 this.view.addUser2FlipCardKeyListener(new User2FlipCardKeyListener());
	 }
	 
	 // listener implementations
	 class NewGameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			model.NewGame();
			// call view method - reset the decks on screen
		}
	 }
	 
	 class EndGameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			model.EndGame();
			// call view method - announce winner
		}
	 }
	 
	 class User1SlapKeyListener implements KeyListener{

		public void keyTyped(KeyEvent e) {
			model.User_1_SlapsPile();
			// call view method - slap hand from user 1 side
		}

		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) { }
		 
	 }
	 
	 class User2SlapKeyListener implements KeyListener{

			public void keyTyped(KeyEvent e) {
				model.User_2_SlapsPile();
				// call view method - slap hand from user 2 side
			}

			public void keyPressed(KeyEvent e) { }

			public void keyReleased(KeyEvent e) { }
			 
	 }
	 
	 class User1FlipCardKeyListener implements KeyListener{

			public void keyTyped(KeyEvent e) {
				// if user1 key code is typed..
					Card flippedCard = model.User_1_FlipsCard();
					// call view method - show new card in middle pile
					view.FlipCard(flippedCard.getCardImageFile());
			}

			public void keyPressed(KeyEvent e) { }

			public void keyReleased(KeyEvent e) { }
			 
	 }
	 
	 class User2FlipCardKeyListener implements KeyListener{

			public void keyTyped(KeyEvent e) {
				// if user2 key code is typed..
					Card flippedCard = model.User_2_FlipsCard();
					// call view method - show new card in middle pile
					view.FlipCard(flippedCard.getCardImageFile());
			}

			public void keyPressed(KeyEvent e) { }

			public void keyReleased(KeyEvent e) { }
			 
	 }
}
