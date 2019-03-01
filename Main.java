import java.util.*;

public class Main {
	// constants
	static final char[] suits = {'H', 'D', 'C', 'S'};
	static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

	
	// this  method takes in user inputs and returns them as an arrayList
	static List<String> getCardsFromInput() {  
		  Scanner sc = new Scanner(System.in);
		  List<String> inputCards = new ArrayList<String>();

		  // read all the cards from input
		  while (inputCards.size() < 5) {
		    String cardString = sc.nextLine();
		    System.out.println("input: " + cardString);

		    if (cardString.length() != 2) {
		      // "2H", "AS"
		      System.out.println("Invalid card: " + cardString);
		      continue;
		    }

		    String sRank = cardString.charAt(0) + "";
		    char cSuit = cardString.charAt(1);
		    int r = indexOf(ranks, sRank);
		    int s = indexOf(suits, cSuit);

		    if (r == -1 || s == -1) {
		      System.out.println("Invalid card: " + cardString);
		      continue;
		    }
		    inputCards.add(cardString);
		  }

		  return inputCards;
		}
	
// these Generic methods are searching if there is any element present in the array	
    public static <T> int indexOf(T[] haystack, T needle)      
    {
        for (int i=0; i<haystack.length; i++)
        {
            if (haystack[i].equals(needle)) return i;   // this returns that element if found
        }

        return -1;     // if the element is not found -1 is returned
    }	
    public static int indexOf(char[] haystack, char needle)     
    {
        for (int i=0; i<haystack.length; i++)     
        {
            if (haystack[i] == needle) return i;
        }

        return -1;
    }
    
    
    
 // this method generates a "deck" using the constant ranks and suits
    public static List<Card> generateDeck() {  
        List<Card> deck = new ArrayList<>();    // this is for suits and ranks  comparisons 
        for (int s = 0; s < suits.length; s++) {  // for the suit
            for (int r = 0; r < ranks.length; r++) {  // for the rank
                deck.add(new Card(s,r));      // this line creates  a new object of type Card!
            }
        }
        return deck;
    }
	

	public static List<Card> generateHand() {  
	    List<Card> deck = generateDeck();
	    return deck.subList(0,5);
	}

	public static class Card {      // This is a data type for  other collections
	    final int suit;
	    final int rank;

	    Card(int s, int r) {   // paramentarized constructor
	        suit = s;
	        rank = r;
	    }

	    public String rankString() {
	      return ranks[rank];
	    }

	    public String suitString() {
	      return suits[suit] + "";
	    }

	    @Override
	    public String toString() {
	        return suits[suit] + ranks[rank]; // or however you want the cards to be printed
	    }
	}



	static List<Card> buildHand(List<String> cardStrings) {
	  List<Card> hand = new ArrayList<Card>();
	  for (String cardString : cardStrings) {
	      String sRank = cardString.charAt(0) + "";
	      char cSuit = cardString.charAt(1);
	      int r = indexOf(ranks, sRank);
	      int s = indexOf(suits, cSuit);

	      if (r == -1 || s == -1) {
	        System.out.println("Invalid card: " + cardString);
	        continue;
	      }

	      Card card = new Card(s, r);
	      hand.add(card);
	    }
	    Collections.sort(hand, Comparator.comparing(c -> c.rank));   // this statement 
	    return hand;
	}
	static String value(List<Card> hand) {  // this method   
	    boolean straight = true;
	    boolean flush = true;
	    for (int i = 1; i < hand.size(); i++) {  
	        straight &= hand.get(i - 1).rank + 1 == hand.get(i).rank;
	        flush &= hand.get(i - 1).suit == hand.get(i).suit;
	    }

	    // straight flush
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

	/** Represents {@code length} cards of rank {@code rank} */
	static class Run {   
	    int length;
	    int rank;
	    
	    Run(){}
	    
	    Run(int rank) {
	    	this.rank = rank;
	    }
	    
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
	
	public static void main(String[] args) {
	    System.out.println("Please enter your cards (one by one) in Uppercase - Each ending with the suit e.g 2D: ");
	    List<String> inputCards = getCardsFromInput();
	    List<Card> hand = buildHand(inputCards);
	    System.out.println("Your hand is: " + hand);
	    System.out.println("The best poker Hand constructed is: " + value(hand));

	} 
	
	

}
