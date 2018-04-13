package monopoly.engine.game;

import java.util.Observable;
import java.util.Random;

import monopoly.engine.player.Player;

public class Turn extends Observable {
	private int numDoubles;
	private int[] diceValues;
	private int diceSum;
	private Player player;
	private Board board;
	private Monopoly monopoly;

	public Turn(Player player) {
		this.player = player;
		diceValues = new int[2];
		monopoly = Monopoly.getInstance();
		board = monopoly.getBoard();
	}
	
	public void rollDice() {
		Random r = new Random();
		diceValues[0] = r.nextInt(6); 
		diceValues[1] = r.nextInt(6);
		diceSum = diceValues[0] + diceValues[1];
	}
	
	public void takeTurn() {
		rollDice();
		if(player.isJailed()) {
			if(diceValues[0] == diceValues[1]) { player.setJailed(false); }
			return;
		}			
		if(diceValues[0] == diceValues[1]) { numDoubles++; }
		while(numDoubles > 0) {
			rollDice();
			if(numDoubles < 3) { 
				notifyObservers();
				player.setCurrentIndex(player.getCurrentIndex() + diceSum);
				board.getSquares()[player.getCurrentIndex()].performAction(player);
				if(player.isJailed()) { 
					notifyObservers(); 
					return;
				}
			}
			else if(numDoubles == 3) { 
				player.setJailed(true);
				notifyObservers();
				return;
			}		
		}
	}
	
	public int getNumDoubles() {
		return numDoubles;
	}

	public int getDiceSum() {
		return diceSum;
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
		numDoubles = 0;
	}
}
