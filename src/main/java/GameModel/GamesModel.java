package GameModel;

import javax.swing.JOptionPane;
import Players.Player;


public class GamesModel{

	public boolean whichPlayer = false;

	public int allRounds;	
	public Player p1 = null;
	public Player p2 = null;
	public int round = 0;
	public int wygrana;
	public int przegrana;
	public StrategyGamesModel gamesModel=null;
	
	
	public GamesModel(Player p1, Player p2, int allRounds, int gra) {
		this.p1=p1;
		this.p2=p2;
		
		this.allRounds=allRounds;
		round = 0;
		
		switch(gra){
			case 0: gamesModel = new TicTacToeStrategy(); break;
			case 1: gamesModel = new RockPaperScissorsStrategy(); break;
		}
		wygrana = 10;
		przegrana = 20;
				
	}
	

	
	public int roundFunction(){
		this.round++;
		if(round==allRounds){
			Winner();
			System.exit(0);
		}
		return round;
	}

	
	 public boolean Winner(){
		boolean theFirstPlayerIsTheWinner = false;
		if(p1.punkty > p2.punkty){
			JOptionPane.showMessageDialog(null, "Wygral gracz " + p1.name + " i zdobyl " + p1.punkty + "pkt\nZas gracz " + p2.name + " uzyskal " + p2.punkty + "pkt");
			theFirstPlayerIsTheWinner = true;
		}
		else if(p2.punkty > p1.punkty)
				JOptionPane.showMessageDialog(null, "Wygral gracz " + p2.name + " i zdobyl " + p2.punkty + "pkt\nZas gracz " + p1.name + " uzyskal " + p1.punkty + "pkt");
		else
			JOptionPane.showMessageDialog(null, "Remis");
		
		return theFirstPlayerIsTheWinner;
	}
	 


		public int returnWygrana(){
			return wygrana;
		}
		
		public int returnPrzegrana(){
			return przegrana;
		}

}
