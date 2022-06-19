
/**
 * This program calculates the total number of boys and girls and how many combinations
 * (two boys, two girls, or one boy and one girl) 
 * there are in a large set and calculates the percentages.
 *
 * @author Sreeya Gambhirrao
 * @version 12/27/2021
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Family
{
   public static void main(String[] args) throws IOException
   {
       Scanner inFile = new Scanner(new File("MaleFemaleInFamily.txt"));
       String token = "";
       int counterBG = 0;
       int counterBB = 0;
       int counterGG = 0;
       while (inFile.hasNext())
       {
        token = inFile.nextLine();   
        if(token.equals("BG"))
        {
            counterBG++;
        } else if(token.equals("BB"))
        {
            counterBB++;
        } else if(token.equals("GG"))
        {
            counterGG++;
        }
       }inFile.close();
       int total = counterBG + counterBB + counterGG;
       System.out.println("Total: " + total);
       System.out.println("One Boy and One Girl (%): " + ((double)counterBG/total *100));
       System.out.println("Two Boys (%): " + ((double)counterBB/total *100));
       System.out.println("Two Girls (%): " + ((double)counterGG/total *100));
       
   }
}
