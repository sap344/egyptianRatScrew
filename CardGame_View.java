/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CardGame_View extends JFrame {
	
	private JPanel TopPanel  = new JPanel();
	private JPanel LeftPanel = new JPanel();
	private JPanel CenterPanel = new JPanel();
	private JPanel RightPanel = new JPanel();
	private JPanel BottomPanel = new JPanel();
	private Color backGroundColor = new Color(40,102,10);
	private JLabel GameTitle = new JLabel("Egyptian Rat Screw");
	private JLabel GameSubTitle = new JLabel("Slap your way to a win!");
	private JLabel LeadLabel = new JLabel("-");
	private JButton NewGameButton = new JButton("New Game");
	private JButton EndGameButton = new JButton("End Game");
	private JButton HelpButton = new JButton("Help");
	private ImageIcon centerCard = new ImageIcon("images/b.gif");
	
	CardGame_View() {
		JPanel gamePanel = new JPanel(new BorderLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setTitle("EgyptianRatScrew-ShreyaPatel-CS338");
		
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
		
		Container contents = gamePanel;
		contents.setBackground(new Color(40,102,10));
		this.getContentPane().add(contents);
		//this.setVisible(true);
	}
	
	// actions
	public void FlipCard(String imageFile) {
		centerCard = new ImageIcon(imageFile);
	}
	
	// add action listeners
	void addNewGameListener(ActionListener listenerForNewGameButton) {
		NewGameButton.addActionListener(listenerForNewGameButton);
	}
	
	void addEndGameListener(ActionListener listenerForEndGameButton) {
		EndGameButton.addActionListener(listenerForEndGameButton);
	}
	
	void addUser1SlapKeyListener(KeyListener listenerForUser1Slap) {
		this.addKeyListener(listenerForUser1Slap);
	}
	
	void addUser2SlapKeyListener(KeyListener listenerForUser2Slap) {
		this.addKeyListener(listenerForUser2Slap);
	}
	
	void addUser1FlipCardKeyListener(KeyListener listenerForUser1FlipCard) {
		this.addKeyListener(listenerForUser1FlipCard);
	}
	
	void addUser2FlipCardKeyListener(KeyListener listenerForUser2FlipCard) {
		this.addKeyListener(listenerForUser2FlipCard);
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
		newGameButtonPanel.add(NewGameButton);
		
		EndGameButton.setPreferredSize(new Dimension(120,60));
		EndGameButton.setFont(new Font("HanziPen TC", Font.BOLD, 20));
		EndGameButton.setForeground(new Color(40,102,10));
		EndGameButton.setAlignmentX(CENTER_ALIGNMENT);
		
		buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
		buttonPanel.add(newGameButtonPanel);
		buttonPanel.add(Box.createRigidArea(new Dimension(0,30)));
		buttonPanel.add(EndGameButton);
		
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
		
		ImageIcon deck_left = new ImageIcon("images/deck_left.gif");
		
		//---
		
		LeftPanel.add(user1Label, BorderLayout.NORTH);
		LeftPanel.add(new JLabel(deck_left), BorderLayout.CENTER);
	}
	
	void SetupCenterPanel() {
		CenterPanel.setLayout(new BorderLayout());
		CenterPanel.setBackground(backGroundColor);
		
		//---
		LeadLabel.setFont(new Font("HanziPen TC", Font.BOLD, 40));
		LeadLabel.setForeground(Color.WHITE);
		LeadLabel.setBorder(new EmptyBorder(10,0,0,0));
		LeadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//---
		CenterPanel.add(LeadLabel, BorderLayout.SOUTH);
		CenterPanel.add(new JLabel(centerCard), BorderLayout.CENTER);
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
		
		ImageIcon deck_right = new ImageIcon("images/deck_right.gif");
		
		//---
		
		RightPanel.add(user2Label, BorderLayout.NORTH);
		RightPanel.add(new JLabel(deck_right), BorderLayout.CENTER);
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
}
