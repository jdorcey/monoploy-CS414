package monopoly.engine.game;

import monopoly.engine.player.Player;
import monopoly.engine.square.Deed;
import monopoly.engine.square.Square;

public class Banker {

	public static void buyProperty(Player player, Square tile) {
    	if (!(tile instanceof Deed)) {
			System.out.println("Trying to buy a non deed Tile " + tile.getName());
			return;
		}
		Deed deed = (Deed) tile;
		System.out.printf("player %s bought %s for $%d\n", player.getToken(), deed.getName(), deed.getPurchasePrice());
		player.addDeed(deed);
		player.deduct(deed.getPurchasePrice());
	}
	
	public static void auctionProperty(Deed deed) {
		//TODO Prompt User for buy or auction
	}
	
	public static void go(Player player) {
		System.out.printf("%s received $200 for passing Go\n", player.getToken());
		player.deposit(200);
	}
	
	public static void luxuryTax(Player player) {
		System.out.printf("%s paid $100 in luxury tax\n", player.getToken());
		player.deduct(100);
	}
	
	public static void incomeTax(Player player) {
		// deduct $200 or 10% from the player account
		int money = player.getMoney();
		if (money/10 < 200) {
			System.out.printf("%s paid $%d in income tax\n", player.getToken(), money/10);
			player.deduct(money/10);
		}else {
			System.out.printf("%s paid $%d in income tax\n", player.getToken(), 200);
			player.deduct(200);
		}
	}
}
