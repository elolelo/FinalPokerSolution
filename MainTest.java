import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MainTest {

	static final char[] suits = {'H', 'D', 'C', 'S'};
	static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testIndexOfTArrayT() {
		String[] array = new String[] {"a", "b", "c", "d"};
		assertEquals(6, Main.indexOf(array, "b"));
	}

	@Test
	public void testIndexOfCharArrayChar() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGenerateDeck() {
		//fail("Not yet implemented"); // TODO
		List<Main.Card> deck = Main.generateDeck();
		assertEquals(52,deck.size());
	}

	@Test
	public void testGenerateHand() {
		List<Main.Card> deck = Main.generateHand();
		assertEquals(5,deck.size());
		
	}

	@Test
	public void testGetCardsFromInput() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public void testBuildHand() {
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testValue() {
		//fail("Not yet implemented"); // TODO
		//Should test all cases: Full House, Flush, etc
	}

	@Test
	public void testFindRuns() {
		//fail("Not yet implemented"); // TODO
		//Should test all cases: Full House, Flush, etc
	}

}
