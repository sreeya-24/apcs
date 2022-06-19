
/**
 * This program asks the user to guess a random number the computer generated. 
 * If the random number matches they won. 
 * If it didn't they are asked to guess again.
 *
 * @author Sreeya Gambhirrao
 * @version 12/25/2021
 */
import java.util.Scanner;
public class GuessingGameV1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Guess the number: ");
        int number = in.nextInt();
        int counter = 1;
        
        int randNum = (int)(Math.random() * 100);
        
        while(number != randNum)
        {
            if(number < randNum)
            {
                System.out.println("Too Low");
            } else {
                System.out.println("Too High");
            }
            System.out.println("Guess the number: ");
            number = in.nextInt();
            counter++;
        }
        System.out.println("Congratulations");
        System.out.println("The number is: " + randNum);
        System.out.println("Number of Guesses: " + counter);
    }
}
