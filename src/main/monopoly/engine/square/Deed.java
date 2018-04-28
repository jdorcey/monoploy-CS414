package monopoly.engine.square;

import monopoly.engine.game.Monopoly;
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
	private boolean mortgaged;

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
	
	public String toString() {
		return this.getName();
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getMortgageValue() {
		return mortgageValue;
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
		return mortgaged;
	}
	
	@Override
	public void performAction(Player player) {
		if (owner == null) { player.setBuyState(true); }
		else {
			if(!owner.equals(player)) { owner.transfer(player, calculateRent()); }
			player.setOnNonDeed(true);
		}
	}
	
	public int calculateRent() {
		if(mortgaged) { return 0; }
		if(this.color.getType() == Color.Type.RAILROAD) { return rent[color.numRailroadsorUtilitiesOwned(this)]; }
		if(this.color.getType() == Color.Type.UTILITY) {
			return rent[color.numRailroadsorUtilitiesOwned(this)] * Monopoly.getInstance().getTurn().getDiceSum();
		}
		if (hasHotel) { return rent[5]; }
		if(numHouses == 0 && color.isMonopoly()) { return rent[0] * 2; }
		return rent[numHouses];
	}
	
	public void buyHouseOrHotel() {
		if(numHouses == 4) {
			numHouses = 0;
			hasHotel = true;
			owner.deduct(color.getHouseCost());
			System.out.printf("%s bought a hotel on %s for %d and 4 houses\n", owner, getName(), color.getHouseCost());
		}
		else {
			numHouses++;
			owner.deduct(color.getHouseCost());
			System.out.printf("%s bought a house on %s for %d\n", owner, getName(), color.getHouseCost());
		}
	}
	
	public void sellHouseOrHotel() {
		if(hasHotel) {
			hasHotel = false;
			owner.deposit((color.getHouseCost() / 2));
			numHouses = 4;
			System.out.printf("%s sold the hotel on %s for %d\n", owner, getName(), (color.getHouseCost() / 2));
		}
		else {
			numHouses--;
			owner.deposit(color.getHouseCost() / 2);
			System.out.printf("%s sold a house on %s for %d\n", owner, getName(), color.getHouseCost() / 2);
		}
	}
	
	public void mortgage() {
		mortgaged = true;
		owner.deposit(mortgageValue);
		System.out.printf("%s mortgaged %s for %d\n", owner, getName(), mortgageValue);
	}
	
	public void unmortgage() {
		mortgaged = false;
		owner.deduct(mortgageValue + (mortgageValue / 10));
		System.out.printf("%s unmortgaged %s for %d\n", owner, getName(), mortgageValue + (mortgageValue / 10));
	}
	
	public int getNumHouses() {
		return this.numHouses;
	}
	
	public int getHotels() {
		if(this.hasHotel == true) {
			return 1;
		} else {
			return 0;
		}
	}
}
