package monopoly.engine.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBoard {

	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = Monopoly.getInstance().getBoard();
	}

	@Test
	public void testConstructor() {
		assertEquals("Square 0 should be Go", "Go", board.getSquares()[0].getName());
		assertEquals("Square 1 should be Mediterranean Avenue", "Mediterranean Avenue", board.getDeed(1).getName());
		assertEquals("Square 2 should be Community Chest", "Community Chest", board.getSquares()[2].getName());
		assertEquals("Square 3 should be Baltic Avenue", "Baltic Avenue", board.getDeed(3).getName());
		assertEquals("Square 4 should be Income Tax", "Income Tax", board.getSquares()[4].getName());
		assertEquals("Square 5 should be Reading Railroad", "Reading Railroad", board.getDeed(5).getName());
		assertEquals("Square 6 should be Oriental Avenue", "Oriental Avenue", board.getDeed(6).getName());
		assertEquals("Square 7 should be Chance", "Chance", board.getSquares()[7].getName());
		assertEquals("Square 8 should be Vermont Avenue", "Vermont Avenue", board.getDeed(8).getName());
		assertEquals("Square 9 should be Connecticut Avenue", "Connecticut Avenue", board.getDeed(9).getName());
		assertEquals("Square 10 should be Just Visiting/Jail", "Just Visiting", board.getSquares()[10].getName());
		assertEquals("Square 11 should be St. Charles Place", "St. Charles Place", board.getDeed(11).getName());
		assertEquals("Square 12 should be Electric Company", "Electric Company", board.getDeed(12).getName());
		assertEquals("Square 13 should be States Avenue", "States Avenue", board.getDeed(13).getName());
		assertEquals("Square 14 should be Virginia Avenue", "Virginia Avenue", board.getDeed(14).getName());
		assertEquals("Square 15 should be Pennsylvania Railroad", "Pennsylvania Railroad", board.getDeed(15).getName());
		assertEquals("Square 16 should be St. James Place", "St. James Place", board.getDeed(16).getName());
		assertEquals("Square 17 should be Community Chest", "Community Chest", board.getSquares()[17].getName());
		assertEquals("Square 18 should be Tennessee Avenue", "Tennessee Avenue", board.getDeed(18).getName());
		assertEquals("Square 19 should be New York Avenue", "New York Avenue", board.getDeed(19).getName());
		assertEquals("Square 20 should be Free Parking", "Free Parking", board.getSquares()[20].getName());
		assertEquals("Square 21 should be Kentucky Avenue", "Kentucky Avenue", board.getDeed(21).getName());
		assertEquals("Square 22 should be Chance", "Chance", board.getSquares()[22].getName());
		assertEquals("Square 23 should be Indiana Avenue", "Indiana Avenue", board.getDeed(23).getName());
		assertEquals("Square 24 should be Illinois Avenue", "Illinois Avenue", board.getDeed(24).getName());
		assertEquals("Square 25 should be B. & O. Railroad", "B. & O. Railroad", board.getDeed(25).getName());
		assertEquals("Square 26 should be Atlantic Avenue", "Atlantic Avenue", board.getDeed(26).getName());
		assertEquals("Square 27 should be Ventnor Avenue", "Ventnor Avenue", board.getDeed(27).getName());
		assertEquals("Square 28 should be Water Works", "Water Works", board.getDeed(28).getName());
		assertEquals("Square 29 should be Marvin Gardens", "Marvin Gardens", board.getDeed(29).getName());
		assertEquals("Square 30 should be Go To Jail", "Go to Jail", board.getSquares()[30].getName());
		assertEquals("Square 31 should be Pacific Avenue", "Pacific Avenue", board.getDeed(31).getName());
		assertEquals("Square 32 should be North Carolina Avenue", "North Carolina Avenue", board.getDeed(32).getName());
		assertEquals("Square 33 should be Community Chest", "Community Chest", board.getSquares()[33].getName());
		assertEquals("Square 34 should be Pennsylvania Avenue", "Pennsylvania Avenue", board.getDeed(34).getName());
		assertEquals("Square 35 should be Short Line", "Short Line", board.getDeed(35).getName());
		assertEquals("Square 36 should be Chance", "Chance", board.getSquares()[36].getName());
		assertEquals("Square 37 should be Park Place", "Park Place", board.getDeed(37).getName());
		assertEquals("Square 38 should be Luxury Tax", "Luxury Tax", board.getSquares()[38].getName());
		assertEquals("Square 39 should be Boardwalk", "Boardwalk", board.getDeed(39).getName());
		
		assertEquals("purple's Deed list should contain Mediterranean Avenue", "Mediterranean Avenue", board.purple.getDeeds().get(0).getName());
		assertEquals("purple's Deed list should contain Baltic Avenue", "Baltic Avenue", board.purple.getDeeds().get(1).getName());
		assertEquals("lightblue's Deed list should contain Oriental Avenue", "Oriental Avenue", board.lightblue.getDeeds().get(0).getName());
		assertEquals("lightblue's Deed list should contain Vermont Avenue", "Vermont Avenue", board.lightblue.getDeeds().get(1).getName());
		assertEquals("lightblue's Deed list should contain Connecticut Avenue", "Connecticut Avenue", board.lightblue.getDeeds().get(2).getName());
		assertEquals("pink's Deed list should contain St. Charles Place", "St. Charles Place", board.pink.getDeeds().get(0).getName());
		assertEquals("pink's Deed list should contain States Avenue", "States Avenue", board.pink.getDeeds().get(1).getName());
		assertEquals("pink's Deed list should contain Virginia Avenue", "Virginia Avenue", board.pink.getDeeds().get(2).getName());
		assertEquals("orange's Deed list should contain St. James Place", "St. James Place", board.orange.getDeeds().get(0).getName());
		assertEquals("orange's Deed list should contain Tennesee Avenue", "Tennessee Avenue", board.orange.getDeeds().get(1).getName());
		assertEquals("orange's Deed list should contain New York Avenue", "New York Avenue", board.orange.getDeeds().get(2).getName());
		assertEquals("red's Deed list should contain Kentucky Avenue", "Kentucky Avenue", board.red.getDeeds().get(0).getName());
		assertEquals("red's Deed list should contain Indiana Avenue", "Indiana Avenue", board.red.getDeeds().get(1).getName());
		assertEquals("red's Deed list should contain Illinois Avenue", "Illinois Avenue", board.red.getDeeds().get(2).getName());
		assertEquals("yellow's Deed list should contain Atlantic Avenue", "Atlantic Avenue", board.yellow.getDeeds().get(0).getName());
		assertEquals("yellow's Deed list should contain Ventnor Avenue", "Ventnor Avenue", board.yellow.getDeeds().get(1).getName());
		assertEquals("yellow's Deed list should contain Marvin Gardens", "Marvin Gardens", board.yellow.getDeeds().get(2).getName());
		assertEquals("green's Deed list should contain Pacific Avenue", "Pacific Avenue", board.green.getDeeds().get(0).getName());
		assertEquals("green's Deed list should contain North Carolina Avenue", "North Carolina Avenue", board.green.getDeeds().get(1).getName());
		assertEquals("green's Deed list should contain Pennsylvania Avenue", "Pennsylvania Avenue", board.green.getDeeds().get(2).getName());
		assertEquals("blue's Deed list should contain Park Place", "Park Place", board.blue.getDeeds().get(0).getName());
		assertEquals("blue's Deed list should contain Boarkwalk", "Boardwalk", board.blue.getDeeds().get(1).getName());
		assertEquals("railroad's Deed list should contain Reading Railroad", "Reading Railroad", board.railroad.getDeeds().get(0).getName());
		assertEquals("railroad's Deed list should contain Pennsylvania Railroad", "Pennsylvania Railroad", board.railroad.getDeeds().get(1).getName());
		assertEquals("railroad's Deed list should contain B. & O. Railroad", "B. & O. Railroad", board.railroad.getDeeds().get(2).getName());
		assertEquals("railroad's Deed list should contain Short Line", "Short Line", board.railroad.getDeeds().get(3).getName());
		assertEquals("utility's Deed list should contain Electric Company", "Electric Company", board.utility.getDeeds().get(0).getName());
		assertEquals("utility's Deed list should contain Water Works", "Water Works", board.utility.getDeeds().get(1).getName());
	}	
}