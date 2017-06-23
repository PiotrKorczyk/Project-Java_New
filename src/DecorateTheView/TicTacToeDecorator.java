package DecorateTheView;

import javax.swing.*;
import java.awt.*;

public class TicTacToeDecorator extends ViewDecorator {

	
	public TicTacToeDecorator(InterfaceView dekorowanyWidok) {
		super(dekorowanyWidok);
		// TODO Auto-generated constructor stub
	}
	
	public JLabel setTheGameBackground(int WIDTH, int HEIGHT) {
		Image icon = new ImageIcon(getClass().getResource("background.jpg")).getImage();

		ImageIcon bg = new ImageIcon(icon);
		JLabel background=new JLabel(bg);
        background.setOpaque(true);
        background.setBounds(0,0,WIDTH,HEIGHT);
        return background;
	}	
}
