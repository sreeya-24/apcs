
/**
 * This program displays the months, temperature, humidity, and calculates the heat index 
 * for Key West, Florida.
 *
 * @author Sreeya Gambhirrao
 * @version 1/2/2022
 */
public class HeatIndex
{
    public static void main(String[] args)
    {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        double[] temperature = {70.3,   70.8,   73.8,   77.0,   80.7,   83.4,   84.5,   84.4,   83.4,   80.2,   76.3,   72.0};
        double[] humidity = {69, 67, 66, 64, 66, 69, 67, 67, 70, 69, 69, 70};
        
        System.out.printf("%85s\n", "Heat Index: Key West, Florida");
        System.out.println();
        System.out.printf("%74s", "Months");
        System.out.println();
        
        System.out.printf("%15s", " ");
        for(String month: months)
        {
            System.out.printf("%10s", month);
        }
        System.out.println();
        System.out.println("****************************************************************************************************************************************");
        
        System.out.printf("%-15s", "Temp (F)");
        for(double temp : temperature)
        {
            System.out.printf("%10.1f", temp);
        }
        System.out.println();
        
        System.out.printf("%-15s", "Humidity (%)");
        for(double humi : humidity)
        {
            System.out.printf("%10.1f", humi);
        }
        System.out.println();
        System.out.printf("%-15s", "HI (F)");
        double HI = 0;
        double temp = 0;
        double humi = 0;
        
        for (int i = 0; i< 12; i++) {
            temp = temperature[i];
            humi = humidity[i];
            HI = -42.379 + 2.04901523 * temp + 10.14333127 * humi - 0.22475541 * temp * humi - 6.83783 * 0.001 * temp * temp - 5.481717 * 0.01 * humi * humi + 1.22874 * 0.001 * temp * temp * humi + 8.5282 * 0.0001 * temp * humi * humi - 1.99 * 0.000001 * temp * temp* humi * humi;
            System.out.printf("%10.1f", HI);
        }
        System.out.println();
    }
}
