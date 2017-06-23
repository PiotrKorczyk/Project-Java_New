package GameView;

import DecorateTheView.InterfaceView;
import DecorateTheView.RockPaperScissorDecorator;
import DecorateTheView.TicTacToeDecorator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View  extends JFrame  implements InterfaceView{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int HEIGHT = 600;
    public static final int WIDTH = 400;

    public JButton [] gamesButtons;
    public JButton NewGame;
    protected JButton[] namesButtons;


    public JPanel panelOptions;
    public JPanel gamesButtonsPanel;
    public JPanel namesPanel;
    public JPanel timePanel = new JPanel();

    protected String [] podpisyGamesButtons;

    InterfaceView dekorowanyWidok = null;
    protected JLabel lblLed[] = {new JLabel("�"), new JLabel("�")};
    protected JLabel[] printScore = {new JLabel("Score"), new JLabel("Score")};

    protected JLabel printRound;

    public JLabel countDownlabel = new JLabel();
//    InterfaceView dekorowanyWidok = null;

    protected Color colors[] = { new Color(50,205,0), new Color(255,255,0)};

    public StrategyGamesView strategyView = null;
    public View(int gra){

        setLayout(null);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        gamesButtonsPanel = new JPanel();
        NewGame = new JButton("New Game");
        namesButtons = new JButton[2];
        printRound = new JLabel("Round: " + 1);

        panelOptions = new JPanel();
        panelOptions.setBorder(BorderFactory.createTitledBorder(""));


 /*1*/  panelOptions.setBounds(20,10,170,80);

        panelOptions.add(NewGame);
        panelOptions.add(printRound);

        //panelOptions.setLayout(new FlowLayout());
//		panelOptions.setPreferredSize(new Dimension(100,80));
        panelOptions.setOpaque(false);


        add(panelOptions);

        gamesButtonsPanel.setLayout(new GridLayout(3,3));
        gamesButtonsPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
 /*2*/  gamesButtonsPanel.setBounds(40,230,300,300);



        timePanel.setBorder(BorderFactory.createTitledBorder("Time:"));
        timePanel.setPreferredSize(new Dimension(100,50));
        timePanel.add(countDownlabel);
 /*3*/  timePanel.setBounds(190,10,170,80);

        add(timePanel);

		switch(gra){
			case 0: strategyView = new TicTacToeView(gamesButtons, podpisyGamesButtons, gamesButtonsPanel);
                dekorowanyWidok = new TicTacToeDecorator(this); break;
			case 1: strategyView = new RockPaperAndScissorsView(gamesButtons, podpisyGamesButtons, gamesButtonsPanel);
                dekorowanyWidok = new RockPaperScissorDecorator(this); break;

		}

		add(dekorowanyWidok.setTheGameBackground(WIDTH,HEIGHT));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setPlayersInfo(String []names, int score1, int score2){
        printScore(score1,score2);
        setPlayersOnButtons(names);
        for(int i=0;i<2;i++){
            namesPanel=new JPanel();
            namesPanel.setBackground(colors[i]);
            namesPanel.setLayout(new GridLayout(2,0));
            namesButtons[i] = new JButton();
            namesButtons[i].add(lblLed[i]);
            namesPanel.add(namesButtons[i]);
            namesPanel.add(printScore[i]);
	 /*4*/  namesPanel.setBounds(10+i*180,100,180,80);
            add(namesPanel);
        }
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

    private void setPlayersOnButtons(String []names){
        for(int i = 0; i < 2; i++)
            lblLed[i] = new JLabel("Player " + (i+1) + ": " + names[i]);
    }

    public void printRound(int round){
        printRound.setText("Round: " + (round+1));
    }

    public void printScore(int score1, int score2){
        printScore[0].setText("Score: " + score1);
        printScore[1].setText("Score: " + score2);
    }

    public void setLed(boolean whichPlayer){
        if(whichPlayer == true){
            lblLed[0].setForeground(Color.RED);
            lblLed[1].setForeground(Color.GREEN);
        }

        else{
            lblLed[1].setForeground(Color.RED);
            lblLed[0].setForeground(Color.GREEN);
        }
    }

    public JLabel setTheGameBackground(int x, int y) {
        // TODO Auto-generated method stub
        return null;
    }

}
