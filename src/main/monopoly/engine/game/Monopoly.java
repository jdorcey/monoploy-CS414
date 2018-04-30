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
	private Cards chance;
	private Cards commChest;
	//system test variables
	private boolean doubles;
	private boolean monopolies;
	private boolean broke;

	private Monopoly() { 
		INSTANCE = this;
		board = new Board();
		clock = Clock.systemDefaultZone();
		time = clock.millis();
		gameLength = 300; //one minute
		doubles = false;
		monopolies = false;
		broke = false;
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
		if(broke) {
			for(Player player : this.players) {
				player.setMoney(0);
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
	
	public void setBroke(boolean broke) {
		this.broke = broke;
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
	
	public int getHouses(int index) {
		Square s = board.getDeed(index);
		if (s instanceof Deed) {
			Deed d = (Deed) s;
			return d.getNumHouses();
		}
		return 0;
	}
	
	public int getHotels(int index) {
		Square s = board.getDeed(index);
		if (s instanceof Deed) {
			Deed d = (Deed) s;
			return d.getHotels();
		}
		return 0;
	}
	
	public void mortgageProperty(int index) {
		Square s = board.getDeed(index);
		if (s instanceof Deed) {
			Deed d = (Deed) s;
			if (d.getOwner() == turn.getPlayer()) {
				if (d.isMortgaged()) {
					d.unmortgage();
					GUI.getInstance().printToDialogBox(String.format("%s unmortgaged %s for $%d\n", turn.getPlayer().getToken(), d.getName(), d.getUnmortgageValue()));
				
				}else {
					d.mortgage();
					GUI.getInstance().printToDialogBox(String.format("%s mortgaged %s for $%d\n", turn.getPlayer().getToken(), d.getName(), d.getMortgageValue()));
				}
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