
/**
 * This program encrypts a user inputted sentence and writes it to a file and decrypts the message by reading 
 * from that file.
 *
 * @author Sreeya Gambhirrao
 * @version 4/15/2022
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
public class SreeyaGamCipherTester
{
    public static void main(String[] args) throws IOException
    {
        String wantContinue = "yes";
        
        int shiftKey = 0;
        boolean yesNoEntered = false;
        while(!yesNoEntered)
        {
            Scanner in = new Scanner(System.in);

            System.out.println("Please choose one of the options below: ");
            System.out.println("[E] Encrypt");
            System.out.println("[D] Decrypt");
            System.out.println("[Q] Quit");
            //in.nextLine();
            String choice = in.next();
            //System.out.println();
            
            if(choice.equalsIgnoreCase("E"))
            {   
                shiftKey =(int)(Math.random() * 10) ;
                System.out.println("Shift key: " + shiftKey);
            
                System.out.println("Please enter your message(all capitals): ");
                String message = "";
                in.nextLine();
                message = in.nextLine();
                System.out.println("You Entered "+message);
                //in.close();
                
                SreeyaGamCipher encrypted = new SreeyaGamCipher(message, shiftKey);
                
                String encryptedMessage = encrypted.encrypt();
                System.out.println("Your encrypted Message: " + encryptedMessage);
                PrintWriter outFile = new PrintWriter (new File("encrypted.txt"));

                outFile.println(encryptedMessage);
                outFile.close();
    
            } else if(choice.equalsIgnoreCase("D"))
            {
                Scanner inFile = new Scanner(new File("encrypted.txt"));
                String message = inFile.nextLine();
                inFile.close();
                
                SreeyaGamDecipher decrypted = new SreeyaGamDecipher(message, shiftKey);
                
                String decryptedMessage = decrypted.decrypt();
                System.out.println("Your decrypted Message: " + decryptedMessage);
  
            } else if(choice.equalsIgnoreCase("Q"))
            {
                 System.out.println("You chose Q for quit");
                 System.out.println("You have quitted.");
                 wantContinue = new String("no");
            } else
            {
                System.out.println("You did not choose a valid menu option!");
            }
            //in.close();
            //yesNoEntered = true;
            System.out.println("Do you want to continue?");
            
            System.out.println("[Y] Yes");
            System.out.println("[N] No");
            
            //in = new Scanner(System.in);
            String choice2 = in.next();
            
            if(choice2.equalsIgnoreCase("N"))
            {
                yesNoEntered = true;
            }
        }
        
        
    }
}
