
/**
 * Write a description of class AnnualClimate1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class AnnualClimate1
{
    public static void main(String [] args)
    {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        double[] temperature = {68.1, 69.1234, 72.4, 75.7, 79.6, 82.4, 83.7, 83.6, 82.4, 78.8, 74.4, 69.9};
        double[] precipitation = {1.9, 2.1, 2.6, 3.4, 5.5, 8.5, 5.8, 8.6, 8.4, 6.2, 3.4, 2.2};
        
        double tempSum = 0;
        double rainSum = 0;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("                           Climate Date");
        System.out.println("                    Location: Miami, Florida");
        System.out.println();
        
        System.out.println("Please choose a temperature scale (F or C): ");
        String temperatureScale = in.next();
        
        System.out.println("Month                Temperature (F)                    Precipitation (in)");
        System.out.println("*****************************************************************************");
        for(int i =0; i < months.length; i++)
        {
            System.out.print(months[i] + "\t\t\t");
            if(temperatureScale.equals("F"))
            {
            System.out.print(temperature[i] + "\t\t\t\t\t");
            tempSum += temperature[i];
            }
            
            System.out.println(precipitation[i]);
            rainSum += precipitation[i];
        }
        System.out.println("*****************************************************************************");
        System.out.print("Average: " + tempSum/12 + "\t\t\t" + "Annual: " + rainSum/12);
         
        
        
        
        
        
        
    }
}
