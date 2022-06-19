
/**
 * This program calculates how much CO2 is being emitted for the number of gallons projected 
 * annually.
 *
 * @author Sreeya Gambhirrao
 * @version 1/17/2022
 */
public class CO2FootprintV1
{
    // instance variables - replace the example below with your own
    private double myGallonsUsed;
    private double myTonsCO2;
    private double myPoundsCO2;

    /**
     * Constructor for objects of class CO2FootprintV1
     */
    public CO2FootprintV1(double gals)
    {
        // initialise instance variables
        myGallonsUsed = gals;
    }

    
    /**
     * Method to calculate number of tons emitted for the number of gallons(no parameters)
     */
    public void calcTons()
    {
        // put your code here
        myTonsCO2 = myGallonsUsed * (8.78 * Math.pow(10,-3));
    }
    
    /**
     * Method to convert metric tons to pounds(no parameters)
     */
    public void convertTonsToPounds()
    {
        
        myPoundsCO2 = myTonsCO2 * 2205;
    }
    
    
    /**
     * Getter method to return the value of tons(no parameters)
     */
    public double getTonsCO2()
    {
        return myTonsCO2;
    }
    
    /**
     * Getter method to return the converted tons into pounds(no parameters)
     */
    public double getPoundsCO2()
    {
        return myPoundsCO2;
    }
}
