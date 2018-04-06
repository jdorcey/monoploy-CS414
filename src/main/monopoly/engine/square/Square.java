package monopoly.engine.square;

import monopoly.engine.player.Player;

public abstract class Square {
	
	abstract public void performAction(Player player);
	
	abstract public String getName();
}
