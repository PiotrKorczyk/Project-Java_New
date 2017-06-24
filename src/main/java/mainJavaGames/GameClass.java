package mainJavaGames;

import GameController.GamesController;
import GameModel.GamesModel;
import GameView.View;
import Players.Player;

public class GameClass{
	View view=null;
	GamesController controller = null;
	GamesModel model = null;
	Menu menu = null;
	public GameClass(Player p1, Player p2, int gra, int round){

		if(gra !=5){
			view = new View(gra);
			model = new GamesModel(p1, p2, round, gra);
			controller = new GamesController(model, view, gra);
		}else
			menu = new Menu();


		
	}
}

