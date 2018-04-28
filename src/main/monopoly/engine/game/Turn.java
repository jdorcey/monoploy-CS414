package monopoly.engine.game;

import java.util.Observable;
import java.util.Random;

import monopoly.engine.player.Player;
import monopoly.engine.square.Deed;

public class Turn extends Observable {
	private int numDoubles;
	private int[] diceValues;
	private Player player;
	private Board board;
	private Monopoly monopoly = Monopoly.getInstance();
	private boolean doubles;

	public Turn(Player player) {
		this.player = player;
		diceValues = new int[2];
		resetDiceValues();
		board = monopoly.getBoard();
	}
	
	public Player getPlayer() { 
		return player;	
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
		if(isDoubles()) { 
			//call update to enable the roll button
			setChanged();
			notifyObservers("roll");
			clearChanged();
		}
		//call update to finish this turn
		else {
			setChanged();
			notifyObservers("turn");
			clearChanged();
		}
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

	public void rollDice() {
		Random r = new Random();
		diceValues[0] = r.nextInt(6) + 1; 
		if(Monopoly.getInstance().getDoubles()) { diceValues[1] = diceValues[0]; }
		else { diceValues[1] = r.nextInt(6) + 1; }
		if(monopoly.timeLeft() > 0) { System.out.printf("%s rolled %d and %d\n", player.getToken(), diceValues[0], diceValues[1]); }
	}

	private void movePlayer() {
		player.setCurrentIndex(player.getCurrentIndex() + getDiceSum());
		System.out.printf("Moving %s to %s\n", player.getToken(), board.getSquares()[player.getCurrentIndex() % 40].getName());
		//perform the square's appropriate action
		board.getSquares()[player.getCurrentIndex()].performAction(player);
	} 

	public int[] takeTurn() {
		setChanged();
		notifyObservers("");
		clearChanged();
		rollDice();
		//check if this roll is doubles and increment count of doubles
		if(isDoubles()) {
			numDoubles++; 
			if(monopoly.timeLeft() > 0) { System.out.printf("%s rolled doubles\n", player.getToken()); }
		}
		//call update to disable roll dice button
		
		//check if player will pass Go
		if ((player.getCurrentIndex() + getDiceSum()) >= 40) { Banker.go(player); }
		//check if player is jailed
		if(player.isJailed()) {
			if(isDoubles()) { 
				if (monopoly.timeLeft() > 0) { System.out.printf("%s is no longer jailed\n", player.getToken()); }
				player.setJailed(false); 
			}
			//call update to end turn for jailed player
			setChanged();
			notifyObservers("turn");
			clearChanged();
			return diceValues;
		}			
		//check if this roll was 3rd double (can't move anywhere but jail)
		if(numDoubles == 3) {
			if(monopoly.timeLeft() > 0) { System.out.printf("%s is now jailed\n", player.getToken()); }
			player.setJailed(true);
			player.setCurrentIndex(10);
			//call update to end turn
			setChanged();
			notifyObservers("turn");
			clearChanged();
			return diceValues;
		}	
		//move the number of spaces the dice roll allows
		movePlayer();
		//call update to potentially enable buy/auction buttons
		setChanged();
		notifyObservers("");
		clearChanged();
		//check if roll dice button needs to be re-enabled
		if(player.isOnNonDeed()) {
			if(isDoubles()) { 
				//call update to enable the roll button
				setChanged();
				notifyObservers("roll");
				clearChanged();
			}
			//call update to finish this turn
			else {
				setChanged();
				notifyObservers("turn");
				clearChanged();
			}
		}
		return diceValues;
	}
	
	public void jailBuyOut(Player player) {
		player.setJailed(false);
		if(player.getNumGetOutOfJailFreeCards() > 0) { 
			player.setNumGetOutOfJailFreeCards(--player.getNumGetOutOfJailFreeCards());
		} 
		else { player.deduct(50); }
		setChanged();
		notifyObservers("turn");
		clearChanged();
	}

	public void buyHouseOrHotel(Deed deed) {
		deed.buyHouseOrHotel();
	}

	public void sellHouseOrHotel(Deed deed) {
		deed.sellHouseOrHotel();
	}
	
	public void mortgage(Deed deed) {
		deed.mortgage();
	}
	
	public void unmortgage(Deed deed) {
		deed.unmortgage();
	}

	public void endTurn() {
		//set next player as current player
		player = monopoly.getNextPlayer(player);
		//reset class variables
		numDoubles = 0;
		resetDiceValues();
		//enable roll dice button for next player
		if(player.isJailed()) {
			setChanged();
			notifyObservers("roll jailbuyout");
			clearChanged();
		}
		else {
			setChanged();
			notifyObservers("roll");
			clearChanged();
		}
	}
}
