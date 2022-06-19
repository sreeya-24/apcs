
/**
 * This program converts a english statement to morse code format.
 *
 * @author Sreeya Gambhirrao
 * @version 04/09/2022
 */
import java.io.IOException;
import java.util.Scanner;
public class MorseCodeTester
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please Enter Your Sentence in English Here(No Punctuation): ");
        String userInput = in.nextLine();
        
        MorseCode morseCode = new MorseCode(userInput);
        morseCode.convStatement();
        
    }
}