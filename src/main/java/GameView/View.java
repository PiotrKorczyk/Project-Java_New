package GameView;

import java.awt.*;

import javax.swing.*;


import DecorateTheView.InterfaceView;
import DecorateTheView.RockPaperScissorDecorator;
import DecorateTheView.TicTacToeDecorator;
import GameModel.GamePanel;

public class View  extends JFrame implements InterfaceView{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 334;
	public static final int WIDTH = 315;

	public JButton [] gamesButtons;
	public JButton NewGame;
	protected JButton[] namesButtons;


	public JPanel panelOptions;
	public JPanel gamesButtonsPanel;
	public JPanel namesPanel;
	public JPanel timePanel = new JPanel();

	protected String [] podpisyGamesButtons;


	protected JLabel lblLed[] = {new JLabel("�"), new JLabel("�")};
	protected JLabel[] printScore = {new JLabel("Score"), new JLabel("Score")};

	protected JLabel printRound;

	public JLabel countDownlabel = new JLabel();
	InterfaceView dekorowanyWidok = null;


	public StrategyGamesView strategyView = null;
	private ImageIcon icon;

	public View(int gra){

    	setLayout(null);
    	setPreferredSize(new Dimension(WIDTH,HEIGHT));

		gamesButtonsPanel = new JPanel();
		namesButtons = new JButton[2];

		gamesButtonsPanel.setLayout(new GridLayout(3,3));
		gamesButtonsPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
 /*2*/  gamesButtonsPanel.setBounds(0,0,300,300);



		switch(gra){
			case 0: strategyView = new TicTacToeView(gamesButtons, podpisyGamesButtons, gamesButtonsPanel);	break;
			case 1: strategyView = new RockPaperAndScissorsView(gamesButtons, podpisyGamesButtons, gamesButtonsPanel); break;

		}

		switch(gra){
			case 0: dekorowanyWidok = new TicTacToeDecorator(this); break;
			case 1: dekorowanyWidok = new RockPaperScissorDecorator(this); break;
			case 2: startSnake(); break;
		}
		add(dekorowanyWidok.setTheGameBackground(WIDTH,HEIGHT));
//		new ImageIcon(getClass().getResource("/Untitled-1.jpg")).getImage();

		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     pack();
	     setLocationRelativeTo(null);
	     setVisible(true);
	}


	//schermetyzowac
	public void setGamesButtons(){
		gamesButtons = new JButton[strategyView.ReturnNumberOfButtons()];
		for(int i=0;i<strategyView.ReturnNumberOfButtons();i++){
			gamesButtons[i] = new JButton(strategyView.ReturnSignaturesOfButtons(i));
			gamesButtonsPanel.add(gamesButtons[i]);
		}
		add(gamesButtonsPanel);
	}


	public JLabel setTheGameBackground(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public void startSnake() {
		JFrame frame = new JFrame("Snake");
		frame.setContentPane(new GamePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
