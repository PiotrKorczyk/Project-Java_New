package Threads;

import Players.Player;

import javax.swing.*;
import java.awt.*;

public class Timer implements Runnable{
	private JLabel timelabel;
	public JLabel countDownlabel;
	public int minutes = 0;
	public int sec = 0;
	public boolean getState = true;
	int time = 0;
	int round;
	int timeLimit;
	public Player p = null;
	
	public boolean HurryUp=false;
	public boolean GameOver=false;

	public Timer(Player p, JLabel timelabel, JLabel countDownlabel) {
		super();
		this.p=p;
		this.timelabel = timelabel;
		this.countDownlabel = countDownlabel;
		// TODO Auto-generated constructor stub
	}
	
	public void countTime(int Limit, int round){
		System.out.println(Limit);
		this.timeLimit = Limit/round;
	}
	
	public void run(){
		while(getState){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException exc){
				JOptionPane.showMessageDialog(null,"W�tek zliczania czasu zosta� przerwany.");
				return;
			}
			
			if(!(CountGameTime(getState)) && timelabel!= null)
				System.exit(0);				
			
			EndTheRound(HurryUp);
		}
	}	
	
	void displayTime(){                  
		timelabel.setText(minutes+":"+sec);
	}
	
	boolean CountGameTime(boolean getState){
		time++;
		minutes = time/60;
		sec = time%60;
		if(timelabel !=null)
		displayTime();
		if(!getState)
			JOptionPane.showMessageDialog(null,"Wyszedles z programu po:"+ minutes+":"+sec);
		return getState;
	}
	
	public void EndTheRound(boolean HurryUp){
		if(HurryUp){

			displayHurryUpTime();
			if(timeLimit<0){
				GameOver = true;
			}
		}
	
	}
	
	public int EndTime(Player p){
		System.out.println("Koniec czasu!");
		p.wybor = 3;
		return p.wybor;
	}

	public void displayHurryUpTime(){
		int min=0, s=0;
		countDownlabel.setForeground(Color.BLACK);
		if(((timeLimit) >= 0)){
			min = timeLimit/60;
			s = timeLimit%60;
			//(String.format("Jednocyfrowa: %1$02d", number));
			countDownlabel.setText(min+":"+s);
			if(timeLimit<10)
				countDownlabel.setForeground(Color.RED);
			timeLimit--;
		}
		
		else{
			countDownlabel.setForeground(Color.RED);
			countDownlabel.setText("KONIEC CZASU!");
		}
	}

}
