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
		//System.out.printf("player %s bought %s for $%d\n", player.getToken(), deed.getName(), deed.getPurchasePrice());
		player.addDeed(deed);
		player.deduct(deed.getPurchasePrice());
	}
	
	public static void auctionProperty(Square square, ArrayList<Integer> bids, boolean trade) {
		if(square instanceof Deed) {
			Deed deed = (Deed) square;
			int max = Integer.MIN_VALUE;
			int winner = -1;
			for(Integer i = 0; i < bids.size(); i++) {
				if(bids.get(i) > max) {
					max = bids.get(i);
					if(trade) {
						//owner is 0, add 1 to everything
						if(Monopoly.getInstance().getPlayers().indexOf(deed.getOwner()) == 0) {
							if(bids.size() == 1) { winner = 1; }
							else if(bids.size() == 2) {
								if(i == 0) { winner = 1; }
								else if(i == 1) { winner = 2; }
							}
							else if(bids.size() == 3) {
								if(i == 0) { winner = 1; }
								else if(i == 1) { winner = 2; }
								else if(i == 2) { winner = 3; }
							}
						}
						//owner is 1, add 1 to index 1 and 2
						else if(Monopoly.getInstance().getPlayers().indexOf(deed.getOwner()) == 1) {
							if(i == 1) { winner = 2; }
							else if(i == 2) { winner = 3; }
							else { winner = i; }
						}
						//owner is 2, add 1 to index 2
						else if(Monopoly.getInstance().getPlayers().indexOf(deed.getOwner()) == 2) {
							if(Monopoly.getInstance().getPlayers().size() > 3 && i == 2) { winner = 3; }
							else { winner = i; }
						}
						else { winner = i; }
					}
					else { winner = i; }
				}
			}
			if(trade) { GUI.getInstance().printToDialogBox(String.format("%s traded %s to %s for $%d.\n", deed.getOwner().getToken(), deed.getName(), Monopoly.getInstance().getPlayers().get(winner).getToken(), max)); }
			else { GUI.getInstance().printToDialogBox(String.format("%s won the auction of %s with a bid of $%d.\n", Monopoly.getInstance().getPlayers().get(winner).getToken(), deed.getName(), max)); }
			if(deed.getOwner() != null) { //this means the auction is a trade
				deed.getOwner().deposit(max); //pay the player for the deed
				deed.getOwner().removeDeed(deed); //remove the deed from the owner
			}
			Monopoly.getInstance().getPlayers().get(winner).addDeed(deed);
			Monopoly.getInstance().getPlayers().get(winner).deduct(max);
		}
		//TODO Prompt User for buy or auction
	}
	
	public static void go(Player player) {
		GUI.getInstance().printToDialogBox(String.format("%s received $200 for passing Go\n", player.getToken()));
		player.deposit(200);
	}
	
	public static void luxuryTax(Player player) {
		GUI.getInstance().printToDialogBox(String.format("%s paid $100 in luxury tax.\n", player.getToken()));
		player.deduct(100);
	}
	
	public static void incomeTax(Player player) {
		// deduct $200 or 10% from the player account
		int money = player.getMoney();
		if (money/10 < 200) {
			GUI.getInstance().printToDialogBox(String.format("%s paid $%d in income tax\n", player.getToken(), money/10));
			player.deduct(money/10);
		}else {
			GUI.getInstance().printToDialogBox(String.format("%s paid $%d in income tax\n", player.getToken(), 200));
			player.deduct(200);
		}
	}
}
