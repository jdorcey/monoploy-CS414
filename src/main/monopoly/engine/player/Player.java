package monopoly.engine.player;

import java.util.LinkedList;

import monopoly.engine.square.Deed;

public class Player {
	
	public enum TokenName{DOG, BATTLESHIP, CAR, HAT};
	private Assets assets;
	private TokenName token; 
	private boolean isJailed;
	private boolean buyState;
	private int currentIndex;
	
	public Player(TokenName name) {
		assets = new Assets(this);
		token = name;
		isJailed = false;
		buyState = false;
		currentIndex = 0;
	}
	
	public Assets getAssets() {
		return assets;
	}
	
	public String getToken() {
		switch(token) {
		case BATTLESHIP: 	return "Battleship"; 	
		case DOG: 			return "Dog"; 			
		case CAR: 			return "Car";			
		case HAT:			return "Hat"; 
		}
		return null;
	}
	
	public boolean isJailed() {
		return isJailed;
	}
	
	public void setJailed(boolean isJailed) {
		this.isJailed = isJailed;
	}
	
	public boolean inBuyState() {
		return buyState;
	}
	
	public void setBuyState(boolean buyState) {
		this.buyState = buyState;
	}
	
	public int getCurrentIndex() {
		return this.currentIndex;
	}
	
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = (currentIndex % 40);
	}
	
	public int getMoney() {
		return assets.getMoney();
	}
	
	public LinkedList<Deed> getDeeds() {
		return assets.getDeeds();
	}

	public void addDeed(Deed deed) {
		assets.addDeed(deed);
	}
	
	public void removeDeed(Deed deed) {
		assets.removeDeed(deed);
	}
	
	public int getNetWorth() {
		return assets.getNetWorth();
	}
	
	//called only on player selling properties to other player
	public void trade(Player other, int money, LinkedList<Deed> deeds) { 
		transfer(other, money);
		for (Deed deed: deeds) {
			removeDeed(deed);
			other.addDeed(deed);
		}
	}
	
	public void transfer(Player other, int amount) {
		other.deduct(amount);
		deposit(amount);
		System.out.printf("%s payed %s $%d\n", this.getToken(), other.getToken(), amount);
	}
	
	public void deduct(int amount) {
		assets.deduct(amount);
	}
	
	public void deposit(int amount) {
		assets.deposit(amount);
	}
}
