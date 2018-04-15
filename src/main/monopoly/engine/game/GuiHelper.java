package monopoly.engine.game;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GuiHelper {
	private JLayeredPane pane;
	private JLabel label;
	private int xcoord;
	private int ycoord;
	private int width;
	private int height;
	
	public GuiHelper() {}
	
	public GuiHelper(int x, int y, int width, int height, ArrayList<JLayeredPane> list, String imgJPG) {
		pane = new JLayeredPane();
		label = new JLabel();
		pane.add(label);
		pane.setBounds(x, y, width, height);
		xcoord = x;
		ycoord = y;
		this.width = width;
		this.height = height;
		list.add(pane);
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/" + imgJPG + ".jpg"));
			label.setIcon(new ImageIcon(img));
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
		label.setIcon(imageIcon);
	}

}
