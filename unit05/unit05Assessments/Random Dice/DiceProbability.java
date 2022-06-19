/**
 * This program takes two dice with the user's desired number of sides and rolls each die randomly to 
 * calculate the probability of getting each sum of dice.
 * 
 * @author Sreeya Gambhirrao
 * @version 12/30/2021
 */
 
import java.util.Random;
import java.util.Scanner;
public class DiceProbability
{
    public static void main(String[] args)
    {
        //Declare and initialize variables and objects
        Scanner in = new Scanner(System.in);
        Random randNum = new Random();
        
        //int match = 0; 
        int die1, die2; //Random generated numbers
        int counter = 0; //Number of times sum of dice matches the current sum


        //Input: ask user for number of rolls and number of sides on a die
        System.out.println("Please enter the number of sides on a die: ");
        int diceSide = in.nextInt();
       
        System.out.println("Please enter the number of dice rolls: ");
        int trials = in.nextInt();
        
        
        //Print heading for output table
        System.out.println("Sum Of Dice \t Probability");

        
        //***************************************************************************************
        //Using nested loops, cycle through the possible sums of the dice.
        //Roll the dice the given number of times for each sum.
        //Count how many times the sum of the dice match the current sum being looked for.
        //***************************************************************************************
        
        for(int sum = 2; sum <= diceSide * 2; sum++)
        {
            for(int trial = 0; trial < trials; trial++)
            {
                die1 = randNum.nextInt(diceSide) + 1;
                die2 = randNum.nextInt(diceSide) + 1;
                
                    if(die1 + die2 == sum)
                    {
                        counter++;
                    }
            }
            //System.out.println(counter +" "+ trials + " " + (double)counter/trials + " " + ((double)counter/trials) * 100);
            
            double average = ((double)counter/trials) * 100;
            System.out.println("   " + sum + "s" + "\t\t   " + average);
            counter = 0;
        }
        
    } //end main
}//end class DiceProbability