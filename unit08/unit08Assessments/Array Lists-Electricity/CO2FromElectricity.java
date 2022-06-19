
/**
 * This program calculates average electricity bill, average monthly price, and annual CO2 emissions.
 *
 * @author Sreeya Gambhirrao
 * @version 1/19/2022
 */
import java.util.ArrayList;
public class CO2FromElectricity
{
    // private instance variables
    private double averageBill;
    private double averagePrice;
    private double electricityCO2;
    

    /**
     * Constructor for objects of class CO2FromElectricity
     */
    public CO2FromElectricity()
    {
        
    }

    /**
     * a mutator method to calculate average bill 
     * taking monthly Bill as parameter
     */
    public double calcAverageBill(ArrayList<Double> monthlyBill)
    {
        // put your code here
        double element = 0.0;
        double sum = 0.0;
        for(int i = 0; i < monthlyBill.size(); i++)
        {
            element = monthlyBill.get(i);
            sum += element;
        }
        averageBill = sum/monthlyBill.size();
        
        return averageBill;
    }
    
    /**
     * a mutator method to calculate average price 
     * taking monthly Price as parameter
     */
    public double calcAveragePrice(ArrayList<Double> monthlyPrice)
    {
        double eachPrice = 0.0;
        double sum = 0.0;
        for(int i = 0; i < monthlyPrice.size(); i++)
        {
            eachPrice = monthlyPrice.get(i);
            sum += eachPrice;
        }
        averagePrice = sum/monthlyPrice.size();
        
        return averagePrice;
    }
    
    /**
     * a mutator method to calculate electricity 
     * taking avgBill and avgPrice as parameters
     */
    public double calcElectricityCO2(double avgBill, double avgPrice)
    {
        electricityCO2 = (avgBill * 1.37 * 12)/avgPrice;
        
        return electricityCO2;
    }
}
