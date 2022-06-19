
/**
 * This program demostrates the difference between mass and weight using my weight.
 *
 * @author Sreeya Gambhirrao
 * @version 1/9/2022
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class WeightOnPlanetsV1
{
    //function for reading the file and calculating the weight on every planet
   public static void readFile(String[] planets) throws IOException
   {
       int i = 0;
       double[] gravities = new double[9];
       double[] weights = new double[gravities.length];
       double myWeight = 124.3;
       double mass = 0;
       Scanner inFile = new Scanner(new File("gravityForce.txt"));
       
       while(inFile.hasNext())
       {
           gravities[i] = inFile.nextDouble();
           i++;
       }
       inFile.close();
       
       for (int j = 0; j< gravities.length; j++) {
           mass = (myWeight) * (433.59237);
           weights[j] = (mass * gravities[j])/(433.59237);
       }
       
       for (i = 0; i < weights.length; i++) {
           System.out.printf("%-16s%6.2f%15.2f\n",planets[i],gravities[i],  weights[i]);
       }
   }
    
   //main function which prints out data 
   public static void main(String[] args) throws IOException
   {
       String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Staurn", "Uranus", "Neptune","Pluto"};
       System.out.printf("%35s\n","My Weight on the Planets");
       System.out.printf("%-16s%6s%15s\n", "Planet", "Gravity", "Weight(lbs)");
       System.out.println("---------------------------------------");
       readFile(planets);
   }
}
