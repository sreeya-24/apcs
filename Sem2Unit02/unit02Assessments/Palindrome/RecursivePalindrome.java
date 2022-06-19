
/**
 * This program takes the user input of a word or phrase, reverses it, and checks to see 
 * if it is a palindrome.
 *
 * @author Sreeya Gambhirrao
 * @version 2/21/2022
 */
public class RecursivePalindrome
{
    /**
     * Constructor for objects of class RecursivePalindrome
     */
    public RecursivePalindrome()
    {
    }

    /**
     * A method to reverse the string
     *
     * @param  String s
     * @return the reversed string
     */
    public static String reverseString(String s)
    {
        if(s.length() == 0)
        {
           return ""; 
        } else 
        {
            String firstLetter = s.substring(0,1);
            String reverseOfRest = reverseString(s.substring(1,s.length()));
            
            String fullStringReverse = reverseOfRest + firstLetter;
            
            return fullStringReverse;
        }
    }
    
    /**
     * A method to check if reversed string is a palindrome
     *
     * @param  String s
     * @return whether string is palindrome(true or false)
     */
    public static boolean isPolyndrome(String s) {
        String reversed = reverseString(s);
        if (reversed.equalsIgnoreCase(s)) {
            return true;
        } else {
            return false;
        }
    }
}
