package monopoly.engine.game;

import java.util.Random;

import monopoly.engine.player.Player;

public class Board {

	
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
