package monopoly.engine.game;

import java.util.Observable;
import java.util.Random;

import monopoly.engine.player.Player;

public class Turn extends Observable {
	private int numDoubles;
	private int[] diceValues;
	private Player player;
	private Board board;
	private Monopoly monopoly = Monopoly.getInstance();
	private boolean isTurnOver;

	public Turn(Player player) {
		this.player = player;
		diceValues = new int[2];
		resetDiceValues();
		board = monopoly.getBoard();
		isTurnOver = false;
	}

	public Player getPlayer() { 
		return player;	
	}

	public boolean isTurnOver() { 
		return isTurnOver; 
	}
	
	public int getDiceSum() { 
		return diceValues[0] + diceValues[1]; 
	}

	public String getToken() { 
		return player.getToken();
	}

	public int getCurrentIndex() { 
		return player.getCurrentIndex();	
	}

	public boolean inBuyState() { 
		return player.inBuyState(); 
	}

	public void doneBuying() { 
		setChanged();
		player.setBuyState(false);
		isTurnOver = true;
		notifyObservers();
		clearChanged();
	}
	
	public boolean isJailed() { 
		return player.isJailed(); 
	}

	private boolean isDoubles() {
		return diceValues[0] == diceValues[1];
	}

	private void resetDiceValues() {
		diceValues[0] = 0;
		diceValues[1] = 0;
	}
	
	public boolean canRoll() {
		return diceValues[0] == 0 || (isDoubles() && numDoubles != 0 && numDoubles < 3);
	}
	
	public void rollDice() {
		Random r = new Random();
		diceValues[0] = r.nextInt(6) + 1; 
		diceValues[1] = r.nextInt(6) + 1;
	}

	private void movePlayer() {
		setChanged();
		player.setCurrentIndex(player.getCurrentIndex() + getDiceSum());
		isTurnOver = false;
		board.getSquares()[player.getCurrentIndex()].performAction(player);
		if (!player.inBuyState())
			isTurnOver = true;
		notifyObservers(" ");
		clearChanged();
	} 
	
	public int[] takeTurn() {
		if(!canRoll())
			return diceValues;
		rollDice();
		if(player.isJailed()) {
			if(isDoubles()) { 
				player.setJailed(false); 
				isTurnOver = true;
			}
			setChanged();
			notifyObservers();
			clearChanged();
			return diceValues;
		}			
		if(isDoubles()) { numDoubles++; }
		movePlayer();
		if(numDoubles == 3) {
			player.setJailed(true);
			isTurnOver = true;
			setChanged();
			notifyObservers();
			clearChanged();
			return diceValues;
		}	
		return diceValues;
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
		//reset class variables
		numDoubles = 0;
		resetDiceValues();
		isTurnOver = false;
		setChanged();
		notifyObservers();
		clearChanged();
	}
}
