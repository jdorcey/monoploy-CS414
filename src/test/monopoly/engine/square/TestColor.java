package monopoly.engine.square;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import monopoly.engine.game.Monopoly;
import monopoly.engine.player.Player;

public class TestColor {

	private static Monopoly game = Monopoly.getInstance();
	private static Player player1 = new Player(Player.TokenName.DOG);
	private static Player player2 = new Player(Player.TokenName.CAR);
	private static Deed ElectricCompany = game.getBoard().utility.getDeeds().get(0);
	private static Deed WaterWorks = game.getBoard().utility.getDeeds().get(1);
	
	@Before
	public void setUp() throws Exception {
		game.setPlayers(new ArrayList<>(Arrays.asList(new Player[] {player1, player2})));
	}

	/*@Test
	public void testAddDeeds() {
		
	}*/

	@Test
	public void testIsMonopoly() {
		player1.addDeed(ElectricCompany);
		player1.addDeed(WaterWorks);
		assertEquals(player1, WaterWorks.getOwner());
		assertEquals(player1, ElectricCompany.getOwner());
		assertTrue(game.getBoard().utility.isMonopoly());
		player1.removeDeed(ElectricCompany);
		assertEquals(null, ElectricCompany.getOwner());
		assertFalse(game.getBoard().utility.isMonopoly());
		player2.addDeed(ElectricCompany);
		assertEquals(player2, ElectricCompany.getOwner());
		assertFalse(game.getBoard().utility.isMonopoly());
	}
	  
	/*@Test
	public void testNumRailroadsOrUtilties() {

	}*/
}
