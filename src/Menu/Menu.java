package Menu;

import GameController.GamesController;
import GameModel.GamesModel;
import GameView.View;
import Players.Gracz;
import Players.Player;
import game.GamePanel;
import mainJavaGames.GameClass;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame  implements ActionListener{


    public static final int HEIGHT = 400;
    public static final int WIDTH = 430;
    View view=null;
    GamesController controller = null;
    GamesModel model = null;

    private JButton exit;
    private JButton Start_Tic_Tac_Toe;
    private JButton Start_Pap_Kam_Noz;
    private JButton Snake;
    private JLabel poczatek;
    public Player player1,player2;
    public int round;
    public Menu() {
        setLayout(new FlowLayout());
        player1 = null;
        player2 = null;
        round = 0;

        poczatek = new JLabel("<html>Witam w symulatorze spedzenia czasu<br>Prosze wybrac gre</html>");
        poczatek.setBounds(100, 10, 500, 50);
        add(poczatek);

        Start_Pap_Kam_Noz = new JButton("Papier, Kamien, Nozyce");
        Start_Pap_Kam_Noz.addActionListener((ActionListener) this);
        Start_Pap_Kam_Noz.setBounds(110, 150, 200, 50);
        Start_Pap_Kam_Noz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callPlayer(0,"P1");
                setPlayersNames(0);
//                round = Integer.parseInt( JOptionPane.showInputDialog(null,"Ile rund chcesz rozegra�: "));
                view = new View(1);
                model = new GamesModel(player1, player2, 1, 1);
                controller = new GamesController(model, view, 1);
            }
        });
        add(Start_Pap_Kam_Noz);


        exit = new JButton("Wyjscie");
        exit.addActionListener((ActionListener) this);
        exit.setBounds(300, 300, 90, 40);
        add(exit);

        Start_Tic_Tac_Toe = new JButton("Kolko i Krzyzyk");
        Start_Tic_Tac_Toe.addActionListener((ActionListener) this);
        Start_Tic_Tac_Toe.setBounds(110, 80, 200, 50);
        Start_Tic_Tac_Toe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callPlayer(0,"P1");
                setPlayersNames(0);
//                round = Integer.parseInt( JOptionPane.showInputDialog(null,"Ile rund chcesz rozegra�: "));
                view = new View(0);
                model = new GamesModel(player1, player2, 1, 0);
                controller = new GamesController(model, view, 0);
            }
        });
        add(Start_Tic_Tac_Toe);

        Snake = new JButton("Snake");
        Snake.setBounds(110, 220, 200, 50);
        Snake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                startSnake();
            }
        });
        add(Snake);


        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setTitle("Gierki");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void callPlayer(int typGracza, String playerName){

        if(typGracza == 0){
            player1 = new Gracz("P1",100,100);
            player2 = new Gracz("Komputer",100,100);

        }


    }

    private void setPlayersNames(int gra){
        player1.setName();
        if(gra==0)
            player2.setName();
    }
}

