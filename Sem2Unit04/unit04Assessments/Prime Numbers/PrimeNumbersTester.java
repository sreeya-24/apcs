
/**
 * This program asks the user to enter a number and calculates the prime numbers from 1 to that number.
 *
 * @author Sreeya Gambhirrao
 * @version 04/16/2022
 */
import java.util.Scanner;
public class PrimeNumbersTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter an upper limit(e.g 100, 1000): ");
        int upperLimit = in.nextInt();
        
        PrimeNumbers prime = new PrimeNumbers(upperLimit);
        String primeNum = prime.calcPrime();
        
        System.out.println("The prime numbers are: " + primeNum); 
        
    }
}
