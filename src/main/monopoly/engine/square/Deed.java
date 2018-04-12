package monopoly.engine.square;

import monopoly.engine.game.Banker;
import monopoly.engine.player.Player;

public class Deed extends Square{
	public enum DeedName{ATLANTIC_AVENUE, B_AND_O_RAILROAD, BALTIC_AVENUE, BOARDWALK, CONNECTICUT_AVENUE, ELECTRIC_COMPANY, ILLINOIS_AVENUE, INDIANA_AVENUE,
		KENTUCKY_AVENUE, MARVIN_GARDENS, MEDITERRANEAN_AVENUE, NEW_YORK_AVENUE, NORTH_CAROLINA_AVENUE, ORIENTAL_AVENUE, PACIFIC_AVENUE, PARK_PLACE,
		PENNSYLVANIA_AVENUE, PENNSYLVANIA_RAILROAD, READING_RAILROAD, SHORT_LINE, STCHARLES_PLACE, STJAMES_PLACE, STATES_AVENUE, TENNESSEE_AVENUE, 
		VENTNOR_AVENUE, VERMONT_AVENUE, VIRGINIA_AVENUE, WATER_WORKS};
	
	private DeedName name;
	private int purchasePrice;
	private int mortgageValue;
	private int[] rent;
	private Color color;
	private Player owner;
	private int numHouses;
	private boolean hasHotel;

	public Deed(DeedName name, int purchasePrice, int[] rent, Color color) {
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.mortgageValue = purchasePrice / 2;
		this.rent = rent;
		this.color = color;
		this.owner = null;
		this.numHouses = 0;
		this.hasHotel = false;
	}
	
	@Override
	public void performAction(Player player) {
		if (owner == null) {
			Banker.sellProperty(player, this);
		}else {
			if(owner.equals(player)) {
				return;
			}
			player.transfer(owner, calculateRent());
		}
	}
	
	public int getMortgageValue() {
		return mortgageValue;
	}
	
	public int calculateRent() {
		if(this.color.getType() == Color.Type.RAILROAD) { return rent[color.numRailroadsorUtilitiesOwned(this)]; }
		if(this.color.getType() == Color.Type.UTILITY) {
			int numOwned = color.numRailroadsorUtilitiesOwned(this);
			switch(numOwned) {
			//replace -1 with current dice roll
			case 1: 	return rent[0] * -1;
			case 2:		return rent[1] * -1; 
			}
		}
		if (hasHotel) { return rent[5]; }
		if(numHouses == 0 && color.isMonopoly()) { return rent[0] * 2; }
		return rent[numHouses];
	}
	
	public Color getColor() {
		return color;
	}
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public boolean isMortgaged() {
		return false;
	}

	@Override
	public String getName() {
		switch(this.name) {
		case ATLANTIC_AVENUE:		return "Atlantic Avenue";
		case B_AND_O_RAILROAD:		return "B. & O. Railroad";
		case BALTIC_AVENUE:			return "Baltic Avenue";
		case BOARDWALK:				return "Boardwalk";
		case CONNECTICUT_AVENUE:	return "Connecticut Avenue";
		case ELECTRIC_COMPANY:		return "Electric Company";
		case ILLINOIS_AVENUE:		return "Illinois Avenue";
		case INDIANA_AVENUE:		return "Indiana Avenue";
		case KENTUCKY_AVENUE:		return "Kentucky Avenue";
		case MARVIN_GARDENS:		return "Marvin Gardens";
		case MEDITERRANEAN_AVENUE:	return "Mediterranean Avenue";
		case NEW_YORK_AVENUE:		return "New York Avenue";
		case NORTH_CAROLINA_AVENUE:	return "North Carolina Avenue";
		case ORIENTAL_AVENUE:		return "Oriental Avenue";
		case PACIFIC_AVENUE:		return "Pacific Avenue";
		case PARK_PLACE:			return "Park Place";
		case PENNSYLVANIA_AVENUE:	return "Pennsylvania Avenue";
		case PENNSYLVANIA_RAILROAD:	return "Pennsylvania Railroad";
		case READING_RAILROAD:		return "Reading Railroad";
		case SHORT_LINE: 			return "Short Line";
		case STCHARLES_PLACE:		return "St. Charles Place";
		case STJAMES_PLACE:			return "St. James Place";
		case STATES_AVENUE:			return "States Avenue";
		case TENNESSEE_AVENUE:		return "Tennessee Avenue";
		case VENTNOR_AVENUE:		return "Ventnor Avenue";
		case VERMONT_AVENUE:		return "Vermont Avenue";
		case VIRGINIA_AVENUE:		return "Virginia Avenue";
		case WATER_WORKS:			return "Water Works";
		}
		return null;
	}
}
