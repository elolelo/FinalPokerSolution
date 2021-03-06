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
		assertEquals(1, Main.indexOf(array, "b"));
	}

	@Test
	public void testIndexOfCharArrayChar() {
		String chars = "abcd";
		assertEquals(1, Main.indexOf(chars.toCharArray(), 'b'));
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
		//manually tested using the user input
	}

	@Test
	public void testBuildHand() {
		List<String> strings = new ArrayList();
		strings.add("2D");
		strings.add("3D");
		strings.add("4D");
		strings.add("5D");
		strings.add("6D");
		
		

		List<String> expectedStrings = new ArrayList();
		expectedStrings.add("D2");
		expectedStrings.add("D3");
		expectedStrings.add("D4");
		expectedStrings.add("D5");
		expectedStrings.add("D6");
		
		List<Main.Card> hand = Main.buildHand(strings);
		
		assertEquals(expectedStrings.get(0), hand.get(0).toString());
		assertEquals(expectedStrings.get(1), hand.get(1).toString());
		assertEquals(expectedStrings.get(2), hand.get(2).toString());
		assertEquals(expectedStrings.get(3), hand.get(3).toString());
		assertEquals(expectedStrings.get(4), hand.get(4).toString());
	}
	
	@Test
	public void testValue() {
		List<Main.Card> deck = Main.generateHand();
		assertEquals("Straight Flush from H6", Main.value(deck));
		//TO-DO later - test all other hands
	}

	@Test
	public void testFindRuns() {
		List<Main.Card> hand = Main.generateHand();
		List<Main.Run> runs = new ArrayList<>();
		runs.add(new Main.Run(2));
		runs.add(new Main.Run(3));
		runs.add(new Main.Run(4));
		runs.add(new Main.Run(5));
		runs.add(new Main.Run(6));
		
		List<Main.Run> rRuns = Main.findRuns(hand);
		System.out.println(rRuns);
		System.out.println(runs);
		assertEquals(runs.get(0).toString(), rRuns.get(0).toString());
		//To Do later - Should test all cases (hands): Full House, Flush, etc
	}

}
