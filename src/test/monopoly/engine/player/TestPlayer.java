package monopoly.engine.player;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import monopoly.engine.game.Monopoly;
import monopoly.engine.square.Deed;

public class TestPlayer {

	private static Monopoly game = Monopoly.getInstance();
	private Player player1 = new Player(Player.TokenName.DOG);
	private Player player2 = new Player(Player.TokenName.BATTLESHIP);
	private Player player3 = new Player(Player.TokenName.HAT);
	private Player player4 = new Player(Player.TokenName.CAR);
	private static Deed ConnecticutAvenue = new Deed(Deed.DeedName.CONNECTICUT_AVENUE, 120, new int[] {8, 40, 100, 300, 450, 600}, game.getBoard().lightblue);
	//private static Deed ParkPlace = new Deed(Deed.DeedName.PARK_PLACE, 350, new int[] {35, 175, 500, 1100, 1300, 1500}, game.getBoard().blue);
	
	@Before
	public void setUp() throws Exception {
		game.setPlayers(new ArrayList<>(Arrays.asList(new Player[] {player1, player2, player3, player4})));
	}

	@Test
	public void testGetToken() {
		assertEquals("Should be \"Dog\"", "Dog", player1.getToken());
		assertEquals("Should be \"Battleship\"", "Battleship", player2.getToken());
		assertEquals("Should be \"Hat\"", "Hat", player3.getToken());
		assertEquals("Should be \"Car\"", "Car", player4.getToken());
	}
	
	@Test
	public void testInitialAssets() {
		assertEquals("Player should start with $1500", 1500, player1.getMoney());
		assertTrue("Player should start with empty Deeds list", player1.getDeeds().isEmpty());
	}
	
	@Test
	public void testDeeds() {
		player1.addDeed(ConnecticutAvenue);
		assertTrue("Player's Deed list should contain property", player1.getDeeds().contains(ConnecticutAvenue));
		player1.removeDeed(ConnecticutAvenue);
		assertTrue("", player1.getDeeds().isEmpty());
	}
	
	@Test
	public void testTrade() {
		player1.addDeed(ConnecticutAvenue);
		player1.trade(player2, 500, new LinkedList<>(Arrays.asList(new Deed[] {ConnecticutAvenue})));
		assertTrue("Traded property was not removed from seller's Deed list", !player1.getDeeds().contains(ConnecticutAvenue));
		assertTrue("Traded property was not added to buyer's Deed list", player2.getDeeds().contains(ConnecticutAvenue));
		assertEquals("Traded money was not added to seller's money", 2000, player1.getMoney());
		assertEquals("Traded money was not deducted from buyer's money", 1000, player2.getMoney());
	}
}
