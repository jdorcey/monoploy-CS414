package monopoly.engine.game;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import monopoly.engine.player.Player;

public class Monopoly implements Observer { 

	private static Monopoly INSTANCE = null;
	private Board board;
	private Turn turn;
	private ArrayList<Player> players;
	private Player winner;
	private Clock clock;
	private long time; 
	private long gameLength;
	private boolean doubles;

	private Monopoly() { 
		INSTANCE = this;
		board = new Board();
		clock = Clock.systemDefaultZone();
		time = clock.millis();
		gameLength = 300; //one minute
		doubles = false;
	}

	public static Monopoly getInstance() {
		if (INSTANCE != null) return INSTANCE;
		else return new Monopoly();
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
	
	public Player playGame() {
		for(Player p : players) { 
			p.getAssets().addObserver(this); 
		}
		while(!gameOver()) {
			for(Player player : players) {
				Turn turn = new Turn(player);
				turn.takeTurn();
			}
		}
		return winner();
	}

	/*
	private void determineOrder() {
		TreeMap<Integer, Player> order = new TreeMap<>();
		Random r = new Random();
		for(Player p : players) {
			Integer roll = r.nextInt(6) + r.nextInt(6);
			while(order.containsKey(roll)) {
				Player otherPlayer = order.get(roll);
				order.remove(roll);
				order.put(r.nextInt(6) + r.nextInt(6), otherPlayer);
				roll = r.nextInt(6) + r.nextInt(6);
			}
			order.put(roll, p);
		}
		players.clear();
		players.addAll(order.values());
	}

	private void setUpGame() {
		//prompt user to input number of players and choose tokens
		//Banker.initializePlayers(players);
		determineOrder();
		for(Player p : players) { 
			p.getAssets().addObserver(this); 
		}
	}
	 */
	public double timeLeft() {
		return (gameLength * 1000) - (clock.millis() - time);
	}
	
	
	public boolean gameOver() {
		return players.size() == 1 || (clock.millis() - time) >= (gameLength * 1000);
	}
	
	private Player winner() {
		int highest = 0;
		for (Player player: players) {
			if(player.getNetWorth() > highest)
				winner = player;
		}
		return winner;
	}

	//@Override
	public void update(Observable o, Object arg) {
		switch(o.getClass().getName()) {
		case "Assets": 		players.remove(arg);	break;
		}
	}
}