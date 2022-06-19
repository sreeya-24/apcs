
/**
 * This program takes user input of a sentence and either encrypts or decrypts the message.
 *
 * @author Sreeya Gambhirrao
 * @version 04/10/2022
 */
import java.util.Scanner;
public class CaesarShiftTester
{
    public static void main(String[] args)
    {
        String wantContinue = "yes";
        
        while(wantContinue.equals("yes"))
        {
            Scanner in = new Scanner(System.in);
            
            System.out.println("Please enter a number (0-25) which will be used to shift: ");
            int shiftKey = in.nextInt();
            
            System.out.println("Please choose one of the options below: ");
            System.out.println("[E] Encrypt");
            System.out.println("[D] Decrypt");
            System.out.println("[Q] Quit");
            
            String choice = in.next();
            System.out.println();
            
            System.out.println("Please enter your message(all capitals): ");
            String message = in.next();
            
            
            if(choice.equalsIgnoreCase("E"))
            {
                CaesarShiftEncryption encrypted = new CaesarShiftEncryption(message, shiftKey);
                
                String encryptedMessage = encrypted.encrypt();
                System.out.println("Your encrypted Message: " + encryptedMessage);
            } else if(choice.equalsIgnoreCase("D"))
            {
                CaesarShiftDecryption decrypted = new CaesarShiftDecryption(message, shiftKey);
                
                String decryptedMessage = decrypted.decrypt();
                System.out.println("Your decrypted Message: " + decryptedMessage);
            } else if(choice.equalsIgnoreCase("Q"))
            {
                 System.out.println("You chose Q for quit");
                 System.out.println("You have quitted.");
                 wantContinue = "no";
            } else
            {
                System.out.println("You did not choose a valid menu option!");
            }
            
            System.out.println("Do you want to continue?");
            
            System.out.println("[Y] Yes");
            System.out.println("[N] No");
            
            String choice2 = in.next();
            
            if(choice2.equalsIgnoreCase("N"))
            {
                wantContinue = "no";
            }
        }
        
        
    }
}
