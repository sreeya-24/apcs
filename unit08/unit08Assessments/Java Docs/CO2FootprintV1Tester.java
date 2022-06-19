
/**
 * This program calculates how much CO2 is being emitted for the number of gallons projected 
 * annually.
 *
 * @author Sreeya Gambhirrao
 * @version 1/17/2022
 */
public class CO2FootprintV1Tester
{
    public static void main(String[] args)
    {
        double gallonsUsed = 91.20;
        
        //creating a new object called footprint of type CO2FootprintV1
        CO2FootprintV1 footprint = new CO2FootprintV1(gallonsUsed);
        
        //calling calcTons method on footprint
        footprint.calcTons();
        
        //calling convertTonsToPounds method on footprint
        footprint.convertTonsToPounds();
        
        //printing results to the terminal
        System.out.printf("%30s\n", "CO2 Emissions");
        System.out.printf("%s%18s%14s\n", "Gallons", "Pounds", "Tons");
        System.out.printf("%s%20s%15s\n", "Of Gas", "From Gas", "From Gas");
        System.out.println("***********************************************");
        System.out.printf("%.2f%21.2f%14.2f\n", gallonsUsed, footprint.getPoundsCO2(), footprint.getTonsCO2());
    }
}
