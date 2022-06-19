
/**
 * This program generates a random password based on the user input of a menu option and the number of characters in the password.
 *
 * @author Sreeya Gambhirrao
 * @version 12/31/2021
 */
import java.util.Random;
import java.util.Scanner;
public class Password
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String password = "";
        int randNum = 0;
        Random randNumList = new Random();
        char charOfPass = ' ';
        System.out.println();
        System.out.println("                    Password Generator Menu");
        System.out.println("*************************************************************");
        System.out.println("*   Select a number that corresponds to a menu option       *");
        System.out.println("*   [1] Lowercase only                                      *");
        System.out.println("*   [2] Uppercase only                                      *");
        System.out.println("*   [3] Lowercase and Uppercase                             *");
        System.out.println("*   [4] Lowercase, Uppercase, Numbers, and Punctuation      *");
        System.out.println("*   [5] Quit                                                *");
        System.out.println("*************************************************************");
        System.out.println("Enter Choice: ");
        String choice = in.next();
        
        if(choice.equals("5"))
        {
            System.out.println("You chose Q for quit");
            System.out.println("You have quitted.");
            System.exit(0);
        }
        
        System.out.println("Please enter number of characters of password (max. 14): ");
        int numOfChar = in.nextInt();
        
        for(int counter = 1; counter<=numOfChar; counter++)
        {
            if(choice.equals("1"))
            {
                randNum = randNumList.nextInt(25) + 97;
                charOfPass = (char)(randNum);
            } else if(choice.equals("2"))
            {
                randNum = randNumList.nextInt(25) + 65;
                charOfPass = (char)(randNum);
            } else if(choice.equals("3")) {
                randNum = randNumList.nextInt(64) + 65;
                while (!((randNum >= 65 && randNum <= 90) || (randNum >= 97 && randNum <= 122))) {
                    randNum = randNumList.nextInt(64) + 65;
                }
                charOfPass = (char)(randNum);
            } else if(choice.equals("4")) {
                randNum = randNumList.nextInt(74) + 48;
                charOfPass = (char)(randNum);
            } 
            password += charOfPass;
        }   
        System.out.println("Password: " + password);
    }
}
