package monopoly.engine.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;
import monopoly.engine.player.*;
import monopoly.engine.square.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestBanker.class, 
					TestBoard.class,
					TestMonopoly.class,
					TestTurn.class,
					TestAssets.class,
					TestPlayer.class,
					TestColor.class,
					TestDeed.class,
					TestNonDeed.class
					})
public class TestSuite {
	public static junit.framework.Test suite() { return new JUnit4TestAdapter(TestSuite.class); }
	@Test
	public static final void main(String[] args) { junit.textui.TestRunner.run(suite()); }
}

