package monopoly.engine.game;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.TreeMap;
import java.util.Timer;

import monopoly.engine.player.Player;

public class Monopoly implements Observer { 
	
	private static Monopoly INSTANCE;
	private Board board;
	private ArrayList<Player> players;
	private Player winner;
	private Clock clock;
	private long time; 
  private long gameLength;
	
	protected Monopoly() { 
		players = new ArrayList<>();
		board = new Board();
		clock = Clock.systemDefaultZone();
		time = clock.millis();
		gameLength = 60; //one minute
	}
	
    public static Monopoly getInstance() {
        if (INSTANCE != null) return INSTANCE;
        else return new Monopoly();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public Player getNextPlayer(Player player) {
		return players.get((players.indexOf(player) + 1) % players.size());
	}

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
		Banker.initializePlayers(players);
		determineOrder();
		for(Player p : players) { 
			board.getCurrentLocations().put(p, 0);
			p.getAssets().addObserver(this); 
		}
	}
	
	private Player winner() {
		int highest = 0;
		for (Player player: players) {
			if(player.getNetWorth() > highest)
				winner = player;
		}
		return winner;
	}
	
	private boolean gameOver() {
		//check if timer is out of time? or players.size() == 1 then return true;
		if (players.size() == 1) {
			return true;
		}
		if (clock.millis() - time >= gameLength * 1000) { //has the game exceeded its play time
			return true;
		}
		return false;
	}
	
	//@Override
	public void update(Observable o, Object arg) {
		switch(o.getClass().getName()) {
			case "Assets": 		players.remove(arg);	break;
		}
		gameOver();
	}
}
