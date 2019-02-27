import java.util.*;
public class Main { 

	// constants suits and ranks
	static final char[] suits = {'H', 'D', 'C', 'S'};  
    	static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"}; 
    	
    	
    	//this indexOf method is useful for ranks
    	public static <T> int indexOf(T[] haystack, T needle)
    	{
        for (int i=0; i<haystack.length; i++)
        {
            if (haystack[i].equals(needle)) return i;   // this returns that element if found
        }
        return -1;     // if the element is not found -1 is returned
    	}

	
	//this indexOf method is useful for suits	
    	public static int indexOf(char[] haystack, char needle)     // same method but different arguments
    		{
        for (int i=0; i<haystack.length; i++)     
        {
            if (haystack[i] == needle) return i;
        }

        return -1;
    	}
  

	// this method is for getting and validating user input
	public static List<String> getCardsFromInput() {  
      	
      	Scanner sc = new Scanner(System.in);
      		
      	List<String> inputCards = new ArrayList<String>();  
	while (inputCards.size() < 5) {
        String cardString = sc.nextLine();
        System.out.println("input: " + cardString);

        if (cardString.length() != 2) {
          // "2H", "AS"
          System.out.println("Invalid card: " + cardString);
          continue;
        		}
	
		}
	return inputCards;
	}
	
	static class Card {     // nested class is representing the  "card"
        final int suit;
        final int rank;

        Card(int s, int r) {    // card constructor 
            suit = s;
            rank = r;
        }

        public String rankString() {  // this method returns  as string the value of ranks element at position rank
          return ranks[rank];
        }

        public String suitString() {   // this method returns as string the value of suits element  at position suit
          return suits[suit] + "";
        }

        @Override
        public String toString() {
            return  ranks[rank] + suits[suit]; 
        }
    }
	
	
	static List<Card> buildHand(List<String> cardStrings) {  // this method builds a string "card" from user inputs
      		List<Card> hand = new ArrayList<Card>();    // this arraylist is for the comparison
      		for (String cardString : cardStrings) {
			String sRank = cardString.charAt(0) + "";
			char cSuit = cardString.charAt(1);
			int r = indexOf(ranks, sRank);
			int s = indexOf(suits, cSuit);

		  if (r == -1 || s == -1) {
		    System.out.println("Invalid card: " + cardString);  // checks for the validity of the input
		    continue;
          }

		  Card card = new Card(s, r); // card object storing valid user inputs
		  hand.add(card);
        }
        Collections.sort(hand, Comparator.comparing(c -> c.rank));   // best Java 8 feature!
        return hand;
    	}
	
	static String value(List<Card> hand) {  // this method evaluates the "hand" 5 - the cards
        boolean straight = true;
        boolean flush = true;
        
        for (int i = 1; i < hand.size(); i++) {   
            straight &= hand.get(i - 1).rank + 1 == hand.get(i).rank;  
            flush &= hand.get(i - 1).suit == hand.get(i).suit;  
        }
        // straight flush and a royal flush
        if (straight && flush) {
            Card highestCard = hand.get(4);
            if (highestCard.rankString() == "A") {
              return "Royal flush in " + highestCard.suitString();
            }
            return "Straight Flush from " + highestCard;
        }

        List<Run> runs = findRuns(hand);  
        
        runs.sort(Comparator.comparing(r -> -r.rank));
        runs.sort(Comparator.comparing(r -> -r.length));


        // four of a kind
        if (runs.get(0).length == 4) {
            return "Four of a Kind: " + runs;
        }

        if (runs.get(0).length == 3 && runs.get(1).length == 2) {
            return "Full House: " + runs;
        }

        if (flush) {
            return "Flush!";
        }

        if (straight) {
            return "Straight from " + hand.get(4);
        }

        if (runs.get(0).length == 3) {
            return "Three of a Kind: " + runs;
        }

        if (runs.get(1).length == 2) {
            return "Two pair: " + runs;
        }

        if (runs.get(0).length == 2) {
            return "Pair: " + runs;
        }

        return "High card: " + runs;
    	}
        
       
	static class Run {    // a nested class with method returning a value of rank from ranks array
        int length;
        int rank;

        @Override
        public String toString() {
            return ranks[rank];
        	}
    	}
    	
    	static List<Run> findRuns(List<Card> hand) {       
        List<Run> runs = new ArrayList<>();  
        Run run = null;
        for (Card c : hand) {    
            if (run != null && run.rank == c.rank) {
                run.length++;
            } else {
                run = new Run();
                runs.add(run);
                run.rank = c.rank;
                run.length = 1;
            }
        }
        System.out.println("all runs: " + runs);
        return runs;
    	}
    	
    	
    	static void runTest(String cardString) {
	      	List<String> inputCards = Arrays.asList(cardString.split(" "));
	      	List<Card> hand = buildHand(inputCards);
	      	System.out.println("Test: value(\"" + hand + "\") = " + value(hand));
    	}

    	static void runTests() {  // ran these tests manually by inputting, one by the values in brackets
	      	System.out.println("Running tests:");
	      	runTest("AH KH QH JH TH"); 
	      	runTest("2H JS JS QH KS");
	      	runTest("2H KH 4H JH TH");
	      	runTest("AS TC TH 3D 3S");
	      	System.out.println("DONE!");
    	}
	
	public static void main(String[] args) {
		System.out.println("Please enter your cards (one by one): ");
		List<String> inputCards = getCardsFromInput();
		runTests();
	}
}
 

