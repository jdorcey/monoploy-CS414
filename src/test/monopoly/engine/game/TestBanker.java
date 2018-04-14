//package monopoly.engine.game;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import monopoly.engine.player.Player;
//
//class TestBanker {
//
//	private Monopoly game;
//	
//	@Before
//	void setUp() throws Exception {
//		game = Monopoly.getInstance();
//	}
//	
//	@Test
//	void testInitializePlayers() {
//		Banker.initializePlayers(game.getPlayers());
//		for(Player player : game.getPlayers()) {
//			assertEquals("ERROR in Banker: not all players have correct starting cash", 1500, player.getMoney());
//		}
//	}
//
//	@Test
//	void testSellProperty() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void testAuctionProperty() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGo() {
//		Player player = game.getCurrentPlayer();
//		int currentBalance = player.getMoney();
//		Banker.go(player);
//		assertEquals("ERROR in Banker: passing GO did not give player $200", currentBalance+200, player.getMoney());
//	}
//	
//	@Test
//	void testIncomeTax() {
//		Player player = game.getCurrentPlayer();
//		int expectedBalance = -1;
//		if (player.getMoney()/10 < 200) { expectedBalance = player.getMoney() - player.getMoney()/10; }
//		else { expectedBalance = player.getMoney() - 200;}
//		Banker.incomeTax(player);
//		assertEquals("ERROR in Banker: income Tax was not deducted correctly", expectedBalance, player.getMoney());
//	}
//	
//	@Test
//	void testluxuryTax() {
//		Player player = game.getCurrentPlayer();
//		int currentBalance = player.getMoney();
//		Banker.luxuryTax(player);
//		assertEquals("ERROR in Banker: passing GO did not give player $200", currentBalance-100, player.getMoney());
//	}
//}
