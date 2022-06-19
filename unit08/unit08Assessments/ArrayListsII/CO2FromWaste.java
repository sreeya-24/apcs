
/**
 * This program calculates gross waste emission, waste reduction, and the net waste reduction
 * of six households.
 *
 * @author Sreeya Gambhirrao
 * @version 1/22/2022
 */
public class CO2FromWaste
{
    // private instance variables
    private int numberOfPeople;
    
    private boolean paperRecycled;
    private boolean plasticRecycled;
    private boolean glassRecycled;
    private boolean cansRecycled;
    
    private double grossWasteEmission;
    private double wasteReduction;
    private double netWasteReduction;
    /**
     * Constructor for objects of class CO2FromWaste
     */
    public CO2FromWaste(int numPeople, boolean paper, boolean plastic, boolean glass, boolean cans)
    {
        // initialise instance variables
        numberOfPeople = numPeople;
        paperRecycled = paper;
        plasticRecycled = plastic;
        glassRecycled = glass;
        cansRecycled = cans;
    }

    /**
     * A method to calculate the gross waste reduction(no parameters)
     */
    public void calcGrossWasteEmission()
    {
        grossWasteEmission = numberOfPeople * 1080.00;
    }
    
    /**
     * A method to calculate the waste reduction(no parameters)
     */
    public void calcWasteReduction()
    {
        double papers;
        double plastics;
        double glasses;
        double cansR;
        
        if(paperRecycled == true)
        {
            papers = 184;
        } else {
            papers = 0;
        }
        
        if(plasticRecycled == true)
        {
            plastics = 25.6;
        } else {
            plastics = 0;
        }
        
        if(glassRecycled == true)
        {
            glasses = 46.6;
        } else {
            glasses = 0;
        }
        
        if(cansRecycled == true)
        {
            cansR = 165.8;
        } else {
            cansR = 0;
        }
        
        wasteReduction = numberOfPeople * (papers + plastics + glasses + cansR);
    }
    
    /**
     * A method to calculate the net waste reduction(no parameters)
     */
    public void calcNetWasteReduction()
    {
        netWasteReduction = grossWasteEmission - wasteReduction;
    }
    
    /**
     * getter method for gross waste emission
     */
    public double getGrossWasteEmission()
    {
        return grossWasteEmission;
    }
    
    /**
     * getter method for waste reduction
     */
    public double getWasteReduction()
    {
        return wasteReduction;
    }
    
    /**
     * getter method for net waste reduction
     */
    public double getNetWasteReduction()
    {
        return netWasteReduction;
    }
    
    /**
     * getter methods fro household, paper, plastic, glass, and cans.
     */
    
    public int getNumberOfPeople()
    {
        return numberOfPeople;
    }
    
    public boolean getPaperRecycled()
    {
        return paperRecycled;
    }
    
    public boolean getPlasticRecycled()
    {
        return plasticRecycled;
    }
    
    public boolean getGlassRecycled()
    {
        return glassRecycled;
    }
    
    public boolean getCansRecycled()
    {
        return cansRecycled;
    }
}
