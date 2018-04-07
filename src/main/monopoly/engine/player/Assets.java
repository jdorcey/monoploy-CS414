package monopoly.engine.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import monopoly.engine.square.Deed;

public class Assets extends Observable {
	private int money;
	private LinkedList<Deed> deeds;
	private Player owner;
	private ArrayList<Object> observers = new ArrayList<>();

	public Assets(Player owner) {
		money = 0;
		deeds = new LinkedList<>();
		this.owner = owner;
	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void notifyObservers() {
		// loop through and notify each observer
		Iterator<Object> i = observers.iterator();
		while(i.hasNext()) {
			Observer o = (Observer) i.next();
			o.update(this, owner);
		}
	}

	public int getMoney() {
		return money;
	}
	
	public LinkedList<Deed> getDeeds() {
		return deeds;
	}

	public void addDeed(Deed deed) {
		deeds.add(deed);
	}

	public void removeDeed(Deed deed) {
		deeds.remove(deed);
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
				notifyObservers();
			}
			//GUI feedback
		}
	}

	public void deposit(int amount) {
		money += amount;
	}

}
