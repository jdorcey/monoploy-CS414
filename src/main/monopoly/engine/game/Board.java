package monopoly.engine.game;

import java.util.Arrays;

import monopoly.engine.square.*;


public class Board {
	
	private Square[] squares;	
	private Color purple = new Color(Color.Type.PURPLE, 50);
	private Color lightblue = new Color(Color.Type.LIGHT_BLUE, 50);
	private Color pink = new Color(Color.Type.PINK, 100);
	private Color orange = new Color(Color.Type.ORANGE, 100);
	private Color red = new Color(Color.Type.RED, 150);
	private Color yellow = new Color(Color.Type.YELLOW, 150);
	private Color green = new Color(Color.Type.GREEN, 200);
	private Color blue = new Color(Color.Type.BLUE, 200);
	private Color railroad = new Color(Color.Type.RAILROAD, null);
	private Color utility = new Color(Color.Type.UTILITY, null);
	private Deed MediteranneanAvenue = new Deed(Deed.DeedName.MEDITERRANEAN_AVENUE, 60, new int[] {2, 10, 30, 90, 160, 250}, purple);
	private Deed BalticAvenue = new Deed(Deed.DeedName.BALTIC_AVENUE, 60, new int[] {4, 20, 60, 180, 320, 450}, purple); 
	private Deed OrientalAvenue = new Deed(Deed.DeedName.ORIENTAL_AVENUE, 100, new int[] {6, 30, 90, 270, 400, 550}, lightblue);
	private Deed VermontAvenue = new Deed(Deed.DeedName.VERMONT_AVENUE, 100, new int[] {6, 30, 90, 270, 400, 550}, lightblue);
	private Deed ConnecticutAvenue = new Deed(Deed.DeedName.CONNECTICUT_AVENUE, 120, new int[] {8, 40, 100, 300, 450, 600}, lightblue);
	private Deed StCharlesPlace = new Deed(Deed.DeedName.STCHARLES_PLACE, 140, new int[] {10, 50, 150, 450, 625, 750}, pink);
	private Deed StatesAvenue = new Deed(Deed.DeedName.STATES_AVENUE, 140, new int[] {10, 50, 150, 450, 625, 750}, pink);
	private Deed VirginiaAvenue = new Deed(Deed.DeedName.VIRGINIA_AVENUE, 160, new int[] {12, 60, 180, 500, 700, 900}, pink);
	private Deed StJamesPlace = new Deed(Deed.DeedName.STJAMES_PLACE, 180, new int[] {14, 70, 200, 550, 750, 950}, orange);
	private Deed TennesseeAvenue = new Deed(Deed.DeedName.TENNESSEE_AVENUE, 180, new int[] {14, 70, 200, 550, 750, 950}, orange);
	private Deed NewYorkAvenue = new Deed(Deed.DeedName.NEW_YORK_AVENUE, 200, new int[] {16, 80, 220, 600, 800, 1000}, orange);
	private Deed KentuckyAvenue = new Deed(Deed.DeedName.KENTUCKY_AVENUE, 220, new int[] {18, 90, 250, 700, 875, 1050}, red);
	private Deed IndianaAvenue = new Deed(Deed.DeedName.INDIANA_AVENUE, 220, new int[] {18, 90, 250, 700, 875, 1050}, red);
	private Deed IllinoisAvenue = new Deed(Deed.DeedName.ILLINOIS_AVENUE, 240, new int[] {20, 100, 300, 750, 925, 1100}, red);
	private Deed AtlanticAvenue = new Deed(Deed.DeedName.ATLANTIC_AVENUE, 260, new int[] {22, 110, 330, 800, 975, 1150}, yellow);
	private Deed VentnorAvenue = new Deed(Deed.DeedName.VENTNOR_AVENUE, 260, new int[] {22, 110, 330, 800, 975, 1150}, yellow);
	private Deed MarvinGardens = new Deed(Deed.DeedName.MARVIN_GARDENS, 280, new int[] {24, 120, 360, 850, 1025, 1200}, yellow);
	private Deed PacificAvenue = new Deed(Deed.DeedName.PACIFIC_AVENUE, 300, new int[] {26, 130, 390, 900, 1100, 1275}, green);
	private Deed NorthCarolinaAvenue = new Deed(Deed.DeedName.NORTH_CAROLINA_AVENUE, 300, new int[] {26, 130, 390, 900, 1100, 1275}, green);
	private Deed PennsylvaniaAvenue = new Deed(Deed.DeedName.PENNSYLVANIA_AVENUE, 320, new int[] {28, 150, 450, 1000, 1200, 1400}, green);
	private Deed ParkPlace = new Deed(Deed.DeedName.PARK_PLACE, 350, new int[] {35, 175, 500, 1100, 1300, 1500}, blue);
	private Deed Boardwalk = new Deed(Deed.DeedName.BOARDWALK, 400, new int[] {50, 200, 600, 1400, 1700, 2000}, blue);
	private Deed ReadingRailroad = new Deed(Deed.DeedName.READING_RAILROAD, 200, new int[] {25, 50, 100, 200}, railroad);
	private Deed PennsylvaniaRailroad = new Deed(Deed.DeedName.PENNSYLVANIA_RAILROAD, 200, new int[] {25, 50, 100, 200}, railroad);
	private Deed BandORailroad = new Deed(Deed.DeedName.B_AND_O_RAILROAD, 200, new int[] {25, 50, 100, 200}, railroad);
	private Deed ShortLine = new Deed(Deed.DeedName.SHORT_LINE, 200, new int[] {25, 50, 100, 200}, railroad);
	private Deed ElectricCompany = new Deed(Deed.DeedName.ELECTRIC_COMPANY, 150, new int[] {4, 10}, utility);
	private Deed WaterWorks = new Deed(Deed.DeedName.WATER_WORKS, 150, new int[] {4, 10}, utility);
		
	public Board() {
		squares = new Square[] {new NonDeed(NonDeed.SquareType.GO), MediteranneanAvenue, new NonDeed(NonDeed.SquareType.COMMUNITY_CHEST), 
				BalticAvenue, new NonDeed(NonDeed.SquareType.INCOME_TAX), ReadingRailroad, OrientalAvenue, 
				new NonDeed(NonDeed.SquareType.CHANCE), VermontAvenue, ConnecticutAvenue, new NonDeed(NonDeed.SquareType.JUST_VISITING_JAIL),
				StCharlesPlace, ElectricCompany, StatesAvenue, VirginiaAvenue, PennsylvaniaRailroad, StJamesPlace,
				new NonDeed(NonDeed.SquareType.COMMUNITY_CHEST), TennesseeAvenue, NewYorkAvenue, new NonDeed(NonDeed.SquareType.FREE_PARKING),
				KentuckyAvenue, new NonDeed(NonDeed.SquareType.CHANCE), IndianaAvenue, IllinoisAvenue, BandORailroad, AtlanticAvenue,
				VentnorAvenue, WaterWorks, MarvinGardens, new NonDeed(NonDeed.SquareType.GO_TO_JAIL), PacificAvenue, NorthCarolinaAvenue,
				new NonDeed(NonDeed.SquareType.COMMUNITY_CHEST), PennsylvaniaAvenue, ShortLine, new NonDeed(NonDeed.SquareType.CHANCE),
				ParkPlace, new NonDeed(NonDeed.SquareType.LUXURY_TAX), Boardwalk};
		purple.addDeeds(Arrays.asList(new Deed[] {MediteranneanAvenue, BalticAvenue}));
		lightblue.addDeeds(Arrays.asList(new Deed[] {OrientalAvenue, VermontAvenue, ConnecticutAvenue}));
		pink.addDeeds(Arrays.asList(new Deed[] {StCharlesPlace, StatesAvenue, VirginiaAvenue}));
		orange.addDeeds(Arrays.asList(new Deed[] {StJamesPlace, TennesseeAvenue, NewYorkAvenue}));
		red.addDeeds(Arrays.asList(new Deed[] {KentuckyAvenue, IndianaAvenue, IllinoisAvenue}));
		yellow.addDeeds(Arrays.asList(new Deed[] {AtlanticAvenue, VentnorAvenue, MarvinGardens}));
		green.addDeeds(Arrays.asList(new Deed[] {PacificAvenue, NorthCarolinaAvenue, PennsylvaniaAvenue}));
		blue.addDeeds(Arrays.asList(new Deed[] {ParkPlace, Boardwalk}));
		railroad.addDeeds(Arrays.asList(new Deed[] {ReadingRailroad, PennsylvaniaRailroad, BandORailroad, ShortLine}));
		utility.addDeeds(Arrays.asList(new Deed[] {ElectricCompany, WaterWorks}));
	}

	public Square[] getSquares() {
		return squares;
	}
	
	public Square getDeed(int index) {
		return squares[index];
	}
}
