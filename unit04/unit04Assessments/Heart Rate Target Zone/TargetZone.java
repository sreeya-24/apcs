
/**
 * This program takes user inout of age, resting heart rate, and heart rate after 
 * exercise to calculate the target zone for that person and checks whether their 
 * heart rate after exercise is within that target zone.
 *
 * @author Sreeya Gambhirrao
 * @version 11/25/2021
 */
import java.util.Scanner;
public class TargetZone
{
    public static void main(String[] args)
    {
    int age;
    int restHeartRate;
    int afterHeartRate;
    
    Scanner in = new Scanner(System.in);
    
    System.out.println("Determine Your Target Heart Rate Zone for Cardiovascular Exercise (50% - 85%)");
    System.out.println();
    
    System.out.print("Please enter your age: ");
    age = in.nextInt();
    System.out.println();
    
    System.out.print("Please enter your resting heart rate: ");
    restHeartRate = in.nextInt();
    System.out.println();
    
    System.out.print("Please enter your heart rate after exercising: ");
    afterHeartRate = in.nextInt();
    System.out.println();
    
    int maxHeartRate = 220 - age;
    //System.out.print(maxHeartRate);
    
    int heartRateReserve = maxHeartRate - restHeartRate;
    //System.out.println(heartRateReserve);
    
    double lowerEnd = 0.5 * heartRateReserve + restHeartRate;
    //System.out.println(lowerEnd);
    
    double upperEnd = 0.85 * heartRateReserve + restHeartRate;
    //System.out.println(upperEnd);
    
    System.out.println("Your heart rate target zone is between " + lowerEnd + " and " + upperEnd);
    System.out.println();
    
    //Below the if condition checks if heart rate is within target zone
    if(afterHeartRate >= lowerEnd && afterHeartRate <= upperEnd) {
        System.out.println("After exercising, your heart rate is within your target zone.");
    }
    
    //Below the if condition checks if heart rate is outside target zone
    if(afterHeartRate < lowerEnd || afterHeartRate > upperEnd) {
        System.out.println("After exercising, your heart rate is not within your target zone.");
    }
    
        
        
    }
}
