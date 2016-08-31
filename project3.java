import java.awt.Color;
import java.awt.Container;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

public class project3 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("EgyptianRatScrew-ShreyaPatel-CS338");
		frame.setSize(1200, 700);
		Game_View gui = new Game_View();
		
		Container contents = gui.CreateGUI();
		((JComponent) contents).setBorder(new EmptyBorder(6,6,6,6));
		//contents.setFocusable(true);
		frame.getContentPane().add(contents);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
