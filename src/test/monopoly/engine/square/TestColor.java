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
	private static Player player = new Player(Player.TokenName.DOG);
	private Deed ElectricCompany = new Deed(Deed.DeedName.ELECTRIC_COMPANY, 150, new int[] {4, 10}, game.getBoard().utility);
	private Deed WaterWorks = new Deed(Deed.DeedName.WATER_WORKS, 150, new int[] {4, 10}, game.getBoard().utility);
	
	@Before
	public void setUp() throws Exception {
		game.setPlayers(new ArrayList<>(Arrays.asList(new Player[] {player})));
		player.addDeed(ElectricCompany);
		player.addDeed(WaterWorks);
	}

	@Test
	public void testAddDeeds() {
		
	}

	@Test
	public void testIsMonopoly() {
		
	}
	  
	@Test
	public void testNumRailroadsOrUtilties() {

	}
}
