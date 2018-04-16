package monopoly.engine.player;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import monopoly.engine.square.Deed;

public class Assets extends Observable {
	private int money;
	private LinkedList<Deed> deeds;
	private Player owner;

	public Assets(Player owner) {
		money = 1500;
		deeds = new LinkedList<>();
		this.owner = owner;
	}
	
	public int getMoney() {
		return money;
	}
	
	public LinkedList<Deed> getDeeds() {
		return deeds;
	}
	
	public void addObserver(Observer o) {
		super.addObserver(o);
	}

	public void addDeed(Deed deed) {
		deeds.add(deed);
		System.out.printf("%s now owns %s\n", owner.getToken(), deed.getName());
	}

	public void removeDeed(Deed deed) {
		deeds.remove(deed);
		System.out.printf("%s no longer owns %s\n", owner.getToken(), deed.getName());
	}
	
	public int getNetWorth() {
		int mortgageValues = 0;
		for(Deed deed : deeds) {
			mortgageValues += deed.getMortgageValue();
		}
		return money + mortgageValues;
	}

	public void deduct(int amount) {
		money -= amount;
		if (money < 0) {
			//bankrupt?
			boolean bankrupt = true;
			for (Deed current: deeds)
				if(!current.isMortgaged())
					bankrupt = false;
			if(bankrupt) {
				setChanged();
				notifyObservers();
				clearChanged();
			}
			//GUI feedback
		}
		System.out.printf("%s's new balance is $%d\n", owner.getToken(), money);
	}

	public void deposit(int amount) {
		money += amount;
		System.out.printf("%s's new balance is $%d\n", owner.getToken(), money);
	}

}
