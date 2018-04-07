package monopoly.engine.player;

import java.util.LinkedList;

import monopoly.engine.square.Deed;

public class Player {
	private Assets asset;
	private Token token; 
	
	public Player(Token.Name name) {
		asset = new Assets(this);
		token = new Token(name);
	}

	// Jenn need input on how you're going to interact with this
	public void takeTurn() {
		// roll dice
		// buy/sell houses/hotel
		// need input from the GUI
	}
	
	// need to call trade on both players. only one player with money
	// if deeds not transferred use null
	public void trade(Player other, int money, LinkedList<Deed> deeds) { 
		transfer(other, money);
		for (Deed deed: deeds) {
			removeDeed(deed);
			other.addDeed(deed);
		}
	}
	
	public void transfer(Player other, int amount) {
		deduct(amount);
		other.deposit(amount);
	}
	
	public void deduct(int amount) {
		asset.deduct(amount);
	}
	
	public void deposit(int amount) {
		asset.deposit(amount);
	}
	
	public void addDeed(Deed deed) {
		asset.addDeed(deed);
	}
	
	public void removeDeed(Deed deed) {
		asset.removeDeed(deed);
	}
	
	public int getMoney() {
		return asset.getMoney();
	}
}
