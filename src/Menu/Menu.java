package Menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame  {


    public static final int HEIGHT = 400;
    public static final int WIDTH = 430;


    private JButton exit;
    private JButton Start_Tic_Tac_Toe;
    private JButton Start_Pap_Kam_Noz;
    private JLabel poczatek;


    public Menu() {
        setLayout(new FlowLayout());

        poczatek = new JLabel("<html>Witam w symulatorze spedzenia czasu<br>Prosze wybrac gre</html>");
        poczatek.setBounds(100, 10, 500, 50);
        add(poczatek);

        Start_Pap_Kam_Noz = new JButton("Papier, Kamien, Nozyce");
        Start_Pap_Kam_Noz.addActionListener((ActionListener) this);
        Start_Pap_Kam_Noz.setBounds(110, 150, 200, 50);
        add(Start_Pap_Kam_Noz);


        exit = new JButton("Wyjscie");
        exit.addActionListener((ActionListener) this);
        exit.setBounds(300, 300, 90, 40);
        add(exit);

        Start_Tic_Tac_Toe = new JButton("Kolko i Krzyzyk");
        Start_Tic_Tac_Toe.addActionListener((ActionListener) this);
        Start_Tic_Tac_Toe.setBounds(110, 80, 200, 50);
        add(Start_Tic_Tac_Toe);


        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setTitle("Gierki");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}


