
/**
 * This program creates the functions for the three different cars.
 *
 * @author Sreeya Gambhirrao
 * @version 1/16/2022
 */
public class CarV7
{
    //private instance variables for 1st car
    private String carType;
    private int startMiles1;
    private int endMiles1;
    private double gallonsUsed1;
    private double pricePerGallon1;
    
    //default constructor
    public CarV7(String carType1, int sMiles1, int eMiles1, double gallons1, double price1)
    {
        //first car
        startMiles1 = sMiles1;
        endMiles1 = eMiles1;
        gallonsUsed1 = gallons1;
        pricePerGallon1 = price1;
        carType = carType1;
        
    }
        
    //method for calculating the distance
    public int calcDistance1() {
        return endMiles1 - startMiles1;
    }
    
    //method for calculating miles per gallon
    public double calcMPG1() {
        return calcDistance1()/gallonsUsed1;
    }
    
    //method for calculating gallons per miles
    public double calcGPM1(int dist1)
    {
        return gallonsUsed1/(double)dist1;
    }
    
    //method for calculating total cost
    public double totalCost1()
    {
        return pricePerGallon1 * gallonsUsed1;
    }
    
    //get methods
    public String getCarType1()
    {
        return carType;
    }
    
    public int getStartMiles1()
    {
        return startMiles1;
    }
    
    public int getEndMiles1()
    {
        return endMiles1;
    }
    
    public double getGallonsUsed1()
    {
        return gallonsUsed1;
    }
    
    public double getPricePerGallon1()
    {
        return pricePerGallon1;
    }
}