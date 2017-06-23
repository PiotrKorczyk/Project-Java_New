package mainJavaGames;

//import GameController.GamesController;

import GameController.GamesController;
import GameModel.GamesModel;
import GameView.View;
import Menu.Menu;
import Players.Player;

public class GameClass{
    View view=null;
    GamesController controller = null;
    GamesModel model = null;
//        game gam = null;
    Menu menu = null;
    public GameClass(Player p1, Player p2, int gra, int round){


        if(gra == 0 || gra == 1) {
            view = new View(gra);
            model = new GamesModel(p1, p2, round, gra);
            controller = new GamesController(model, view, gra);
        }


            if(gra == 5)	menu = new Menu();





    }
}

