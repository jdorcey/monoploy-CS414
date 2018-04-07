package monopoly.engine.game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import monopoly.engine.player.Player;

public class Monopoly implements Observer { 
	
	private static Monopoly INSTANCE;
	Board board;
	ArrayList<Player> players;
	
	//we need a timer
	
	protected Monopoly() { 
		players = new ArrayList<>();
		board = new Board();
	}

    public static Monopoly getInstance() {
        if (INSTANCE != null) return INSTANCE;
        else return new Monopoly();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sendToJail(Player player) {
		// pretty sure this shouldn't be static
		
	}
	
	public Player getNextPlayer(Player player) {
		return players.get((players.indexOf(player) + 1) % players.size());
	}

	private void determineOrder() {
		//do we need this?
	}
	
	private void setUpGame() {
		//prompt user to input number of players and choose tokens
		Banker.initializePlayers(players);
		for(Player p : players) { 
			board.getCurrentLocations().put(p, 0);
			p.getAssets().addObserver(this); 
		}
	}
	
	private boolean gameOver() {
		//check if timer is out of time? or players.size() == 1 then return true;
		return false;
	}
	
	//@Override
	public void update(Observable o, Object arg) {
		switch(o.getClass().getName()) {
			case "Assets": 		players.remove(arg);	break;
		}
	}
}
