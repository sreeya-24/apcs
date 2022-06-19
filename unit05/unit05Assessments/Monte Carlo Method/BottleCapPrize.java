
/**
 * This program uses the Monte Carlo Method to find the average drinks the user needs to win the prize.
 *
 * @author Sreeya Gambhirrao
 * @version Gambhirrao
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
public class BottleCapPrize
{
   public static void main(String[] args) throws IOException
   {
       PrintWriter outFile = new PrintWriter(new File("CapPrize.txt"));
       
       int token;
       int counter = 0;
       int randCap = 0;
       int sum = 0;
       
       for(int trial = 0; trial < 1000; trial++)
       {
        counter = 0;
        
            while(randCap != 1)
            {
                randCap = (int)(Math.random() * 10);
                counter++;
            }
            outFile.println(counter);
            randCap = 0;
       }
       outFile.close();
       
       Scanner inFile = new Scanner(new File("CapPrize.txt"));
       
       while(inFile.hasNextInt())
       {
          token = inFile.nextInt();
          sum = sum + token;
       }
       inFile.close();
        double average = sum/1000;
        System.out.println("Average Number of Bottles to Drink for the Prize: " + average);
       
   }
}
