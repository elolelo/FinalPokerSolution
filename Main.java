import java.util.*;
public class Main { 


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
 

