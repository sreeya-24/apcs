
/**
 * This program calculates the miles per gallon and gallons per miles.
 *
 * @author Sreeya Gambhirrao
 * @version 1/16/2022
 */
public class CarV5
{
    //private instance variables
    private String carType;
    private int startMiles1;
    private int endMiles1;
    private double gallonsUsed1;
    private double pricePerGallon;
    //default constructor
    public CarV5(String carType1, int sMiles1, int eMiles1, double gallons1, double price)
    {
        //System.out.println("I am in constructor: " + carType1 + sMiles1 + startMiles1);
        startMiles1 = sMiles1;
        endMiles1 = eMiles1;
        gallonsUsed1 = gallons1;
        pricePerGallon = price;
        carType = carType1;
        //System.out.println("I am in end: " + carType1 + startMiles1);
    }
    
    //method for calculating the distance
    public int calcDistance() {
        return endMiles1 - startMiles1;
    }
    
    //method for calculating miles per gallon
    public double calcMPG() {
        return calcDistance()/gallonsUsed1;
    }
    
    //method for calculating gallons per miles
    public double calcGPM(int dist)
    {
        return gallonsUsed1/(double)dist;
    }
    
    //method for calculating total cost
    public double totalCost()
    {
        return pricePerGallon * gallonsUsed1;
    }
    
    //get methods
    public String getCarType()
    {
        return carType;
    }
    
    public int getStartMiles()
    {
        return startMiles1;
    }
    
    public int getEndMiles()
    {
        return endMiles1;
    }
    
    public double getGallonsUsed()
    {
        return gallonsUsed1;
    }
    
    public double getPricePerGallon()
    {
        return pricePerGallon;
    }
    

    //main method
    public static void main(String[] args) {
        //declaring and intializing varibles
        String carType1 = "2015 Toyota Camry";
        int sMiles1 = 44000 ;
        int eMiles1 = 44200 ;
        int distance1 = 0;
        double MPG1 = 0.0;
        double gallons1 = 8.5 ;
        double pricePerGallon = 2.98;
        double GPM = 0.0;
        
        //creating a new object of type CarV3
        CarV5 car1 = new CarV5(carType1,sMiles1, eMiles1, gallons1, pricePerGallon);
        
        //calling the functions
        distance1 = car1.calcDistance();
        MPG1 = car1.calcMPG();
        GPM = car1.calcGPM(distance1);

        //Printing the results on the console
        System.out.printf("%80s\n", "Gas Mileage Calculations");
        System.out.printf("%s%20s%15s%15s%15s%15s%15s%15s%15s\n", "Type of Car", "Start Miles", "End Miles", "Distance", "Gallons", "Price", "Cost", "Miles/gal", "Gals/miles");
        System.out.println("=========================================================================================================================================");
        System.out.printf("%s%12d%15d%12d%16.1f%18.1f%16.1f%12.2f%14.4f\n", car1.getCarType(), car1.getStartMiles(), car1.getEndMiles(), distance1, car1.getGallonsUsed(), pricePerGallon, car1.totalCost(), MPG1, GPM);
        
        
    }
}
