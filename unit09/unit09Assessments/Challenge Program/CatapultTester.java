
/**
 * This program calculates the trajectory of a projectile based on
 * launch angles and launch speed.
 *
 * @author Sreeya Gambhirrao
 * @version 1/23/2022
 */
public class CatapultTester
{
    public static void main(String[] args)
    {
        //creating new array
        Catapult[][] catapults = new Catapult[7][7];
        int speed;
        
        //for loop to get trajectory
        for(int row = 0; row < catapults.length; row++)
        {
            speed = 20 + 5*row;
            
            for(int col = 0; col < catapults.length; col++)
            {
                catapults[row][col] = new Catapult(speed, 25 + 5*col);
            }
        }
        
        // printing header
        System.out.println("                                 Projectile Distance(feet)                    ");
        System.out.println("MPH      25 Deg      30 Deg      35 Deg      40 Deg      45 Deg      50 Deg      55 Deg   ");
        System.out.println();
        System.out.println("========================================================================================");
        
        //printing actual data using for loop
        for(Catapult[] catapult : catapults)
        {
            System.out.printf("%3.0f", catapult[0].getVelocity());
            
            for(int col = 0; col < catapults.length; col++)
            {
                catapult[col].calcDistance();
                System.out.printf("%12.1f", catapult[col].getDistance());
            }
            System.out.println();
        }
    }
}
