package monopoly.engine.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import monopoly.engine.player.Player;
import monopoly.engine.square.Deed;

public class GUI implements Observer {
	private JFrame frame;
	private ArrayList<GuiHelper> tiles;
	private JLayeredPane p1 = new JLayeredPane();
	private JLayeredPane p2 = new JLayeredPane();
	private JLayeredPane p3 = new JLayeredPane();
	private JLayeredPane p4 = new JLayeredPane();
	private JLayeredPane propertiesBox = new JLayeredPane();
	private JLayeredPane medHouses = new JLayeredPane();
	private JLayeredPane balHouses = new JLayeredPane();
	private JLayeredPane oreHouses = new JLayeredPane();
	
	private JLabel propertiesLabel = new JLabel();
	private JLabel playerPropsLabel = new JLabel();
	private JLabel timer = new JLabel();
	private JLabel player1Money = new JLabel();
	private JLabel player2Money = new JLabel();
	private JLabel player3Money = new JLabel();
	private JLabel player4Money = new JLabel();
	private JLabel player1GOFJ = new JLabel();
	private JLabel player2GOFJ = new JLabel();
	private JLabel player3GOFJ = new JLabel();
	private JLabel player4GOFJ = new JLabel();
	private JLabel player1Monops = new JLabel();
	private JLabel player2Monops = new JLabel();
	private JLabel player3Monops = new JLabel();
	private JLabel player4Monops = new JLabel();
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
	private JButton jailBuyOutButton = new JButton("Pay Bail");
	private JButton buyButton = new JButton("Buy Properties");
	private JButton mortgageButton = new JButton("Mortgage");
	private JButton tradeButton = new JButton("Trade");
	private JButton auctionButton = new JButton("Auction");
	private JButton addPlayer1Button = new JButton("Add Player");
	private JButton addPlayer2Button = new JButton("Add Player");
	private JButton addPlayer3Button = new JButton("Add Player");
	private JButton addPlayer4Button = new JButton("Add Player");
	private JButton startGameButton = new JButton("START GAME!");
	private JButton finishTurnButton = new JButton("Finish Turn");
	private JButton buyHHButton = new JButton("Buy Houses/Hotels");
	private JButton sellHHButton = new JButton("Sell Houses/Hotels");
	private JButton player1Token = new JButton();
	private JButton player2Token = new JButton();
	private JButton player3Token = new JButton();
	private JButton player4Token = new JButton();

	private JTextArea gameDialog = new JTextArea();
	private JScrollPane dialogBox = new JScrollPane(gameDialog);
	private String gameDialogText;
	
	private ArrayList<Player> players;
	private ArrayList<JLayeredPane> playersPanels;
	private ArrayList<JLayeredPane> boardPanels;

	private int[] rollVal;
	private Monopoly game = Monopoly.getInstance();
	private Turn playerTurn;
	private String lastToken = "";
	
	/**
	 * GUI constructor to create the main frame
	 */
	public GUI() {
		boardPanels = new ArrayList<JLayeredPane>();	
		playersPanels = new ArrayList<JLayeredPane>();
		players = new ArrayList<Player>();
		tiles = new ArrayList<GuiHelper>(40);
		for (int i = 0; i < 40 ; i++)
			tiles.add(null);
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
		button.setFont(new Font("Arial", Font.BOLD, 12));
		button.setBackground(new Color(r, b, g));
		button.setBorder(BorderFactory.createLineBorder(Color.black, 3));	
	}

	/**
	 * Set squares on right side of board
	 */
	private void setRightSquares() {
		tiles.set(39, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 1289 * (720.0/2160)), 65, 50, boardPanels, "boardwalk"));
		tiles.set(38, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 1151 * (720.0/2160)), 65, 50, boardPanels, "luxuryTax"));
		tiles.set(37, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 1016 * (720.0/2160)), 65, 50, boardPanels, "parkPlace"));
		tiles.set(36, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 878 * (720.0/2160)), 65, 50, boardPanels, "chanceRi"));
		tiles.set(35, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 740 * (720.0/2160)), 65, 50, boardPanels, "shortLine"));
		tiles.set(34, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 602 * (720.0/2160)), 65, 50, boardPanels, "PennsylvaniaAvenue"));
		tiles.set(33, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 464 * (720.0/2160)), 65, 50, boardPanels, "communityChestR"));
		tiles.set(32, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 329 * (720.0/2160)), 65, 50, boardPanels, "northCarolinaAvenue"));
		tiles.set(31, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 191 * (720.0/2160)), 65, 50, boardPanels, "PacificAvenue"));
		tiles.set(30, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 65, 65, boardPanels, "goToJail"));
	}

	/**
	 * Set squares on upper side of board
	 */
	private void setUpperSquares() {
		tiles.set(29, new GuiHelper((int) Math.floor(3417 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "MarvinGardens"));
		tiles.set(28, new GuiHelper((int) Math.floor(3279 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "waterWorksUtil"));
		tiles.set(27, new GuiHelper((int) Math.floor(3141 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "VentnorAvenue"));
		tiles.set(26, new GuiHelper((int) Math.floor(3003 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "AtlanticAvenue"));
		tiles.set(25, new GuiHelper((int) Math.floor(2865 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "boRailroad"));
		tiles.set(24, new GuiHelper((int) Math.floor(2727 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "illinoisAvenue"));
		tiles.set(23, new GuiHelper((int) Math.floor(2589 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "IndianaAvenue"));
		tiles.set(22, new GuiHelper((int) Math.floor(2451 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "chanceUp"));
		tiles.set(21, new GuiHelper((int) Math.floor(2313 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 50, 65, boardPanels, "KentuckyAvenue"));
		tiles.set(20, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 65, 65, boardPanels, "freeParking"));	
	}
	
	/**
	 * Set squares on left side of board
	 */
	private void setLeftSquares() {
		tiles.set(19, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 191 * (720.0/2160)), 65, 50, boardPanels, "nyAve"));
		tiles.set(18, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 332 * (720.0/2160)), 65, 50, boardPanels, "tennesseeAvenue"));
		tiles.set(17, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 467 * (720.0/2160)), 65, 50, boardPanels, "communityChestL"));
		tiles.set(16, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 605 * (720.0/2160)), 65, 50, boardPanels, "stJamesPlace"));
		tiles.set(15, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 740 * (720.0/2160)), 65, 50, boardPanels, "pennRailroad"));
		tiles.set(14, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 878 * (720.0/2160)), 65, 50, boardPanels, "virginiaAvenue"));
		tiles.set(13, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 1016 * (720.0/2160)), 65, 50, boardPanels, "statesAvenue"));
		tiles.set(12, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 1151 * (720.0/2160)), 65, 50, boardPanels, "electricCompanyUtil"));
		tiles.set(11, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 1286 * (720.0/2160)), 65, 50, boardPanels, "stCharlesPlace"));
		tiles.set(10, new GuiHelper((int) Math.floor(2136 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 65, 65, boardPanels, "justVisiting"));		
	}

	/**
	 * Set squares on bottom side of board
	 */
	private void setBottomSquares() {
		tiles.set(9, new GuiHelper((int) Math.floor(2319 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "connecticutAvenue"));
		tiles.set(8, new GuiHelper((int) Math.floor(2457 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "vermontAvenue"));
		tiles.set(7, new GuiHelper((int) Math.floor(2592 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "chanceBot"));
		tiles.set(6, new GuiHelper((int) Math.floor(2730 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "orientalAvenue"));
		tiles.set(5, new GuiHelper((int) Math.floor(2868 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "readingRailroad"));
		tiles.set(4, new GuiHelper((int) Math.floor(3006 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "incomeTax"));
		tiles.set(3, new GuiHelper((int) Math.floor(3144 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "balticAvenue"));
		tiles.set(2, new GuiHelper((int) Math.floor(3282 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "communityChestBot"));
		tiles.set(1, new GuiHelper((int) Math.floor(3420 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 50, 65, boardPanels, "mediterraneanAvenue"));
		tiles.set(0, new GuiHelper((int) Math.floor(3560 * (1280.0/3840)), (int) Math.floor( 1424 * (720.0/2160)), 65, 65, boardPanels, "passGo"));
	}

	/**
	 * display properties owned by each player
	 */
	private void playersOwnedPropertiesBox() {	
		playerPropsLabel.setText("<html> " + playerTurn.getToken() + "'s Owned Properties: " + "<br> ");
		String propsStr = "";
		int count = 0;
		for(Deed d : playerTurn.getPlayer().getDeeds()) {
			if(count == 4)  {
				propsStr +=  "<br> " + d + ", ";
				count = 1;
			}else {
				propsStr += d + ", ";
				count++;
			}
		}
		propertiesLabel.setText("<html> " + propsStr + "</html>");
	}
	
	/**
	 * Initializes the game frame
	 */
	private void initialize() {
		FlowLayout flow = new FlowLayout();
		flow.setHgap(0);
		flow.setVgap(0);
		frame = new JFrame("T13 Monopoly Game CS414");
		frame.getContentPane().setBackground(new Color(212, 252, 228));
		frame.setPreferredSize(new Dimension(1280, 720));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

		//put all squares on board
		setLeftSquares();
		setUpperSquares();
		setRightSquares();
		setBottomSquares();
		for (int i = 0; i < 40 ; i++) 
			tiles.get(i).setLayout(flow);

		//set monopoly logo on board
		logo.setBounds((int) Math.floor(2600 * (1280.0/3840)), (int) Math.floor( 700 * (720.0/2160)), 240, 45);
		setLabel(logo, "logo");

		//set buttons on board	
		communityChestButton.setBounds((int) Math.floor(2500 * (1280.0/3840)), (int) Math.floor( 300 * (720.0/2160)), 150, 75);
		chanceButton.setBounds((int) Math.floor(2985 * (1280.0/3840)), (int) Math.floor( 1025 * (720.0/2160)), 150, 75);
		rollDiceButton.setBounds((int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 250 * (720.0/2160)), 125, 45);
		buyButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 410 * (720.0/2160)), 125, 45);
		mortgageButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 570 * (720.0/2160)), 125, 45);
		auctionButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 730 * (720.0/2160)), 125, 45);
		tradeButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 890 * (720.0/2160)), 125, 45);
		jailBuyOutButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 1050 * (720.0/2160)), 125, 45);
		buyHHButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 1210 * (720.0/2160)), 125, 45);
		sellHHButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 1370 * (720.0/2160)), 125, 45);
		startGameButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 1750 * (720.0/2160)), 125, 45);
		finishTurnButton.setBounds( (int) Math.floor(1613 * (1280.0/3840)), (int) Math.floor( 1600 * (720.0/2160)), 125, 45);
		setButton(communityChestButton, 212, 252, 228);
		setButton(chanceButton, 212, 252, 228);
		setButton(rollDiceButton, 255, 100, 100);
		setButton(buyButton, 74, 165, 255);
		setButton(mortgageButton, 255, 172, 89);
		setButton(auctionButton, 255, 255, 172);
		setButton(tradeButton, 153, 153, 255);
		setButton(jailBuyOutButton, 0, 230, 230);
		setButton(startGameButton, 255, 0, 128);
		setButton(finishTurnButton, 99, 177, 177);
		setButton(buyHHButton, 255, 83, 255);
		setButton(sellHHButton, 0, 255, 128);
		startGameButton.setVisible(false);
		finishTurnButton.setVisible(false);
		communityChestButton.setEnabled(false);
		chanceButton.setEnabled(false);
		rollDiceButton.setEnabled(false);
		buyButton.setEnabled(false);
		mortgageButton.setEnabled(false);
		auctionButton.setEnabled(false);
		tradeButton.setEnabled(false);
		jailBuyOutButton.setEnabled(false);
		buyHHButton.setEnabled(false);
		sellHHButton.setEnabled(false);

		//set the dice on the board
		dice1.setBounds( (int) Math.floor(1665 * (1280.0/3840)), (int) Math.floor( 10 * (720.0/2160)), 50, 50);
		dice2.setBounds( (int) Math.floor(1805 * (1280.0/3840)), (int) Math.floor( 100 * (720.0/2160)), 50, 50);
		setLabel(dice1, "dice1");
		setLabel(dice2, "dice2");
		dice1.setVisible(false);
		dice2.setVisible(false);

		//set timer on board
		timer.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 300, 25);
		timer.setFont(new Font("Arial", Font.BOLD, 20));
		timer.setVisible(false);
		
		//set dialog box
		gameDialog.setFont(new Font("Arial", Font.BOLD, 20));
		dialogBox.setBounds( (int) Math.floor(25 * (1280.0/3840)), (int) Math.floor( 100 * (720.0/2160)), 500, 500);
		dialogBox.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		dialogBox.setVisible(false);
		
		//set properties box and players section of board	
		propertiesBox.setBounds( (int) Math.floor(25 * (1280.0/3840)), (int) Math.floor( 1600 * (720.0/2160)), 500, 150);
		propertiesBox.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
		playerPropsLabel.setFont(new Font("Arial", Font.BOLD, 14));
		playerPropsLabel.setBounds( (int) Math.floor(40 * (1280.0/3840)), (int) Math.floor( 1570 * (720.0/2160)), 250, 50);
		propertiesLabel.setFont(new Font("Arial", Font.BOLD, 12));
		propertiesLabel.setBounds( (int) Math.floor(60 * (1280.0/3840)), (int) Math.floor( 1605 * (720.0/2160)), 470, 130);
		propertiesBox.setVisible(true);
		propertiesLabel.setVisible(false);
		playerPropsLabel.setVisible(false);
		p1.setBounds( (int) Math.floor(2190 * (1280.0/3840)), (int) Math.floor( 1630 * (720.0/2160)), 125, 140);
		p1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		p2.setBounds( (int) Math.floor(2580 * (1280.0/3840)), (int) Math.floor( 1630 * (720.0/2160)), 125, 140);
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		p3.setBounds( (int) Math.floor(2967 * (1280.0/3840)), (int) Math.floor( 1630 * (720.0/2160)), 125, 140);
		p3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		p4.setBounds( (int) Math.floor(3355 * (1280.0/3840)), (int) Math.floor( 1630 * (720.0/2160)), 125, 140);
		p4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		playersPanels.add(p1);
		playersPanels.add(p2);
		playersPanels.add(p3);
		playersPanels.add(p4);
		
		//set houses and hotels areas
		medHouses.setBounds( (int) Math.floor(3430 * (1280.0/3840)), (int) Math.floor( 1362 * (720.0/2160)), 20, 20);
		medHouses.setBorder(BorderFactory.createLineBorder(Color.green, 2));
		//medHouses.setBackground(Color.green);
		
		balHouses.setBounds( (int) Math.floor(3150 * (1280.0/3840)), (int) Math.floor( 1362 * (720.0/2160)), 20, 20);
		balHouses.setBorder(BorderFactory.createLineBorder(Color.green, 2));
		
		oreHouses.setBounds( (int) Math.floor(3000 * (1280.0/3840)), (int) Math.floor( 1362 * (720.0/2160)), 20, 20);
		oreHouses.setBorder(BorderFactory.createLineBorder(Color.green, 2));
		
		

		//button to add player 1 
		addPlayer1Button.setBounds( (int) Math.floor(2230 * (1280.0/3840)), (int) Math.floor( 1825 * (720.0/2160)), 100, 25);
		setButton(addPlayer1Button, 113, 208, 255);
		addPlayer1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer1Button.setVisible(false);				
				//add a new player
				players.add(new Player(Player.TokenName.DOG));
				//add player1 token to board
				player1Token.setBounds( (int) Math.floor(3545 * (1280.0/3840)), (int) Math.floor( 1480 * (720.0/2160)), 50, 50);
				setButton(player1Token, "dogToken");
				//add player1 info/money to player area
				player1.setBounds( (int) Math.floor(2340 * (1280.0/3840)), (int) Math.floor( 1625 * (720.0/2160)), 50, 50);
				setLabel(player1, "dogToken");
				player1Money.setText("Money: $" + players.get(0).getMoney());
				player1Money.setFont(new Font("Arial", Font.BOLD, 12));
				player1Money.setBounds( (int) Math.floor(2255 * (1280.0/3840)), (int) Math.floor( 1750 * (720.0/2160)), 100, 20);
				player1GOFJ.setText("Jail Cards: " + players.get(0).getNumGetOutOfJailCards());
				player1GOFJ.setFont(new Font("Arial", Font.BOLD, 12));
				player1GOFJ.setBounds( (int) Math.floor(2255 * (1280.0/3840)), (int) Math.floor( 1810 * (720.0/2160)), 100, 20);
				player1Monops.setText("Monopolies: " + players.get(0).getMonopolies());
				player1Monops.setFont(new Font("Arial", Font.BOLD, 12));
				player1Monops.setBounds( (int) Math.floor(2255 * (1280.0/3840)), (int) Math.floor( 1865 * (720.0/2160)), 100, 20);
				frame.setComponentZOrder(player1Token, new Integer(0));
				//button to add player2
				addPlayer2Button.setBounds( (int) Math.floor(2620 * (1280.0/3840)), (int) Math.floor( 1825 * (720.0/2160)), 100, 25);
				setButton(addPlayer2Button, 113, 208, 255);	
			}

		});

		addPlayer2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer2Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.BATTLESHIP));
				//add player2 token and info to board
				player2Token.setBounds( (int) Math.floor(3625 * (1280.0/3840)), (int) Math.floor( 1480 * (720.0/2160)), 50, 50);
				setButton(player2Token, "battleShipToken");
				player2.setBounds( (int) Math.floor(2735 * (1280.0/3840)), (int) Math.floor(1625 * (720.0/2160)), 50, 50);
				setLabel(player2, "battleShipToken");
				//add player2 initial starting money to board
				player2Money.setText("Money: $" + players.get(1).getMoney());
				player2Money.setFont(new Font("Arial", Font.BOLD, 12));
				player2Money.setBounds( (int) Math.floor(2640 * (1280.0/3840)), (int) Math.floor( 1750 * (720.0/2160)), 100, 20);
				player2GOFJ.setText("Jail Cards: " + players.get(1).getNumGetOutOfJailCards());
				player2GOFJ.setFont(new Font("Arial", Font.BOLD, 12));
				player2GOFJ.setBounds( (int) Math.floor(2640 * (1280.0/3840)), (int) Math.floor( 1810 * (720.0/2160)), 100, 20);
				player2Monops.setText("Monopolies: " + players.get(1).getMonopolies());
				player2Monops.setFont(new Font("Arial", Font.BOLD, 12));
				player2Monops.setBounds( (int) Math.floor(2640 * (1280.0/3840)), (int) Math.floor( 1860 * (720.0/2160)), 100, 20);
				frame.setComponentZOrder(player2Token, new Integer(0));
				//button to add player3
				addPlayer3Button.setBounds( (int) Math.floor(3005 * (1280.0/3840)), (int) Math.floor( 1825 * (720.0/2160)), 100, 25);
				setButton(addPlayer3Button, 113, 208, 255);

				//Game can be started since 2 players have been added
				startGameButton.setVisible(true);
			}

		});		

		addPlayer3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer3Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.CAR));
				//add player3 token and info to board
				player3Token.setBounds( (int) Math.floor(3550 * (1280.0/3840)), (int) Math.floor( 1565 * (720.0/2160)), 50, 50);
				setButton(player3Token, "carToken");
				player3.setBounds( (int) Math.floor(3120 * (1280.0/3840)), (int) Math.floor( 1625 * (720.0/2160)), 50, 50);
				setLabel(player3, "carToken");
				//add player3 initial starting money to board
				player3Money.setText("Money: $" + players.get(2).getMoney());
				player3Money.setFont(new Font("Arial", Font.BOLD, 12));
				player3Money.setBounds( (int) Math.floor(3030 * (1280.0/3840)), (int) Math.floor( 1750 * (720.0/2160)), 100, 25);
				player3GOFJ.setText("Jail Cards: " + players.get(2).getNumGetOutOfJailCards());
				player3GOFJ.setFont(new Font("Arial", Font.BOLD, 12));
				player3GOFJ.setBounds( (int) Math.floor(3030 * (1280.0/3840)), (int) Math.floor( 1810 * (720.0/2160)), 100, 20);
				player3Monops.setText("Monopolies: " + players.get(2).getMonopolies());
				player3Monops.setFont(new Font("Arial", Font.BOLD, 12));
				player3Monops.setBounds( (int) Math.floor(3030 * (1280.0/3840)), (int) Math.floor( 1860 * (720.0/2160)), 100, 20);
				frame.setComponentZOrder(player3Token, new Integer(0));
				//button to add player3
				addPlayer4Button.setBounds( (int) Math.floor(3390 * (1280.0/3840)), (int) Math.floor( 1825 * (720.0/2160)), 100, 25);
				setButton(addPlayer4Button, 113, 208, 255);
			}

		});

		addPlayer4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer4Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.HAT));
				//add player4 token and info to board
				player4Token.setBounds( (int) Math.floor(3635 * (1280.0/3840)), (int) Math.floor( 1565 * (720.0/2160)), 50, 50);
				setButton(player4Token, "hatToken");
				player4.setBounds( (int) Math.floor(3500 * (1280.0/3840)), (int) Math.floor( 1625 * (720.0/2160)), 50, 50);
				setLabel(player4, "hatToken");
				//add player4 initial starting money to board
				player4Money.setText("Money: $" + players.get(3).getMoney());
				player4Money.setFont(new Font("Arial", Font.BOLD, 12));
				player4Money.setBounds( (int) Math.floor(3420 * (1280.0/3840)), (int) Math.floor( 1750 * (720.0/2160)), 100, 25);
				player4GOFJ.setText("Jail Cards: " + players.get(3).getNumGetOutOfJailCards());
				player4GOFJ.setFont(new Font("Arial", Font.BOLD, 12));
				player4GOFJ.setBounds( (int) Math.floor(3420 * (1280.0/3840)), (int) Math.floor( 1810 * (720.0/2160)), 100, 20);
				player4Monops.setText("Monopolies: " + players.get(3).getMonopolies());
				player4Monops.setFont(new Font("Arial", Font.BOLD, 12));
				player4Monops.setBounds( (int) Math.floor(3420 * (1280.0/3840)), (int) Math.floor( 1860 * (720.0/2160)), 100, 20);
				frame.setComponentZOrder(player4Token, new Integer(0));			
			}
		});

		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameDialogText = "- Game Started!\n";
				gameDialog.append(gameDialogText);
				addPlayer3Button.setVisible(false);
				addPlayer4Button.setVisible(false);
				startGame();
			}
		});
		
		//add everything to frame
		for (int i = 0; i < 40 ; i++) {
			frame.getContentPane().add(tiles.get(i).getPane());
		}	
		
		frame.getContentPane().add(logo);
		frame.getContentPane().add(player1);
		frame.getContentPane().add(player1Money);
		frame.getContentPane().add(player1Token);
		frame.getContentPane().add(player1GOFJ);
		frame.getContentPane().add(player1Monops);
		frame.getContentPane().add(player2);
		frame.getContentPane().add(player2Money);
		frame.getContentPane().add(player2Token);
		frame.getContentPane().add(player2GOFJ);
		frame.getContentPane().add(player2Monops);
		frame.getContentPane().add(player3);
		frame.getContentPane().add(player3Money);
		frame.getContentPane().add(player3Token);
		frame.getContentPane().add(player3GOFJ);
		frame.getContentPane().add(player3Monops);
		frame.getContentPane().add(player4);
		frame.getContentPane().add(player4Money);
		frame.getContentPane().add(player4Token);
		frame.getContentPane().add(player4GOFJ);
		frame.getContentPane().add(player4Monops);
		frame.getContentPane().add(timer);
		frame.getContentPane().add(propertiesBox);
		frame.getContentPane().add(propertiesLabel);
		frame.getContentPane().add(playerPropsLabel);
		frame.getContentPane().add(p1);
		frame.getContentPane().add(p2);
		frame.getContentPane().add(p3);
		frame.getContentPane().add(p4);
		frame.getContentPane().add(addPlayer1Button);
		frame.getContentPane().add(addPlayer2Button);
		frame.getContentPane().add(addPlayer3Button);
		frame.getContentPane().add(addPlayer4Button);
		frame.getContentPane().add(communityChestButton);
		frame.getContentPane().add(chanceButton);
		frame.getContentPane().add(rollDiceButton);
		frame.getContentPane().add(dice1);
		frame.getContentPane().add(dice2);
		frame.getContentPane().add(buyButton);
		frame.getContentPane().add(mortgageButton);
		frame.getContentPane().add(auctionButton);
		frame.getContentPane().add(tradeButton);
		frame.getContentPane().add(jailBuyOutButton);
		frame.getContentPane().add(startGameButton);
		frame.getContentPane().add(finishTurnButton);
		frame.getContentPane().add(buyHHButton);
		frame.getContentPane().add(sellHHButton);
		frame.getContentPane().add(dialogBox);
		
		frame.getContentPane().add(medHouses);
		frame.getContentPane().add(balHouses);
		frame.getContentPane().add(oreHouses);
		
		
	}
	
	/**
	 * Set player area
	 */
	private void setPlayerBorder() {
		switch (lastToken) {
		case "Dog": 			
			p1.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			break;
		case "Battleship": 	 			
			p2.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			break;
		case "Car": 			 			
			p3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			break;
		case "Hat": 	 			
			p4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			break;
		default:
			break;
		}

		switch(playerTurn.getToken()) {
		case "Dog": 			
			p1.setBorder(BorderFactory.createLineBorder(Color.magenta, 4));
			break;
		case "Battleship": 	 			
			p2.setBorder(BorderFactory.createLineBorder(Color.magenta, 4));
			break;
		case "Car": 			 			
			p3.setBorder(BorderFactory.createLineBorder(Color.magenta, 4));
			break;
		case "Hat": 
			p4.setBorder(BorderFactory.createLineBorder(Color.magenta, 4));
			break;
		default:
			break;
		}

		lastToken = playerTurn.getToken();
	}

	/**
	 * updates the dice on the board after each roll
	 */
	private void updateDice(JLabel die, int index) {
		switch (rollVal[index]) {
		case 1:
			setLabel(die, "dice1");
			break;
		case 2:
			setLabel(die, "dice2");
			break;
		case 3:
			setLabel(die, "dice3");
			break;
		case 4:
			setLabel(die, "dice4");
			break;
		case 5:
			setLabel(die, "dice5");
			break;
		case 6:
			setLabel(die, "dice6");
			break;
		}
	}

	/**
	 * start a new game
	 */
	private void startGame() {
		startGameButton.setVisible(false);
		game.setPlayers(players);
		playerTurn = game.getTurn();
		setPlayerBorder();
		timer.setVisible(true);
		dialogBox.setVisible(false);
		propertiesBox.setVisible(true);
		propertiesLabel.setVisible(true);
		playerPropsLabel.setVisible(true);
		playersOwnedPropertiesBox();
		playerTurn.addObserver(this);
		rollDiceButton.setEnabled(true);
		dice1.setVisible(true);
		dice2.setVisible(true);
    
		//Only handles displaying the dice
		rollDiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//player takes turn
				rollVal = playerTurn.takeTurn();
				//update roll to dialog box
				gameDialogText = "- " + playerTurn.getToken() + " rolled " + (rollVal[0] + rollVal[1]) + ".\n";
				gameDialog.append(gameDialogText);
				if(rollVal[0] == rollVal[1]) {
					gameDialogText = "- " + playerTurn.getToken() + " rolled doubles!\n";
					gameDialog.append(gameDialogText);	
				}
				//set dice label to value rolled
				updateDice(dice1, 0);
				updateDice(dice2, 1);
				//move player token after roll and update dialog box
				movePlayerOnBoard(playerTurn.getToken(), game.getCurrentPlayer().getCurrentIndex());
				gameDialogText = "- " + playerTurn.getToken() + " moved to " + game.getBoard().getSquares()[playerTurn.getCurrentIndex()].getName() + ".\n";
				gameDialog.append(gameDialogText);
			}
		});

		//end turn
		finishTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//update dialog box that player finished their turn
				gameDialogText = "- " + playerTurn.getToken() + " finished turn. \n";
				gameDialog.append(gameDialogText);
				System.out.println("Finish Turn!\n");
				playerTurn.endTurn();
				//update dialog box with next players turn
				gameDialogText = "- " + playerTurn.getToken() + "'s turn. \n";
				gameDialog.append(gameDialogText);
				setPlayerBorder();
				playersOwnedPropertiesBox();
			}
		});

		//Yeah we need to talk about this one
		auctionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Auction!");
				playerTurn.doneBuying();
			}
		});

		//need money check on this
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//update dialog box with property player bought
				gameDialogText = "- " + playerTurn.getToken() + " bought " + game.getBoard().getDeed(playerTurn.getCurrentIndex()).getName() + ".\n";
				gameDialog.append(gameDialogText);
				System.out.println("Buy Property!");
				Banker.buyProperty(playerTurn.getPlayer(), game.getBoard().getDeed(playerTurn.getCurrentIndex()));
				//finishTurnButton.setVisible(true);
				playerTurn.doneBuying();
				playersOwnedPropertiesBox();
			}
		});
		
		jailBuyOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//update dialog box with property player bought
				gameDialogText = "- " + playerTurn.getToken() + " bailed themselves out of jail.\n";
				gameDialog.append(gameDialogText);
				System.out.printf("%s bailed themselves out of jail.\n", playerTurn.getToken());
				playerTurn.jailBuyOut(playerTurn.getPlayer());
			}
		});
	}

	/**
	 * moves the players token on the board
	 */
	private void movePlayerOnBoard(String token, int index) {
		JButton playerToken = new JButton();
		switch(token) {
		case "Dog": 			
			playerToken = player1Token;
			break;
		case "Battleship": 	
			playerToken = player2Token;
			break;
		case "Car": 			 	
			playerToken = player3Token;
			break;
		case "Hat": 
			playerToken = player4Token;
			break;
		default:
			break;
		}
		switch (index) {
		case 0:
			playerToken.setBounds( (int) Math.floor(3590 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 1:
			playerToken.setBounds( (int) Math.floor(3425 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 2:
			playerToken.setBounds( (int) Math.floor(3290 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 3:
			playerToken.setBounds( (int) Math.floor(3150 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 4:
			playerToken.setBounds( (int) Math.floor(3010 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 5:
			playerToken.setBounds( (int) Math.floor(2870 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 6:
			playerToken.setBounds( (int) Math.floor(2740 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 7:
			playerToken.setBounds( (int) Math.floor(2600 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 8:
			playerToken.setBounds( (int) Math.floor(2465 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;
		case 9:
			playerToken.setBounds( (int) Math.floor(2325 * (1280.0/3840)), (int) Math.floor( 1525 * (720.0/2160)), 50, 50);
			break;	
		case 10:
			if(playerTurn.isJailed()) {
				System.out.printf("Moving %s to Jail\n", playerTurn.getPlayer().getToken());
				playerToken.setBounds( (int) Math.floor(2200 * (1280.0/3840)), (int) Math.floor( 1490 * (720.0/2160)), 50, 50);	
			}else {
			playerToken.setBounds( (int) Math.floor(2120 * (1280.0/3840)), (int) Math.floor( 1565 * (720.0/2160)), 50, 50);
			}
			break;
		case 11:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 1360 * (720.0/2160)), 50, 50);
			break;
		case 12:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 1225 * (720.0/2160)), 50, 50);
			break;
		case 13:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 1087 * (720.0/2160)), 50, 50);
			break;
		case 14:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 950 * (720.0/2160)), 50, 50);
			break;
		case 15:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 810 * (720.0/2160)), 50, 50);
			break;
		case 16:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 675 * (720.0/2160)), 50, 50);
			break;
		case 17:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 540 * (720.0/2160)), 50, 50);
			break;
		case 18:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 400 * (720.0/2160)), 50, 50);
			break;
		case 19:
			playerToken.setBounds( (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 265 * (720.0/2160)), 50, 50);
			break;
		case 20:
			playerToken.setBounds(  (int) Math.floor(2165 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 21:
			playerToken.setBounds( (int) Math.floor(2325 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 22:
			playerToken.setBounds( (int) Math.floor(2460 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 23:
			playerToken.setBounds( (int) Math.floor(2600 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 24:
			playerToken.setBounds( (int) Math.floor(2735 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 25:
			playerToken.setBounds( (int) Math.floor(2875 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 26:
			playerToken.setBounds( (int) Math.floor(3010 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 27:
			playerToken.setBounds( (int) Math.floor(3160 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 28:
			playerToken.setBounds( (int) Math.floor(3285 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;
		case 29:
			playerToken.setBounds( (int) Math.floor(3425 * (1280.0/3840)), (int) Math.floor( 95 * (720.0/2160)), 50, 50);
			break;			
		case 30:
			playerToken.setBounds( (int) Math.floor(2200 * (1280.0/3840)), (int) Math.floor( 1490 * (720.0/2160)), 50, 50);
			break;
		case 31:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 265 * (720.0/2160)), 50, 50);
			break;
		case 32:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 400 * (720.0/2160)), 50, 50);
			break;
		case 33:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 535 * (720.0/2160)), 50, 50);
			break;
		case 34:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 675 * (720.0/2160)), 50, 50);
			break;
		case 35:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 810 * (720.0/2160)), 50, 50);
			break;
		case 36:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 950 * (720.0/2160)), 50, 50);
			break;
		case 37:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 1090 * (720.0/2160)), 50, 50);
			break;
		case 38:
			playerToken.setBounds(  (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 1225 * (720.0/2160)), 50, 50);
			break;
		case 39:
			playerToken.setBounds( (int) Math.floor(3595 * (1280.0/3840)), (int) Math.floor( 1360 * (720.0/2160)), 50, 50);
			break;
		}		
		frame.setComponentZOrder(playerToken, new Integer(0));
	}

	/**
	 * update observer
	 */
	@Override
	public void update(Observable o, Object arg) {
		//do nothing else since the game is over!!!
		if (game.gameOver()) { return; }
		//update time
		timer.setText("Time Remaining: " + (int) game.timeLeft() / 1000 + " seconds");
		updateMoney(playerTurn.getToken());
		auctionButton.setEnabled(playerTurn.inBuyState());
		buyButton.setEnabled(playerTurn.inBuyState());
		String argument = (String) arg;
		if(argument.contains("turn")) {	finishTurnButton.setVisible(true); }
		else { finishTurnButton.setVisible(false); }
		if(argument.contains("roll")) { rollDiceButton.setEnabled(true); }
		else { rollDiceButton.setEnabled(false); }
		if(argument.contains("jailbuyout")) { jailBuyOutButton.setEnabled(true); }
		else { jailBuyOutButton.setEnabled(false); }
		
		//System.out.printf("canRoll = %b\n", playerTurn.canRoll());
		//System.out.printf("isTurnOver = %b\n", playerTurn.isTurnOver());
		//System.out.printf("inBuyState = %b\n", playerTurn.inBuyState());
	}
	
	/**
	 * moves the players token on the board
	 */
	private void updateMoney(String token) {
		switch(token) {
		case "Dog": 			
			player1Money.setText("Money: $" + playerTurn.getPlayer().getMoney());
			break;
		case "Battleship": 	
			player2Money.setText("Money: $" + playerTurn.getPlayer().getMoney());
			break;
		case "Car": 			 	
			player3Money.setText("Money: $" + playerTurn.getPlayer().getMoney());
			break;
		case "Hat": 
			player4Money.setText("Money: $" + playerTurn.getPlayer().getMoney());
			break;
		default:
			break;
		}
	}

	/**
	 * Launch application.
	 */
	public static void main(String[] args) {
		GUI window = new GUI();
		window.frame.setVisible(true);
		if(args.length > 0) {
			if(args[0].contains("doubles")) {							
				window.game.setDoubles(true);
			}
			if(args[0].contains("monopolies")) {
				//window.game.
			}
		}
	}
}