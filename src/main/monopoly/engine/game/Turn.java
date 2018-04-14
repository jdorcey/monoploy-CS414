package monopoly.engine.game;

import java.util.Observable;
import java.util.Random;

import monopoly.engine.player.Player;
import monopoly.engine.player.Player.TokenName;

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
		resetdiceValues();
		board = monopoly.getBoard();
		isTurnOver = false;
	}
	
	public int[] rollDice() {
		Random r = new Random();
		diceValues[0] = r.nextInt(6); 
		diceValues[1] = r.nextInt(6);
		return diceValues;
	}
	
	public int[] takeTurn() {
		if(!canRoll())
			return diceValues;
		rollDice();
		if(player.isJailed()) {
			if(isDoubles()) { player.setJailed(false); isTurnOver = true;}
			return diceValues;
		}			
		if(isDoubles()) { numDoubles++; }
		movePlayer();
		if(numDoubles == 3) {
			player.setJailed(true);
			isTurnOver = true;
			notifyObservers();
			return diceValues;
		}	
		return diceValues;
	}
	
	public boolean isJailed() { return player.isJailed(); }

	public boolean canRoll() {
		return diceValues[0] == 0 || ((isDoubles()) && (numDoubles != 0) && (numDoubles < 3));
	}
	
	public Player getPlayer() { return player;	}

	private int getNumDoubles() { return numDoubles;  }

	public int getDiceSum() { return diceValues[0] + diceValues[1]; }
	
	public String getToken() { return player.getToken();}
	
	public int getCurrentIndex() { return player.getCurrentIndex();	}
	
	public boolean isBuyState() { return player.isBuyState(); }
	
	public void doneBuying() { 
		setChanged();
		player.setBuyState(false);
		isTurnOver = true;
		notifyObservers();
		clearChanged();
	}
	
	public void buyHouse() {
		//buy house/hotel
		//DO NOT DO FOR THIS ITERATION
	}
	
	public void sellHouse() {
		//sell house/hotel
		//DO NOT DO FOR THIS ITERATION
	}
    
	public boolean isTurnOver() { return isTurnOver; }
	
    public void endTurn() {
    	setChanged();
		//set next player as current player
		player = monopoly.getNextPlayer(player);
		//reset class variables
		numDoubles = 0;
		resetdiceValues();
		isTurnOver = false;
		notifyObservers();
		clearChanged();
	}
	
    private void resetdiceValues() {
		diceValues[0] = 0;
		diceValues[1] = 0;
    }
	private boolean isDoubles() {return diceValues[0] == diceValues[1];}
	
	private void movePlayer() {
		setChanged();
		player.setCurrentIndex(player.getCurrentIndex() + getDiceSum());
		isTurnOver = false;
		board.getSquares()[player.getCurrentIndex()].performAction(player);
		if (!player.isBuyState())
			isTurnOver = true;
		notifyObservers();
		clearChanged();
	}
}
