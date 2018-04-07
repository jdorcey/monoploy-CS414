package monopoly.engine.game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import monopoly.engine.player.Player;

public class Monopoly implements Observer { 
	Board board;
	ArrayList<Player> players;
	//used to calculate rent on utilities
	int currentRoll;
	//used to check if same player rolls multiple doubles
	Player currentTurn;
	//we need a timer
	
	public Monopoly () { //Singleton Instance?
		board = new Board();
		players = new ArrayList<>();
		currentRoll = -1;
		currentTurn = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rollDice() {
		//show graphic
		Random r = new Random();
		int one = r.nextInt(6); int two = r.nextInt(6);
		return one + two;
	}
	
	public static void sendToJail(Player player) {
		// pretty sure this shouldn't be static
		
	}
	
	private void determineOrder() {
		//determine order
		for(Player p : players) {
			p.getAssets().addObserver(this);
		}
	}
	
	private void setUpGame() {
		//prompt user to input number of players and choose tokens
		Banker.initializePlayers(players);
		determineOrder();
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
