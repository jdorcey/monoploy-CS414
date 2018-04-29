package monopoly.engine.player;

import java.util.ArrayList;
import java.util.LinkedList;

import monopoly.engine.game.Monopoly;
import monopoly.engine.square.Color;
import monopoly.engine.square.Deed;

public class Player {
	
	public enum TokenName{DOG, BATTLESHIP, CAR, HAT};
	private Assets assets;
	private TokenName token; 
	private boolean isJailed;
	private boolean buyState;
	private boolean sellState;
	private boolean onNonDeed;
	private int currentIndex;
	private ArrayList<Color> monopolies;
	
	public Player(TokenName name) {
		assets = new Assets(this);
		token = name;
		isJailed = false;
		buyState = false;
		sellState = false;
		onNonDeed = false;
		currentIndex = 0;
		monopolies = new ArrayList<Color>();
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
	
	public boolean inSellState() {
		return sellState;
	}

	public boolean isOnNonDeed() {
		return onNonDeed;
	}
	
	public void setOnNonDeed(boolean onNonDeed) {
		this.onNonDeed = onNonDeed;
	}
	
	public void setBuyState(boolean buyState) {
		this.buyState = buyState;
	}
	
	public void setSellState(boolean sellState) {
		this.sellState = sellState;
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
	
	public void setMoney(int money) {
		assets.setMoney(money);
	}
	
	public ArrayList<Color> getMonopolies() {
		return this.monopolies;
	}
	
	public void addMonopolies(Color monColor) { 
		this.monopolies.add(monColor);
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
			if(deed.isMortgaged()) { deed.unmortgage(); }
		}
	}
	
	public boolean transfer(Player other, int amount) {
		if (other.deduct(amount)) {			
			deposit(amount);
			Monopoly.getInstance().printToDialog(String.format("%s paid %s $%d\n", other.getToken(), this.getToken(), amount));
			return true;
		}
		return false;
	}
	
	public boolean deduct(int amount) {
		return assets.deduct(amount);
	}
	
	public void deposit(int amount) {
		assets.deposit(amount);
	}
	
	public int getNumGetOutOfJailFreeCards() {
		return assets.getNumGetOutOfJailFreeCards();
	}

	public void setNumGetOutOfJailFreeCards(int numGetOutOfJailFreeCards) {
		assets.setNumGetOutOfJailFreeCards(numGetOutOfJailFreeCards);
	}
}
