package monopoly.engine.square;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

import monopoly.engine.player.Player;

public class Color {
	
	public enum Type {PURPLE, RAILROAD, LIGHT_BLUE, PINK, ORANGE, RED, YELLOW, UTILITY, GREEN, BLUE};
	private ArrayList<Deed> deeds;
	private Type type;
	private Integer houseCost;
	
	public Color(Type type, Integer houseCost) {
		deeds = new ArrayList<>();
		this.type = type;
		this.houseCost = houseCost;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public void addDeeds(Collection<Deed> deeds) {
		this.deeds.addAll(deeds);
	}
	
	public boolean isMonopoly() {
		Player owner = null;
		for (Deed current: deeds) {
			if (owner == null)
				owner = current.getOwner();
			else if(!current.getOwner().equals(owner))
				return false;
		}
		return true;
	}
	public int numRailroadsorUtilitiesOwned(Deed deed) {
		Player owner = deed.getOwner();
		int count = 0;
		for (Deed current: deeds) {
			if(current.getOwner().equals(owner))
				count++;
		}
		return count - 1;
	}
}
