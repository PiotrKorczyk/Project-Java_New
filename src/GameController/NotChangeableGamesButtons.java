package GameController;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

import javax.swing.*;

public class NotChangeableGamesButtons implements ControlTheGamesButtons {
	
	public void controlTheButtons(Object source, GamesModel model, View view, Timer timer, Player p1, int allRounds, JButton[] gamesButtons){
	
		model.gamesModel.ChoiceOfTheFirstPlayer(((AbstractButton) source).getText(),model.p1);
		model.whichPlayer = !model.whichPlayer;
		view.setLed(model.whichPlayer);
		model.EndOfTime(timer, p1, allRounds);
		
		model.gamesModel.Judge(model.p1,model.p2,model.wygrana,model.przegrana,model.gamesModel.setRand(model.p1,model.p2));
		model.whichPlayer = !model.whichPlayer;
		view.setLed(model.whichPlayer);
		model.StartTimerFunc(timer, p1.timeLimit, allRounds);
			
		model.roundFunction();
		view.printRound(model.round);
		view.printScore(model.p1.punkty,model.p2.punkty);
	}

	public void NewGameFunction(JButton[] gamesButtons) {
		// TODO Auto-generated method stub
		
	}
	
}
