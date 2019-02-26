# FinalPokerSolution
This is the dev skill test from Inclusitity Solution

About this solution: This program will accept text input (of playing  Poker game cards ) then evaluates what the best poker hand could be constructed with the cards.



Steps:

1. Get the necessary  Java library  imports
2. Get  input from user  
3. Account for the validity of the  text input   
    3.1 Use of try/catch statement or the exception class or assert statements
4. Define suits and values [arrays/enums/arraylist] and populate with the constant poker values equivalents
    4.1 Ensure looping though each suits/value [arraylist/enum] to determine comparisons for ranks 
5. Store the text input as a compatible type for comparison with the 
  5.1 Find a way to split this string such that values for the suit and values become accessible

6.Loop through the arrays using a and start searching - create method/s for this
  6.1 Test the methods to see if they meet current expectations

7. Create ranking categories 
    7.1 Make each category accessible and avaible for evaluating the comparisons
       7.2 Test this
8. Use method/s to search and compare the the array from user to the value and suits arrays
    8.1 Loop through each element from each list/array to find best/ closest match 
          ! Using the Java 8 comparator.comparing() 
      8.2. Closed match should meet the specific rank definition
          8.3. If it is met, then return that rank's value
     
 
Assumptions made:

1. Not accounting for ace-to-five low rules

