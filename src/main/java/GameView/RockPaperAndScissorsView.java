package GameView;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RockPaperAndScissorsView implements StrategyGamesView{

	public JButton []gamesButtons=null;
	public String [] podpisyGamesButtons=null;
	public JPanel gamesButtonsPanel=null;

	int NumberOfButtons;


	public RockPaperAndScissorsView(JButton []gamesButtons, String [] podpisyGamesButtons, JPanel gamesButtonsPanel){
		gamesButtons = new JButton[3];
		podpisyGamesButtons = new String[3];
		podpisyGamesButtons[0] = "Kamien";
		podpisyGamesButtons[1] = "Papier";
		podpisyGamesButtons[2] = "Nozyce";
		NumberOfButtons = 3;

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
