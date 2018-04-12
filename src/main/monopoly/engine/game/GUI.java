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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import monopoly.engine.player.Player;
import monopoly.engine.player.Player.TokenName;

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
	private JLabel player1Money = new JLabel();
	private JLabel player2Money = new JLabel();
	private JLabel player3Money = new JLabel();
	private JLabel player4Money = new JLabel();
	private JLabel player1 = new JLabel();
	private JLabel player2 = new JLabel();
	private JLabel player3 = new JLabel();
	private JLabel player4 = new JLabel();
	private JLabel logo = new JLabel();
	private JLabel dice1 = new JLabel();
	private JLabel dice2 = new JLabel();
	
	private JButton communityChestButton = new JButton("Community Chest");
	private JButton chanceButton = new JButton("Chance");
	private JButton rollDiceButton = new JButton("Roll Dice");
	private JButton buyButton = new JButton("Buy Properties");
	private JButton sellButton = new JButton("Sell Properties");
	private JButton tradeButton = new JButton("Trade");
	private JButton auctionButton = new JButton("Auction");
	private JButton addPlayer1Button = new JButton("Add Player");
	private JButton addPlayer2Button = new JButton("Add Player");
	private JButton addPlayer3Button = new JButton("Add Player");
	private JButton addPlayer4Button = new JButton("Add Player");
	private JButton startGameButton = new JButton("START GAME!");
	private JButton player1Token = new JButton();
	private JButton player2Token = new JButton();
	private JButton player3Token = new JButton();
	private JButton player4Token = new JButton();

	private ArrayList<Player> players;
	private ArrayList<JLayeredPane> playersPanels;
	private ArrayList<JLayeredPane> boardPanels;

	/**
	 * GUI constructor to create the main frame
	 */
	public GUI() {
		boardPanels = new ArrayList<JLayeredPane>();	
		playersPanels = new ArrayList<JLayeredPane>();
		players = new ArrayList<Player>();

		initialize();
	}
	
	/**
	 * Set labels on board
	 */
	private void setLabel(JLabel square, String imgJPG) {
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/" + imgJPG + ".jpg"));
			square.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("ERROR: Unable to set " + square + "image.");
		}
	}
	
	/**
	 * Set buttons on board
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
	
	/**
	 * Set buttons on board, overloaded method
	 */
	private void setButton(JButton button, int r, int b, int g) {
		button.setFont(new Font("Arial", Font.BOLD, 34));
		button.setBackground(new Color(r, b, g));
		button.setBorder(BorderFactory.createLineBorder(Color.black, 3));	
	}
	
	/**
	 * Set squares on left side of board
	 */
	private void setLeftSquares() {
		nyAve.setBounds(10, 184, 4700, 163);
		tennAve.setBounds(0, 316, 4720, 163);
		commChestL.setBounds(0, 449, 4720, 163);
		stJamesPl.setBounds(0, 580, 4720, 163);
		pennRR.setBounds(0, 706, 4720, 163);
		virginiaAve.setBounds(0, 841, 4720, 163);
		statesAve.setBounds(0, 975, 4720, 163);
		electricComp.setBounds(0, 1109, 4720, 163);
		stCharlesPl.setBounds(0, 1243, 4720, 163);
		justVisit.setBounds(0, 1376, 4720, 200);
				
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
				
		setLabel(nyAvenue, "newYorkAvenue");
		setLabel(tennAvenue, "tennesseeAvenue");
		setLabel(commChestLeft, "communityChestL");
		setLabel(stJamesPlace, "stJamesPlace");
		setLabel(pennRailroad, "pennRailroad");
		setLabel(virginiaAvenue, "virginiaAvenue");
		setLabel(statesAvenue, "statesAvenue");
		setLabel(electricCompanyUtil, "electricCompanyUtil");
		setLabel(stCharlesPlace, "stCharlesPlace");
		setLabel(justVisiting, "justVisiting");
		
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
	
	/**
	 * Set squares on upper side of board
	 */
	private void setUpperSquares() {
		freePark.setBounds(5, 3, 4711, 326);
		kentuckyAve.setBounds(326, 0, 4380, 326);
		chanceU.setBounds(489, 0, 4308, 326);
		indianaAve.setBounds(652, 0, 4240, 326);
		illinoisAve.setBounds(815, 0, 4173, 326);
		boRR.setBounds(978, 0, 4108, 326);
		atlanticAve.setBounds(1141, 0, 4045, 326);
		ventnorAve.setBounds(1304, 0, 3984, 326);
		waterWorks.setBounds(1467, 0, 3925, 326);
		marvinGards.setBounds(1630, 0, 3868, 326);
		
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
		
		setLabel(freeParking, "freeParking");
		setLabel(kentuckyAvenue, "KentuckyAvenue");
		setLabel(chanceUp, "chanceUp");
		setLabel(indianaAvenue, "IndianaAvenue");
		setLabel(illinoisAvenue, "illinoisAvenue");
		setLabel(boRailroad, "boRailroad");
		setLabel(atlanticAvenue, "AtlanticAvenue");
		setLabel(ventnorAvenue, "VentnorAvenue");
		setLabel(waterWorksUtil, "waterWorksUtil");
		setLabel(marvinGardens, "MarvinGardens");
		
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
	
	/**
	 * Set squares on right side of board
	 */
	private void setRightSquares() {
		goJail.setBounds(3555, 0, 326, 326);
		pacificAve.setBounds(3555, 179, 326, 163);
		northCarolinaAve.setBounds(3555, 314, 326, 163);
		commChestR.setBounds(3555, 446, 326, 163);
		pennAve.setBounds(3555, 580, 326, 163);
		shortLRR.setBounds(3555, 711, 326, 163);
		chanceR.setBounds(3555, 844, 326, 163);
		parkPl.setBounds(3555, 976, 326, 163);
		luxTax.setBounds(3555, 1109, 326, 163);
		bdwalk.setBounds(3555, 1239, 326, 163);
		
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
		
		setLabel(gotoJail, "gotoJail");
		setLabel(pacificAvenue, "PacificAvenue");
		setLabel(northCarolinaAvenue, "northCarolinaAvenue");
		setLabel(commChestRight, "communityChestR");
		setLabel(pennAvenue, "PennsylvaniaAvenue");
		setLabel(shortLineRailroad, "shortLine");
		setLabel(chanceRi, "chanceRi");
		setLabel(parkPlace, "parkPlace");
		setLabel(luxuryTax, "luxuryTax");
		setLabel(boardwalk, "boardwalk");
		
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
	
	/**
	 * Set squares on bottom side of board
	 */
	private void setBottomSquares() {
		connAve.setBounds(2436, 1373, 163, 326);
		vermontAve.setBounds(2570, 1373, 163, 326);
		chanceBot.setBounds(2705, 1373, 163, 326);
		orientalAve.setBounds(2841, 1373, 163, 326);
		readingRR.setBounds(2965, 1373, 163, 326);
		inTax.setBounds(3094, 1373, 163, 326);
		balticAve.setBounds(3192, 1373, 212, 326);
		commChestB.setBounds(3347, 1373, 163, 326);
		medAve.setBounds(3456, 1373, 212, 326);
		pGo.setBounds(3557, 1373, 326, 326);

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
		
		setLabel(passGo, "passGo");
		setLabel(connAvenue, "connecticutAvenue");
		setLabel(vermontAvenue, "vermontAvenue");
		setLabel(chanceBottom, "chanceBot");
		setLabel(orientalAvenue, "orientalAvenue");
		setLabel(readingRailroad, "readingRailroad");
		setLabel(incomeTax, "incomeTax");
		setLabel(balticAvenue, "balticAvenue");		
		setLabel(commChestBottom, "communityChestBot");		
		setLabel(mediterraneanAvenue, "mediterraneanAvenue");
		
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
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(screenSize);
		frame.setResizable(false);
		//frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		//put all squares on board
		setLeftSquares();
		setUpperSquares();
		setRightSquares();
		setBottomSquares();
		
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
		
		//set monopoly logo on board
		logo.setBounds(2555, 650, 1000, 200);
		setLabel(logo, "logo");
		
		//set buttons on board		
		communityChestButton.setBounds(2575, 300, 400, 200);
		chanceButton.setBounds(3100, 1050, 400, 200);
		rollDiceButton.setBounds(1413, 250, 300, 130);
		buyButton.setBounds(1413, 450, 300, 130);
		sellButton.setBounds(1413, 650, 300, 130);
		auctionButton.setBounds(1413, 850, 300, 130);
		tradeButton.setBounds(1413, 1050, 300, 130);
		startGameButton.setBounds(1800, 1750, 350, 170);
		setButton(communityChestButton, 212, 252, 228);
		setButton(chanceButton, 212, 252, 228);
		setButton(rollDiceButton, 255, 100, 100);
		setButton(buyButton, 74, 165, 255);
		setButton(sellButton, 255, 172, 89);
		setButton(auctionButton, 255, 255, 172);
		setButton(tradeButton, 153, 153, 255);
		setButton(startGameButton, 255, 0, 128);
		
		startGameButton.setVisible(false);
		communityChestButton.setEnabled(false);
		chanceButton.setEnabled(false);
		rollDiceButton.setEnabled(false);
		buyButton.setEnabled(false);
		sellButton.setEnabled(false);
		auctionButton.setEnabled(false);
		tradeButton.setEnabled(false);
		
		//set the dice on the board
		dice1.setBounds(1475, 50, 100, 100);
		dice2.setBounds(1575, 125, 100, 100);
		setLabel(dice1, "dice1");
		setLabel(dice2, "dice2");
		dice1.setVisible(false);
		dice2.setVisible(false);
		
		//set players section of board
		p1.setBounds(2265, 1600, 385, 424);
		p1.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p2.setBounds(2650, 1600, 385, 424);
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p3.setBounds(3035, 1600, 385, 424);
		p3.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p4.setBounds(3420, 1600, 385, 424);
		p4.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		playersPanels.add(p1);
		playersPanels.add(p2);
		playersPanels.add(p3);
		playersPanels.add(p4);
		
		//button to add player 1 
		addPlayer1Button.setBounds(2335, 1800, 250, 110);
		setButton(addPlayer1Button, 0, 255, 128);
	
		addPlayer1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer1Button.setVisible(false);				
				//add a new player
				players.add(new Player(Player.TokenName.DOG));
				
				//add player1 token and info to board
				player1Token.setBounds(3550, 1370, 255, 110);
				setButton(player1Token, "dogToken");
				player1.setBounds(2420, 1600, 255, 110);
				setLabel(player1, "dogToken");
				
				//add player1 initial starting money to board
				player1Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player1Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player1Money.setBounds(2350, 1685, 250, 110);

				frame.getContentPane().add(player1);
				frame.getContentPane().add(player1Money);
				
				//button to add player2
				addPlayer2Button.setBounds(2720, 1800, 250, 110);
				setButton(addPlayer2Button, 0, 255, 128);	
			}

		});
		
		addPlayer2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer2Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.BATTLESHIP));
				
				//add player2 token and info to board
				player2Token.setBounds(3635, 1370, 255, 110);
				setButton(player2Token, "battleShipToken");
				player2.setBounds(2810, 1605, 100, 110);
				setLabel(player2, "battleShipToken");
		
				//add player2 initial starting money to board
				player2Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player2Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player2Money.setBounds(2750, 1685, 250, 110);

				frame.getContentPane().add(player2);
				frame.getContentPane().add(player2Money);
				
				//button to add player3
				addPlayer3Button.setBounds(3105, 1800, 250, 110);
				setButton(addPlayer3Button, 0, 255, 128);
				
				//Game can be started since 2 players have been added
				startGameButton.setVisible(true);
				startGameButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						p1.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
						addPlayer3Button.setVisible(false);
						startGame();
					}
				});
			}

		});
		
		addPlayer3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer3Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.CAR));
				
				//add player3 token and info to board
				player3Token.setBounds(3550, 1458, 255, 110);
				setButton(player3Token, "carToken");
				player3.setBounds(3190, 1615, 255, 110);
				setLabel(player3, "carToken");

				//add player3 initial starting money to board
				player3Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player3Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player3Money.setBounds(3130, 1685, 250, 110);

				frame.getContentPane().add(player3);
				frame.getContentPane().add(player3Money);
				
				//button to add player3
				addPlayer4Button.setBounds(3490, 1800, 250, 110);
				setButton(addPlayer4Button, 0, 255, 128);
				
				startGameButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						p1.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
						addPlayer4Button.setVisible(false);
						
						startGame();
					}
				});
			}

		});
		
		addPlayer4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer4Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.HAT));
				
				//add player4 token and info to board
				player4Token.setBounds(3640, 1458, 255, 110);
				setButton(player4Token, "hatToken");
				player4.setBounds(3570, 1615, 255, 110);
				setLabel(player4, "hatToken");

				//add player4 initial starting money to board
				player4Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player4Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player4Money.setBounds(3520, 1685, 250, 110);

				frame.getContentPane().add(player4);
				frame.getContentPane().add(player4Money);	
				
				startGameButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						p1.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
						startGame();
					}
				});
			}

		});
		
		//add everything to frame
		frame.getContentPane().add(logo);
		frame.getContentPane().add(player1Token);
		frame.getContentPane().add(player2Token);
		frame.getContentPane().add(player3Token);
		frame.getContentPane().add(player4Token);
		frame.getContentPane().add(p1);
		frame.getContentPane().add(p2);
		frame.getContentPane().add(p3);
		frame.getContentPane().add(p4);
		frame.getContentPane().add(addPlayer1Button);
		frame.getContentPane().add(addPlayer2Button);
		frame.getContentPane().add(addPlayer3Button);
		frame.getContentPane().add(addPlayer4Button);
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
		frame.getContentPane().add(dice1);
		frame.getContentPane().add(dice2);
		frame.getContentPane().add(buyButton);
		frame.getContentPane().add(sellButton);
		frame.getContentPane().add(auctionButton);
		frame.getContentPane().add(tradeButton);
		frame.getContentPane().add(startGameButton);
	}
	
	/**
	 * start a new game
	 */
	private void startGame() {
		startGameButton.setVisible(false);

		rollDiceButton.setEnabled(true);
		dice1.setVisible(true);
		dice2.setVisible(true);
		
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
