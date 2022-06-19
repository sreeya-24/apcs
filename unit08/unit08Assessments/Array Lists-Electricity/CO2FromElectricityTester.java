
/**
 *  This program calculates average electricity bill, average monthly price, and annual CO2 emissions.
 *
 * @author Sreeya Gambhirrao
 * @version 1/20/2022
 */
import java.util.ArrayList;
public class CO2FromElectricityTester
{
    public static void main(String[] args)
    {
        //declaring of variables of type double
        double averageBill;
        double averagePrice;
        double emissions;
        
        //creating new object of type CO2FromElectricity
        CO2FromElectricity electricity = new CO2FromElectricity();
        
        //New array list for monthly bills
        ArrayList<Double> monthlyBills = new ArrayList();
        
        //adding values to monthlyBills array list
        monthlyBills.add(116.15);
        monthlyBills.add(120.55);
        monthlyBills.add(110.26);
        monthlyBills.add(115.67);
        monthlyBills.add(90.78);
        
        //calling calcAverageBill method
        averageBill = electricity.calcAverageBill(monthlyBills);
        
        //New array list for monthly price
        ArrayList<Double>monthlyPrices = new ArrayList();
        
        //adding values to monthlyPrices array list
        monthlyPrices.add(0.32882);
        monthlyPrices.add(0.32892);
        monthlyPrices.add(0.32810);
        monthlyPrices.add(0.32882);
        monthlyPrices.add(0.26175);
        
        //calling calcAveragePrice method
        averagePrice = electricity.calcAveragePrice(monthlyPrices);
        
        //calling calcElectricityCO2 method
        emissions = electricity.calcElectricityCO2(averageBill, averagePrice);
        
        //Printing results
        System.out.print("Average Monthly Electricity Bill: ");
        System.out.printf("%5.2f", averageBill);
        System.out.println();
        
        System.out.print("Average Monthly Electricity Price: ");
        System.out.printf("%5.2f", averagePrice);
        System.out.println();
        
        System.out.print("Annual CO2 Emissions from Electricity Usage: ");
        System.out.printf("%3.2f", emissions);
        System.out.println();
        
    }
}    