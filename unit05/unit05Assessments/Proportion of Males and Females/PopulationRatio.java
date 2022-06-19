
/**
 * This program takes the user input of a population size and calaculates the 
 * ratio of males to females.
 *
 * @author Sreeya Gambhirrao
 * @version 12/25/2021
 */
import java.util.Scanner;
public class PopulationRatio
{
    public static void main(String[] args)
    {
        int males = 0;
        int females = 0;
        int counter = 1;
        double randNum = 0.0;
        Scanner in = new Scanner(System.in);
        
        System.out.println("What is the population size?");
        int size = in.nextInt();
        
        int numberOfTimes = 0;
        
        while(numberOfTimes < 5) {
            while(counter <= size)
            {
                randNum = Math.random();
                System.out.print(counter + "\t" + randNum);
                
                if(randNum < 0.502)
                {
                    males++;
                    //System.out.println("\t males");
                    
                }
                else
                {
                    females++;
                    //System.out.println("\t females");
                   }
                counter++;      
            }
            System.out.println("******"+numberOfTimes+"***");
            System.out.println("Number of Males = " + males);
            System.out.println("Number of Females = " + females);
            System.out.println("Ratio of Males to Females: " + (double)males/females);
            numberOfTimes++;
            males =0;
            females=0;
            counter= 1;
    }
        
        
        
        
    }
    }
