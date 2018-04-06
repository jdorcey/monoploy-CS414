package monopoly.engine.player;

public class Player {
	private Assets asset;
	
	public Player() {
		
	}

	public void takeTurn() {
		// roll dice
		// buy/sell houses/hotel
		// need input from the GUI
	}
	
	public void transfer(Player other, int amount) {
		// deduct the amount of money from this account
		// deposit amount to other player's account
		
	}
	
	public void deduct(int amount) {
		//remove amount from player's account
		
	}
	
	public void deposit(int amount) {
		//add amount to player's account
		
	}
}
