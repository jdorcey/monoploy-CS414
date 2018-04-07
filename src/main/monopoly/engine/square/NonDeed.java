package monopoly.engine.square;

import monopoly.engine.player.Player;

public class NonDeed extends Square {
	public enum SquareType {GO, JUST_VISITING_JAIL, GO_TO_JAIL, FREE_PARKING, COMMUNITY_CHEST, CHANCE, INCOME_TAX, LUXURY_TAX};
	private SquareType type;
	public NonDeed(SquareType type) {
		this.type = type;
	}
	
	public void performAction(Player player) {
		switch(this.type) {
		case GO: 					break; //Banker.go(player);
		case JUST_VISITING_JAIL: 	break; //do nothing
		case GO_TO_JAIL: 			break; //player.setJailedState(true);
		case FREE_PARKING: 			break; //do nothing
		case COMMUNITY_CHEST: 		break;
		case CHANCE: 				break;
		case INCOME_TAX: 			break; //Banker.incomeTax(player);
		case LUXURY_TAX:			break; //Banker.luxuryTax(player);
		}
	}

	@Override
	public String getName() {
		switch(this.type) {
		case GO: 					return "Go";	 
		case JUST_VISITING_JAIL:	return "Just Visiting/Jail";
		case GO_TO_JAIL: 			return "Go to Jail";				
		case FREE_PARKING:			return "Free Parking";
		case COMMUNITY_CHEST: 		return "Community Chest";
		case CHANCE: 				return "Chance";
		case INCOME_TAX: 			return "Income Tax";
		case LUXURY_TAX:			return "Luxury Tax";
		}
		return null;
	}
}
