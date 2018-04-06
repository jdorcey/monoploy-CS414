package monopoly.engine.square;

import monopoly.engine.game.Banker;
import monopoly.engine.player.Player;

public class Deed extends Square{
	public enum DeedName{ATLANTIC_AVENUE, B_AND_O_RAILROAD, BALTIC_AVENUE, BOARDWALK, CONNECTICUT_AVENUE, ELECTRIC_COMPANY, ILLINOIS_AVENUE, INDIANA_AVENUE,
		KENTUCKY_AVENUE, MARVIN_GARDENS, MEDITERRANEAN_AVENUE, NEW_YORK_AVENUE, NORTH_CAROLINA_AVENUE, ORIENTAL_AVENUE, PACIFIC_AVENUE, PARK_PLACE,
		PENNSYLVANIA_AVENUE, PENNSYLVANIA_RAILROAD, READING_RAILROAD, SHORT_LINE, STCHARLES_PLACE, STJAMES_PLACE, STATES_AVENUE, TENNESSEE_AVENUE, 
		VENTNOR_AVENUE, VERMONT_AVENUE, VIRGINIA_AVENUE, WATER_WORKS};
	
	private int[] rent;
	private Color color;
	private Player owner;
	private DeedName name;
	private int numHouses;
	private boolean hasHotel;
	
	public Deed(DeedName name, int[] rent, Color color) {
		this.name = name;
		this.rent = rent;
		this.color = color;
		owner = null;
		numHouses = 0;
		hasHotel = false;
	}

	@Override
	public void performAction(Player player) {
		if (owner == null) {
			Banker.sellProperty(player, this);
		}else {
			if(owner.equals(player)) {
				return;
			}
			player.payRent(calculateRent());
		}
	}
	
	private int calculateRent() {
		if (hasHotel) {
			return rent[5];
		}
		return rent[numHouses];
	}
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
