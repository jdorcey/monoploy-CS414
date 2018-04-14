package monopoly.engine.game;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import monopoly.engine.player.Player;

public class Monopoly implements Observer { 
	
	private static Monopoly INSTANCE;
	private Board board;
	private ArrayList<Player> players;
	private Player winner;
	private Turn turn;
	private Clock clock;
	private long time; 
	private long gameLength;
	
	protected Monopoly() { 
		board = new Board();
		clock = Clock.systemDefaultZone();
		time = clock.millis();
		gameLength = 60; //one minute
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
	
	public Board getBoard() {
		return board;
	}
	
    public static Monopoly getInstance() {
        if (INSTANCE != null) return INSTANCE;
        else return new Monopoly();
    }
    
    public void setPlayers(ArrayList<Player> players) {
    	this.players = players;
    	this.turn = new Turn(players.get(0));
    }
    public Turn getTurn() {
		return turn;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Player getCurrentPlayer() { 
		// TODO need to implement this
		return turn.getPlayer();
	}
	
	public Player getNextPlayer(Player player) {
		return players.get((players.indexOf(player) + 1) % players.size());
	}

	private boolean gameOver() {
		return players.size() == 1 || (clock.millis() - time) >= (gameLength * 1000);
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
		//gameOver();  ????????
	}
}