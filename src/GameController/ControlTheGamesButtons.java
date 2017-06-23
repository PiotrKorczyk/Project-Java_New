package GameController;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

import javax.swing.*;

public interface ControlTheGamesButtons {
	
	public void controlTheButtons(Object source, GamesModel model, View view, Timer timer, Player p1, int allRounds, JButton[] gamesButtons);
	public void NewGameFunction(JButton[] gamesButtons);
}
