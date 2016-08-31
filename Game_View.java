/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;

public class Game_View {
	
	private JPanel TopPanel  = new JPanel();
	private JPanel LeftPanel = new JPanel();
	private JPanel CenterPanel = new JPanel();
	private JPanel RightPanel = new JPanel();
	private JPanel BottomPanel = new JPanel();
	private Color backGroundColor = new Color(40,102,10);
	private JLabel GameTitle = new JLabel("Egyptian Rat Screw");
	private JLabel GameSubTitle = new JLabel("Slap your way to a win!");
	private JLabel LeadLabel = new JLabel();
	private JLabel CenterLabel = new JLabel();
	private JButton NewGameButton = new JButton("New Game");
	private JButton EndGameButton = new JButton("End Game");
	private JButton HelpButton = new JButton("Help");
	private ImageIcon centerCard = new ImageIcon();
	private ImageIcon deck_left = new ImageIcon("images/deck_left.gif");
	private ImageIcon deck_right = new ImageIcon("images/deck_right.gif");
	private JLabel deck_left_label = new JLabel();
	private JLabel deck_right_label = new JLabel();
	private JLabel user1Label = new JLabel();
	private JLabel user2Label = new JLabel();
	private JPanel gamePanel = new JPanel(new BorderLayout());
	
	// creates the entire panel
	protected Container CreateGUI() {
		gamePanel.setFocusable(true);
		SetupTopPanel();
		SetupLeftPanel();
		SetupCenterPanel();
		SetupRightPanel();
		SetupBottomPanel();
		
		gamePanel.add(TopPanel, BorderLayout.NORTH);
		gamePanel.add(LeftPanel, BorderLayout.WEST);
		gamePanel.add(CenterPanel, BorderLayout.CENTER);
		gamePanel.add(RightPanel, BorderLayout.EAST);
		gamePanel.add(BottomPanel, BorderLayout.SOUTH);
		
		gamePanel.setBackground(backGroundColor);
		gamePanel.addKeyListener(new FrameKeyListener());
		
		return gamePanel;
	}

	// actions
	public void FlipCard(String imageFile) {
		this.centerCard = new ImageIcon(imageFile);
		this.CenterLabel.setText("");
		this.CenterLabel.setBorder(BorderFactory.createLineBorder(new Color(88,44,44), 8));
		this.CenterLabel.setBackground(new Color(30,53,18));
		this.CenterLabel.setIcon(centerCard);
		this.user1Label.setText("User1: " + user1Pile.GetNumberOfCardsInDeck());
		this.user2Label.setText("User2: " + user2Pile.GetNumberOfCardsInDeck());
		this.LeadLabel.setFont(new Font("HanziPen TC", Font.BOLD, 20));
		this.LeadLabel.setText(whoIsLeading());
	}
	
	public void NewGameView() {
		this.deck_left_label.setIcon(deck_left);
		this.deck_right_label.setIcon(deck_right);
		this.CenterLabel.setForeground(new Color(30,53,18));
		this.CenterLabel.setBackground(Color.WHITE);
		this.CenterLabel.setText("User1 goes first - press 'a' to flip a card.");
	}
	
	public void EndGameView(String winner) {
		this.CenterLabel.setIcon(null);
		this.CenterLabel.setForeground(Color.WHITE);
		this.CenterLabel.setText(winner);
	}
	
	public void SlapPile() {
		this.centerCard = new ImageIcon("images/hand.gif");
		this.CenterLabel.setIcon(centerCard);
	}
	
	// listener classes
	public class NewGameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			NewGame();
			NewGameView();
			gamePanel.grabFocus();
		}
	 }
	 
	 public class EndGameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String winner = EndGame();
			EndGameView(winner);
		}
	 }
	 
	 public class HelpListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 String howTo = String.format("%s\n%s\n%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t\t%s\n\t\t%s\n\n%s\n%ss ", 
						"This application provides any user with a fun and exciting card game! Two players can play at a time on 1 keyboard.",
						"Each player just needs to use 2 keys - one for flipping over a card from their stack, and the other for slapping the pile in the middle.",
						"The point of the game is to get all the cards in the deck by slapping the middle pile. The rules are as follows:",
						"• The game begins user 1 flipping over the first card, the user keeps flipping until he/she flips over an Ace, King, Queen, or a Jack (A/K/Q/J).",
						"• Let’s say User1 flips over an A,then User2 has 4flips/chances to flip over another A/K/Q/J. If User2 flips over a Q in their second chance, then the turn moves to User1, who now has 2 chances to get an A/K/Q/J. This goes back an forth.",
						"• Once a user takes up all the chances he/she has for that turn and still has not flipped over an A/K/Q/J, then the other user gets the middle pile.",
						"• The fun part of the game are the two slapping rules, where you can slap the pile to take it if one of these rules are followed:",
						"– Double: when two of the same value cards (ex. 5, 5) are flipped over consecutively",
						"– Sandwich: when two two cards of equivalent value are laid down consecutively, but with one card of different value between them (ex. 4,7,4)",
						"The user1 keys are as follows: flip = ‘a’ | slap = ’s’",
						"The user2 keys are as follows: flip = ‘;’ | slap = ‘’’");
			 JTextArea jta = new JTextArea(howTo);
			 jta.setEditable(false);
	         JScrollPane jsp = new JScrollPane(jta);
	         jsp.setPreferredSize(new Dimension(1200, 300));
			 JOptionPane.showMessageDialog(gamePanel,
					    jsp,
					    "How To Play",
					    JOptionPane.PLAIN_MESSAGE);

		}
	 }
	 
	 public class FrameKeyListener implements KeyListener{
			
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == 'a') // user1 flips card (key: a)
			{
				if (CurrentPlayer.equals("user1"))
				{
					Card flippedCard = User_1_FlipsCard();
					FlipCard(flippedCard.getCardImageFile());
					CheckFlippedCardAndUpdateTurns(flippedCard);
				}
				else
				{
					LeadLabel.setText("Not your turn User1!");
				}
			}
			else if (e.getKeyChar() == 's') // user1 slaps pile (key: s)
			{
				User_1_SlapsPile();
				SlapPile();
			}
			else if (e.getKeyChar() == ';') // user2 flips card (key: ;)
			{
				if (CurrentPlayer.equals("user2"))
				{
					Card flippedCard = User_2_FlipsCard();
					FlipCard(flippedCard.getCardImageFile());
					CheckFlippedCardAndUpdateTurns(flippedCard);
				}
				else
				{
					LeadLabel.setText("Not your turn User2!");
				}
			}
			else if (e.getKeyChar() == '\'') // user2 slaps pile (key: ')
			{
				User_2_SlapsPile();
				SlapPile();
			}
			else
			{
				// do nothing
			}
		}

		public void keyPressed(KeyEvent e) { }

		public void keyReleased(KeyEvent e) { }
	}
	
	// set view component settings
	void SetupTopPanel() {
		TopPanel.setLayout(new BorderLayout());
		TopPanel.setBackground(backGroundColor);
		TopPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		//---
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
		titlePanel.setBackground(backGroundColor);
		
		GameTitle.setFont(new Font("HanziPen TC", Font.BOLD, 80));
		GameTitle.setForeground(Color.WHITE);
		
		GameSubTitle.setFont(new Font("HanziPen TC", Font.BOLD, 50));
		GameSubTitle.setForeground(Color.WHITE);
		
		titlePanel.add(GameTitle);
		titlePanel.add(GameSubTitle);
		
		//---
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBackground(backGroundColor);
		Border empty = new EmptyBorder (0,20,20,160);
		buttonPanel.setBorder(empty);
		
		JPanel newGameButtonPanel = new JPanel(); // this is only to keep my preferred button size
		newGameButtonPanel.setBackground(backGroundColor);
		NewGameButton.setPreferredSize(new Dimension(120,60));
		NewGameButton.setFont(new Font("HanziPen TC", Font.BOLD, 20));
		NewGameButton.setForeground(new Color(40,102,10));
		NewGameButton.addActionListener(new NewGameListener());
		newGameButtonPanel.add(NewGameButton);
		
		JPanel endGameButtonPanel = new JPanel();
		endGameButtonPanel.setBackground(backGroundColor);
		EndGameButton.setPreferredSize(new Dimension(120,60));
		EndGameButton.setFont(new Font("HanziPen TC", Font.BOLD, 20));
		EndGameButton.setForeground(new Color(40,102,10));
		EndGameButton.addActionListener(new EndGameListener());
		endGameButtonPanel.add(EndGameButton);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
		buttonPanel.add(newGameButtonPanel);
		buttonPanel.add(Box.createRigidArea(new Dimension(0,30)));
		buttonPanel.add(endGameButtonPanel);
		
		//---
		
		TopPanel.add(titlePanel, BorderLayout.CENTER);
		TopPanel.add(buttonPanel, BorderLayout.WEST);
	}
	
	void SetupLeftPanel() {
		LeftPanel.setLayout(new BorderLayout());
		LeftPanel.setBackground(backGroundColor);
		LeftPanel.setBorder(new EmptyBorder(0,150,0,50));
		
		//---
		user1Label.setText("User1");
		user1Label.setFont(new Font("HanziPen TC", Font.BOLD, 40));
		user1Label.setForeground(Color.WHITE);
		user1Label.setBorder(new EmptyBorder(10,0,0,0));
		
		//---
		
		LeftPanel.add(user1Label, BorderLayout.NORTH);
		LeftPanel.add(deck_left_label, BorderLayout.CENTER);
	}
	
	void SetupCenterPanel() {
		CenterPanel.setLayout(new BorderLayout());
		CenterPanel.setBackground(backGroundColor);
		
		//---
		LeadLabel.setFont(new Font("HanziPen TC", Font.BOLD, 40));
		LeadLabel.setForeground(Color.WHITE);
		LeadLabel.setBorder(new EmptyBorder(10,0,0,0));
		LeadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//CenterLabel.setIcon(centerCard);
		CenterLabel.setText("Click the [New Game] button to begin!");
		CenterLabel.setFont(new Font("HanziPen TC", Font.BOLD, 30));
		CenterLabel.setForeground(new Color(30,53,18));
		CenterLabel.setBackground(Color.WHITE);
		CenterLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 8));
		CenterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CenterLabel.setOpaque(true);
		
		//---
		CenterPanel.add(LeadLabel, BorderLayout.SOUTH);
		CenterPanel.add(CenterLabel, BorderLayout.CENTER);
	}
	
	void SetupRightPanel() {
		RightPanel.setLayout(new BorderLayout());
		RightPanel.setBackground(backGroundColor);
		RightPanel.setBorder(new EmptyBorder(0,50,0,150));
		
		//---
		user2Label.setText("User2");
		user2Label.setFont(new Font("HanziPen TC", Font.BOLD, 40));
		user2Label.setForeground(Color.WHITE);
		user2Label.setBorder(new EmptyBorder(10,0,0,0));
		
		//---
		
		RightPanel.add(user2Label, BorderLayout.NORTH);
		RightPanel.add(deck_right_label, BorderLayout.CENTER);
	}
	
	void SetupBottomPanel() {
		BottomPanel.setLayout(new BorderLayout());
		BottomPanel.setBackground(backGroundColor);
		
		//---
		JPanel helpPanel = new JPanel();
		helpPanel.setBorder(new EmptyBorder(0,10,10,0));
		helpPanel.setBackground(backGroundColor);
		HelpButton.setPreferredSize(new Dimension(70,40));
		HelpButton.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		HelpButton.setForeground(new Color(40,102,10));
		HelpButton.addActionListener(new HelpListener());
		helpPanel.add(HelpButton);

		//---
		
		BottomPanel.add(helpPanel, BorderLayout.WEST);
	}
	
	
	
	
	//======================================================================
	//======================================================================
	//======================================================================
	
	
	
	
	// properties
		private static Deck middlePile = new Deck(52);
		private static Deck user1Pile = new Deck(0);
		private static Deck user2Pile = new Deck(0);
		private static List<Card> CardTracker = new ArrayList<Card>();
		private static int NumOfTurns;
		private static String CurrentPlayer;
		private static boolean isFirstTurn;
		
		
		public void StartGame() {
			
			// -- put 26 shuffled cards into the user1's pile
			for (int i = 0; i< 26; i++)
			{
				Card c = middlePile.DrawCardFromDeck();
				//user1Pile.AddToNewDeck(c);
				user1Pile.PutCardInDeck(c);
			}
			// -- put the other shuffled 26 in user2's pile
			for (int i = 0; i< 26; i++)
			{
				Card c = middlePile.DrawCardFromDeck();
				//user2Pile.AddToNewDeck(c);
				user2Pile.PutCardInDeck(c);
			}
			
			// user1 always goes first
			CurrentPlayer = "user1";
			isFirstTurn = true;
		}
		
		// methods
		public Card User_1_FlipsCard() {
			Card flippedCard = user1Pile.DrawCardFromDeck();
			middlePile.PutCardInDeck(flippedCard);
			CardTracker.add(flippedCard);
			return flippedCard;
		}
		
		public Card User_2_FlipsCard() {
			Card flippedCard = user2Pile.DrawCardFromDeck();
			middlePile.PutCardInDeck(flippedCard);
			CardTracker.add(flippedCard);
			return flippedCard;
		}
		
		public void CheckFlippedCardAndUpdateTurns(Card flippedCard) {
			int rank = flippedCard.getRank();
			if (isFirstTurn && (rank != 0 || rank != 12 || rank != 11 || rank != 10))
			{
				SwitchPlayers();
				isFirstTurn = false;
			}
			else
			{
				isFirstTurn = false;
				if (rank == 0)
				{
					// if card is an Ace
					NumOfTurns = 4;
					SwitchPlayers();
				}
				else if (rank == 12)
				{
					// if card is a King
					NumOfTurns = 3;
					SwitchPlayers();
				}
				else if (rank == 11)
				{
					// if card is a Queen
					NumOfTurns = 2;
					SwitchPlayers();
				}
				else if (rank == 10)
				{
					// if card is a Jack
					NumOfTurns = 1;
					SwitchPlayers();
				}
				else
				{
					// if some other card
					NumOfTurns = NumOfTurns - 1;
				}
				
				// if out of turns
				if (NumOfTurns == 0)
				{
					if (CurrentPlayer == "user1") // then user2 gets the pile
					{
						for (int i = 0; i < middlePile.GetNumberOfCardsInDeck() + 1; i++)
						{
							Card c = middlePile.DrawCardFromDeck();
							user2Pile.PutCardInDeck(c);
						}
						
						LeadLabel.setFont(new Font("HanziPen TC", Font.BOLD, 10));
						LeadLabel.setText("You're out of turns - User 2 gets the pile!");
						CurrentPlayer = "user2";
					}
					else // if currentPlayer = user 2, then user 1 gets the pile
					{
						for (int i = 0; i < middlePile.GetNumberOfCardsInDeck() + 1; i++)
						{
							Card c = middlePile.DrawCardFromDeck();
							user1Pile.PutCardInDeck(c);
						}
						
						LeadLabel.setFont(new Font("HanziPen TC", Font.BOLD, 10));
						LeadLabel.setText("You're out of turns - User 1 gets the pile!");
						CurrentPlayer = "user1";
					}
					
					//middlePile.ClearPile();
					CardTracker.clear();
				}
			}
		}
		
		public void SwitchPlayers() {
			String player = CurrentPlayer;
			if (player.equals("user1"))
			{
				CurrentPlayer = "user2";
			}
			else
			{
				CurrentPlayer = "user1";
			}
		}
		
		public void User_1_SlapsPile() {
			// is called when the user hit his/her slap key
			// if valid slapRule give the slapper the middle pile, else give the opponent the middle pile
			if (checkSlapRule())
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				for (int n = 0; n < total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user1Pile.PutCardInDeck(c);
				}
				
				LeadLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				LeadLabel.setText("user1 takes the pile!");
				CurrentPlayer = "user1";
			}
			else
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				for (int n = 0; n < total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user2Pile.PutCardInDeck(c);
				}
				
				LeadLabel.setFont(new Font("HanziPen TC", Font.BOLD, 10));
				LeadLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				LeadLabel.setText("Sorry - invalid Slap --> user2 takes the pile!");
				CurrentPlayer = "user2";
			}
			
			CardTracker.clear();
		}
		
		public void User_2_SlapsPile() {
			// is called when the user hit his/her slap key
			// if valid slapRule give the slapper the middle pile, else give the opponent the middle pile
			if (checkSlapRule())
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				
				for (int n = 0; n < total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user2Pile.PutCardInDeck(c);
				}
				
				LeadLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				LeadLabel.setText("user2 takes the pile!");
				CurrentPlayer = "user2";
			}
			else
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				
				for (int n = 0; n < total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user1Pile.PutCardInDeck(c);
				}
				
				LeadLabel.setFont(new Font("HanziPen TC", Font.BOLD, 10));
				LeadLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				LeadLabel.setText("Sorry - invalid Slap --> user1 takes the pile!");
				CurrentPlayer = "user1";
			}
			
			CardTracker.clear();
		}
		
		public void NewGame() {
			// reset all decks and call constructor again to distribute cards
			user1Pile = new Deck(0);
			user2Pile = new Deck(0);
			middlePile = new Deck(52);
			StartGame(); // CHECK THIS and make sure its okay
		}
		
		public String EndGame() {
			String winner = "";
			int user1Pts = user1Pile.GetNumberOfCardsInDeck();
			int user2Pts = user2Pile.GetNumberOfCardsInDeck();
			
			if (user1Pts > user2Pts)
			{
				winner = "User1 wins!";
			}
			else if (user1Pts < user2Pts)
			{
				winner = "User2 wins!";
			}
			else
			{
				winner = "Tie!";
			}
			
			return winner;
		}
		
		private boolean checkSlapRule() {
			boolean isSlapperValid = false; // give the slapper the middle pile
			int num = middlePile.GetNumberOfCardsInDeck();
			p("middlePile num: " + num);
			p("cardTracker: " + CardTracker.size());
			
			if (num >= 2)
			{
				Card a = CardTracker.get(num-1);
				Card b = CardTracker.get(num-2);
				
				if (a.getRank() == b.getRank())
				{
					isSlapperValid = true;
				}
				else if (num >= 3)
				{
					Card c = CardTracker.get(num-3);
					if (a.getRank() == c.getRank())
					{
						isSlapperValid = true;
					}
				}
				else
				{
					isSlapperValid = false;
				}
			}
			
			return isSlapperValid;
		}
		
		private String whoIsLeading() {
			String lead = "";
			int user1Pts = user1Pile.GetNumberOfCardsInDeck();
			int user2Pts = user2Pile.GetNumberOfCardsInDeck();
			
			if (user1Pts > user2Pts)
			{
				lead = "User1 is leading!";
			}
			else if (user1Pts < user2Pts)
			{
				lead = "User2 is leading!";
			}
			else
			{
				lead = "Both users are tied currently!";
			}
			
			return lead;
		}
		
		private void p(String print) {
			System.out.println(print);
		}
}
