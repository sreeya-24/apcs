
/**
 * This program takes the user input of a word or phrase, reverses it, and checks to see 
 * if it is a palindrome.
 * 
 * @author Sreeya Gambhirrao
 * @version 2/21/2022
 */

import java.util.Scanner;
public class RecursivePalindromeTester
{
    public static void main(String[] args)
{
    //Scanner object
    Scanner in;
    in = new Scanner(System.in);
    
    //variables for choice and user inputed word or phrase
    String choice = "C";
    String inputWord;
    
    //while loop to check whether user wants to continue or quit
    while(choice.equalsIgnoreCase("C"))
    {
        //Ask the user to input word or phrase
        System.out.print("Please enter a word or a phrase: ");
        inputWord = in.next();  
          
        //New object of type RecursivePalindrome
        RecursivePalindrome palindrome = new RecursivePalindrome();
        
        //Calling function
        boolean isPolyndrome = palindrome.isPolyndrome(inputWord);
        
        //If loop to determine whether word or phrase is a palindrome
        if (isPolyndrome == true) {
            System.out.println("Yes it is a Palindrome");
        } else {
            System.out.println("No it is not a Palindrome");
        }
        
        //Ask user if they want to continue or quit
        System.out.println();
        System.out.println("[C] Do you want continue?");
        System.out.println("[Q] Quit");    
        choice = in.next();
        
    }
        
    System.out.println("You have quitted. Please come again soon!");
        
        
        
}
}
