package GameModel;

import javax.swing.JOptionPane;

import Players.Player;


public class RockPaperScissorsStrategy implements StrategyGamesModel{

	public int Random(Player p1, Player p2, int n, int ktoLosuje){
		int wybor;
		wybor = (int) (Math.random()*n);
		if(wybor == 0)
			JOptionPane.showMessageDialog(null,"Gracz "+p2.name+": wybral kamien");
		else if(wybor==1)
			JOptionPane.showMessageDialog(null,"Gracz "+p2.name+": wybral papier");
		else
			JOptionPane.showMessageDialog(null,"Gracz "+p2.name+": wybral nozyce");
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
			p1.punkty += wygrana;
			p2.punkty -= przegrana;
		}

		else if(p1.wybor == wylosowano){
			System.out.println("Remis!");
			winner = "remis";
		}

		else {
			if( p1.wybor == 3 ||  (p1.wybor != 0 && p1.wybor != 1 && p1.wybor != 2)){
				p2.punkty += wygrana;
				p1.punkty -= przegrana;
				winner = p2.name;
			}
			else if(((p2.wybor == 0 && wylosowano==2) || (p2.wybor == 2 && wylosowano==1)|| (p2.wybor == 1 && wylosowano==0)))
				p2.punkty += wygrana;
			p1.punkty -= przegrana;
			winner = p2.name;
		}
		return winner;
	}

	public int ChoiceOfTheFirstPlayer(String choice, Player p1) {
		if(choice == "Kamien"){
			p1.wybor = 0;
		}
		else if(choice == "Papier"){
			p1.wybor = 1;
		}
		else if(choice == "Nozyce"){
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




	public int CheckRandomButton(String[] Signatures, String znak) {
		// TODO Auto-generated method stub
		return 0;
	}
}

