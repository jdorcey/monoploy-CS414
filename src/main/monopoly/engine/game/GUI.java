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
import javax.swing.border.Border;

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
	private JLayeredPane test = new JLayeredPane();
	private JLabel propertiesLabel = new JLabel();
	private JLabel timer = new JLabel();
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
	private JButton mortgageButton = new JButton("Mortgage");
	private JButton tradeButton = new JButton("Trade");
	private JButton auctionButton = new JButton("Auction");
	private JButton addPlayer1Button = new JButton("Add Player");
	private JButton addPlayer2Button = new JButton("Add Player");
	private JButton addPlayer3Button = new JButton("Add Player");
	private JButton addPlayer4Button = new JButton("Add Player");
	private JButton startGameButton = new JButton("START GAME!");
	private JButton finishTurnButton = new JButton("Finish Turn");
	private JButton player1Token = new JButton();
	private JButton player2Token = new JButton();
	private JButton player3Token = new JButton();
	private JButton player4Token = new JButton();

	private ArrayList<Player> players;
	private ArrayList<JLayeredPane> playersPanels;
	private ArrayList<JLayeredPane> boardPanels;
	
	private JTextArea gameDialog = new JTextArea();
	private JScrollPane dialogBox = new JScrollPane(gameDialog);
	private String gameDialogText;

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
		button.setFont(new Font("Arial", Font.BOLD, 34));
		button.setBackground(new Color(r, b, g));
		button.setBorder(BorderFactory.createLineBorder(Color.black, 3));	
	}

	/**
	 * Set squares on left side of board
	 */
	private void setLeftSquares() {
		tiles.set(19, new GuiHelper((int) Math.floor(10 * (1280.0/3840)), (int) Math.floor( 184 * (720.0/2160)), 4700, 163, boardPanels, "newYorkAvenue"));
		tiles.set(18, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 316 * (720.0/2160)), 4720, 163, boardPanels, "tennesseeAvenue"));
		tiles.set(17, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 449 * (720.0/2160)), 4720, 163, boardPanels, "communityChestL"));
		tiles.set(16, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 580 * (720.0/2160)), 4720, 163, boardPanels, "stJamesPlace"));
		tiles.set(15, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 706 * (720.0/2160)), 4720, 163, boardPanels, "pennRailroad"));
		tiles.set(14, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 841 * (720.0/2160)), 4720, 163, boardPanels, "virginiaAvenue"));
		tiles.set(13, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 975 * (720.0/2160)), 4720, 163, boardPanels, "statesAvenue"));
		tiles.set(12, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 1109 * (720.0/2160)), 4720, 163, boardPanels, "electricCompanyUtil"));
		tiles.set(11, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 1243 * (720.0/2160)), 4720, 163, boardPanels, "stCharlesPlace"));
		tiles.set(10, new GuiHelper((int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 1376 * (720.0/2160)), 4720, 200, boardPanels, "justVisiting"));
	}

	/**
	 * Set squares on upper side of board
	 */
	private void setUpperSquares() {
		tiles.set(20, new GuiHelper((int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 3 * (720.0/2160)), 4711, 326, boardPanels, "freeParking"));
		tiles.set(21, new GuiHelper((int) Math.floor(326 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 4380, 326, boardPanels, "KentuckyAvenue"));
		tiles.set(22, new GuiHelper((int) Math.floor(489 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 4308, 326, boardPanels, "chanceUp"));
		tiles.set(23, new GuiHelper((int) Math.floor(652 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 4240, 326, boardPanels, "IndianaAvenue"));
		tiles.set(24, new GuiHelper((int) Math.floor(815 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 4173, 326, boardPanels, "illinoisAvenue"));
		tiles.set(25, new GuiHelper((int) Math.floor(978 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 4108, 326, boardPanels, "boRailroad"));
		tiles.set(26, new GuiHelper((int) Math.floor(1141 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 4045, 326, boardPanels, "AtlanticAvenue"));
		tiles.set(27, new GuiHelper((int) Math.floor(1304 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 3984, 326, boardPanels, "VentnorAvenue"));
		tiles.set(28, new GuiHelper((int) Math.floor(1467 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 3925, 326, boardPanels, "waterWorksUtil"));
		tiles.set(29, new GuiHelper((int) Math.floor(1630 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 3868, 326, boardPanels, "MarvinGardens"));
	}

	/**
	 * Set squares on right side of board
	 */
	private void setRightSquares() {
		tiles.set(30, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 0 * (720.0/2160)), 326, 326, boardPanels, "goToJail"));
		tiles.set(31, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 179 * (720.0/2160)), 326, 163, boardPanels, "PacificAvenue"));
		tiles.set(32, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 314 * (720.0/2160)), 326, 163, boardPanels, "northCarolinaAvenue"));
		tiles.set(33, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 446 * (720.0/2160)), 326, 163, boardPanels, "communityChestR"));
		tiles.set(34, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 580 * (720.0/2160)), 326, 163, boardPanels, "PennsylvaniaAvenue"));
		tiles.set(35, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 711 * (720.0/2160)), 326, 163, boardPanels, "shortLine"));
		tiles.set(36, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 844 * (720.0/2160)), 326, 163, boardPanels, "chanceRi"));
		tiles.set(37, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 976 * (720.0/2160)), 326, 163, boardPanels, "parkPlace"));
		tiles.set(38, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 1109 * (720.0/2160)), 326, 163, boardPanels, "luxuryTax"));
		tiles.set(39, new GuiHelper((int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 1239 * (720.0/2160)), 326, 163, boardPanels, "boardwalk"));
	}

	/**
	 * Set squares on bottom side of board
	 */
	private void setBottomSquares() {
		tiles.set(9, new GuiHelper((int) Math.floor(2436 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 163, 326, boardPanels, "connecticutAvenue"));
		tiles.set(8, new GuiHelper((int) Math.floor(2570 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 163, 326, boardPanels, "vermontAvenue"));
		tiles.set(7, new GuiHelper((int) Math.floor(2705 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 163, 326, boardPanels, "chanceBot"));
		tiles.set(6, new GuiHelper((int) Math.floor(2841 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 163, 326, boardPanels, "orientalAvenue"));
		tiles.set(5, new GuiHelper((int) Math.floor(2965 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 163, 326, boardPanels, "readingRailroad"));
		tiles.set(4, new GuiHelper((int) Math.floor(3094 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 163, 326, boardPanels, "incomeTax"));
		tiles.set(3, new GuiHelper((int) Math.floor(3192 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 212, 326, boardPanels, "balticAvenue"));
		tiles.set(2, new GuiHelper((int) Math.floor(3347 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 163, 326, boardPanels, "communityChestBot"));
		tiles.set(1, new GuiHelper((int) Math.floor(3456 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 212, 326, boardPanels, "mediterraneanAvenue"));
		tiles.set(0, new GuiHelper((int) Math.floor(3557 * (1280.0/3840)), (int) Math.floor( 1373 * (720.0/2160)), 326, 326, boardPanels, "passGo"));
	}

	/**
	 * display properties owned by each player
	 */
	private void playersOwnedPropertiesBox() {	
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
		propertiesLabel.setText("<html> " + playerTurn.getToken() + "'s Owned Properties: " + "<br> " + propsStr + "</html>");
	}
	
	/**
	 * Initializes the game frame
	 */
	private void initialize() {
		FlowLayout flow = new FlowLayout();
		flow.setHgap(0);
		flow.setVgap(0);
		frame = new JFrame("T13 Monopoly Game CS414");
		//frame.setLayout(flow);
		frame.getContentPane().setBackground(new Color(212, 252, 228));
		frame.setPreferredSize(new Dimension(1280, 720));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);

		//put all squares on board
		setLeftSquares();
		setUpperSquares();
		setRightSquares();
		setBottomSquares();
		for (int i = 0; i < 40 ; i++) 
			tiles.get(i).setLayout(flow);

		//set monopoly logo on board
		logo.setBounds((int) Math.floor(2555 * (1280.0/3840)), (int) Math.floor( 650 * (720.0/2160)), 1000, 200);
		setLabel(logo, "logo");

		//set buttons on board		
		communityChestButton.setBounds((int) Math.floor(2575 * (1280.0/3840)), (int) Math.floor( 300 * (720.0/2160)), 400, 200);
		chanceButton.setBounds((int) Math.floor(3100 * (1280.0/3840)), (int) Math.floor( 1050 * (720.0/2160)), 400, 200);
		rollDiceButton.setBounds((int) Math.floor(1413 * (1280.0/3840)), (int) Math.floor( 250 * (720.0/2160)), 300, 130);
		buyButton.setBounds( (int) Math.floor(1413 * (1280.0/3840)), (int) Math.floor( 450 * (720.0/2160)), 300, 130);
		mortgageButton.setBounds( (int) Math.floor(1413 * (1280.0/3840)), (int) Math.floor( 650 * (720.0/2160)), 300, 130);
		auctionButton.setBounds( (int) Math.floor(1413 * (1280.0/3840)), (int) Math.floor( 850 * (720.0/2160)), 300, 130);
		tradeButton.setBounds( (int) Math.floor(1413 * (1280.0/3840)), (int) Math.floor( 1050 * (720.0/2160)), 300, 130);
		startGameButton.setBounds( (int) Math.floor(1800 * (1280.0/3840)), (int) Math.floor( 1750 * (720.0/2160)), 350, 170);
		finishTurnButton.setBounds( (int) Math.floor(1900 * (1280.0/3840)), (int) Math.floor( 1750 * (720.0/2160)), 300, 130);
		setButton(communityChestButton, 212, 252, 228);
		setButton(chanceButton, 212, 252, 228);
		setButton(rollDiceButton, 255, 100, 100);
		setButton(buyButton, 74, 165, 255);
		setButton(mortgageButton, 255, 172, 89);
		setButton(auctionButton, 255, 255, 172);
		setButton(tradeButton, 153, 153, 255);
		setButton(startGameButton, 255, 0, 128);
		setButton(finishTurnButton, 99, 177, 177);
		startGameButton.setVisible(false);
		finishTurnButton.setVisible(false);
		communityChestButton.setEnabled(false);
		chanceButton.setEnabled(false);
		rollDiceButton.setEnabled(false);
		buyButton.setEnabled(false);
		mortgageButton.setEnabled(false);
		auctionButton.setEnabled(false);
		tradeButton.setEnabled(false);

		//set the dice on the board
		dice1.setBounds( (int) Math.floor(1475 * (1280.0/3840)), (int) Math.floor( 50 * (720.0/2160)), 100, 100);
		dice2.setBounds( (int) Math.floor(1575 * (1280.0/3840)), (int) Math.floor( 125 * (720.0/2160)), 100, 100);
		setLabel(dice1, "dice1");
		setLabel(dice2, "dice2");
		dice1.setVisible(false);
		dice2.setVisible(false);

		//set timer on board
		timer.setBounds( (int) Math.floor(50 * (1280.0/3840)), (int) Math.floor( 50 * (720.0/2160)), 1000, 200);
		timer.setFont(new Font("Arial", Font.BOLD, 60));
		timer.setVisible(false);
		
		//set properties box and players section of board	
		propertiesBox.setBounds( (int) Math.floor(100 * (1280.0/3840)), (int) Math.floor( 1600 * (720.0/2160)), 1600, 424);
		propertiesBox.setBorder(BorderFactory.createLineBorder(Color.blue, 4));
		propertiesLabel.setFont(new Font("Arial", Font.BOLD, 32));
		propertiesLabel.setBounds( (int) Math.floor(150 * (1280.0/3840)), (int) Math.floor( 1425 * (720.0/2160)), 1500, 500);
		propertiesBox.setVisible(false);
		propertiesLabel.setVisible(false);
		p1.setBounds( (int) Math.floor(2265 * (1280.0/3840)), (int) Math.floor( 1600 * (720.0/2160)), 385, 424);
		p1.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p2.setBounds( (int) Math.floor(2650 * (1280.0/3840)), (int) Math.floor( 1600 * (720.0/2160)), 385, 424);
		p2.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p3.setBounds( (int) Math.floor(3035 * (1280.0/3840)), (int) Math.floor( 1600 * (720.0/2160)), 385, 424);
		p3.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		p4.setBounds( (int) Math.floor(3420 * (1280.0/3840)), (int) Math.floor( 1600 * (720.0/2160)), 385, 424);
		p4.setBorder(BorderFactory.createLineBorder(Color.black, 4));
		playersPanels.add(p1);
		playersPanels.add(p2);
		playersPanels.add(p3);
		playersPanels.add(p4);
		
		//set dialog box
		gameDialog.setFont(new Font("Arial", Font.BOLD, 32));
		dialogBox.setBounds( (int) Math.floor(50 * (1280.0/3840)), (int) Math.floor( 250 * (720.0/2160)), 1200, 1000);
		dialogBox.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		dialogBox.setVisible(false);

		//button to add player 1 
		addPlayer1Button.setBounds( (int) Math.floor(2335 * (1280.0/3840)), (int) Math.floor( 1800 * (720.0/2160)), 250, 110);
		setButton(addPlayer1Button, 0, 255, 128);

		addPlayer1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer1Button.setVisible(false);				
				//add a new player
				players.add(new Player(Player.TokenName.DOG));

				//add player1 token to board
				player1Token.setBounds( (int) Math.floor(3550 * (1280.0/3840)), (int) Math.floor( 1430 * (720.0/2160)), 255, 110);
				setButton(player1Token, "dogToken");
				
				//add player1 info/money to player area
				player1.setBounds( (int) Math.floor(2420 * (1280.0/3840)), (int) Math.floor( 1420 * (720.0/2160)), 200, 500);
				setLabel(player1, "dogToken");
				player1Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player1Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player1Money.setBounds( (int) Math.floor(2350 * (1280.0/3840)), (int) Math.floor( 1685 * (720.0/2160)), 250, 110);
				p1.add(player1);
				p1.add(player1Money);
				
				frame.getContentPane().add(player1);
				frame.setComponentZOrder(player1Token, new Integer(0));
				frame.getContentPane().add(player1Money);

				//button to add player2
				addPlayer2Button.setBounds( (int) Math.floor(2720 * (1280.0/3840)), (int) Math.floor( 1800 * (720.0/2160)), 250, 110);
				setButton(addPlayer2Button, 0, 255, 128);	
			}

		});

		addPlayer2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer2Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.BATTLESHIP));

				//add player2 token and info to board
				player2Token.setBounds( (int) Math.floor(3635 * (1280.0/3840)), (int) Math.floor( 1430 * (720.0/2160)), 255, 110);
				setButton(player2Token, "battleShipToken");
				player2.setBounds( (int) Math.floor(2810 * (1280.0/3840)), (int) Math.floor(1605 * (720.0/2160)), 100, 110);
				setLabel(player2, "battleShipToken");

				//add player2 initial starting money to board
				player2Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player2Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player2Money.setBounds( (int) Math.floor(2750 * (1280.0/3840)), (int) Math.floor( 1685 * (720.0/2160)), 250, 110);
				p1.add(player2);
				p1.add(player2Money);

				frame.getContentPane().add(player2);
				frame.setComponentZOrder(player2Token, new Integer(0));
				frame.getContentPane().add(player2Money);

				//button to add player3
				addPlayer3Button.setBounds( (int) Math.floor(3105 * (1280.0/3840)), (int) Math.floor( 1800 * (720.0/2160)), 250, 110);
				setButton(addPlayer3Button, 0, 255, 128);

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
				player3Token.setBounds( (int) Math.floor(3550 * (1280.0/3840)), (int) Math.floor( 1520 * (720.0/2160)), 255, 110);
				setButton(player3Token, "carToken");
				player3.setBounds( (int) Math.floor(3190 * (1280.0/3840)), (int) Math.floor( 1615 * (720.0/2160)), 255, 110);
				setLabel(player3, "carToken");

				//add player3 initial starting money to board
				player3Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player3Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player3Money.setBounds( (int) Math.floor(3130 * (1280.0/3840)), (int) Math.floor( 1685 * (720.0/2160)), 250, 110);
				p1.add(player3);
				p1.add(player3Money);

				frame.getContentPane().add(player3);
				frame.setComponentZOrder(player3Token, new Integer(0));
				frame.getContentPane().add(player3Money);

				//button to add player3
				addPlayer4Button.setBounds( (int) Math.floor(3490 * (1280.0/3840)), (int) Math.floor( 1800 * (720.0/2160)), 250, 110);
				setButton(addPlayer4Button, 0, 255, 128);

			}

		});

		addPlayer4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPlayer4Button.setVisible(false);
				//add new player
				players.add(new Player(Player.TokenName.HAT));

				//add player4 token and info to board
				player4Token.setBounds( (int) Math.floor(3640 * (1280.0/3840)), (int) Math.floor( 1520 * (720.0/2160)), 255, 110);
				setButton(player4Token, "hatToken");
				player4.setBounds( (int) Math.floor(3570 * (1280.0/3840)), (int) Math.floor( 1615 * (720.0/2160)), 255, 110);
				setLabel(player4, "hatToken");

				//add player4 initial starting money to board
				player4Money.setText("Money: $" + String.valueOf(players.get(0).getMoney()));
				player4Money.setFont(new Font("Arial", Font.ITALIC, 30));
				player4Money.setBounds( (int) Math.floor(3520 * (1280.0/3840)), (int) Math.floor( 1685 * (720.0/2160)), 250, 110);
				p1.add(player4);
				p1.add(player4Money);

				frame.getContentPane().add(player4);
				frame.setComponentZOrder(player4Token, new Integer(0));
				frame.getContentPane().add(player4Money);				
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
		for (int i = 0; i < 40 ; i++)
			frame.getContentPane().add(tiles.get(i).getPane());
		frame.getContentPane().add(logo);
		frame.getContentPane().add(player1Token);
		frame.getContentPane().add(player2Token);
		frame.getContentPane().add(player3Token);
		frame.getContentPane().add(player4Token);
		frame.getContentPane().add(timer);
		frame.getContentPane().add(propertiesBox);
		frame.getContentPane().add(propertiesLabel);
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
		frame.getContentPane().add(startGameButton);
		frame.getContentPane().add(finishTurnButton);
		frame.getContentPane().add(dialogBox);
	}

	/**
	 * Set player area
	 */
	private void setPlayerBorder() {
		switch (lastToken) {
		case "Dog": 			
			p1.setBorder(BorderFactory.createLineBorder(Color.black, 4));
			break;
		case "Battleship": 	 			
			p2.setBorder(BorderFactory.createLineBorder(Color.black, 4));
			break;
		case "Car": 			 			
			p3.setBorder(BorderFactory.createLineBorder(Color.black, 4));
			break;
		case "Hat": 	 			
			p4.setBorder(BorderFactory.createLineBorder(Color.black, 4));
			break;
		default:
			break;
		}

		switch(playerTurn.getToken()) {
		case "Dog": 			
			p1.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
			break;
		case "Battleship": 	 			
			p2.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
			break;
		case "Car": 			 			
			p3.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
			break;
		case "Hat": 
			p4.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
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
		dialogBox.setVisible(true);
		propertiesBox.setVisible(true);
		propertiesLabel.setVisible(true);
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
				gameDialogText = "- " + playerTurn.getToken() + " bought " + game.getBoard().getDeed(playerTurn.getCurrentIndex()) + ".\n";
				gameDialog.append(gameDialogText);
				System.out.println("Buy Property!");
				Banker.buyProperty(playerTurn.getPlayer(), game.getBoard().getDeed(playerTurn.getCurrentIndex()));
				//finishTurnButton.setVisible(true);
				playerTurn.doneBuying();
				playersOwnedPropertiesBox();
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
			playerToken.setBounds( (int) Math.floor(3557 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 326, 326);
			break;
		case 1:
			playerToken.setBounds( (int) Math.floor(3456 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 212, 326);
			break;
		case 2:
			playerToken.setBounds( (int) Math.floor(3347 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 163, 326);
			break;
		case 3:
			playerToken.setBounds( (int) Math.floor(3192 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 212, 326);
			break;
		case 4:
			playerToken.setBounds( (int) Math.floor(3094 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 163, 326);
			break;
		case 5:
			playerToken.setBounds( (int) Math.floor(2965 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 163, 326);
			break;
		case 6:
			playerToken.setBounds( (int) Math.floor(2841 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 163, 326);
			break;
		case 7:
			playerToken.setBounds( (int) Math.floor(2705 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 163, 326);
			break;
		case 8:
			playerToken.setBounds( (int) Math.floor(2570 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 163, 326);
			break;
		case 9:
			playerToken.setBounds( (int) Math.floor(2436 * (1280.0/3840)), (int) Math.floor( 1375 * (720.0/2160)), 163, 326);
			break;	
		case 10:
			if(playerTurn.isJailed()) {
				System.out.printf("Moving %s to Jail\n", playerTurn.getPlayer().getToken());
				playerToken.setBounds( (int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 1450 * (720.0/2160)), 4770, 200);	
			}else {
			playerToken.setBounds( (int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 1475 * (720.0/2160)), 4720, 200);
			}
			break;
		case 11:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 1290 * (720.0/2160)), 4720, 163);
			break;
		case 12:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 1160 * (720.0/2160)), 4720, 163);
			break;
		case 13:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 1022 * (720.0/2160)), 4720, 163);
			break;
		case 14:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 890 * (720.0/2160)), 4720, 163);
			break;
		case 15:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 750 * (720.0/2160)), 4720, 163);
			break;
		case 16:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 620 * (720.0/2160)), 4720, 163);
			break;
		case 17:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 490 * (720.0/2160)), 4720, 163);
			break;
		case 18:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 365 * (720.0/2160)), 4720, 163);
			break;
		case 19:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 230 * (720.0/2160)), 4700, 163);
			break;
		case 20:
			playerToken.setBounds( (int) Math.floor(5 * (1280.0/3840)), (int) Math.floor( 3 * (720.0/2160)), 4711, 326);
			break;
		case 21:
			playerToken.setBounds( (int) Math.floor(326 * (1280.0/3840)), (int) Math.floor( 2 * (720.0/2160)), 4380, 295);
			break;
		case 22:
			playerToken.setBounds( (int) Math.floor(489 * (1280.0/3840)), (int) Math.floor( 2 * (720.0/2160)), 4308, 295);
			break;
		case 23:
			playerToken.setBounds( (int) Math.floor(652 * (1280.0/3840)), (int) Math.floor( 2 * (720.0/2160)), 4240, 295);
			break;
		case 24:
			playerToken.setBounds( (int) Math.floor(815 * (1280.0/3840)), (int) Math.floor( 2 * (720.0/2160)), 4173, 295);
			break;
		case 25:
			playerToken.setBounds( (int) Math.floor(978 * (1280.0/3840)), (int) Math.floor( 2 * (720.0/2160)), 4108, 295);
			break;
		case 26:
			playerToken.setBounds( (int) Math.floor(1141 * (1280.0/3840)), (int) Math.floor( 2 * (720.0/2160)), 4045, 295);
			break;
		case 27:
			playerToken.setBounds( (int) Math.floor(1304 * (1280.0/3840)), (int) Math.floor( 2 * (720.0/2160)), 3984, 295);
			break;
		case 28:
			playerToken.setBounds( (int) Math.floor(1467 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 3925, 295);
			break;
		case 29:
			playerToken.setBounds( (int) Math.floor(1630 * (1280.0/3840)), (int) Math.floor( 5 * (720.0/2160)), 3868, 295);
			break;			
		case 30:
			playerToken.setBounds( (int) Math.floor(0 * (1280.0/3840)), (int) Math.floor( 1450 * (720.0/2160)), 4770, 200);
			break;
		case 31:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 225 * (720.0/2160)), 326, 163);
			break;
		case 32:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 360 * (720.0/2160)), 326, 163);
			break;
		case 33:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 490 * (720.0/2160)), 326, 163);
			break;
		case 34:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 625 * (720.0/2160)), 326, 163);
			break;
		case 35:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 760 * (720.0/2160)), 326, 163);
			break;
		case 36:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 890 * (720.0/2160)), 326, 163);
			break;
		case 37:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 1025 * (720.0/2160)), 326, 163);
			break;
		case 38:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 1155 * (720.0/2160)), 326, 163);
			break;
		case 39:
			playerToken.setBounds( (int) Math.floor(3555 * (1280.0/3840)), (int) Math.floor( 1285 * (720.0/2160)), 326, 163);
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