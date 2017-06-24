package GameView;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TicTacToeView implements StrategyGamesView{
	public JButton []gamesButtons=null;
	public String [] podpisyGamesButtons=null;
	public JPanel gamesButtonsPanel=null;
	
	int NumberOfButtons;

	
	public TicTacToeView(JButton []gamesButtons, String [] podpisyGamesButtons, JPanel gamesButtonsPanel){
		gamesButtons = new JButton[9];
		podpisyGamesButtons = new String[9];
		for(int i =0; i<9;i++)
			podpisyGamesButtons[i] = "CLICK";
		NumberOfButtons = 9;
		
		this.gamesButtonsPanel = gamesButtonsPanel;
		this.gamesButtons = gamesButtons;
		this.podpisyGamesButtons = podpisyGamesButtons;
	}
	
	public int ReturnNumberOfButtons(){
		return NumberOfButtons;
	}
	
	public String ReturnSignaturesOfButtons(int i){
		return podpisyGamesButtons[i];
	}
}
