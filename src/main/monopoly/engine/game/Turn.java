package monopoly.engine.game;

import java.util.Observable;
import java.util.Random;

import monopoly.engine.player.Player;

public class Turn extends Observable {
	private int numDoubles;
	private int[] diceValues;
	private Player player;
	private Board board;
	private Monopoly monopoly;

	public Turn(Player player) {
		this.player = player;
		diceValues = new int[2];
		monopoly = Monopoly.getInstance();
		board = monopoly.getBoard();
	}
	
	public int[] rollDice() {
		Random r = new Random();
		diceValues[0] = r.nextInt(6); 
		diceValues[1] = r.nextInt(6);
		return diceValues;
	}
	
	public int[] takeTurn() {
		rollDice();
		if(player.isJailed()) {
			if(diceValues[0] == diceValues[1]) { player.setJailed(false); }
			return diceValues;
		}			
		if(isDoubles()) { numDoubles++; }
		while(canRoll()) {
			rollDice();
			movePlayer();
//			if(numDoubles < 3) { 
//				movePlayer();
////				if(player.isJailed()) { 
////					notifyObservers(); 
////					return diceValues;
////				}
//			}else
			if(numDoubles == 3) {
				player.setJailed(true);
				notifyObservers();
				return diceValues;
			}		
		}
		return diceValues;
	}
	
	public boolean isJailed() {
		return player.isJailed();
	}
	public boolean canRoll() {
		if((isDoubles()) && (numDoubles != 0) && (numDoubles < 3)) {
			return true;
		}
		return false;
	}
	
	public Player getPlayer() {
		return player;
	}

	public int getNumDoubles() {
		return numDoubles;
	}

	public int getDiceSum() {
		return diceValues[0] + diceValues[1];
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
		diceValues = new int[2];
	}
	private boolean isDoubles() {return diceValues[0] == diceValues[1];}
	private void movePlayer() {
		setChanged();
		notifyObservers();
		player.setCurrentIndex(player.getCurrentIndex() + getDiceSum());
		board.getSquares()[player.getCurrentIndex()].performAction(player);
		clearChanged();
	}
}
