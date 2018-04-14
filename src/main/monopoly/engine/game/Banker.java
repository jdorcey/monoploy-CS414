package monopoly.engine.game;

import java.util.ArrayList;

import monopoly.engine.player.Player;
import monopoly.engine.square.Deed;

public class Banker {

	public static void initializePlayers(ArrayList<Player> players) {
		for(Player player : players) {
			player.deposit(1500); //players start with 1500
		}
	}
	public static void buyProperty(Player player, Deed deed) {
		player.addDeed(deed);
		player.deduct(deed.getPurchasePrice());
		System.out.printf("player %s bought %s\n", player.getToken(), deed.getName());
	}
	public static void auctionProperty(Deed deed) {
		//TODO Prompt User for buy or auction
	}
	public static void go(Player player) {
		player.deposit(200);
	}
	public static void luxuryTax(Player player) {
		player.deduct(100);
	}
	public static void incomeTax(Player player) {
		// deduct $200 or 10% from the player account
		int money = player.getMoney();
		if (money/10 < 200) {
			player.deduct(money/10);
		}else {
			player.deduct(200);
		}
	}
}
