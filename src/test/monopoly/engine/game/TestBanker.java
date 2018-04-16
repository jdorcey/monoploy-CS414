package monopoly.engine.game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import monopoly.engine.player.Player;
import monopoly.engine.square.Deed;

public class TestBanker {

	private static Monopoly game = Monopoly.getInstance();
	private static Player player1 = new Player(Player.TokenName.DOG);
	private static Player player2 = new Player(Player.TokenName.BATTLESHIP);
	private static Deed ParkPlace = new Deed(Deed.DeedName.PARK_PLACE, 350, new int[] {35, 175, 500, 1100, 1300, 1500}, game.getBoard().blue);
	
	@Before
	public void setUp() throws Exception {
		game.setPlayers(new ArrayList<>(Arrays.asList(new Player[] {player1, player2})));
	}
	
	@Test
	public void testBuyProperty() {
		int money = player1.getMoney();
		assertTrue(player1.getDeeds().isEmpty());
		Banker.buyProperty(player1, ParkPlace);
		assertTrue("Property not added to player's Deed list", !player1.getDeeds().isEmpty() && player1.getDeeds().contains(ParkPlace));
		assertEquals("Property's owner was not set", player1, ParkPlace.getOwner());
		assertEquals("Purchase price was not deducted from player's money", money - ParkPlace.getPurchasePrice(), player1.getMoney());
	}
	
	@Test
	public void testAuctionProperty() {
	
	}

	@Test
	public void testGo() {
		int currentBalance = game.getCurrentPlayer().getMoney();
		Banker.go(game.getCurrentPlayer());
		assertEquals("ERROR in Banker: passing GO did not give player $200", currentBalance+200, game.getCurrentPlayer().getMoney());
	}
	
	@Test
	public void testIncomeTax() {
		int expectedBalance = -1;
		if (game.getCurrentPlayer().getMoney()/10 < 200) { expectedBalance = game.getCurrentPlayer().getMoney() - game.getCurrentPlayer().getMoney()/10; }
		else { expectedBalance = game.getCurrentPlayer().getMoney() - 200;}
		Banker.incomeTax(game.getCurrentPlayer());
		assertEquals("ERROR in Banker: income Tax was not deducted correctly", expectedBalance, game.getCurrentPlayer().getMoney());
	}
	
	@Test
	public void testluxuryTax() {
		int currentBalance = game.getCurrentPlayer().getMoney();
		Banker.luxuryTax(game.getCurrentPlayer());
		assertEquals("ERROR in Banker: passing GO did not give player $200", currentBalance-100, game.getCurrentPlayer().getMoney());
	}
}