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
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GuiHelper {
	private JLayeredPane pane;
	private JLayeredPane housesPane = null;
	private JLabel numHouses = null;
	private JLayeredPane hotelsPane = null;
	private JLabel numHotels = null;
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
				Monopoly.getInstance().getTurn().update("");
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
	
	public void setHotel(int x, int y, int height, int width) {
		hotelsPane = new JLayeredPane();
		numHotels = new JLabel();
		GUI.frame.add(hotelsPane);
		GUI.frame.add(numHotels);
		hotelsPane.setBounds(x, y, height, width);
		hotelsPane.setBorder(BorderFactory.createLineBorder(Color.red, 2));
		numHotels.setText("" + Monopoly.getInstance().getHotels(index));
		numHotels.setFont(new Font("Arial", Font.BOLD, 12));
		numHotels.setBounds( x + 7, y + 4, height - 10, width - 10);
	}
	
	public void setHouses(int x, int y, int height, int width) {
		housesPane = new JLayeredPane();
		numHouses = new JLabel();
		GUI.frame.add(housesPane);
		GUI.frame.add(numHouses);
		housesPane.setBounds(x, y, height, width);
		housesPane.setBorder(BorderFactory.createLineBorder(Color.green, 2));
		numHouses.setText("" + Monopoly.getInstance().getHouses(index));
		numHouses.setFont(new Font("Arial", Font.BOLD, 12));
		numHouses.setBounds( x + 7, y + 4, height - 10, width - 10);
	}
	
	public void updateCounts() {
		if (hotelsPane == null) {
			return;
		}
		numHouses.setText("" + Monopoly.getInstance().getHouses(index));
		numHotels.setText("" + Monopoly.getInstance().getHotels(index));
	}
}
