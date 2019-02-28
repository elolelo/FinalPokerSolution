import java.util.*;
public class Main { 
// constants
    static final char[] suits = {'H', 'D', 'C', 'S'};  
    static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"}; 



// this  method takes in user inputs and returns them as an arrayList
    static List<String> getCardsFromInput() {     
      Scanner sc = new Scanner(System.in);  
      
      List<String> inputCards = new ArrayList<String>();   // this array list is going to store the inputted elements

// read all the cards from input
        while (inputCards.size() < 5) {
        String cardString = sc.nextLine();
        System.out.println("Enter another card: ");

        if (cardString.length() != 2) {
          // "2H", "AS"
          System.out.println("Invalid card: " + cardString);
          continue;
        }
      
        String sRank = cardString.charAt(0) + "";  // this will read the number first as rank
        char cSuit = cardString.charAt(1);  // this will read the suit after the rank
        int r = indexOf(ranks, sRank);
        int s = indexOf(suits, cSuit);

        if (r == -1 || s == -1) {
          System.out.println("Invalid card: " + cardString);
          continue;
        }
        inputCards.add(cardString);  // if card is valid
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
    
    
    
    


// this method return a portion of an arrayList from index 0 to 4 
    public static List<Card> generateHand() {    
        List<Card> deck = generateDeck();
        return deck.subList(0,5);
    }


// this nested - class represents a card
    static class Card {     
        final int suit;
        final int rank;

        Card(int s, int r) {     // constructor initializing the parameters
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


// this method builds a card from the inputted string
    static List<Card> buildHand(List<String> cardStrings) {  
      List<Card> hand = new ArrayList<Card>();    // this arraylist is for the comparison
      for (String cardString : cardStrings) {
          String sRank = cardString.charAt(0) + " ";
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
        Collections.sort(hand, Comparator.comparing(c -> c.rank));   // the  greatest feature of Java 8!
        return hand;
    }

//  this  method defines how to run tests
    static void runTest(String cardString) {         
      List<String> inputCards = Arrays.asList(cardString.split(" "));  // this gets the list view of an array
      List<Card> hand = buildHand(inputCards);
      System.out.println("Test: value(\"" + hand + "\") = " + value(hand));
    }

    static void runTests() {    // this method runs tests inside it
      System.out.println("Running tests:");
      runTest("AH KH QH JH TH");
      runTest("2H JS JS QH KS");
      runTest("2H KH 4H JH TH");
      runTest("AS TC TH 3D 3S");
      runTest("AH KH QH JH TH");
      runTest("2H JS JS QH KS");
      runTest("2H KH 4H JH TH");
      runTest("AS TC TH 3D 3S");
      runTest("AH KH QH JH TH");
      runTest("2H JS JS QH KS");
      runTest("2H KH 4H JH TH");
      runTest("AS TC TH 3D 3S");
      runTest("AH KH QH JH TH");
      runTest("2H JS JS QH KS");
      runTest("2H KH 4H JH TH");
      runTest("AS TC TH 3D 3S");
      runTest("AH KH QH JH TH");
      runTest("2H JS JS QH KS");
      runTest("2H KH 4H JH TH");
      runTest("AS TC TH 3D 3S");
      runTest("AH KH QH JH TH");
      runTest("2H JS JS QH KS");
      runTest("2H KH 4H JH TH");
      runTest("AS TC TH 3D 3S");
      System.out.println("DONE!");
    }

	// this method evaluates the "hand" 5 - the cards  - this is called the value method
    static String value(List<Card> hand) {  
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
              return "Royal flush!" ; // in " + highestCard.suitString();
            }
            return "Straight Flush!"; // from  + highestCard;
        }

        List<Run> runs = findRuns(hand);
        
        runs.sort(Comparator.comparing(r -> -r.rank));
        runs.sort(Comparator.comparing(r -> -r.length));


        // four of a kind
        if (runs.get(0).length == 4) {
            return "Four of a Kind! = " ;
        }

        if (runs.get(0).length == 3 && runs.get(1).length == 2) {
            return "Full House! = " ;
        }

        if (flush) {
            return "Flush!";
        }

        if (straight) {
            return "Straight !" ;
        }

        if (runs.get(0).length == 3) {
            return "Three of a Kind! = ";
        }

        if (runs.get(1).length == 2) {
            return "Two pair! = ";
        }

        if (runs.get(0).length == 2) {
            return "Pair! = ";
        }

        return "High card!  ";
    }

    /** Nested class represents {@code length} cards of rank {@code rank} */
    static class Run {        
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
        System.out.println("all runs = " + runs);
        return runs;
    }
    
    public static void main(String[] args) { 
        System.out.println("Please enter your cards (one by one) in Uppercase - Each ending with the suit e.g 2D: ");
        List<String> inputCards = getCardsFromInput();
        
        List<Card> hand = buildHand(inputCards);   
        System.out.println("Your hand is: " + hand);
        System.out.println("The best poker Hand constructed is: " + value(hand));  

        //runTests();

    }
}
