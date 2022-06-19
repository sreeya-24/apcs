
/**
 * This program calculates CO2 emitted from gasoline, waste, and electricity. It also 
 * calculates the CO2 reduced from recycling and lightbulbs.
 *
 * @author Sreeya Gambhirrao
 * @version 1/23/2022
 */
public class CO2Footprint
{
    // instance variables - replace the example below with your own
    
    private double annualGasolineUsed;
    private double averageElectricityUsed;
    private double averageElectricityPrice;
    private int numberOfPeople;
    private boolean paperRecycled;
    private boolean plasticRecycled;
    private boolean glassRecycled;
    private boolean cansRecycled;
    private int lightBulbsUsed;
    
    private double co2EmittedFromGas;
    private double co2EmittedFromElectricity;
    private double co2ReducedFromRecycling;
    private double co2EmittedFromWaste;
    private double co2ReducedFromNewbulbs;
    

    /**
     * Constructor for objects of class CO2Footprint
     */
    public CO2Footprint(double gasUsed, double electrictyUsed, double electrictyPrice, int houseHold, boolean paper, boolean plastic, boolean glass, boolean cans, int lightBulbs)
    {
        // initialise instance variables
        annualGasolineUsed = gasUsed;
        averageElectricityUsed = electrictyUsed;
        averageElectricityPrice = electrictyPrice;
        numberOfPeople = houseHold;
        paperRecycled = paper;
        plasticRecycled = plastic;
        glassRecycled = glass;
        cansRecycled = cans;
        lightBulbsUsed = lightBulbs;
    }

    /**
     * This once calculated CO2 emitted from Gasoline Used
     */
    public double calcCO2FromGasoline()
    {
        // put your code here
        co2EmittedFromGas = annualGasolineUsed* 8.43 * (8.78 * Math.pow(10,-3));
        return co2EmittedFromGas;
    }
    
      /**
     * a mutator method to calculate electricity 
     * 
     */
    public double calcCO2FromElectricity()
    {
        co2EmittedFromElectricity = (averageElectricityUsed * 1.37 * 12)/averageElectricityPrice;
        return co2EmittedFromElectricity;
    }
    
        /**
     * A method to calculate the waste reduction(no parameters)
     */
    public double calcCO2ReducedFromRecycling()
    {
        double papers,plastics,glasses,cansR;
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
        
        co2ReducedFromRecycling = numberOfPeople * (papers + plastics + glasses + cansR);
        return co2ReducedFromRecycling;
    }
    
     /**
     * A method to calculate the gross waste reduction(no parameters)
     */
    public double calcCO2FromWaste()
    {
        co2EmittedFromWaste = numberOfPeople * 1080.00;
        return co2EmittedFromWaste;
    }
    
         /**
     * A method to calculate the gross waste reduction(no parameters)
     */
    public double calcCO2ReducedFromBulbs()
    {
        co2ReducedFromNewbulbs = lightBulbsUsed * 1.37 * 73 ;
        return co2ReducedFromNewbulbs;
    }
    
    
}
