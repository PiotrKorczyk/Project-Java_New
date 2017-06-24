
package GameModel;

import javax.swing.JOptionPane;

import Players.Player;


public class TicTacToeStrategy implements StrategyGamesModel{

	public String []symbole = {"O","X"};
	public String znak = "O";
	String []Signatures = new String[9];
	
	public String setChar(boolean whichPlayer){

		if(whichPlayer == true){
			znak = symbole[1];
		}
		else{
			znak = symbole[0];
		}
		return znak;
	}
		
	public boolean Wins(Player p1, Player p2, int wygrana, int przegrana, String []Signatures){
		boolean Status=false;
		int count=0;
		
		if((Signatures[0] == Signatures[1] && Signatures[1] == Signatures[2] && Signatures[2] == znak)
		 ||(Signatures[3] == Signatures[4] && Signatures[4] == Signatures[5] && Signatures[5] == znak)
		 ||(Signatures[6] == Signatures[7] && Signatures[7] == Signatures[8] && Signatures[8] == znak)
		 ||(Signatures[0] == Signatures[4] && Signatures[4] == Signatures[8] && Signatures[8] == znak)
		 ||(Signatures[2] == Signatures[4] && Signatures[4] == Signatures[6] && Signatures[6] == znak)
		
		 ||(Signatures[0] == Signatures[3] && Signatures[3] == Signatures[6] && Signatures[6] == znak)
		 ||(Signatures[1] == Signatures[4] && Signatures[4] == Signatures[7] && Signatures[7] == znak)
		 ||(Signatures[2] == Signatures[5] && Signatures[5] == Signatures[8] && Signatures[8] == znak)){
		
			if( znak == "X"){
				JOptionPane.showMessageDialog(null, "Wygral " + p2.name);
				p2.punkty += wygrana;
				p1.punkty -= przegrana;
			}
			
			else if(znak == "O"){
				JOptionPane.showMessageDialog(null, "Wygral " + p1.name);
				p1.punkty += wygrana;
				p2.punkty -= przegrana;
			}		
			Status = true;
		}
		
		else{
			for(int i=0;i<9;i++)
				if(Signatures[i]!="CLICK")
					count++;
					if(count == 9){
						JOptionPane.showMessageDialog(null, "Remis");
						Status = true;
					}
		}		
		return Status;
		
	}
	
	public int CheckRandomButton(String []Signatures, String znak){
		int random;
		do
			random = (int) (Math.random()*9);
		while(Signatures[random] != "CLICK");
		return random;
	}

	
	public int ChoiceOfTheFirstPlayer(String choice, Player p1) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Random(Player p1, Player p2, int n, int ktoLosuje) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String Judge(Player p1, Player p2, int wygrana, int przegrana, int randomChoice) {
		return null;
		// TODO Auto-generated method stub
	}

	public int setRand(Player p1, Player p2) {
		// TODO Auto-generated method stub
		return 0;
	}


}
