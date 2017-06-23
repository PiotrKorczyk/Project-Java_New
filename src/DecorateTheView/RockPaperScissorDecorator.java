package DecorateTheView;

import javax.swing.*;
import java.awt.*;

public class RockPaperScissorDecorator extends ViewDecorator {

	
	public RockPaperScissorDecorator(InterfaceView dekorowanyWidok) {
		super(dekorowanyWidok);
		// TODO Auto-generated constructor stub
	}
	
	public JLabel setTheGameBackground(int WIDTH, int HEIGHT) {
		Image icon = new ImageIcon(getClass().getResource("Untitled-2.jpg")).getImage();

		ImageIcon bg = new ImageIcon(icon);
		JLabel background=new JLabel(bg);
        background.setOpaque(true);
        background.setBounds(0,0,WIDTH,HEIGHT);
        return background;
	}
}