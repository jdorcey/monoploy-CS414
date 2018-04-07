package monopoly.engine.player;

import java.util.LinkedList;

import monopoly.engine.square.Deed;

public class Assets {
	private int money;
	private LinkedList<Deed> deeds;
	
	public Assets() {
		money = 0;
		deeds = new LinkedList<>();
	}
	
	public int getMoney() {
		return money;
	}
	
	public void addDeed(Deed deed) {
		deeds.add(deed);
	}
	
	public void removeDeed(Deed deed) {
		deeds.remove(deed);
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
				//game over
			}
			//GUI feedback
		}
	}

	public void deposit(int amount) {
		money += amount;
	}

}
