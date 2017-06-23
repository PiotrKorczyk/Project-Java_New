package Players;


import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package JAVA #2;

public class Gracz extends Player{
	
	
	public Gracz(){
		name = "";
		punkty = 0;
		pieniadze = 100;
        typGracza = "Gracz";
        timeLimit = 360;
	}
	
	public Gracz(String _name, int _punkty, int _pieniadze){
		name = _name;
		punkty = _punkty;
		pieniadze = _pieniadze;
        typGracza = "Gracz";
        timeLimit = 360;
	}
	
	
	public void Komunikat_Wygranej(int punkty, int losuj_komunikat){
		switch(losuj_komunikat){	
		case 0: JOptionPane.showMessageDialog(null, "Brawo  " + name + " wygrales " + punkty+" pkt");break;
		case 1: JOptionPane.showMessageDialog(null,"Bardzo ³adnie " + name + " wygrales " + punkty+" pkt");break;
		case 2: JOptionPane.showMessageDialog(null,"Bardzo ³adnie " + name + " zdobe³eœ " + punkty+" pkt");break;
		case 3: JOptionPane.showMessageDialog(null,"Supeeeer! " + name + " wygrales " + punkty+" pkt");break;
		}
	}
	
	public void Komunikat_Przegranej(int punkty, int losuj_komunikat){
		switch(losuj_komunikat){	
		case 0: JOptionPane.showMessageDialog(null,"Niestety " + name + " straci³eœ " + punkty+" pkt");break;
		case 1: JOptionPane.showMessageDialog(null,"Bardzo mi przykro " + name + " przegra³eœ " + punkty+" pkt");break;
		case 2: JOptionPane.showMessageDialog(null,"Tym razem sie nie uda³o " + name + " masz " + punkty+" pkt mniej");break;
		case 3: JOptionPane.showMessageDialog(null,"Nastêpnym razem bedzie lepiej! " + name + " tym razem straci³eœ " + punkty+" pkt");break;
		}
	}
}

