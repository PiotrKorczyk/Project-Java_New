package Players;

import javax.swing.JOptionPane;

public abstract class Player{
//zmienne
  public String name = "bez imienia";
  public int punkty;
  int pieniadze;
  public int wybor=3;
  public int timeLimit;
  String typGracza = "jakis gracz";

 //konstruktory
  public Player() { }

  //metody
  String getTypGracza()      { return typGracza; }
  String getName()     { return  name;   }
  int getWynik()    { return pieniadze; }


  public void Strategy(int tab[], int n, int i){
	  tab[i]=wybor;
  }


  public void setName(){
	  	name = JOptionPane.showInputDialog("Na poczatek podaj swoje imie i nazwisko: ");


	}

}

