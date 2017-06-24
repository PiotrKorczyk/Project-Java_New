package mainJavaGames;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Players.*;

public class Menu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 400;
	public static final int WIDTH = 430;
	private JComboBox<String> comboGamesBox;
	
	private JButton startButton;
	private JButton musicButton;
	private JButton exit;
	

	
	private JPanel gamersPanel;;
	private JPanel gamesPanel;
	private JPanel timePanel;	
	

    String string[] = {};
	String Gry[] = { "Kolko i krzyzyk", "Kamien papier nozyce", "Snake"};
		
	public int round;
	
	public Player player1,player2;
	
	public Menu() {
		setLayout(null);

		player1 = null;
		player2 = null;
		round = 0;
		

		comboGamesBox = new JComboBox<String>(Gry);
		createMenuPanels(gamesPanel, comboGamesBox, "Wybierz gre");

		
		startButton = new JButton("Zacznij gre");
		startButton.setBounds(45,170,200,35);
		startButton.addActionListener(this);
		add(startButton);


				
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}
	
	
	
	private void createMenuPanels(JPanel jpanel, JComboBox<String> jcombobox, String string){
		jpanel = new JPanel();
					

		jpanel.setBounds(45,100,200,60);
		jpanel.setPreferredSize(new Dimension(100,70));
		jpanel.add(jcombobox);
		
		
		
		add(jpanel);
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(((AbstractButton) source).getText() == "Zacznij gre"){
			callPlayer(1,"P1");
			setPlayersNames(comboGamesBox.getSelectedIndex());
			callGame(comboGamesBox.getSelectedIndex());

		}		
	}
	
	public void callPlayer(int typGracza, String playerName){

	    player1 = new Gracz(playerName,100);
	    player2 = new Gracz("Komputer",100);

			
	}
	
	private void setPlayersNames(int gra){
		player1.setName();
		if(gra==0)
			player2.setName();
	}
	
	public void callGame(final int gra){

		EventQueue.invokeLater(new Runnable(){

			public void run(){
				new GameClass(player1,player2,gra,5);
			}
		});
	}
	
}

