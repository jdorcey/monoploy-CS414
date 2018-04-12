package monopoly.engine.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestBanker.class, 
					TestBoard.class,
					TestMonopoly.class,
					TestTurn.class})
public class TestSuite {
	public static junit.framework.Test suite() { return new JUnit4TestAdapter(TestSuite.class); }
	public static final void main(String[] args) { junit.textui.TestRunner.run(suite()); }
}

