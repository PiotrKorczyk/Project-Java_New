package GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;



public class GamesController implements ActionListener{
		
		
	GamesModel model = null;
	View view = null;
	
	
	String [] names = new String[2];
	

	ControlTheGamesButtons ctgb = null;
	
	public GamesController(final GamesModel model, final View view, int gra){
		
		
		this.view = view;
		this.model = model;
		names[0] = model.p1.name;
		names[1] = model.p2.name;
	

		view.setGamesButtons();
		
		addActionListeners();
		System.out.println(model.p1.name);
		
		
		switch(gra){
			case 0:	ctgb = new ChangeableGamesButtons(); break;
			case 1: ctgb = new NotChangeableGamesButtons(); break;
		}
		
		view.NewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	ctgb.NewGameFunction(view.gamesButtons);
		    	model.p1.punkty = 100;
		    	model.p2.punkty = 100;
			}
		});
	}
	
	
	public void actionPerformed(ActionEvent e) {		
		Object source = e.getSource();

		ctgb.controlTheButtons((AbstractButton) source, model, view,  model.p1, model.allRounds, view.gamesButtons);
			
	}
	
	private void addActionListeners(){
	    for (JButton gamesButtons : view.gamesButtons)
	    	gamesButtons.addActionListener(this);
	}
	



}
