package monopoly.engine.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GUI {
	private JFrame frame;
	
	private JLayeredPane freePark;
	private JLayeredPane justVisit;
	private JLayeredPane goJail;
	private JLayeredPane pGo;
	private JLayeredPane nyAve;
	private JLayeredPane tennAve;
	private JLayeredPane commChestL;
	private JLayeredPane stJamesPl;
	private JLayeredPane pennRR;
	private JLayeredPane virginiaAve;
	private JLayeredPane statesAve;
	private JLayeredPane electricComp;
	private JLayeredPane stCharlesPl;
	private JLayeredPane kentuckyAve;
	private JLayeredPane chanceU;
	private JLayeredPane indianaAve;
	private JLayeredPane illinoisAve;
	private JLayeredPane boRR;
	private JLayeredPane atlanticAve;
	private JLayeredPane ventnorAve;
	private JLayeredPane waterWorks;
	private JLayeredPane marvinGards;
	private JLayeredPane pacificAve;
	private JLayeredPane northCarolinaAve;
	private JLayeredPane comChestR;
	private JLayeredPane pennAve;
	private JLayeredPane shortLRR;
	private JLayeredPane chanceR;
	private JLayeredPane parkPl;
	private JLayeredPane luxTax;
	private JLayeredPane bdwalk;
	private JLayeredPane connAve;
	private JLayeredPane vermontAve;
	private JLayeredPane chanceBot;
	private JLayeredPane orientalAve;
	private JLayeredPane readingRR;
	private JLayeredPane inTax;
	private JLayeredPane balticAve;
	private JLayeredPane comChestBot;
	private JLayeredPane medAve;
	private JLayeredPane player1;
	private JLayeredPane player2;
	private JLayeredPane player3;
	private JLayeredPane player4;

	private int frameHeight;
	
	private JButton communityChest;
	private JButton chanceButton;
	private JButton rollDiceButton;
	private JButton buyButton;
	private JButton sellButton;
	private JButton tradeButton;
	private JButton auctionButton;
	private JButton fileBankruptcyButton;
	
	private JLabel passGo;
	private JLabel connAvenue;
	private JLabel vermontAvenue;
	private JLabel chanceBottom;
	private JLabel orientalAvenue;
	private JLabel readingRailroad;
	private JLabel incomeTax;
	private JLabel balticAvenue;
	private JLabel comChestBottom;
	private JLabel mediterraneanAvenue;
	private JLabel justVisiting;
	private JLabel nyAvenue;
	private JLabel tennAvenue;
	private JLabel commChestLe;
	private JLabel stJamesPlace;
	private JLabel pennRailroad;
	private JLabel virginiaAvenue;
	private JLabel statesAvenue;
	private JLabel electricCompanyUtil;
	private JLabel stCharlesPlace;
	private JLabel freeParking;
	private JLabel kentuckyAvenue;
	private JLabel chanceUp;
	private JLabel indianaAvenue;
	private JLabel illinoisAvenue;
	private JLabel boRailroad;
	private JLabel atlanticAvenue;
	private JLabel ventnorAvenue;
	private JLabel waterWorksUtil;
	private JLabel marvinGardens;
	private JLabel gotoJail;
	private JLabel pacificAvenue;
	private JLabel northCarolinaAvenue;
	private JLabel comChestRight;
	private JLabel pennAvenue;
	private JLabel shortLineRailroad;
	private JLabel chanceRi;
	private JLabel parkPlace;
	private JLabel luxuryTax;
	private JLabel boardwalk;
	
	private ArrayList<JLayeredPane> boardPanels;
	private int frameWidth;

	/**
	 * Create main frame.
	 */
	public GUI() {
		boardPanels = new ArrayList<JLayeredPane>();		
		initialize();
	}

	/**
	 * Initialize game frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		FlowLayout flow = new FlowLayout();
		flow.setHgap(0);
		flow.setVgap(0);
		frame = new JFrame("T13 Monopoly Game CS414");
		frame.setLayout(flow);
		frame.getContentPane().setBackground(new Color(212, 252, 228));
		//frame.setForeground(new Color(200, 191, 231));
		//frame.setBackground(new Color(255, 174, 201));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(screenSize);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frameHeight = frame.getHeight() - 40;
		frameWidth = frame.getWidth();
		
		//left side of board
		nyAve = new JLayeredPane();
		nyAve.setBounds(10, (int) (frameHeight / 11.5), (int) (frameHeight / .451), (int) (frameHeight / 13));
		tennAve = new JLayeredPane();
		tennAve.setBounds(0, (int) (frameHeight / 6.7), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		commChestL = new JLayeredPane();
		commChestL.setBounds(0, (int) (frameHeight / 4.72), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		stJamesPl = new JLayeredPane();
		stJamesPl.setBounds(0, (int) (frameHeight / 3.65), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		pennRR = new JLayeredPane();
		pennRR.setBounds(0, (int) (frameHeight / 3), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		virginiaAve = new JLayeredPane();
		virginiaAve.setBounds(0, (int) (frameHeight / 2.52), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		statesAve = new JLayeredPane();
		statesAve.setBounds(0, (int) (frameHeight / 2.17435), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		electricComp = new JLayeredPane();
		electricComp.setBounds(0, (int) (frameHeight / 1.911), (int) (frameHeight / .4491), (int) (frameHeight / 13));
		stCharlesPl = new JLayeredPane();
		stCharlesPl.setBounds(0, (int) (frameHeight / 1.705), (int) (frameHeight / .4491), (int) (frameHeight / 9));
		justVisit = new JLayeredPane();
		justVisit.setBounds(0, (int) (frameHeight / 1.54), (int) (frameHeight / .4491), (int) (frameHeight / 6.5));
		
		//upper side of board
		freePark = new JLayeredPane();
		freePark.setBounds(5, 3, (int) (frameHeight / .45), (int) (frameHeight / 6.5));
		kentuckyAve = new JLayeredPane();
		kentuckyAve.setBounds((int) (frameHeight / 6.5), 0, (int) (frameHeight / .484), (int) (frameHeight / 6.5));
		chanceU = new JLayeredPane();
		chanceU.setBounds((int) (frameHeight / 6.5 * 1.5), 0, (int) (frameHeight / .492), (int) (frameHeight / 6.5));
		indianaAve = new JLayeredPane();
		indianaAve.setBounds((int) (frameHeight / 6.5 * 2), 0, (int) (frameHeight / .5), (int) (frameHeight / 6.5));
		illinoisAve = new JLayeredPane();
		illinoisAve.setBounds((int) (frameHeight / 6.5 * 2.5), 0, (int) (frameHeight / .508), (int) (frameHeight / 6.5));
		boRR = new JLayeredPane();
		boRR.setBounds((int) (frameHeight / 6.5 * 3), 0, (int) (frameHeight / .516), (int) (frameHeight / 6.5));
		atlanticAve = new JLayeredPane();
		atlanticAve.setBounds((int) (frameHeight / 6.5 * 3.5), 0, (int) (frameHeight / .524), (int) (frameHeight / 6.5));
		ventnorAve = new JLayeredPane();
		ventnorAve.setBounds((int) (frameHeight / 6.5 * 4), 0, (int) (frameHeight / .532), (int) (frameHeight / 6.5));
		waterWorks = new JLayeredPane();
		waterWorks.setBounds((int) (frameHeight / 6.5 * 4.5), 0, (int) (frameHeight / .54), (int) (frameHeight / 6.5));
		marvinGards = new JLayeredPane();
		marvinGards.setBounds((int) (frameHeight / 6.5 * 5), 0, (int) (frameHeight /.548), (int) (frameHeight / 6.5));
		
		//right side of board
		goJail = new JLayeredPane();
		goJail.setBounds((int) (frameHeight / 6.5 * 10.9), 0, (int) (frameHeight / 6.5), (int) (frameHeight / 6.5));
		pacificAve = new JLayeredPane();
		pacificAve.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 11.8), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		northCarolinaAve = new JLayeredPane();
		northCarolinaAve.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 6.745), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		comChestR = new JLayeredPane();
		comChestR.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 4.745), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		pennAve = new JLayeredPane();
		pennAve.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 3.65), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		shortLRR = new JLayeredPane();
		shortLRR.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 2.98), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		chanceR = new JLayeredPane();
		chanceR.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 2.51), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		parkPl = new JLayeredPane();
		parkPl.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 2.17), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		luxTax = new JLayeredPane();
		luxTax.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 1.91), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		bdwalk = new JLayeredPane();
		bdwalk.setBounds((int) (frameHeight / 6.5 * 10.9), (int) (frameHeight / 1.71), (int) (frameHeight / 6.5), (int) (frameHeight / 13));
		
		//bottom side of board
		connAve = new JLayeredPane();
		connAve.setBounds((int) (frameHeight / .86999), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		vermontAve = new JLayeredPane();
		vermontAve.setBounds((int) (frameHeight / .8249), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		chanceBot = new JLayeredPane();
		chanceBot.setBounds((int) (frameHeight / .7835), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		orientalAve = new JLayeredPane();
		orientalAve.setBounds((int) (frameHeight / .746), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		readingRR = new JLayeredPane();
		readingRR.setBounds((int) (frameHeight / .715), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		inTax = new JLayeredPane();
		inTax.setBounds((int) (frameHeight / .685), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		balticAve = new JLayeredPane();
		balticAve.setBounds((int) (frameHeight / .664), (int) (frameHeight / 1.544), (int) (frameHeight / 10), (int) (frameHeight / 4.5));
		comChestBot = new JLayeredPane();
		comChestBot.setBounds((int) (frameHeight / .6334), (int) (frameHeight / 1.544), (int) (frameHeight / 13), (int) (frameHeight / 6.5));
		medAve = new JLayeredPane();
		medAve.setBounds((int) (frameHeight / .6134), (int) (frameHeight / 1.544), (int) (frameHeight / 10), (int) (frameHeight / 4.5));
		pGo = new JLayeredPane();
		pGo.setBounds((int) (frameHeight / .596), (int) (frameHeight / 1.54), (int) (frameHeight / 6.5), (int) (frameHeight / 6.5));

		boardPanels.add(pGo);
		boardPanels.add(medAve);
		boardPanels.add(comChestBot);
		boardPanels.add(balticAve);
		boardPanels.add(inTax);
		boardPanels.add(readingRR);
		boardPanels.add(orientalAve);
		boardPanels.add(chanceBot);
		boardPanels.add(vermontAve);
		boardPanels.add(connAve);
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
		boardPanels.add(goJail);
		boardPanels.add(pacificAve);
		boardPanels.add(northCarolinaAve);
		boardPanels.add(comChestR);
		boardPanels.add(pennAve);
		boardPanels.add(shortLRR);
		boardPanels.add(chanceR);
		boardPanels.add(parkPl);
		boardPanels.add(luxTax);
		boardPanels.add(bdwalk);

		passGo = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/passGo.jpg"));
			passGo.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		justVisiting = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/justVisiting.jpg"));
			justVisiting.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		connAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/connecticutAvenue.jpg"));
			connAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		vermontAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/vermontAvenue.jpg"));
			vermontAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		chanceBottom = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/chanceBot.jpg"));
			chanceBottom.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		orientalAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/orientalAvenue.jpg"));
			orientalAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		readingRailroad = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/readingRailroad.jpg"));
			readingRailroad.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		incomeTax = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/incomeTax.jpg"));
			incomeTax.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		balticAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/balticAvenue.jpg"));
			balticAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		comChestBottom = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/communityChestBot.jpg"));
			comChestBottom.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		mediterraneanAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/mediterraneanAvenue.jpg"));
			mediterraneanAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		connAve.setLayout(flow);
		vermontAve.setLayout(flow);
		chanceBot.setLayout(flow);
		orientalAve.setLayout(flow);
		readingRR.setLayout(flow);
		inTax.setLayout(flow);
		balticAve.setLayout(flow);
		comChestBot.setLayout(flow);
		medAve.setLayout(flow);
		pGo.setLayout(flow);
		justVisit.setLayout(flow);
		pGo.add(passGo);
		justVisit.add(justVisiting);

		connAve.add(connAvenue);
		vermontAve.add(vermontAvenue);
		chanceBot.add(chanceBottom);
		orientalAve.add(orientalAvenue);
		readingRR.add(readingRailroad);
		inTax.add(incomeTax);
		balticAve.add(balticAvenue);
		comChestBot.add(comChestBottom);
		medAve.add(mediterraneanAvenue);

		nyAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/newYorkAvenue.jpg"));
			nyAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		tennAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/tennesseeAvenue.jpg"));
			tennAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		commChestLe = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/communityChestL.jpg"));
			commChestLe.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		stJamesPlace = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/stJamesPlace.jpg"));
			stJamesPlace.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		pennRailroad = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/pennRailroad.jpg"));
			pennRailroad.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		virginiaAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/virginiaAvenue.jpg"));
			virginiaAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		statesAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/statesAvenue.jpg"));
			statesAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		electricCompanyUtil = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/electricCompanyUtil.jpg"));
			electricCompanyUtil.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		stCharlesPlace = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/stCharlesPlace.jpg"));
			stCharlesPlace.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		nyAve.setLayout(flow);
		tennAve.setLayout(flow);
		commChestL.setLayout(flow);
		stJamesPl.setLayout(flow);
		pennRR.setLayout(flow);
		virginiaAve.setLayout(flow);
		statesAve.setLayout(flow);
		electricComp.setLayout(flow);
		stCharlesPl.setLayout(flow);
		
		nyAve.add(nyAvenue);
		tennAve.add(tennAvenue);
		commChestL.add(commChestLe);
		stJamesPl.add(stJamesPlace);
		pennRR.add(pennRailroad);
		virginiaAve.add(virginiaAvenue);
		statesAve.add(statesAvenue);
		electricComp.add(electricCompanyUtil);
		stCharlesPl.add(stCharlesPlace);

		freeParking = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/freeParking.jpg"));
			freeParking.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		kentuckyAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/KentuckyAvenue.jpg"));
			kentuckyAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		chanceUp = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/chanceUp.jpg"));
			chanceUp.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		indianaAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/IndianaAvenue.jpg"));
			indianaAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		illinoisAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/illinoisAvenue.jpg"));
			illinoisAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		boRailroad = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/boRailroad.jpg"));
			boRailroad.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		atlanticAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/AtlanticAvenue.jpg"));
			atlanticAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		ventnorAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/VentnorAvenue.jpg"));
			ventnorAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		waterWorksUtil = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/waterWorksUtil.jpg"));
			waterWorksUtil.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		marvinGardens = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/MarvinGardens.jpg"));
			marvinGardens.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

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

		gotoJail = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/goToJail.jpg"));
			gotoJail.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		pacificAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/PacificAvenue.jpg"));
			pacificAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		northCarolinaAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/northCarolinaAvenue.jpg"));
			northCarolinaAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		comChestRight = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/communityChestR.jpg"));
			comChestRight.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		pennAvenue = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/PennsylvaniaAvenue.jpg"));
			pennAvenue.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		shortLineRailroad = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/shortLine.jpg"));
			shortLineRailroad.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		chanceRi = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/chanceRi.jpg"));
			chanceRi.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		parkPlace = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/parkPlace.jpg"));
			parkPlace.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		luxuryTax = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/luxuryTax.jpg"));
			luxuryTax.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		boardwalk = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/boardwalk.jpg"));
			boardwalk.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		goJail.setLayout(flow);
		pacificAve.setLayout(flow);
		northCarolinaAve.setLayout(flow);
		comChestR.setLayout(flow);
		pennAve.setLayout(flow);
		shortLRR.setLayout(flow);
		chanceR.setLayout(flow);
		parkPl.setLayout(flow);
		luxTax.setLayout(flow);
		bdwalk.setLayout(flow);
		
		goJail.add(gotoJail);
		pacificAve.add(pacificAvenue);
		northCarolinaAve.add(northCarolinaAvenue);
		comChestR.add(comChestRight);
		pennAve.add(pennAvenue);
		shortLRR.add(shortLineRailroad);
		chanceR.add(chanceRi);
		parkPl.add(parkPlace);
		luxTax.add(luxuryTax);
		bdwalk.add(boardwalk);

		communityChest = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/chest.jpg"));
			communityChest.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		communityChest.setBounds((int) (frameHeight / .81), (int) (frameHeight / 7), (int) (frameHeight / 7), (int) (frameHeight / 5));
		communityChest.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		communityChest.setBorderPainted(false);
		communityChest.setContentAreaFilled(false);
		
		chanceButton = new JButton();
		chanceButton.setBounds((int) (frameHeight / .7), (int) (frameHeight / 2.5), (int) (frameHeight / 3.33), (int) (frameHeight / 5));
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/chance.jpg"));
			chanceButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		chanceButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		chanceButton.setBorderPainted(false);
		chanceButton.setContentAreaFilled(false);
		
		
		rollDiceButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/rollDiceButton.jpg"));
			rollDiceButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		rollDiceButton.setBounds((int) (frameHeight / 1.5), (int) (frameHeight / 20), (int) (frameHeight / 7), (int) (frameHeight / 5));
		rollDiceButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		rollDiceButton.setBorderPainted(false);
		rollDiceButton.setContentAreaFilled(false);
		
		buyButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/buyButton.jpg"));
			buyButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		buyButton.setBounds((int) (frameHeight / 1.5), (int) (frameHeight / 9), (int) (frameHeight / 7), (int) (frameHeight / 5));
		buyButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		buyButton.setBorderPainted(false);
		buyButton.setContentAreaFilled(false);
		
		sellButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/sellButton.jpg"));
			sellButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		sellButton.setBounds((int) (frameHeight / 1.5), (int) (frameHeight / 6), (int) (frameHeight / 7), (int) (frameHeight / 5));
		sellButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		sellButton.setBorderPainted(false);
		sellButton.setContentAreaFilled(false);
		
		auctionButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/auctionButton.jpg"));
			auctionButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		auctionButton.setBounds((int) (frameHeight / 1.5), (int) (frameHeight / 4.5), (int) (frameHeight / 7), (int) (frameHeight / 5));
		auctionButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		auctionButton.setBorderPainted(false);
		auctionButton.setContentAreaFilled(false);
		
		tradeButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/tradeButton.jpg"));
			tradeButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		tradeButton.setBounds((int) (frameHeight / 1.5), (int) (frameHeight / 3.6), (int) (frameHeight / 7), (int) (frameHeight / 5));
		tradeButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tradeButton.setBorderPainted(false);
		tradeButton.setContentAreaFilled(false);
		
		fileBankruptcyButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/fileBankruptcyButton.jpg"));
			fileBankruptcyButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		
		fileBankruptcyButton.setBounds((int) (frameHeight / 1.5), (int) (frameHeight / 3), (int) (frameHeight / 7), (int) (frameHeight / 5));
		fileBankruptcyButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		fileBankruptcyButton.setBorderPainted(false);
		fileBankruptcyButton.setContentAreaFilled(false);
		
		player1 = new JLayeredPane();
		player1.setBounds(frameHeight + 145, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		player1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		player2 = new JLayeredPane();
		player2.setBounds(frameHeight + 530, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		player2.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		player3 = new JLayeredPane();
		player3.setBounds(frameHeight + 915, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		player3.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		player4 = new JLayeredPane();
		player4.setBounds(frameHeight + 1300, 1600, (int) (frameHeight / 5.5), (int) (frameHeight / 5));
		player4.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		frame.getContentPane().add(player1);
		frame.getContentPane().add(player2);
		frame.getContentPane().add(player3);
		frame.getContentPane().add(player4);
	
		frame.getContentPane().add(justVisit, -1);
		frame.getContentPane().add(freePark, -1);
		frame.getContentPane().add(nyAve, -1);
		frame.getContentPane().add(tennAve, -1);
		frame.getContentPane().add(commChestL, -1);
		frame.getContentPane().add(stJamesPl, -1);
		frame.getContentPane().add(pennRR, -1);
		frame.getContentPane().add(virginiaAve, -1);
		frame.getContentPane().add(statesAve, -1);
		frame.getContentPane().add(electricComp, -1);
		frame.getContentPane().add(stCharlesPl, -1);
		frame.getContentPane().add(kentuckyAve, -1);
		frame.getContentPane().add(chanceU, -1);
		frame.getContentPane().add(indianaAve, -1);
		frame.getContentPane().add(illinoisAve, -1);
		frame.getContentPane().add(boRR, -1);
		frame.getContentPane().add(atlanticAve, -1);
		frame.getContentPane().add(ventnorAve, -1);
		frame.getContentPane().add(waterWorks, -1);
		frame.getContentPane().add(marvinGards, -1);
		frame.getContentPane().add(goJail, -1);
		frame.getContentPane().add(pacificAve, -1);
		frame.getContentPane().add(northCarolinaAve, -1);
		frame.getContentPane().add(comChestR, -1);
		frame.getContentPane().add(pennAve, -1);
		frame.getContentPane().add(shortLRR, -1);
		frame.getContentPane().add(chanceR, -1);
		frame.getContentPane().add(parkPl, -1);
		frame.getContentPane().add(luxTax, -1);
		frame.getContentPane().add(bdwalk, -1);
		frame.getContentPane().add(connAve, -1);
		frame.getContentPane().add(vermontAve, -1);
		frame.getContentPane().add(chanceBot, -1);
		frame.getContentPane().add(orientalAve, -1);
		frame.getContentPane().add(readingRR, -1);
		frame.getContentPane().add(inTax, -1);
		frame.getContentPane().add(balticAve, -1);
		frame.getContentPane().add(comChestBot, -1);
		frame.getContentPane().add(medAve, -1);
		frame.getContentPane().add(pGo, -1);
		frame.getContentPane().add(communityChest, -1);
		frame.getContentPane().add(chanceButton, -1);
		frame.getContentPane().add(rollDiceButton, -1);
		frame.getContentPane().add(buyButton, -1);
		frame.getContentPane().add(sellButton, -1);
		frame.getContentPane().add(auctionButton, -1);
		frame.getContentPane().add(tradeButton, -1);
		frame.getContentPane().add(fileBankruptcyButton, -1);
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
