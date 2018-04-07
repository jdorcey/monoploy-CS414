package monopoly.engine.game;

import java.util.ArrayList;

import monopoly.engine.player.Player;

public class Monopoly {
	Board board;
	ArrayList<Player> players;
	
	public Monopoly () { //Singleton Instance?
		board = new Board();
		players = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sendToJail(Player player) {
		// pretty sure this shouldn't be static
		
	}
	
	private void determineOrder() {
		
	}
	
	private void setUpGame() {
		//prompt user to input number of players and choose tokens
		Banker.initializePlayers(players);
	}
	
	private boolean gameOver() {
		return false;
	}
}
