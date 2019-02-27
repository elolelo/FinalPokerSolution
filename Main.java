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
	
	static class Card {     // this class is represents a card
        final int suit;
        final int rank;

        Card(int s, int r) {   
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

		  Card card = new Card(s, r);
		  hand.add(card);
        }
        Collections.sort(hand, Comparator.comparing(c -> c.rank));   // best Java 8 feature!
        return hand;
    }
	
	static String value(List<Card> hand) {  // this method evaluates the "hand" 5 - the cards
        boolean straight = true;
        boolean flush = true;
        
        for (int i = 1; i < hand.size(); i++) {   
            straight &= hand.get(i - 1).rank + 1 == hand.get(i).rank;  //  looping to for checking rank
        }  
        for (int i = 1:i < hand.size();i++){  
            flush &= hand.get(i - 1).suit == hand.get(i).suit;  // looping for checking suit
        }
	
}
	
	
	
	public static void main(String[] args) {
		System.out.println("Please enter your cards (one by one): ");
		List<String> inputCards = getCardsFromInput();
		//runTests();
	}
}
 

