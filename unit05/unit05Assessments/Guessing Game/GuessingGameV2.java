/**
 * This program asks the user to guess a random number the computer generated between their chosen range. 
 * If the random number matches they won. 
 * If it didn't they are asked to guess again.
 *
 * @author Sreeya Gambhirrao
 * @version 12/25/2021
 */
import java.util.Scanner;
public class GuessingGameV2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the low ");
        int low_number = in.nextInt();
        System.out.println("Enter the high ");
        int high_number = in.nextInt();
        System.out.println("Guess the number in between " + low_number + " to " + high_number+ ": ");
        int number = in.nextInt();
        int counter = 1;
        
        int range = high_number - low_number;
        int randNum = (int)(Math.random() * range) + low_number;
        
        while(number != randNum)
        {
            if(number < randNum)
            {
                System.out.println("Too Low");
            } else {
                System.out.println("Too High");
            }
            System.out.println("Guess the number between "+ low_number + " to " + high_number+ ": ");
            number = in.nextInt();
            counter++;
        }
        System.out.println("Congratulations");
        System.out.println("The number is: " + randNum);
        System.out.println("Number of Guesses: " + counter);
    }
}
