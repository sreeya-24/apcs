
/**
 * Write a description of class AnnuelFuelUse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnnuelFuelUse
{
    // instance variables - replace the example below with your own
    private int fillUp;
    private int days;
    private int sMiles;
    private int eMiles;
    private int distance;
    private double gallonsUsed;
    private double MPG;
    private double price;
    private double cost;
    
    /**
     * Constructor for objects of class AnnuelFuelUse
     */
    public AnnuelFuelUse(int fillUpNumber, int day, int startMiles, int endMiles, double gallons, double pricePerGallon )
    {
        // initialise instance variables
        fillUp = fillUpNumber;
        days = day;
        sMiles = startMiles;
        eMiles = endMiles;
        gallonsUsed = gallons;
        price = pricePerGallon;
    }

    /**
     * Caluclates distance
     */
    public int calcDistance()
    {
        distance = eMiles - sMiles;
        return distance;
    }
    
    /**
     * Caluclates MPG
     */
    public void calcMPG()
    {
        MPG = (double)calcDistance()/gallonsUsed;
    }
    
    /**
     * Caluclates Total cost
     */
    public void calcTotalCost()
    {
        cost = gallonsUsed*price;
    }
    
    /**
     * Getter methods below
     */
    
    public int getFillUp()
    {
        return fillUp;
    }
    
    public int getDays()
    {
        return days;
    }
    
    public int getStartMiles()
    {
        return sMiles;
    }
    
    public int getEndMiles()
    {
        return eMiles;
    }
    
    public int getDistance()
    {
        calcDistance();
        return distance;
    }
    
    public double getMPG()
    {
        calcMPG();
        return MPG;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public double getTotalCost()
    {
        calcTotalCost();
        return cost;
    }
    
    public double getGallonsUsed()
    {
        return gallonsUsed;
    }
}
