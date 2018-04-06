package monopoly.engine.square;

import java.util.LinkedList;

import monopoly.engine.player.Player;

public class Color {
	public enum Type {PURPLE, RAILROAD, LIGHT_BLUE, PINK, ORANGE, RED, YELLOW, UTILITY, GREEN, BLUE};
	
	private LinkedList<Deed> deeds;
	private Type type;
	public Color(Type type) {
		deeds = new LinkedList<>();
		this.type = type;
	}
	
	public void addDeed(Deed newDeed) {
		deeds.add(newDeed);
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
}
