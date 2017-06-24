package JUnitPackage;

import Players.Gracz;
import org.junit.Assert;

import GameModel.GamesModel;
import Players.Player;
//import Players.Student;
import org.testng.annotations.Test;

public class Testy {

	Player p1 = new Gracz();
	Player p2 = new Gracz();

	@org.junit.Test
	public void testCreateGamesModel() {
		GamesModel model = new GamesModel(p1,p2,5,1);
		Assert.assertNotNull(model);
		Assert.assertEquals(10, model.returnWygrana());
		Assert.assertEquals(20, model.returnPrzegrana());
	}
	
	@org.junit.Test
	public void testFromModelFunctionroundFunction() {
		GamesModel model = new GamesModel(p1,p2,5,2);
		Assert.assertEquals(1, model.roundFunction());
	}
	
	@org.junit.Test
	public void testFromModelFunctionWinner() {
		p1.punkty = 150;
		p2.punkty = -150;
		GamesModel model = new GamesModel(p1,p2,5,2);
		Assert.assertEquals(true, model.Winner());
	}
	
	@org.junit.Test
	public void testFromRockPaperScissorsModelFunctionRandom() {
		GamesModel model = new GamesModel(p1,p2,5,2);
		Assert.assertEquals(0, model.gamesModel.ChoiceOfTheFirstPlayer("Kamie�", p1));
		Assert.assertEquals(1, model.gamesModel.ChoiceOfTheFirstPlayer("Papier", p1));
		Assert.assertEquals(2, model.gamesModel.ChoiceOfTheFirstPlayer("No�yce", p1));
	}
	
	@Test
	public void testFromHareAndDeerModelFunctionJudge() {
		GamesModel model = new GamesModel(p1,p2,5,3);
		p1.wybor = 1;
		Assert.assertEquals(("Wygrani: gracz "+ " " + p1.name + " i " + p2.name), model.gamesModel.Judge(p1, p2, model.wygrana, model.przegrana,1));
		p1.wybor = 2;
		Assert.assertEquals(p1.name, model.gamesModel.Judge(p1, p2, model.wygrana, model.przegrana,1));
		p1.wybor = 2;
		Assert.assertEquals(("Wygrani: gracz "+ " " + p1.name + " i " + p2.name), model.gamesModel.Judge(p1, p2, model.wygrana, model.przegrana,2));
		p1.wybor = 1;
		Assert.assertEquals(p2.name, model.gamesModel.Judge(p1, p2, model.wygrana, model.przegrana,2));
	}

	@org.junit.Test
	public void testFromTicTacToeModelFunctionWins() {
		GamesModel model = new GamesModel(p1,p2,5,0);
		String [] Signatures = new String[9];
		//TEST DLA WYGRANEGO GRACZA ZE ZNAKIEM - O
		Signatures[0] = "O";	Signatures[1] = "O";	Signatures[2] = "O";
		Signatures[3] = "X";	Signatures[4] = "O";	Signatures[5] = "X";
		Signatures[6] = "X";	Signatures[7] = "X";	Signatures[8] = "X";
		
		Assert.assertEquals(true, model.gamesModel.Wins(p1, p2, model.wygrana, model.przegrana,Signatures));
		
		//TEST DLA WYGRANEGO GRACZA ZE ZNAKIEM - O
		Signatures[0] = "O";	Signatures[1] = "CLICK";	Signatures[2] = "O";
		Signatures[3] = "O";	Signatures[4] = "O";		Signatures[5] = "CLICKX";
		Signatures[6] = "X";	Signatures[7] = "CLICK";	Signatures[8] = "O";
		
		Assert.assertEquals(true, model.gamesModel.Wins(p1, p2, model.wygrana, model.przegrana,Signatures));
		
		//TEST DLA REMISU
		Signatures[0] = "X";	Signatures[1] = "O";	Signatures[2] = "X";
		Signatures[3] = "O";	Signatures[4] = "O";	Signatures[5] = "X";
		Signatures[6] = "X";	Signatures[7] = "X";	Signatures[8] = "O";
		
		Assert.assertEquals(true, model.gamesModel.Wins(p1, p2, model.wygrana, model.przegrana,Signatures));
	
		//TEST DLA SYTUACJI PRZED ROZPOCZECIEM GDY NIE MA KOGO OCENIAC
		Signatures[0] = "CLICK";	Signatures[1] = "CLICK";	Signatures[2] = "CLICK";
		Signatures[3] = "CLICK";	Signatures[4] = "CLICK";	Signatures[5] = "CLICK";
		Signatures[6] = "CLICK";	Signatures[7] = "CLICK";	Signatures[8] = "CLICK";

		Assert.assertEquals(false, model.gamesModel.Wins(p1, p2, model.wygrana, model.przegrana,Signatures));

	}
	
	
}
