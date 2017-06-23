package GameController;

import GameModel.GamesModel;
import GameView.View;
import Players.Player;
import Threads.Timer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamesController implements ActionListener{
		
		
	GamesModel model = null;
	View view = null;
	
	
	String [] names = new String[2];
	
	Timer timer = null;
	Thread threadtimer = new Thread(timer);
	ControlTheGamesButtons ctgb = null;
	
	public GamesController(final GamesModel model, final View view, int gra){
		
		
		this.view = view;
		this.model = model;
		names[0] = model.p1.name;
		names[1] = model.p2.name;
	
		view.setPlayersInfo(names,model.p1.punkty, model.p2.punkty);
		timer =	new Timer(model.p1, null,view.countDownlabel);
		Thread threadtimer = new Thread(timer);
				
		threadtimer.start();
		

		view.setLed(model.whichPlayer);
		
		view.setGamesButtons();
		
		addActionListeners();
		System.out.println(model.p1.name);
		StartTimerFunc(model.p1.timeLimit,model.allRounds);
		
		switch(gra){
			case 0:	ctgb = new ChangeableGamesButtons(); break;
			case 1:
			case 2:
			case 3: ctgb = new NotChangeableGamesButtons(); break;
		}
		
		view.NewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	ctgb.NewGameFunction(view.gamesButtons);
		    	view.printRound(model.round);
		    	model.p1.punkty = 100;
		    	model.p2.punkty = 100;
		    	view.printScore(model.p1.punkty,model.p2.punkty);
			}
		});
	}
	
	
	public void actionPerformed(ActionEvent e) {		
		Object source = e.getSource();

		ctgb.controlTheButtons((AbstractButton) source, model, view, timer, model.p1, model.allRounds, view.gamesButtons);
			
	}
	
	private void addActionListeners(){
	    for (JButton gamesButtons : view.gamesButtons)
	    	gamesButtons.addActionListener(this);
	}
	
	protected boolean StartTimerFunc(int timeLimit, int allRoundss){
		
		timer.countTime(timeLimit, allRoundss);
		timer.GameOver=false;
		timer.HurryUp = true;
		
		return true;
	}

	protected boolean EndOfTime(Player p1, int allRoundss){
		System.out.println(p1.name);
		if((p1.wybor == 0 || p1.wybor == 1 || p1.wybor == 2) && timer.GameOver == false)
			timer.GameOver=true;
		else if((p1.wybor != 0 || p1.wybor != 1 || p1.wybor != 2) && timer.GameOver == false)
			timer.GameOver=true;
		else
			p1.wybor = timer.EndTime(p1);
			
		return timer.GameOver;
	}
}
