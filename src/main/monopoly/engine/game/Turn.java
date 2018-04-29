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
		if(isDoubles()) { update("roll"); }
		else { update("turn"); }
	}

	public boolean isJailed() { 
		return player.isJailed(); 
	}

	public boolean isDoubles() {
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
		if(monopoly.timeLeft() > 0) { monopoly.printToDialog(String.format("%s rolled %d\n", player.getToken(), getDiceSum())); }
	}

	private void movePlayer() {
		movePlayer(getDiceSum(), true);
	} 

	public void movePlayer(int distance, boolean toggle) { //toggle true if move with// toggle false if move to
		if(toggle) { player.setCurrentIndex(player.getCurrentIndex() + distance); }
		else { player.setCurrentIndex(distance); }
		if(player.isJailed()) { monopoly.printToDialog(String.format("Moving %s to Jail.\n", player.getToken())); }
		else { monopoly.printToDialog(String.format("Moving %s to %s\n", player.getToken(), board.getSquares()[player.getCurrentIndex() % 40].getName())); }
		//perform the square's appropriate action
		board.getSquares()[player.getCurrentIndex()].performAction(player);
	} 

	public int[] takeTurn() {
		if(monopoly.timeLeft() <= 0) { 
			update(""); 
			return diceValues; 
		}
		rollDice();
		//check if this roll is doubles and increment count of doubles
		if(isDoubles()) {
			numDoubles++; 
			if(monopoly.timeLeft() > 0) { monopoly.printToDialog(String.format("%s rolled doubles\n", player.getToken())); }
		}
		//call update to disable roll dice button
		
		//check if player will pass Go
		if ((player.getCurrentIndex() + getDiceSum()) >= 40) { Banker.go(player); }
		//check if player is jailed
		if(player.isJailed()) {
			if(isDoubles()) { 
				if (monopoly.timeLeft() > 0) { monopoly.printToDialog(String.format("%s is no longer jailed\n", player.getToken())); }
				player.setJailed(false); 
			}
			update("turn");
			return diceValues;
		}			
		//check if this roll was 3rd double (can't move anywhere but jail)
		if(numDoubles == 3) {
			if(monopoly.timeLeft() > 0) { monopoly.printToDialog(String.format("Moving %s to Jail.\n", player.getToken())); }
			player.setJailed(true);
			player.setCurrentIndex(10);
			update("turn");
			return diceValues;
		}	
		//move the number of spaces the dice roll allows
		movePlayer();
		//call update to potentially enable buy/auction buttons
		//update("");
		//check if roll dice button needs to be re-enabled
		if(player.inSellState()) { update(""); }
		if(player.isOnNonDeed()) {
			if(isDoubles()) { 
				//call update to enable the roll button
				update("roll");
			}
			//call update to finish this turn
			else { update("turn"); }
		}
		return diceValues;
	}
	
	public void jailBuyOut(Player player) {
		player.setJailed(false);
		if(player.getNumGetOutOfJailFreeCards() > 0) { 
			player.setNumGetOutOfJailFreeCards(player.getNumGetOutOfJailFreeCards() - 1);
		} 
		else { player.deduct(50); }
		update("turn");
	}

	public void update(String arg) {
		setChanged();
		notifyObservers(arg);
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
		if(player.isJailed()) { update("roll jailbuyout"); }
		else { update("roll"); }
	}
}
