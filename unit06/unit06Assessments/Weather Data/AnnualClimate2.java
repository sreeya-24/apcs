
/**
 * This program uses the user's desired temperature scale and precipitation scale to display and 
 * calculate the average temperature and annual precipitation of Key West, Florida.
 *
 * @author Sreeya Gambhirrao
 * @version 1/2/2022
 */
import java.util.Scanner;
public class AnnualClimate2
{
    public static void main(String [] args)
    {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        //Using Key West Data; Commented Maimi Data
        double[] temperature = {70.3, 70.8, 73.8, 77.0, 80.7, 83.4, 84.5, 84.4, 83.4, 80.2, 76.3, 72.0};//{68.123, 69.1, 72.4, 75.7, 79.6, 82.4, 83.7, 83.6, 82.4, 78.8, 74.4, 69.9};
        double[] precipitation = {2.2, 1.5, 1.9, 2.1, 3.5, 4.6, 3.3, 5.4, 5.5, 4.3, 2.6, 2.1};//{1.93, 2.1, 2.6, 3.4, 5.5, 8.5, 5.8, 8.6, 8.4, 6.2, 3.4, 2.2};
        
        double tempSum = 0;
        double rainSum = 0;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("                           Climate Date");
        System.out.println("                    Location: Miami, Florida");
        System.out.println();
        
        System.out.println("Please choose a temperature scale (F or C): ");
        String temperatureScale = in.next();
        
        System.out.println("Please choose a precipitation scale (in. or cm.): ");
        String precipitationScale = in.next();
        
        System.out.println("Month                Temperature (F)                    Precipitation (in)");
        System.out.println("*****************************************************************************");
        for(int i =0; i < months.length; i++)
        {
            System.out.print(months[i] + "\t\t\t");
            if(temperatureScale.equals("F"))
            {
            System.out.printf("%-20.1f", temperature[i]);
            tempSum += temperature[i];
            } else if(temperatureScale.equals("C"))
            {
                double tempC = (double)((double)5/9) * (double)(temperature[i] - 32);
                tempSum += tempC;
                System.out.printf("%-20.1f", tempC);
            }
            
            if(precipitationScale.equals("in"))
            {
            System.out.printf("%20.1f\n", precipitation[i]);
            rainSum += precipitation[i];
            } else if(precipitationScale.equals("cm"))
            {
                double rainC = precipitation[i] * 2.54;
                rainSum += rainC;
                System.out.printf("%20.1f\n", rainC);
            }
        }
        System.out.println("*****************************************************************************");
        System.out.printf("%25s %-20.1f","Average:", tempSum/12);
        System.out.printf("%15s %-20.1f", "Annual:", rainSum/12); 
    }
}
