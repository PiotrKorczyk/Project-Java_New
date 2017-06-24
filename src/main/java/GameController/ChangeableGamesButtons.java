package GameController;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import GameModel.GamesModel;
import GameView.View;
import Players.Player;


public class ChangeableGamesButtons implements ControlTheGamesButtons{

	String [] Signatures = new String[9];

	public void NewGameFunction(JButton []gamesButtons){
		resetButtons(gamesButtons);
		UpdateSignaturesOnButtons(gamesButtons);
	}
	
	public String [] UpdateSignaturesOnButtons(JButton[] buttons){
		for(int i =0 ;i<9;i++)
			Signatures[i] = buttons[i].getText();
	
		return Signatures;
	}
		
	public void controlTheButtons( Object choice, GamesModel model, View view,  Player p1, int allRounds, JButton[] gamesButtons) {
			if( ((AbstractButton) choice).getText() == "CLICK"){
			
				
					((AbstractButton) choice).setText(model.gamesModel.setChar(model.whichPlayer));
				model.whichPlayer =!model.whichPlayer;

				if(model.gamesModel.Wins(model.p1, model.p2, model.wygrana, model.przegrana, UpdateSignaturesOnButtons(gamesButtons))){
					resetButtons(gamesButtons);
					UpdateSignaturesOnButtons(gamesButtons);
					model.roundFunction();
				}
			}
	}
	
	private void resetButtons(JButton [] gamesButtons){
		for(int i=0;i<9;i++){
			gamesButtons[i].setText("CLICK");
			gamesButtons[i].repaint();
		}
	}
	
	public void setRandomButton(GamesModel model, JButton[] gamesButtons, String znak){
		gamesButtons[model.gamesModel.CheckRandomButton(Signatures,znak)].setText(znak);
	}


	
}
