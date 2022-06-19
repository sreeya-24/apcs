
/**
 * This program displays the years, hurricane names, their wind speeds and pressure 
 * and calculates their hurricane scale using the wind speed.
 *
 * @author Sreeya Gambhirrao
 * @version 1/3/2022
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class Hurricanes2
{
    public static void main(String[] args)  throws IOException
    {
        Scanner in = new Scanner(new File("hurcdata2.txt"));
        String line = "";
        String[] years = new String[100];
        String year = "";
        
        String[] months = new String[100];
        String month = "";
        
        int[] pressure = new int[100];
        int pres = 0;
        
        int[] windSpeed = new int[100];
        int speed = 0;
        
        String[] hurricanes = new String[100];
        String hurricane = "";
        
        int index = 0;
        
        while (in.hasNextLine()) {
            line = in.nextLine();
            //System.out.println(line);
            year = line.substring(0,5);
            years[index] = year;
            
            month = line.substring(5,8);
            months[index] = month;
            
            pres = Integer.parseInt(line.substring(12,16).trim());
            pressure[index] = pres;
            
            speed = Integer.parseInt(line.substring(19,22).trim());
            windSpeed[index] = speed;
            
            hurricane = line.substring(22,line.length()).trim();
            hurricanes[index] = hurricane;
            
            index++;
        } 
        in.close();
        //System.out.println("index:" + index);
        
        int category = 0;
        
        System.out.printf("%55s", "Hurricanes 1980 - 2006");
        System.out.println();
        System.out.println();
        System.out.println("Year      Hurricane               Category         Pressure (mb)        Wind Speed (mph)");
        System.out.println("=====================================================================================");
        
        int sumCategory = 0;
        double averageCategory = 0;
        int maxCategory = 0;
        int minCategory = Integer.MAX_VALUE;
        
        int categoryCount1 = 0;
        int categoryCount2 = 0;
        int categoryCount3 = 0;
        int categoryCount4 = 0;
        int categoryCount5 = 0;
        
        int sumPressure = 0;
        double averagePressure = 0;
        int maxPressure = 0;
        int minPressure = Integer.MAX_VALUE;
        
        int sumWindSpeed = 0;
        double averageSpeed = 0;
        int maxSpeed = 0;
        int minSpeed = Integer.MAX_VALUE;
        
        for (int i = 0; i < index; i++)
        {
            if((windSpeed[i] >= 64) && (windSpeed[i] <= 82))
            {
                category = 1;
                categoryCount1++;
            } else if((windSpeed[i] >= 83) && (windSpeed[i] <= 95))
            {
                category = 2;
                categoryCount2++;
            } else if((windSpeed[i] >=96) && (windSpeed[i] <= 112))
            {
                category = 3;
                categoryCount3++;
            } else if((windSpeed[i] >= 113) && (windSpeed[i] <= 136))
            {
                category = 4;
                categoryCount4++;
            } else if(windSpeed[i] >= 137)
            {
                category = 5;
                categoryCount5++;
            }
            sumCategory += category;
            sumPressure += pressure[i];
            sumWindSpeed += windSpeed[i];
            
            if (category > maxCategory) {
                maxCategory = category;
            }
            
            if (category < minCategory) {
                minCategory = category;
            }
            
            if (pressure[i] > maxPressure) {
                maxPressure = pressure[i];
            }
            
            if (pressure[i] < minPressure) {
                minPressure = pressure[i];
            }
            
            if (windSpeed[i] > maxSpeed) {
                maxSpeed = windSpeed[i];
            }
            
            if (windSpeed[i] < minSpeed) {
                minSpeed = windSpeed[i];
            }
            
            System.out.printf("%-10s",years[i]); //+ " " +months[i] + " "+ pressure[i] + " " + windSpeed[i] + " " + hurricanes[i]);
            System.out.printf("%-20s%10d%20d%20d", hurricanes[i], category, pressure[i], windSpeed[i]);
            System.out.println();
            
            /*averageCategory = (double)sumCategory/index;
            averagePressure = (double)sumPressure/index;
            averageSpeed = (double)sumWindSpeed/index;*/
            
        }
        averageCategory = (double)sumCategory/index;
        averagePressure = (double)sumPressure/index;
        averageSpeed = (double)sumWindSpeed/index;
        System.out.println("=======================================================================================");
        System.out.printf("%s%33.1f%20.1f%20.1f", "Average:", averageCategory, averagePressure, averageSpeed);
        System.out.println();
        
        System.out.printf("%s%33d%20d%20d", "Maximum:", maxCategory, maxPressure, maxSpeed);
        System.out.println();
        
        System.out.printf("%s%33d%20d%20d", "Minimum:", minCategory, minPressure, minSpeed);
        System.out.println();
        System.out.println();
        
        System.out.println("Number of Category 1: " + categoryCount1);
        System.out.println("Number of Category 2: " + categoryCount2);
        System.out.println("Number of Category 3: " + categoryCount3);
        System.out.println("Number of Category 4: " + categoryCount4);
        System.out.println("Number of Category 5: " + categoryCount5);
        
        PrintWriter outFile = new PrintWriter (new File("Summary.txt"));
        outFile.println("Number of Category 1: " + categoryCount1);
        outFile.println("Number of Category 2: " + categoryCount2);
        outFile.println("Number of Category 3: " + categoryCount3);
        outFile.println("Number of Category 4: " + categoryCount4);
        outFile.println("Number of Category 5: " + categoryCount5);
        outFile.close();
    }
}
