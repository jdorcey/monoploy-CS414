package monopoly.engine.player;

import java.util.LinkedList;

import monopoly.engine.square.Deed;

public class Player {
	
	public enum TokenName{DOG, BATTLESHIP, CAR, HAT};
	private Assets assets;
	private TokenName token; 
	private boolean isJailed;
	
	
	public Player(TokenName name) {
		assets = new Assets(this);
		token = name;
		isJailed = false;
	}
	
	public boolean isJailed() {
		return isJailed;
	}
	
	public void setJailed(boolean isJailed) {
		this.isJailed = isJailed;
	}
	
	public int getNetWorth() {
		return assets.getNetWorth();
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
	
	public TokenName getToken() {
		return token;
	}
	
	public void transfer(Player other, int amount) {
		deduct(amount);
		other.deposit(amount);
	}
	
	public void deduct(int amount) {
		assets.deduct(amount);
	}
	
	public void deposit(int amount) {
		assets.deposit(amount);
	}
	
	public void addDeed(Deed deed) {
		assets.addDeed(deed);
	}
	
	public void removeDeed(Deed deed) {
		assets.removeDeed(deed);
	}
	
	public Assets getAssets() {
		return assets;
	}
	
	public LinkedList<Deed> getDeeds() {
		return assets.getDeeds();
	}
	
	public int getMoney() {
		return assets.getMoney();
	}
}
