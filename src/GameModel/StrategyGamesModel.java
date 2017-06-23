package GameModel;

import Players.Player;
import Threads.Timer;

public interface StrategyGamesModel{
	public int ChoiceOfTheFirstPlayer(String choice, Player p1);
	public int Random(Player p1, Player p2, int n, int ktoLosuje);
	public String Judge(Player p1, Player p2, int wygrana, int przegrana, int randomChoice);
	public String setChar(boolean whichPlayer);
	public boolean Wins(Player p1, Player p2, int wygrana, int przegrana, String[] Signatures);
	public boolean EndOfTime(Timer timer);
	public int CheckRandomButton(String[] Signatures, String znak);
	public int setRand(Player p1, Player p2);
}
