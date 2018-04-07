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
	
	public void rollDice() {
		//roll dice and move player 
		getDice();
		board.movePiece(player, (diceValue[0] + diceValue[1]));
	}
	
	private void getDice() {
		Random r = new Random();
		diceValue[0] = r.nextInt(6); diceValue[1] = r.nextInt(6);
	}
	
	public void buyHouse() {
		//buy house/hotel
		//DO NOT DO FOR THIS ITERATION
	}
	
	public void sellHouse() {
		//sell house/hotel
		//DO NOT DO FOR THIS ITERATION
	}
	
	public void endTurn() {
		//set next player as current player
		player = monopoly.getNextPlayer(player);
	}
	
	public boolean canRoll() {
		//return true if dice are doubles or if dice are null
		if(player.isJailed()) {
			return false;
		}
		if(diceValue == null || (diceValue[0] == diceValue[1])) {
			return true;
		}
		return false;
	}
}
