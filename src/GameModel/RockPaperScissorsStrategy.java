package GameModel;

import Players.Player;
import Threads.Timer;

import javax.swing.*;

public class RockPaperScissorsStrategy implements StrategyGamesModel {
	
	public int Random(Player p1, Player p2, int n, int ktoLosuje){
		int wybor;
		wybor = (int) (Math.random()*n);
		if(wybor == 0)
			JOptionPane.showMessageDialog(null,"Gracz "+p2.name+": wybra� kamie�");
		else if(wybor==1)
			JOptionPane.showMessageDialog(null,"Gracz "+p2.name+": wybra� papier");
		else
			JOptionPane.showMessageDialog(null,"Gracz "+p2.name+": wybra� no�yce");
		return wybor;
	}
	
	public int setRand(Player p1, Player p2){
		return Random(p1,p2,3,0);
	}
	
	
	public String Judge(Player p1, Player p2, int wygrana, int przegrana, int randomChoice){
		//p2.wybor = Random(p1,p2,3,0);		
		String winner = p1.name;
		p2.wybor = randomChoice;
		int wylosowano=p2.wybor;
		if((p1.wybor == 0 && wylosowano==2) || (p1.wybor == 2 && wylosowano==1)|| (p1.wybor == 1 && wylosowano==0)){
			wylosowano=(int) (Math.random()*4);
//			p1.punkty += wygrana;
//			p1.Komunikat_Wygranej(wygrana, wylosowano);
//			p2.punkty -= przegrana;
//			p2.Komunikat_Przegranej(przegrana, wylosowano);
		}
		
		else if(p1.wybor == wylosowano){
			System.out.println("Remis!");
			winner = "remis";
		}
		
		else {
			if( p1.wybor == 3 ||  (p1.wybor != 0 && p1.wybor != 1 && p1.wybor != 2)){
				System.out.println("Komputer wygrywa na rzecz " + p1.name + wygrana + " pkt");
				p2.punkty += wygrana;
				p1.punkty -= przegrana;
				winner = p2.name;
			}
			else if(((p2.wybor == 0 && wylosowano==2) || (p2.wybor == 2 && wylosowano==1)|| (p2.wybor == 1 && wylosowano==0)))
//			p2.punkty += wygrana;
//			p2.Komunikat_Wygranej(wygrana, wylosowano);
//			p1.punkty -= przegrana;
//			p1.Komunikat_Przegranej(przegrana, wylosowano);
			winner = p2.name;
		}
		return winner;
	}

	public int ChoiceOfTheFirstPlayer(String choice, Player p1) {
		if(choice == "Kamie�"){
			JOptionPane.showMessageDialog(null,"Gracz " + p1.name + " wybra� kamie�");
			p1.wybor = 0;
		}
		else if(choice == "Papier"){
			JOptionPane.showMessageDialog(null,"Gracz " + p1.name + " wybra� papier");
			p1.wybor = 1;
		}
		else if(choice == "No�yce"){
			JOptionPane.showMessageDialog(null,"Gracz " + p1.name + " wybra� no�yce");
			p1.wybor = 2;
		}
		return p1.wybor;
		
	}

	public String setChar(boolean whichPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean Wins(Player p1, Player p2, int wygrana, int przegrana, String[] Signatures) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean EndOfTime(Timer timer) {
		// TODO Auto-generated method stub
		return false;
	}

	public int CheckRandomButton(String[] Signatures, String znak) {
		// TODO Auto-generated method stub
		return 0;
	}
}

