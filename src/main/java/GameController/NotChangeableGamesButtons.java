package GameController;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;


public class NotChangeableGamesButtons implements ControlTheGamesButtons{
	
	public void controlTheButtons(Object source, GamesModel model, View view,  Player p1, int allRounds, JButton[] gamesButtons){		
	
		model.gamesModel.ChoiceOfTheFirstPlayer(((AbstractButton) source).getText(),model.p1);
		model.whichPlayer = !model.whichPlayer;
		model.gamesModel.Judge(model.p1,model.p2,model.wygrana,model.przegrana,model.gamesModel.setRand(model.p1,model.p2));
		model.whichPlayer = !model.whichPlayer;
		model.roundFunction();
	}

	public void NewGameFunction(JButton[] gamesButtons) {
		// TODO Auto-generated method stub
		
	}
	
}
