
/**
 * This program calculates the miles per gallon(Gas Mileage) using the start miles, end miles, 
 * and the gallons.
 *
 * @author Sreeya Gambhirrao
 * @version 1/16/2022
 */
public class CarV3
{
    //default constructor
    public String make;
    public CarV3(String myCarMake)
    {
        make=myCarMake;
    }

    //method for calculating the distance
    public int calcDistance(int sMiles, int eMiles) {
        return eMiles - sMiles;
    }
    
    //method for calculating miles per gallon
    public double calcMPG(int dist, double gals) {
        return dist/gals;
    }
    
    public void updateCarMake(String newMake) {
        make=newMake;
    }
    
    //main method
    public static void main(String[] args) {
        //declaring and intializing varibles
        int sMiles = 44000 ;
        int eMiles = 44200 ;
        int distance = 0;
        double MPG = 0.0;
        double gallons = 8.5 ;
        
        //creating a new object of type CarV3
        CarV3 car1 = new CarV3("Toyota");
        
        //calling the functions
        distance = car1.calcDistance(sMiles, eMiles);
        MPG = car1.calcMPG(distance,gallons);
        
        //Printing the results on the console
        System.out.printf("%60s\n", "Gas Mileage Calculations");
        System.out.printf("%s%20s%15s%15s%15s%15s\n", "Type of Car", "Start Miles", "End Miles", "Distance", "Gallons", "Miles/gal");
        System.out.println("===========================================================================================");
        System.out.printf("%s%12d%15d%12d%16.1f%15.1f\n", "2015 Toyota Camry", sMiles, eMiles, distance, gallons, MPG);
        
        car1.make="jjjj";
        car1.updateCarMake("BMW");
        
    }
}
