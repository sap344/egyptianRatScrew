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
	private JPanel gamePanel = new JPanel(new BorderLayout());
	
	// creates the entire panel
	protected Container CreateGUI() {
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
		
		gamePanel.addKeyListener(new FrameKeyListener());
		
		return gamePanel;
	}

	// actions
	public void FlipCard(String imageFile) {
		this.centerCard = new ImageIcon(imageFile);
		this.CenterLabel.setText("");
		this.CenterLabel.setBorder(BorderFactory.createLineBorder(new Color(88,44,44), 8));
		this.CenterLabel.setBackground(new Color(30,53,18));
		this.CenterLabel.setOpaque(true);
		this.CenterLabel.setIcon(centerCard);
		this.LeadLabel.setText(imageFile);
	}
	
	public void NewGameView() {
		this.deck_left_label.setIcon(deck_left);
		this.deck_right_label.setIcon(deck_right);
		this.CenterLabel.setText("User1 goes first - press 'a' to flip a card.");
	}
	
	public void EndGameView(String winner) {
		this.CenterLabel.setIcon(null);
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
	 
	 public class FrameKeyListener implements KeyListener{
			
		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == 'a') // user1 flips card (key: a)
			{
				Card flippedCard = User_1_FlipsCard();
				FlipCard(flippedCard.getCardImageFile());
			}
			else if (e.getKeyChar() == 's') // user1 slaps pile (key: s)
			{
				User_1_SlapsPile();
				SlapPile();
			}
			else if (e.getKeyChar() == ';') // user2 flips card (key: ;)
			{
				Card flippedCard = User_2_FlipsCard();
				FlipCard(flippedCard.getCardImageFile());
			}
			else if (e.getKeyChar() == '\'') // user2 slaps pile (key: ')
			{
				User_2_SlapsPile();
				SlapPile();
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
		JLabel user1Label = new JLabel("User 1");
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
		JLabel user2Label = new JLabel("User 2");
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
		private static List<Card> slapRuleTracker = new ArrayList<Card>();
		
		
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
		}
		
		// methods
		public Card User_1_FlipsCard() {
			Card flippedCard = user1Pile.DrawCardFromDeck();
			middlePile.PutCardInDeck(flippedCard);
			return flippedCard;
		}
		
		public Card User_2_FlipsCard() {
			Card flippedCard = user2Pile.DrawCardFromDeck();
			middlePile.PutCardInDeck(flippedCard);
			return flippedCard;
		}
		
		public void User_1_SlapsPile() {
			// is called when the user hit his/her slap key
			// if valid slapRule give the slapper the middle pile, else give the opponent the middle pile
			if (checkSlapRule())
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				p("middlePile: " + total);
				p("user1 before: " + user1Pile.GetNumberOfCardsInDeck());
				int n = 0;
				for (; n <= total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user1Pile.PutCardInDeck(c);
				}
				
				p("user1 #of cards: " + user1Pile.GetNumberOfCardsInDeck());
			}
			else
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				p("middlePile: " + total);
				p("user2 before: " + user2Pile.GetNumberOfCardsInDeck());
				int n = 0;
				for (; n <= total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user2Pile.PutCardInDeck(c);
				}
				
				p("user2 #of cards: " + user2Pile.GetNumberOfCardsInDeck());
			}
		}
		
		public void User_2_SlapsPile() {
			// is called when the user hit his/her slap key
			// if valid slapRule give the slapper the middle pile, else give the opponent the middle pile
			if (checkSlapRule())
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				int n = 0;
				for (; n <= total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user2Pile.PutCardInDeck(c);
				}
			}
			else
			{
				int total = middlePile.GetNumberOfCardsInDeck();
				int n = 0;
				for (; n <= total; n++)
				{
					Card c = middlePile.DrawCardFromDeck();
					user1Pile.PutCardInDeck(c);
				}
			}
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
			int user1Pts = calculatePoints(user1Pile);
			int user2Pts = calculatePoints(user2Pile);
			
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

			return isSlapperValid;
		}
		
		private int calculatePoints(Deck countThisPile) {
			int points = 0;
			
			return points;
		}
		
		private void p(String print) {
			System.out.println(print);
		}
}
