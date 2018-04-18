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
		player.setBuyState(false);
		if(!isDoubles()) { 
			isTurnOver = true;
			System.out.println("changing because not doubles");
		}
		setChanged();
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
		return (diceValues[0] == 0 || (isDoubles() && numDoubles < 3)) && !isTurnOver();
	}
	
	public void rollDice() {
		Random r = new Random();
		diceValues[0] = r.nextInt(6) + 1; 
		diceValues[1] = r.nextInt(6) + 1;
		System.out.printf("%s rolled %d and %d\n", player.getToken(), diceValues[0], diceValues[1]);
	}

	private void movePlayer() {
		if ((player.getCurrentIndex() + getDiceSum()) >= 40)
			Banker.go(player);
		player.setCurrentIndex(player.getCurrentIndex() + getDiceSum());
		isTurnOver = false;
		board.getSquares()[player.getCurrentIndex()].performAction(player);
//		if (!player.inBuyState() && !isDoubles()) {
//			isTurnOver = true;
//			System.out.println("changing in branch 1");
//		}
//		else if(player.isOnNonDeed() && !isDoubles()) {
//			isTurnOver = true;
//			System.out.println("changing in branch 2");
//		}
		if (!isDoubles()) {
			isTurnOver = true;
			System.out.println("changing in branch 1");
		}
		setChanged();
		notifyObservers(" ");
		clearChanged();
	} 
	
	public int[] takeTurn() {
		if(!canRoll())
			return diceValues;
		rollDice();
		if(player.isJailed()) { 
			isTurnOver = true;
			if(isDoubles()) { 
				System.out.printf("%s is no longer jailed", player.getToken());
				player.setJailed(false);
				System.out.println("changing in out of jail branch");
			}
			setChanged();
			notifyObservers();
			clearChanged();
			return diceValues;
		}			
		movePlayer();
		if(numDoubles == 3) {
			System.out.printf("%s is now jailed", player.getToken());
			player.setJailed(true);
			player.setCurrentIndex(10);
			isTurnOver = true;
			System.out.println("changing in going to jail branch");
			setChanged();
			notifyObservers();
			clearChanged();
			return diceValues;
		}	
		if(isDoubles()) { 
			numDoubles++; 
			System.out.printf("%s rolled doubles\n", player.getToken());
			isTurnOver = false;
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
		player.setBuyState(false);
		isTurnOver = false;
		setChanged();
		notifyObservers();
		clearChanged();
	}
}
