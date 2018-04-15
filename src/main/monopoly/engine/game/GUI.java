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
import monopoly.engine.player.Player;

public class GUI implements Observer {
	private JFrame frame;
	
	private ArrayList<GuiHelper> tiles;
	private JLayeredPane p1 = new JLayeredPane();
	private JLayeredPane p2 = new JLayeredPane();
	private JLayeredPane p3 = new JLayeredPane();
	private JLayeredPane p4 = new JLayeredPane();
	
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
	private JButton finishTurnButton = new JButton("Finish Turn");
	private JButton player1Token = new JButton();
	private JButton player2Token = new JButton();
	private JButton player3Token = new JButton();
	private JButton player4Token = new JButton();

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
	private void setLabel(GuiHelper square, String imgJPG) {
		try {
			Image img = ImageIO.read(getClass().getResource("/monopoly/engine/game/resources1/" + imgJPG + ".jpg"));
			square.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
			System.out.println("ERROR: Unable to set " + square + "image.");
		}
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
//		for (in range of 1 to 4)
//		for (in range of 1 to 10)
//			if i == 1 
//			  //is corner space
		tiles.set(19, new GuiHelper(10, 184, 4700, 163, boardPanels, "newYorkAvenue"));
		tiles.set(18, new GuiHelper(0, 316, 4720, 163, boardPanels, "tennesseeAvenue"));
		tiles.set(17, new GuiHelper(0, 449, 4720, 163, boardPanels, "communityChestL"));
		tiles.set(16, new GuiHelper(0, 580, 4720, 163, boardPanels, "stJamesPlace"));
		tiles.set(15, new GuiHelper(0, 706, 4720, 163, boardPanels, "pennRailroad"));
		tiles.set(14, new GuiHelper(0, 841, 4720, 163, boardPanels, "virginiaAvenue"));
		tiles.set(13, new GuiHelper(0, 975, 4720, 163, boardPanels, "statesAvenue"));
		tiles.set(12, new GuiHelper(0, 1109, 4720, 163, boardPanels, "electricCompanyUtil"));
		tiles.set(11, new GuiHelper(0, 1243, 4720, 163, boardPanels, "stCharlesPlace"));
		tiles.set(10, new GuiHelper(0, 1376, 4720, 200, boardPanels, "justVisiting"));
	}
	
	/**
	 * Set squares on upper side of board
	 */
	private void setUpperSquares() {
		tiles.set(20, new GuiHelper(5, 3, 4711, 326, boardPanels, "freeParking"));
		tiles.set(21, new GuiHelper(326, 0, 4380, 326, boardPanels, "KentuckyAvenue"));
		tiles.set(22, new GuiHelper(489, 0, 4308, 326, boardPanels, "chanceUp"));
		tiles.set(23, new GuiHelper(652, 0, 4240, 326, boardPanels, "IndianaAvenue"));
		tiles.set(24, new GuiHelper(815, 0, 4173, 326, boardPanels, "illinoisAvenue"));
		tiles.set(25, new GuiHelper(978, 0, 4108, 326, boardPanels, "boRailroad"));
		tiles.set(26, new GuiHelper(1141, 0, 4045, 326, boardPanels, "AtlanticAvenue"));
		tiles.set(27, new GuiHelper(1304, 0, 3984, 326, boardPanels, "VentnorAvenue"));
		tiles.set(28, new GuiHelper(1467, 0, 3925, 326, boardPanels, "waterWorksUtil"));
		tiles.set(29, new GuiHelper(1630, 0, 3868, 326, boardPanels, "MarvinGardens"));
	}
	
	/**
	 * Set squares on right side of board
	 */
	private void setRightSquares() {
		tiles.set(30, new GuiHelper(3555, 0, 326, 326, boardPanels, "gotoJail"));
		tiles.set(31, new GuiHelper(3555, 179, 326, 163, boardPanels, "PacificAvenue"));
		tiles.set(32, new GuiHelper(3555, 314, 326, 163, boardPanels, "northCarolinaAvenue"));
		tiles.set(33, new GuiHelper(3555, 446, 326, 163, boardPanels, "communityChestR"));
		tiles.set(34, new GuiHelper(3555, 580, 326, 163, boardPanels, "PennsylvaniaAvenue"));
		tiles.set(35, new GuiHelper(3555, 711, 326, 163, boardPanels, "shortLine"));
		tiles.set(36, new GuiHelper(3555, 844, 326, 163, boardPanels, "chanceRi"));
		tiles.set(37, new GuiHelper(3555, 976, 326, 163, boardPanels, "parkPlace"));
		tiles.set(38, new GuiHelper(3555, 1109, 326, 163, boardPanels, "luxuryTax"));
		tiles.set(39, new GuiHelper(3555, 1239, 326, 163, boardPanels, "boardwalk"));
	}
	
	/**
	 * Set squares on bottom side of board
	 */
	private void setBottomSquares() {
		tiles.set(9, new GuiHelper(2436, 1373, 163, 326, boardPanels, "connecticutAvenue"));
		tiles.set(8, new GuiHelper(2570, 1373, 163, 326, boardPanels, "vermontAvenue"));
		tiles.set(7, new GuiHelper(2705, 1373, 163, 326, boardPanels, "chanceBot"));
		tiles.set(6, new GuiHelper(2841, 1373, 163, 326, boardPanels, "orientalAvenue"));
		tiles.set(5, new GuiHelper(2965, 1373, 163, 326, boardPanels, "readingRailroad"));
		tiles.set(4, new GuiHelper(3094, 1373, 163, 326, boardPanels, "incomeTax"));
		tiles.set(3, new GuiHelper(3192, 1373, 212, 326, boardPanels, "balticAvenue"));
		tiles.set(2, new GuiHelper(3347, 1373, 163, 326, boardPanels, "communityChestBot"));
		tiles.set(1, new GuiHelper(3456, 1373, 212, 326, boardPanels, "mediterraneanAvenue"));
		tiles.set(0, new GuiHelper(3557, 1373, 326, 326, boardPanels, "passGo"));
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
		
		for (int i = 0; i < 40 ; i++) 
			tiles.get(i).setLayout(flow);
		
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
		finishTurnButton.setBounds(1900, 1750, 300, 130);
		setButton(communityChestButton, 212, 252, 228);
		setButton(chanceButton, 212, 252, 228);
		setButton(rollDiceButton, 255, 100, 100);
		setButton(buyButton, 74, 165, 255);
		setButton(sellButton, 255, 172, 89);
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
			}
		});
		
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		frame.getContentPane().add(sellButton);
		frame.getContentPane().add(auctionButton);
		frame.getContentPane().add(tradeButton);
		frame.getContentPane().add(startGameButton);
		frame.getContentPane().add(finishTurnButton);
	}
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
		playerTurn.addObserver(this);
		
		rollDiceButton.setEnabled(true);
		dice1.setVisible(true);
		dice2.setVisible(true);
		
		//Only handles displaying the dice
		rollDiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rollVal = playerTurn.takeTurn();
				//set dice label to value rolled
				updateDice(dice1, 0);
				updateDice(dice2, 1);
			}
		});
		//end turn
		finishTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("finish turn!\n");
				playerTurn.endTurn();
				setPlayerBorder();
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
				System.out.println("buyProperty!");
				Banker.buyProperty(playerTurn.getPlayer(), game.getBoard().getDeed(playerTurn.getCurrentIndex()));
				playerTurn.doneBuying();
			}
		});
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//arg here is null, we don't need it
		//update money!
		rollDiceButton.setEnabled(playerTurn.canRoll());
		finishTurnButton.setVisible(playerTurn.isTurnOver());
		auctionButton.setEnabled(playerTurn.inBuyState());
		buyButton.setEnabled(playerTurn.inBuyState());

		if(playerTurn.isJailed()) {
			//move to Jail square
			System.out.printf("Moving %s to Jail\n", playerTurn.getPlayer().getToken());
		}
		else { 
			int numSpaces = playerTurn.getDiceSum();
			//move player's token numSpaces
			System.out.printf("Moving %s to %s\n", playerTurn.getToken(), 
					game.getBoard().getSquares()[playerTurn.getCurrentIndex() + numSpaces].getName());
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