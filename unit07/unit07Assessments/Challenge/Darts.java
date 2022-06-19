
/**
 * This program takes user input of the number trials and the number of darts in each trial to 
 * calculate the value of pi.
 *
 * @author Sreeya Gambhirrao
 * @version 1/9/2022
 */
import java.util.Scanner;
public class Darts
{
    /*
     * This function take number of darts and number of trials as function parameters
     * This function return an array of pie values which are doubles
     */
    public static double[] numOfHits(int dartThrows, int numOfTrials)
    {
        int numberOfHits = 0;
        double[] pieValues = new double[numOfTrials];
        double x, y;
        
        // Below loop iterate across number of trials
        for(int i = 0; i < numOfTrials; i++)
        {
            numberOfHits = 0;
            // Below loop iterate across number of darts
            for (int j =0; j< dartThrows; j++) {
                x = Math.random();
                y = Math.random();
                
                if((Math.pow(x,2) + Math.pow(y,2)) <= 1)
                {
                    numberOfHits++;
                }
            }
            pieValues[i] = 4 * ((double)numberOfHits/dartThrows);
        }

        return pieValues;
    }
    
    /*
     * Below function takes array of doubles, which are pi values for each trail
     * Computes Average Pi and prints them to the console
     */
    public static void printTrialsWithAverage(double[] pies) {
        double sumPies = 0.0;
        for (int i =0; i < pies.length; i++) {
            System.out.printf("Trial [ %d ]: pi = %4.2f\n", i,pies[i]);
            sumPies += pies[i];
        }
        System.out.printf("Estimate of Pi = %4.2f",sumPies/pies.length);
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the number of times the darts should be thrown each trial: ");
        int dartThrows = in.nextInt();
        
        System.out.println("Enter the number of trials: ");
        int trials = in.nextInt();
        
        //Calling numOfHits function
        double[] pieValues = numOfHits(dartThrows, trials);
        
        //Calling printTrialsWithAverage function
        printTrialsWithAverage(pieValues);
    }
}
