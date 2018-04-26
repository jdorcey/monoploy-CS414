package monopoly.engine.square;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import monopoly.engine.square.Cards.Card;

public class TestCards {

	@Test
	public void testChance() {
		try {
			Cards chance = new Cards(Cards.Type.CHANCE);
			ArrayList<Card> cards = chance.getCards();
			assertTrue(cards.size() > 0);
		} catch (FileNotFoundException e) {
			fail("error reading in chance cards");
			//e.printStackTrace();
		}
	}
	public void testCommChest() {
		try {
			Cards commchest = new Cards(Cards.Type.COMM_CHEST);
			ArrayList<Card> cards = commchest.getCards();
			assertTrue(cards.size() > 0);
		} catch (FileNotFoundException e) {
			fail("error reading in Community Chest cards");
			//e.printStackTrace();
		}
	}
}
