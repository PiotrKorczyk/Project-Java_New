package GameModel;

import Players.Player;
import Threads.Timer;

import javax.swing.*;

public class GamesModel{

	public boolean whichPlayer = false;

	public int allRounds;	
	public Player p1 = null;
	public Player p2 = null;
	public int round = 0;
	public int wygrana;
	public int przegrana;
	public StrategyGamesModel gamesModel=null;
	
	
	public GamesModel(Player player1, Player player2, int allRounds, int gra) {
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
	

	
	/*
	 schermetyzowana metoda Random()
	 */
	
	
	/*
	 schermetyzowana metoda Judge()
	 */
	
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
			JOptionPane.showMessageDialog(null, "Wygral gracz " + p1.name + " i zdoby� " + p1.punkty + "pkt\nZa� gracz " + p2.name + " uzyska� " + p2.punkty + "pkt");
			theFirstPlayerIsTheWinner = true;
		}
		else if(p2.punkty > p1.punkty)
				JOptionPane.showMessageDialog(null, "Wygral gracz " + p2.name + " i zdoby� " + p2.punkty + "PLN\nZa� gracz " + p1.name + " uzyska� " + p1.punkty + "pkt");
		else
			JOptionPane.showMessageDialog(null, "Remis");
		
		return theFirstPlayerIsTheWinner;
	}
	 

		public boolean StartTimerFunc(Timer timer, int timeLimit, int allRoundss){
			
			timer.countTime(timeLimit, allRoundss);
			timer.GameOver=false;
			timer.HurryUp = true;
			
			return true;
		}
		
		public boolean EndOfTime(Timer timer, Player p1, int allRounds){
			System.out.println(p1.name);
			if((p1.wybor == 0 || p1.wybor == 1 || p1.wybor == 2) && timer.GameOver == false)
				timer.GameOver=true;
			else if((p1.wybor != 0 || p1.wybor != 1 || p1.wybor != 2) && timer.GameOver == false)
				timer.GameOver=true;
			else
				p1.wybor = timer.EndTime(p1);
				
			return timer.GameOver;
		}



		public int returnWygrana(){
			return wygrana;
		}
		
		public int returnPrzegrana(){
			return przegrana;
		}

}
