package monopoly.engine.player;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import monopoly.engine.game.GUI;
import monopoly.engine.game.Monopoly;
import monopoly.engine.square.Deed;

public class Assets extends Observable {
	private int money;
	private int numGetOutOfJailFreeCards;
	private LinkedList<Deed> deeds;
	private Player owner;
	private int owes = 0;
	private Player owedTo = null;

	public Assets(Player owner) {
		numGetOutOfJailFreeCards = 0;
		money = 1500;
		deeds = new LinkedList<>();
		this.owner = owner;
	}
	
	public int getNumGetOutOfJailFreeCards() {
		return numGetOutOfJailFreeCards;
	}

	public void setNumGetOutOfJailFreeCards(int numGetOutOfJailFreeCards) {
		this.numGetOutOfJailFreeCards = numGetOutOfJailFreeCards;
	}

	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Player getOwedTo() {
		return owedTo;
	}
	
	public int getOwes() {
		return owes;
	}
	
	public void setOwes(int owes) {
		this.owes = owes;
	}
	
	public void setOwedTo(Player owedTo) {
		this.owedTo = owedTo;
	}
	
	public LinkedList<Deed> getDeeds() {
		return deeds;
	}
	
	public void addObserver(Observer o) {
		super.addObserver(o);
	}

	public void addDeed(Deed deed) {
		deeds.add(deed);
		deed.setOwner(owner);
		//System.out.printf("%s now owns %s\n", owner.getToken(), deed.getName());
	}

	public void removeDeed(Deed deed) {
		deeds.remove(deed);
		deed.setOwner(null);
		//System.out.printf("%s no longer owns %s\n", owner.getToken(), deed.getName());
	}
	
	public int getNetWorth() {
		int mortgageValues = 0;
		for(Deed deed : deeds) {
			mortgageValues += deed.getMortgageValue();
		}
		return money + mortgageValues;
	}

	public boolean deduct(int amount) {
		if (money - amount < 0) {
			//bankrupt?
			GUI.getInstance().printToDialogBox(String.format("%s does not have enough money & must sell assets.\n- Select one or more of %s's properties.\n", owner.getToken(), owner.getToken()));
			boolean bankrupt = true;
			for (Deed current: deeds)
				if(!current.isMortgaged())
					bankrupt = false;
			if(bankrupt) {
				setChanged();
				notifyObservers();
				clearChanged();
			}
			return false;
			//GUI feedback
		}
		else { 
			money -= amount;
			return true;
			//System.out.printf("%s's new balance is $%d\n", owner.getToken(), money);
		}
	}

	public void deposit(int amount) {
		money += amount;
		//System.out.printf("%s's new balance is $%d\n", owner.getToken(), money);
	}
}
