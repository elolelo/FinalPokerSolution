import java.util.*;
public class Main { 

	// constants
	static final char[] suits = {'H', 'D', 'C', 'S'};  
    	static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"}; 


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
	
}
 

