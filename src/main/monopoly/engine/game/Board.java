package monopoly.engine.game;

import monopoly.engine.player.Player;
import monopoly.engine.square.*;
import java.util.Random;

public class Board {
	
	private Square[] board;
	
	public Board() {
		Color purple = new Color(Color.Type.PURPLE, 50);
		Color lightblue = new Color(Color.Type.LIGHT_BLUE, 50);
		Color pink = new Color(Color.Type.PINK, 100);
		Color orange = new Color(Color.Type.ORANGE, 100);
		Color red = new Color(Color.Type.RED, 150);
		Color yellow = new Color(Color.Type.YELLOW, 150);
		Color green = new Color(Color.Type.GREEN, 200);
		Color blue = new Color(Color.Type.BLUE, 200);
		Color railroad = new Color(Color.Type.RAILROAD, null);
		Color utility = new Color(Color.Type.UTILITY, null);
		board = new Square[] {new NonDeed(NonDeed.SquareType.GO), 
				new Deed(Deed.DeedName.MEDITERRANEAN_AVENUE, 60, new int[] {2, 10, 30, 90, 160, 250}, purple), 
				new NonDeed(NonDeed.SquareType.COMMUNITY_CHEST), 
				new Deed(Deed.DeedName.BALTIC_AVENUE, 60, new int[] {4, 20, 60, 180, 320, 450}, purple), 
				new NonDeed(NonDeed.SquareType.INCOME_TAX), 
				new Deed(Deed.DeedName.READING_RAILROAD, 200, new int[] {25, 50, 100, 200}, railroad),
				new Deed(Deed.DeedName.ORIENTAL_AVENUE, 100, new int[] {6, 30, 90, 270, 400, 550}, lightblue),
				new NonDeed(NonDeed.SquareType.CHANCE),
				new Deed(Deed.DeedName.VERMONT_AVENUE, 100, new int[] {6, 30, 90, 270, 400, 550}, lightblue),
				new Deed(Deed.DeedName.CONNECTICUT_AVENUE, 120, new int[] {8, 40, 100, 300, 450, 600}, lightblue),
				new NonDeed(NonDeed.SquareType.JUST_VISITING_JAIL),
				new Deed(Deed.DeedName.STCHARLES_PLACE, 140, new int[] {10, 50, 150, 450, 625, 750}, pink), 
				new Deed(Deed.DeedName.ELECTRIC_COMPANY, 150, new int[] {4, 10}, utility),
				new Deed(Deed.DeedName.STATES_AVENUE, 140, new int[] {10, 50, 150, 450, 625, 750}, pink), 
				new Deed(Deed.DeedName.VIRGINIA_AVENUE, 160, new int[] {12, 60, 180, 500, 700, 900}, pink),
				new Deed(Deed.DeedName.PENNSYLVANIA_RAILROAD, 200, new int[] {25, 50, 100, 200}, railroad),
				new Deed(Deed.DeedName.STJAMES_PLACE, 180, new int[] {14, 70, 200, 550, 750, 950}, orange),
				new NonDeed(NonDeed.SquareType.COMMUNITY_CHEST),
				};
		//need to add deeds to Colors' deedlists
	}

	
	public void movePiece(Player player) {
		//move player's token around the board
	}
	
	public int rollDice() {
		//show graphic
		Random r = new Random();
		int one = r.nextInt(6); int two = r.nextInt(6);
		return one + two;
	}
}
