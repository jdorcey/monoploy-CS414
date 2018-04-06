package monopoly.engine.square;

import monopoly.engine.game.Banker;
import monopoly.engine.game.Monopoly;
import monopoly.engine.player.Player;

public class NonDeed extends Square {
	public enum SquareType {GO, GO_TO_JAIL, COMMUNITY_CHEST, CHANCE, INCOME_TAX, LUXURY_TAX};
	private SquareType type;
	public NonDeed(SquareType type) {
		this.type = type;
	}
	
	public void performAction(Player player) {
		switch(this.type) {
		case GO: 				Banker.go(player);				break;
		case GO_TO_JAIL: 		Monopoly.sendToJail(player); 	break;
		case COMMUNITY_CHEST: 									break;
		case CHANCE: 											break;
		case INCOME_TAX: 		Banker.incomeTax(player); 		break;
		case LUXURY_TAX:		Banker.luxuryTax(player);		break;
		}
	}

	@Override
	public String getName() {
		switch(this.type) {
		case GO: 				break; //Banker.go(player);
		case GO_TO_JAIL: 		break;
		case COMMUNITY_CHEST: 	break;
		case CHANCE: 			break;
		case INCOME_TAX: 		break;
		case LUXURY_TAX:		break;
		}
		return null;
	}
}
