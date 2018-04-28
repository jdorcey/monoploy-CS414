package monopoly.engine.game;

import java.io.FileNotFoundException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

import monopoly.engine.player.Player;
import monopoly.engine.square.Cards;
import monopoly.engine.square.Deed;
import monopoly.engine.square.Square;

public class Monopoly implements Observer { 

	private static Monopoly INSTANCE = null;
	private Board board;
	private Turn turn;
	private ArrayList<Player> players;
	private Player winner;
	private Clock clock;
	private long time; 
	private long gameLength;
	//system test variables
	private boolean doubles;
	private boolean monopolies;
	private Cards chance;
	private Cards commChest;
	private JTextArea gameDialog;

	private Monopoly() { 
		INSTANCE = this;
		board = new Board();
		clock = Clock.systemDefaultZone();
		time = clock.millis();
		gameLength = 300; //one minute
		doubles = false;
		monopolies = false;
		try {
			chance = new Cards(Cards.Type.CHANCE);
			commChest = new Cards(Cards.Type.COMM_CHEST);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR reading in cards");
		}
	}

	public static Monopoly getInstance() {
		if (INSTANCE != null) return INSTANCE;
		else return new Monopoly();
	}
	
	public void setGameLength(long gameLength) {
		this.gameLength = gameLength;
	}

	public Board getBoard() {
		return board;
	}

	public Turn getTurn() {
		return turn;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
		this.turn = new Turn(this.players.get(0));
		if(monopolies) {
			if(this.players.size() == 2) {
				for(Deed deed : board.blue.getDeeds()) { this.players.get(0).addDeed(deed);	}
				for(Deed deed : board.pink.getDeeds()) { this.players.get(0).addDeed(deed);	}
				for(Deed deed : board.purple.getDeeds()) { this.players.get(0).addDeed(deed); }
				for(Deed deed : board.railroad.getDeeds()) { this.players.get(0).addDeed(deed);	}
				for(Deed deed : board.orange.getDeeds()) { this.players.get(0).addDeed(deed); }
				for(Deed deed : board.red.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.yellow.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.lightblue.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.utility.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.green.getDeeds()) { this.players.get(1).addDeed(deed); }
			}
			else if(this.players.size() == 3) {
				for(Deed deed : board.blue.getDeeds()) { this.players.get(0).addDeed(deed);	}
				for(Deed deed : board.pink.getDeeds()) { this.players.get(0).addDeed(deed);	}
				for(Deed deed : board.purple.getDeeds()) { this.players.get(0).addDeed(deed); }
				for(Deed deed : board.railroad.getDeeds()) { this.players.get(1).addDeed(deed);	}
				for(Deed deed : board.orange.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.red.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.yellow.getDeeds()) { this.players.get(2).addDeed(deed); }
				for(Deed deed : board.lightblue.getDeeds()) { this.players.get(2).addDeed(deed); }
				for(Deed deed : board.utility.getDeeds()) { this.players.get(2).addDeed(deed); }
				for(Deed deed : board.green.getDeeds()) { this.players.get(2).addDeed(deed); }
			}
			else {
				for(Deed deed : board.blue.getDeeds()) { this.players.get(0).addDeed(deed);	}
				for(Deed deed : board.pink.getDeeds()) { this.players.get(0).addDeed(deed);	}
				for(Deed deed : board.purple.getDeeds()) { this.players.get(0).addDeed(deed); }
				for(Deed deed : board.railroad.getDeeds()) { this.players.get(1).addDeed(deed);	}
				for(Deed deed : board.orange.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.red.getDeeds()) { this.players.get(1).addDeed(deed); }
				for(Deed deed : board.yellow.getDeeds()) { this.players.get(2).addDeed(deed); }
				for(Deed deed : board.lightblue.getDeeds()) { this.players.get(2).addDeed(deed); }
				for(Deed deed : board.utility.getDeeds()) { this.players.get(3).addDeed(deed); }
				for(Deed deed : board.green.getDeeds()) { this.players.get(3).addDeed(deed); }
			}
		}
	}   

	public Player getCurrentPlayer() { 
		return turn.getPlayer();
	}

	public Player getNextPlayer(Player player) {
		return players.get((players.indexOf(player) + 1) % players.size());
	}

	public boolean getDoubles() {
		return doubles;
	}
	
	public void setDoubles(boolean doubles) {
		this.doubles = doubles;
	}
	
	public void setMonopolies(boolean monopolies) {
		this.monopolies = monopolies;
	}
	
	public double timeLeft() {
		return (gameLength * 1000) - (clock.millis() - time);
	}
	
	public boolean gameOver() {
		return players.size() == 1 || (clock.millis() - time) >= (gameLength * 1000);
	}
	
	public Player winner() {
		int highest = 0;
		for (Player player: players) {
			if(player.getNetWorth() > highest)
				winner = player;
		}
		return winner;
	}
	
	public void chance(Player player) {
		chance.useCard(chance.getCard(), player);
	}
	
	public void commChest(Player player) {
		commChest.useCard(commChest.getCard(), player);
	}
	
	public void setgameDialog(JTextArea pane) {
		this.gameDialog = pane;
	}

	public void printToDialog(String out) {
		gameDialog.append("- " + out);
	}
	
	public void mortgageProperty(int index) {
		Square s = board.getDeed(index);
		if (s instanceof Deed) {
			Deed d = (Deed) s;
			if (d.getOwner() == turn.getPlayer()) {
				if (d.isMortgaged())
					d.unmortgage();
				else
					d.mortgage();
			}
		}
	}
	
	public void buyHH(int index) {
		Square s = board.getDeed(index);
		if (s instanceof Deed) {
			Deed d = (Deed) s;
			if (d.getOwner() == turn.getPlayer()) {
				d.buyHouseOrHotel();
			}
		}
	}
	
	public void sellHH(int index) {
		Square s = board.getDeed(index);
		if (s instanceof Deed) {
			Deed d = (Deed) s;
			if (d.getOwner() == turn.getPlayer()) {
				d.sellHouseOrHotel();
			}
		}
	}
	
	//@Override
	public void update(Observable o, Object arg) {
		switch(o.getClass().getName()) {
		case "Assets": 		players.remove(arg);	break;
		}
	}
}