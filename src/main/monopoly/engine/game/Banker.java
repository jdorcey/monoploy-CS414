package monopoly.engine.game;

import java.util.ArrayList;

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
	
	public static void auctionProperty(Square square, ArrayList<Integer> bids) {
		if(square instanceof Deed) {
			Deed deed = (Deed) square;
			int max = Integer.MIN_VALUE;
			int winner = -1;
			for(Integer i = 0; i < bids.size(); i++) {
				if(bids.get(i) > max) {
					winner = i;
					max = bids.get(i);
				}
			}
			Monopoly.getInstance().printToDialog(String.format("%s won the auction of %s with a bid of $%d.\n", Monopoly.getInstance().getPlayers().get(winner).getToken(), deed.getName(), max));
			Monopoly.getInstance().getPlayers().get(winner).addDeed(deed);
			Monopoly.getInstance().getPlayers().get(winner).deduct(max);
		}
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
