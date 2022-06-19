
/**
 * This program prints the message that the user inputted using Scanner class.
 *
 * @author Sreeya Gambhirrao
 * @version 11/12/2021
 */
import java.util.Scanner;
public class TextMessageV2
{
    public static void main(String[] args)
    {
        Scanner in;
        in = new Scanner(System.in);
        
        //Scanner Class
        System.out.println("Please enter a Text Message: ");
        String firstWord = in.next();
        String restOfLine = in.nextLine();
        String sentence = firstWord + restOfLine;
        System.out.println("Message: " + sentence);
        
        int stringLength = sentence.length();
        System.out.println("Number of characters of Message: " + stringLength);
        
        
        
    }
}