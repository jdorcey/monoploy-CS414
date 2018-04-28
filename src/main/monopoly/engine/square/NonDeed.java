

package monopoly.engine.square;

import monopoly.engine.game.Banker;
import monopoly.engine.game.Monopoly;
import monopoly.engine.player.Player;

public class NonDeed extends Square {
	
	public enum SquareType {GO, JUST_VISITING_JAIL, GO_TO_JAIL, FREE_PARKING, COMMUNITY_CHEST, CHANCE, INCOME_TAX, LUXURY_TAX};
	private SquareType type;
	
	public NonDeed(SquareType type) {
		this.type = type;
	}
	
	@Override
	public String getName() {
		switch(this.type) {
		case GO: 					return "Go";	 
		case JUST_VISITING_JAIL:	return "Just Visiting";
		case GO_TO_JAIL: 			return "Go to Jail";				
		case FREE_PARKING:			return "Free Parking";
		case COMMUNITY_CHEST: 		return "Community Chest";
		case CHANCE: 				return "Chance";
		case INCOME_TAX: 			return "Income Tax";
		case LUXURY_TAX:			return "Luxury Tax";
		}
		return null;
	}
	
	public void performAction(Player player) {
		switch(this.type) {
		case GO: 					Banker.go(player);			break;
        case JUST_VISITING_JAIL:    							break; //do nothing
		case GO_TO_JAIL: 	  		player.setJailed(true);
									player.setCurrentIndex(10); break;
        case FREE_PARKING: 										break; //do nothing
		case COMMUNITY_CHEST:
			Monopoly.getInstance().commChest(player);
			break;
		case CHANCE:
			Monopoly.getInstance().chance(player);
			break;
		case INCOME_TAX: 		   	Banker.incomeTax(player);	break;
		case LUXURY_TAX:		   	Banker.luxuryTax(player);	break;
		}
		player.setOnNonDeed(true);
	}
}
