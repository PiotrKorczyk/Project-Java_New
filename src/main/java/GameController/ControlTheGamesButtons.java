package GameController;

import javax.swing.JButton;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;

public interface ControlTheGamesButtons {
	
	public void controlTheButtons(Object source, GamesModel model, View view, Player p1, int allRounds, JButton[] gamesButtons);
	public void NewGameFunction(JButton[] gamesButtons);
}
