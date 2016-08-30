/*
* Shreya Patel
* sap344@drexel.edu
* CS338:GUI, Project 3 - Egyptian Rat Screw Card Game
*/

public class project3 {
	
	public static void main(String[] args) {
		CardGame_View view = new CardGame_View();
		Game model = new Game();
		CardGame_ViewController viewController = new CardGame_ViewController(view,model);
		
		view.setVisible(true);
	}
}
