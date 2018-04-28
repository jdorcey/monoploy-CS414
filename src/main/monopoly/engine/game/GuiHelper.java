package monopoly.engine.game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import monopoly.engine.player.Player;

public class GuiHelper {
	private JLayeredPane pane;
	private JButton square;
	private int index; 
	
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
		square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GuiStateTracker t = GuiStateTracker.getInstance();
				t.toggleIndex(index);
				toggleBorder(t.stateAtIndex(index));
			}
		});
	}
	
	private void toggleBorder(boolean toggle) {
		if (!toggle)
			pane.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		else
			pane.setBorder(BorderFactory.createLineBorder(Color.magenta, 2));
	}
	
	public void updateIndex(ArrayList<GuiHelper> tiles) {
		index = tiles.indexOf(this);
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
