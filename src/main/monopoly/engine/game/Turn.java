package monopoly.engine.game;

import java.util.Random;

import monopoly.engine.player.Player;

public class Turn {
	private int numDoubles;
	private int[] diceValue;
	private Player player;
	private Board board;
	private Monopoly monopoly;
	
	
	public Turn(Board board) {
		player = null;
		diceValue = new int[2];
		this.board = board;
		//monopoly = Monopoly.getInstance()
	}
	
	//how is this class getting called?
	//how is this the state pattern?
	
	public void rollDice() {
		Random r = new Random();
		diceValue[0] = r.nextInt(6); diceValue[1] = r.nextInt(6);
		if(diceValue[0] == diceValue[1]) { numDoubles++; }
		if(numDoubles < 3) { board.movePiece(player, (diceValue[0] + diceValue[1])); }
		if(numDoubles == 3) { 
			player.setJailed(true);
			board.movePiece(player, 0);
		}
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
