package monopoly.engine.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import monopoly.engine.player.Player;

public class GUI {
	private JFrame frame;
	
	private JLayeredPane freePark = new JLayeredPane();
	private JLayeredPane justVisit = new JLayeredPane();
	private JLayeredPane goJail = new JLayeredPane();
	private JLayeredPane pGo = new JLayeredPane();
	private JLayeredPane nyAve = new JLayeredPane();
	private JLayeredPane tennAve = new JLayeredPane();
	private JLayeredPane commChestL = new JLayeredPane();
	private JLayeredPane stJamesPl = new JLayeredPane();
	private JLayeredPane pennRR = new JLayeredPane();
	private JLayeredPane virginiaAve = new JLayeredPane();
	private JLayeredPane statesAve = new JLayeredPane();
	private JLayeredPane electricComp = new JLayeredPane();
	private JLayeredPane stCharlesPl = new JLayeredPane();
	private JLayeredPane kentuckyAve = new JLayeredPane();
	private JLayeredPane chanceU = new JLayeredPane();
	private JLayeredPane indianaAve = new JLayeredPane();
	private JLayeredPane illinoisAve = new JLayeredPane();
	private JLayeredPane boRR = new JLayeredPane();
	private JLayeredPane atlanticAve = new JLayeredPane();
	private JLayeredPane ventnorAve = new JLayeredPane();
	private JLayeredPane waterWorks = new JLayeredPane();
	private JLayeredPane marvinGards = new JLayeredPane();
	private JLayeredPane pacificAve = new JLayeredPane();
	private JLayeredPane northCarolinaAve = new JLayeredPane();
	private JLayeredPane commChestR = new JLayeredPane();
	private JLayeredPane pennAve = new JLayeredPane();
	private JLayeredPane shortLRR = new JLayeredPane();
	private JLayeredPane chanceR = new JLayeredPane();
	private JLayeredPane parkPl = new JLayeredPane();
	private JLayeredPane luxTax = new JLayeredPane();
	private JLayeredPane bdwalk = new JLayeredPane();
	private JLayeredPane connAve = new JLayeredPane();
	private JLayeredPane vermontAve = new JLayeredPane();
	private JLayeredPane chanceBot = new JLayeredPane();
	private JLayeredPane orientalAve = new JLayeredPane();
	private JLayeredPane readingRR = new JLayeredPane();
	private JLayeredPane inTax = new JLayeredPane();
	private JLayeredPane balticAve = new JLayeredPane();
	private JLayeredPane commChestB = new JLayeredPane();
	private JLayeredPane medAve = new JLayeredPane();
	private JLayeredPane p1 = new JLayeredPane();
	private JLayeredPane p2 = new JLayeredPane();
	private JLayeredPane p3 = new JLayeredPane();
	private JLayeredPane p4 = new JLayeredPane();
	
	private JLabel passGo = new JLabel();
	private JLabel connAvenue = new JLabel();
	private JLabel vermontAvenue = new JLabel();
	private JLabel chanceBottom = new JLabel();
	private JLabel orientalAvenue = new JLabel();
	private JLabel readingRailroad = new JLabel();
	private JLabel incomeTax = new JLabel();
	private JLabel balticAvenue = new JLabel();
	private JLabel commChestBottom = new JLabel();
	private JLabel mediterraneanAvenue = new JLabel();
	private JLabel justVisiting = new JLabel();
	private JLabel nyAvenue = new JLabel();
	private JLabel tennAvenue = new JLabel();
	private JLabel commChestLeft = new JLabel();
	private JLabel stJamesPlace = new JLabel();
	private JLabel pennRailroad = new JLabel();
	private JLabel virginiaAvenue = new JLabel();
	private JLabel statesAvenue = new JLabel();
	private JLabel electricCompanyUtil = new JLabel();
	private JLabel stCharlesPlace = new JLabel();
	private JLabel freeParking = new JLabel();
	private JLabel kentuckyAvenue = new JLabel();
	private JLabel chanceUp = new JLabel();
	private JLabel indianaAvenue = new JLabel();
	private JLabel illinoisAvenue = new JLabel();
	private JLabel boRailroad = new JLabel();
	private JLabel atlanticAvenue = new JLabel();
	private JLabel ventnorAvenue = new JLabel();
	private JLabel waterWorksUtil = new JLabel();
	private JLabel marvinGardens = new JLabel();
	private JLabel gotoJail = new JLabel();
	private JLabel pacificAvenue = new JLabel();
	private JLabel northCarolinaAvenue = new JLabel();
	private JLabel commChestRight = new JLabel();
	private JLabel pennAvenue = new JLabel();
	private JLabel shortLineRailroad = new JLabel();
	private JLabel chanceRi = new JLabel();
	private JLabel parkPlace = new JLabel();
	private JLabel luxuryTax = new JLabel();
	private JLabel boardwalk = new JLabel();
	
	private JButton communityChestButton = new JButton();
	private JButton chanceButton = new JButton();
	private JButton rollDiceButton = new JButton("Roll Dice");
	private JButton buyButton = new JButton("Buy Properties");
	private JButton sellButton = new JButton("Sell Properties");
	private JButton tradeButton = new JButton("Trade");
	private JButton auctionButton = new JButton("Auction");
	private JButton fileBankruptcyButton = new JButton("File Bankruptcy");
	private JButton addPlayer1 = new JButton("Add Player");
	private JButton addPlayer2 = new JButton("Add Player");
	private JButton addPlayer3 = new JButton("Add Player");
	private JButton addPlayer4 = new JButton("Add Player");
	private JButton player1Token = new JButton();
	private JButton player2Token = new JButton();
	private JButton player3Token = new JButton();
	private JButton player4Token = new JButton();

	private ArrayList<JLayeredPane> playersPanels;
	private ArrayList<JLayeredPane> boardPanels;
	private int frameWidth;
	private int frameHeight;

	/**
	 * GUI constructor to create the main frame
	 */
	public GUI() {
		boardPanels = new ArrayList<JLayeredPane>();	
		playersPanels = new ArrayList<JLayeredPane>();

		initialize();
	}
	
	/**
	 * Set board squares
	 */
	private void setSquare(JLabel square, String imgJPG) {
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/" + imgJPG + ".jpg"));
			square.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("ERROR: Unable to set " + square + "image.");
		}
	}
	
	/**
	 * Set Buttons on Board
	 */
	private void setButton(JButton button, String imgJPG) {
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/" + imgJPG + ".jpg"));
			button.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("ERROR: Unable to set " + button + "image.");
		}
		button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
	}
	
	private void setLeftSquares() {
		nyAve.setBounds(10, (int) (frameHeight / 11.5), (int) (frameHeight / .451), (int) (frameHeight / 13));
		tennAve.setBounds(0, (int) (frameHeight / 6.7), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		commChestL.setBounds(0, (int) (frameHeight / 4.72), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		stJamesPl.setBounds(0, (int) (frameHeight / 3.65), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		pennRR.setBounds(0, (int) (frameHeight / 3), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		virginiaAve.setBounds(0, (int) (frameHeight / 2.52), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		statesAve.setBounds(0, (int) (frameHeight / 2.17435), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		electricComp.setBounds(0, (int) (frameHeight / 1.911), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		stCharlesPl.setBounds(0, (int) (frameHeight / 1.705), (int) (frameHeight / .4491), (int) (frameHeight / 9));
		justVisit.setBounds(0, (int) (frameHeight / 1.54), (int) (frameHeight / .4491), (int) (frameHeight / 6.5));
				
		boardPanels.add(justVisit);
		boardPanels.add(stCharlesPl);
		boardPanels.add(electricComp);
		boardPanels.add(statesAve);
		boardPanels.add(virginiaAve);
		boardPanels.add(pennRR);
		boardPanels.add(stJamesPl);
		boardPanels.add(commChestL);
		boardPanels.add(tennAve);
		boardPanels.add(nyAve);
				
		setSquare(nyAvenue, "newYorkAvenue");
		setSquare(tennAvenue, "tennesseeAvenue");
		setSquare(commChestLeft, "communityChestL");
		setSquare(stJamesPlace, "stJamesPlace");
		setSquare(pennRailroad, "pennRailroad");
		setSquare(virginiaAvenue, "virginiaAvenue");
		setSquare(statesAvenue, "statesAvenue");
		setSquare(electricCompanyUtil, "electricCompanyUtil");
		setSquare(stCharlesPlace, "stCharlesPlace");
		setSquare(justVisiting, "justVisiting");
		
		nyAve.add(nyAvenue);
		tennAve.add(tennAvenue);
		commChestL.add(commChestLeft);
		stJamesPl.add(stJamesPlace);
		pennRR.add(pennRailroad);
		virginiaAve.add(virginiaAvenue);
		statesAve.add(statesAvenue);
		electricComp.add(electricCompanyUtil);
		stCharlesPl.add(stCharlesPlace);
		justVisit.add(justVisiting);
		
		
		
	}
	
	private void setUpperSquares() {
		freePark.setBounds(5, 3, (int) (frameHeight / .45), (int) (frameHeight / 6.5));
		kentuckyAve.setBounds((int) (frameHeight / 6.5), 0, (int) (frameHeight / .484), (int) (frameHeight / 6.5));
		chanceU.setBounds((int) (frameHeight / 6.5 * 1.5), 0, (int) (frameHeight / .492), (int) (frameHeight / 6.5));
		indianaAve.setBounds((int) (frameHeight / 6.5 * 2), 0, (int) (frameHeight / .5), (int) (frameHeight / 6.5));
		illinoisAve.setBounds((int) (frameHeight / 6.5 * 2.5), 0, (int) (frameHeight / .508), (int) (frameHeight / 6.5));
		boRR.setBounds((int) (frameHeight / 6.5 * 3), 0, (int) (frameHeight / .516), (int) (frameHeight / 6.5));
		atlanticAve.setBounds((int) (frameHeight / 6.5 * 3.5), 0, (int) (frameHeight / .524), (int) (frameHeight / 6.5));
		ventnorAve.setBounds((int) (frameHeight / 6.5 * 4), 0, (int) (frameHeight / .532), (int) (frameHeight / 6.5));
		waterWorks.setBounds((int) (frameHeight / 6.5 * 4.5), 0, (int) (frameHeight / .54), (int) (frameHeight / 6.5));
		marvinGards.setBounds((int) (frameHeight / 6.5 * 5), 0, (int) (frameHeight /.548), (int) (frameHeight / 6.5));
		
		boardPanels.add(freePark);
		boardPanels.add(kentuckyAve);
		boardPanels.add(chanceU);
		boardPanels.add(indianaAve);
		boardPanels.add(illinoisAve);
		boardPanels.add(boRR);
		boardPanels.add(atlanticAve);
		boardPanels.add(ventnorAve);
		boardPanels.add(waterWorks);
		boardPanels.add(marvinGards);
		
		setSquare(freeParking, "freeParking");
		setSquare(kentuckyAvenue, "KentuckyAvenue");
		setSquare(chanceUp, "chanceUp");
		setSquare(indianaAvenue, "IndianaAvenue");
		setSquare(illinoisAvenue, "illinoisAvenue");
		setSquare(boRailroad, "boRailroad");
		setSquare(atlanticAvenue, "AtlanticAvenue");
		setSquare(ventnorAvenue, "VentnorAvenue");
		setSquare(waterWorksUtil, "waterWorksUtil");
		setSquare(marvinGardens, "MarvinGardens");
		
		freePark.add(freeParking);
		kentuckyAve.add(kentuckyAvenue);
		chanceU.add(chanceUp);
		indianaAve.add(indianaAvenue);
		illinoisAve.add(illinoisAvenue);
		boRR.add(boRailroad);
		atlanticAve.add(atlanticAvenue);
		ventnorAve.add(ventnorAvenue);
		waterWorks.add(waterWorksUtil);
		marvinGards.add(marvinGardens);
		
		
	}
	
	private void setRightSquares() {
		goJail.setBounds((int) (frameHeight / 6.5 * 10.9), 0, (int) (frameHeight / 6.5), (int) (frameHeight / 6.5));
		pacificAve.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 11.8), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		northCarolinaAve.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 6.745), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		commChestR.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 4.745), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		pennAve.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 3.65), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		shortLRR.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 2.98), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		chanceR.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 2.51), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		parkPl.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 2.17), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		luxTax.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 1.91), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		bdwalk.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 1.71), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		
		boardPanels.add(goJail);
		boardPanels.add(pacificAve);
		boardPanels.add(northCarolinaAve);
		boardPanels.add(commChestR);
		boardPanels.add(pennAve);
		boardPanels.add(shortLRR);
		boardPanels.add(chanceR);
		boardPanels.add(parkPl);
		boardPanels.add(luxTax);
		boardPanels.add(bdwalk);
		
		setSquare(gotoJail, "gotoJail");
		setSquare(pacificAvenue, "PacificAvenue");
		setSquare(northCarolinaAvenue, "northCarolinaAvenue");
		setSquare(commChestRight, "communityChestR");
		setSquare(pennAvenue, "PennsylvaniaAvenue");
		setSquare(shortLineRailroad, "shortLine");
		setSquare(chanceRi, "chanceRi");
		setSquare(parkPlace, "parkPlace");
		setSquare(luxuryTax, "luxuryTax");
		setSquare(boardwalk, "boardwalk");
		
		goJail.add(gotoJail);
		pacificAve.add(pacificAvenue);
		northCarolinaAve.add(northCarolinaAvenue);
		commChestR.add(commChestRight);
		pennAve.add(pennAvenue);
		shortLRR.add(shortLineRailroad);
		chanceR.add(chanceRi);
		parkPl.add(parkPlace);
		luxTax.add(luxuryTax);
		bdwalk.add(boardwalk);
		
		
	}
	
	private void setBottomSquares() {
		connAve.setBounds((int) (frameHeight / .86999), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		vermontAve.setBounds((int) (frameHeight / .8249), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		chanceBot.setBounds((int) (frameHeight / .7835), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		orientalAve.setBounds((int) (frameHeight / .746), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		readingRR.setBounds((int) (frameHeight / .715), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		inTax.setBounds((int) (frameHeight / .685), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		balticAve.setBounds((int) (frameHeight / .664), (int) (frameHeight / 1.544), (int) (frameHeight / 10), (int) (frameHeight / 4.5));
		commChestB.setBounds((int) (frameHeight / .6334), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		medAve.setBounds((int) (frameHeight / .6134), (int) (frameHeight / 1.544), (int) (frameHeight / 10), (int) (frameHeight / 4.5));
		pGo.setBounds((int) (frameHeight / .596), (int) (frameHeight / 1.54), (int) (frameHeight / 6.5), (int) (frameHeight / 6.5));

		boardPanels.add(pGo);
		boardPanels.add(medAve);
		boardPanels.add(commChestB);
		boardPanels.add(balticAve);
		boardPanels.add(inTax);
		boardPanels.add(readingRR);
		boardPanels.add(orientalAve);
		boardPanels.add(chanceBot);
		boardPanels.add(vermontAve);
		boardPanels.add(connAve);
		
		setSquare(passGo, "passGo");
		setSquare(connAvenue, "connecticutAvenue");
		setSquare(vermontAvenue, "vermontAvenue");
		setSquare(chanceBottom, "chanceBot");
		setSquare(orientalAvenue, "orientalAvenue");
		setSquare(readingRailroad, "readingRailroad");
		setSquare(incomeTax, "incomeTax");
		setSquare(balticAvenue, "balticAvenue");		
		setSquare(commChestBottom, "communityChestBot");		
		setSquare(mediterraneanAvenue, "mediterraneanAvenue");
		
		pGo.add(passGo);
		connAve.add(connAvenue);
		vermontAve.add(vermontAvenue);
		chanceBot.add(chanceBottom);
		orientalAve.add(orientalAvenue);
		readingRR.add(readingRailroad);
		inTax.add(incomeTax);
		balticAve.add(balticAvenue);
		commChestB.add(commChestBottom);
		medAve.add(mediterraneanAvenue);
		
		
		
		
	}
	
	private void addButtonsToBoard() {
		
		
	}

	/**
	 * Initializes the game frame
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		FlowLayout flow = new FlowLayout();
		flow.setHgap(0);
		flow.setVgap(0);
		frame = new JFrame("T13 Monopoly Game CS414");
		frame.setLayout(flow);
		frame.getContentPane().setBackground(new Color(212, 252, 228));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(screenSize);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frameHeight = frame.getHeight() - 40;
		frameWidth = frame.getWidth();
		
		setLeftSquares();
		setUpperSquares();
		setRightSquares();
		setBottomSquares();
		
		//set flow layouts
		//left squares
		nyAve.setLayout(flow);
		tennAve.setLayout(flow);
		commChestL.setLayout(flow);
		stJamesPl.setLayout(flow);
		pennRR.setLayout(flow);
		virginiaAve.setLayout(flow);
		statesAve.setLayout(flow);
		electricComp.setLayout(flow);
		stCharlesPl.setLayout(flow);
		justVisit.setLayout(flow);
		
		//upper squares		
		freePark.setLayout(flow);
		kentuckyAve.setLayout(flow);
		chanceU.setLayout(flow);
		indianaAve.setLayout(flow);
		illinoisAve.setLayout(flow);
		boRR.setLayout(flow);
		atlanticAve.setLayout(flow);
		ventnorAve.setLayout(flow);
		waterWorks.setLayout(flow);
		marvinGards.setLayout(flow);

		//right squares
		goJail.setLayout(flow);
		pacificAve.setLayout(flow);
		northCarolinaAve.setLayout(flow);
		commChestR.setLayout(flow);
		pennAve.setLayout(flow);
		shortLRR.setLayout(flow);
		chanceR.setLayout(flow);
		parkPl.setLayout(flow);
		luxTax.setLayout(flow);
		bdwalk.setLayout(flow);
	
		//bottom squares
		connAve.setLayout(flow);
		vermontAve.setLayout(flow);
		chanceBot.setLayout(flow);
		orientalAve.setLayout(flow);
		readingRR.setLayout(flow);
		inTax.setLayout(flow);
		balticAve.setLayout(flow);
		commChestB.setLayout(flow);
		medAve.setLayout(flow);
		pGo.setLayout(flow);
		
		
		//set buttons on board		
		communityChestButton.setBounds((int) (frameHeight / .81), (int) (frameHeight / 7), (int) (frameHeight / 7), (int) (frameHeight / 5));
		chanceButton.setBounds((int) (frameHeight / .7), (int) (frameHeight / 2.5), (int) (frameHeight / 3.33), (int) (frameHeight / 5));
		setButton(communityChestButton, "chest");
		setButton(chanceButton, "chance");
		
		rollDiceButton.setBounds((int) (frameHeight / 1.5), 250, 300, 130);
		buyButton.setBounds((int) (frameHeight / 1.5), 450, 300, 130);
		sellButton.setBounds((int) (frameHeight / 1.5), 650, 300, 130);
		auctionButton.setBounds((int) (frameHeight / 1.5), 850, 300, 130);
		tradeButton.setBounds((int) (frameHeight / 1.5), 1050, 300, 130);
		fileBankruptcyButton.setBounds((int) (frameHeight / 1.5), 1250, 300, 130);

		
		rollDiceButton.setFont(new Font("Arial", Font.BOLD, 34));
		rollDiceButton.setBackground(new Color(255, 100, 100));
		rollDiceButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		buyButton.setFont(new Font("Arial", Font.BOLD, 34));
		buyButton.setBackground(new Color(74, 165, 255));
		buyButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		sellButton.setFont(new Font("Arial", Font.BOLD, 34));
		sellButton.setBackground(new Color(255, 172, 89));
		sellButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		auctionButton.setFont(new Font("Arial", Font.BOLD, 34));
		auctionButton.setBackground(new Color(255, 255, 172));
		auctionButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		tradeButton.setFont(new Font("Arial", Font.BOLD, 34));
		tradeButton.setBackground(new Color(153, 153, 255));
		tradeButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		fileBankruptcyButton.setFont(new Font("Arial", Font.BOLD, 34));
		fileBankruptcyButton.setBackground(new Color(103, 180, 180));
		fileBankruptcyButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		//set player section of board
		addPlayer1.setBounds(frameHeight + 215, 1800, 250, 110);
		addPlayer1.setFont(new Font("Arial", Font.BOLD, 34));
		addPlayer1.setBackground(new Color(0, 255, 128));
		addPlayer1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		player1Token.setBounds(frameHeight + 210, 1680, 250, 70);
		setButton(player1Token, "dogToken");
		
		addPlayer2.setBounds(frameHeight + 600, 1800, 250, 110);
		addPlayer2.setFont(new Font("Arial", Font.BOLD, 34));
		addPlayer2.setBackground(new Color(0, 255, 128));
		addPlayer2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		player2Token.setBounds(frameHeight + 600, 1680, 250, 70);
		setButton(player2Token, "battleShipToken");
		
		addPlayer3.setBounds(frameHeight + 985, 1800, 250, 110);
		addPlayer3.setFont(new Font("Arial", Font.BOLD, 34));
		addPlayer3.setBackground(new Color(0, 255, 128));
		addPlayer3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		player3Token.setBounds(frameHeight + 985, 1680, 250, 70);
		setButton(player3Token, "carToken");
		
		addPlayer4.setBounds(frameHeight + 1370, 1800, 250, 110);
		addPlayer4.setFont(new Font("Arial", Font.BOLD, 34));
		addPlayer4.setBackground(new Color(0, 255, 128));
		addPlayer4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		player4Token.setBounds(frameHeight + 1370, 1680, 250, 70);
		setButton(player4Token, "hatToken");
		
		p1.setBounds(frameHeight + 145, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		p1.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p2.setBounds(frameHeight + 530, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p3.setBounds(frameHeight + 915, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		p3.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p4.setBounds(frameHeight + 1300, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		p4.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		
		playersPanels.add(p1);
		playersPanels.add(p2);
		playersPanels.add(p3);
		playersPanels.add(p4);
	
		player1Token.setVisible(true);
		player2Token.setVisible(true);
		player3Token.setVisible(true);
		player4Token.setVisible(true);
		
		//add everything to frame
		frame.getContentPane().add(player1Token);
		frame.getContentPane().add(player2Token);
		frame.getContentPane().add(player3Token);
		frame.getContentPane().add(player4Token);
		frame.getContentPane().add(p1);
		frame.getContentPane().add(p2);
		frame.getContentPane().add(p3);
		frame.getContentPane().add(p4);
		frame.getContentPane().add(addPlayer1);
		frame.getContentPane().add(addPlayer2);
		frame.getContentPane().add(addPlayer3);
		frame.getContentPane().add(addPlayer4);
	
		frame.getContentPane().add(justVisit);
		frame.getContentPane().add(freePark);
		frame.getContentPane().add(nyAve);
		frame.getContentPane().add(tennAve);
		frame.getContentPane().add(commChestL);
		frame.getContentPane().add(stJamesPl);
		frame.getContentPane().add(pennRR);
		frame.getContentPane().add(virginiaAve);
		frame.getContentPane().add(statesAve);
		frame.getContentPane().add(electricComp);
		frame.getContentPane().add(stCharlesPl);
		frame.getContentPane().add(kentuckyAve);
		frame.getContentPane().add(chanceU);
		frame.getContentPane().add(indianaAve);
		frame.getContentPane().add(illinoisAve);
		frame.getContentPane().add(boRR);
		frame.getContentPane().add(atlanticAve);
		frame.getContentPane().add(ventnorAve);
		frame.getContentPane().add(waterWorks);
		frame.getContentPane().add(marvinGards);
		frame.getContentPane().add(goJail);
		frame.getContentPane().add(pacificAve);
		frame.getContentPane().add(northCarolinaAve);
		frame.getContentPane().add(commChestR);
		frame.getContentPane().add(pennAve);
		frame.getContentPane().add(shortLRR);
		frame.getContentPane().add(chanceR);
		frame.getContentPane().add(parkPl);
		frame.getContentPane().add(luxTax);
		frame.getContentPane().add(bdwalk);
		frame.getContentPane().add(connAve);
		frame.getContentPane().add(vermontAve);
		frame.getContentPane().add(chanceBot);
		frame.getContentPane().add(orientalAve);
		frame.getContentPane().add(readingRR);
		frame.getContentPane().add(inTax);
		frame.getContentPane().add(balticAve);
		frame.getContentPane().add(commChestB);
		frame.getContentPane().add(medAve);
		frame.getContentPane().add(pGo);
		frame.getContentPane().add(communityChestButton);
		frame.getContentPane().add(chanceButton);
		frame.getContentPane().add(rollDiceButton);
		frame.getContentPane().add(buyButton);
		frame.getContentPane().add(sellButton);
		frame.getContentPane().add(auctionButton);
		frame.getContentPane().add(tradeButton);
		frame.getContentPane().add(fileBankruptcyButton);
	}
	
	/**
	 * Launch application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
