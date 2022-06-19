
/**
 * This program calculates the surface gravity of each planet and displays them.
 *
 * @author Sreeya Gambhirrao
 * @version 1/9/2022
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
public class GravityV1
{
    public static double[] surfaceGravity(double[]kg, double[]km)
    {
        double Gnum = 6.67E-11;
        double []surfaceGravities = new double[9];
        
        for(int i = 0; i < surfaceGravities.length; i++)
        {
            surfaceGravities[i] = (((Gnum * kg[i]) / (Math.pow(km[i]/2,2)))/10);
        }
        return surfaceGravities;
    }
    
    public static void outPut(String[]planet, double[] diameter, double[]kg, double[]gravityForce)
    {
        System.out.printf("%43s\n", "Planetary Data");
        System.out.printf("%-10s%15s%20s%20s\n", "Planet", "Diameter(km)", "Mass(kg)", "g(m/s^2)");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        
        for(int i = 0; i < 9; i++)
        {
            System.out.printf("%-10s%15.1f%20.2e%17.2f", planet[i], diameter[i], kg[i], gravityForce[i]);
            System.out.println();
        }
    }
    
    public static void fileData(double[]gravityForce)throws IOException
    {
        PrintWriter outFile = new PrintWriter(new File("gravityForce.txt"));
        double []gravity = gravityForce;
        
        for(int index = 0; index < gravity.length; index++)
        {
            outFile.println(gravity[index]);
        }
        outFile.close();
    }
    
    public static void main(String[]args) throws IOException
    {
        String [] planet = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        double [] kg = {3.30E23, 4.869E24,5.972E24, 6.4219E23, 1.900E27, 5.68E26, 8.683E25, 1.0247E26,1.27E22};
        double [] km = {4880000,12103600,12756300,6794000,142984000,120536000,51118000,49532000,2274000};
        double [] diameter = {4880, 12103.6, 12756.3, 6794, 142984, 120536, 51118, 48532,2274,2376.6};
        double [] gravityForce = surfaceGravity(kg, km);
        outPut(planet, diameter, kg, gravityForce);
        fileData(gravityForce);
        
    }
}
