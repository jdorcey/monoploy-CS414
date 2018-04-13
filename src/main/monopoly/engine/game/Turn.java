package monopoly.engine.game;

import java.util.Random;

import monopoly.engine.player.Player;

public class Turn {
	private int numDoubles;
	private int[] diceValue;
	private Player player;
	private Board board;
	private Monopoly monopoly;
	private boolean rolledDoubles;
	
	
	public Turn(Player player) {
		this.player = player;
		diceValue = new int[2];
		numDoubles = 0;
		monopoly = Monopoly.getInstance();
		this.board = monopoly.getBoard();
	}
	
	//how is this class getting called?
	//how is this the state pattern?
	
	public int[] rollDice() {
		Random r = new Random();
		rolledDoubles = false;
		diceValue[0] = r.nextInt(6); diceValue[1] = r.nextInt(6);
		if(diceValue[0] == diceValue[1]) { 
			numDoubles++; 
			rolledDoubles = true;
		}	
		
		if(numDoubles < 3) { board.movePiece(player, (diceValue[0] + diceValue[1])); }
		if(numDoubles == 3) { 
			player.setJailed(true);
			board.movePiece(player, 0);
			numDoubles = 0;
		}
		
		return diceValue;
	}
	
	public int getNumDoubles() {
		return numDoubles;
	}
	
	public boolean playerRolledDoubles() {
		return rolledDoubles;
	}

	public void buyHouse() {
		//buy house/hotel
		//DO NOT DO FOR THIS ITERATION
	}
	
	public void sellHouse() {
		//sell house/hotel
		//DO NOT DO FOR THIS ITERATION
	}
	
	//where is this being called?
	public void endTurn() {
		//set next player as current player
		player = monopoly.getNextPlayer(player);
	}
	
	//is this method necessary?
	public boolean canRoll() {
		//if player is jailed they can still roll to attempt to get doubles and therefore get out of jail...
		if(player.isJailed()) {
			return false;
		}
		if(diceValue.length == 0 || (diceValue[0] == diceValue[1])) {
			return true;
		}
		return false;
	}
}
