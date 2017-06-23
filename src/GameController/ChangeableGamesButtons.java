package GameController;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

import javax.swing.*;

public class ChangeableGamesButtons implements ControlTheGamesButtons {

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
		
	public void controlTheButtons(Object choice, GamesModel model, View view, Timer timer, Player p1, int allRounds, JButton[] gamesButtons) {
			if( ((AbstractButton) choice).getText() == "CLICK"){
				if(timer.GameOver)
					EndOfTime(model, timer, p1, allRounds, UpdateSignaturesOnButtons(gamesButtons), model.gamesModel.setChar(model.whichPlayer), gamesButtons);					

				else
					((AbstractButton) choice).setText(model.gamesModel.setChar(model.whichPlayer));
				model.whichPlayer =!model.whichPlayer;
				view.setLed(model.whichPlayer);
				model.StartTimerFunc(timer, p1.timeLimit, allRounds);
				if(model.gamesModel.Wins(model.p1, model.p2, model.wygrana, model.przegrana, UpdateSignaturesOnButtons(gamesButtons))){
					resetButtons(gamesButtons);
					UpdateSignaturesOnButtons(gamesButtons);
					model.roundFunction();
					view.printRound(model.round);
					view.printScore(model.p1.punkty, model.p2.punkty);
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
	public void EndOfTime(GamesModel model, Timer timer, Player p1, int allRounds, String[] Sigantures, String znak, JButton[] gamesButtons){
		setRandomButton(model, gamesButtons, znak);
		model.gamesModel.EndOfTime(timer);
	}

	
}
