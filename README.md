# FinalPokerSolution

This is the dev skill test from Inclusitity Solution

About this solution: This program will accept text input (of playing  Poker game cards ) then evaluates what the best poker hand could be constructed with the cards.

 
Assumptions made:

0. User will input the card one at the time

1. The entered user input always starts with a rank then a suit e.g : 2H = 2 of hearts

2. The card 10 is assumed to be T - so for 10S (10 of spades)  = TS

3. This program is case -sensitive. Enter Upper cases only

4.Not accounting for ace-to-five low rules


Steps:

1. Get the necessary  Java library  imports
2. Get  input from user  
3. Account for the validity of the  text input   
    3.1 Use of conditional statements for checking the validity
4. Define suits and values as arrays and populate with the constant poker values equivalents

    4.1 Ensure looping though each suits and each value in  an array to determine comparisons for ranks
    
5. Store the text input as a compatible type for comparisons with the constant rank and files

  5.1 Find a way to split this string such that values for the suit and values become accessible

6. Create a method for looping through the arrays  start searching 

  6.1 Test the methods to see if they meet current expectations

7. Create ranking categories 

    7.1 Make each category accessible and avaible for evaluating the comparisons
    
    7.2 Test this
    
8. Use method/s to search and compare the the array from user to the value and suits arrays

    8.1 Loop through each element from each list/array to find best/ closest match 
    
          ! Using the Java 8 comparator.comparing() 
          
      8.2. Closed match should meet the specific rank definition
      
          8.3. If it is met, then return that rank's value
     

