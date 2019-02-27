import java.util.*;
public class Main { 

	// constants
	static final char[] suits = {'H', 'D', 'C', 'S'};  
    	static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"}; 
    	
    	
    	//this indexOf method is going to be useful for the checkings:
    	
    	public static <T> int indexOf(T[] haystack, T needle)
    {
        for (int i=0; i<haystack.length; i++)
        {
            if (haystack[i].equals(needle)) return i;   // this returns that element if found
        }

        return -1;     // if the element is not found -1 is returned
    }

	
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
	
	
}
 

