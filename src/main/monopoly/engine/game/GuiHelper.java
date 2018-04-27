package monopoly.engine.game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class GuiHelper {
	private JLayeredPane pane;
	private JButton square;
	
	public GuiHelper() {}
	
	public GuiHelper(int x, int y, int width, int height, ArrayList<JLayeredPane> list, String imgJPG) {
		pane = new JLayeredPane();
		square = new JButton();
		pane.add(square);
		pane.setBounds(x, y, width, height);
		
		list.add(pane);
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/" + imgJPG + ".jpg"));
			square.setIcon(new ImageIcon(img));
			square.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		} catch (IOException ex) {
			System.out.println("ERROR: Unable to set " + imgJPG + "image.");
		}
	}
	
	public JLayeredPane getPane() {
		return pane;
	}

	public void setLayout(FlowLayout flow) {
		pane.setLayout(flow);
		
	}

	public void setIcon(ImageIcon imageIcon) {
		square.setIcon(imageIcon);
	}
}
