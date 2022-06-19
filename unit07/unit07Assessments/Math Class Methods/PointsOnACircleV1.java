
/**
 * This program calculates the x and y cordinates of a circle with radius 1.0 using the Math 
 * class methods.
 *
 * @author Sreeya Gambhirrao
 * @version 1/4/2022
 */
public class PointsOnACircleV1
{
    public static void main(String[] args)
    {
        double radius = 1.0;
        double x = 1.0;
        double y = 1.0;
        
        System.out.println();
        System.out.println("                 Points of a Circle of Radius " + radius);
        System.out.printf("%8s%15s%20s%17s", "x1", "x2", "x1", "x2");
        System.out.println();
        System.out.println(" -------------------------------------------------------------");
        
        for(int counter = 0; counter < 21; counter++)
        {
            double valueY = Math.sqrt((Math.pow(radius, 2) - Math.pow(x, 2)));
            System.out.printf("%8.2f%15.2f%20.2f%17.2f", x, valueY, x, -1 * valueY);
            System.out.println();
            x -= 0.1;
        }
        
    }
}
