
/**
 * This program calculates CO2 emitted from gasoline, waste, and electricity. It also 
 * calculates the CO2 reduced from recycling and lightbulbs.
 *
 * @author Sreeya Gambhirrao
 * @version 1/23/2022
 */
import java.util.ArrayList;
public class CO2FootPrintTester
{
    public static void main(String[] args)
    {
        
        //New array list for monthly bills
        ArrayList<CO2Footprint> footPrint = new ArrayList();
                //creating new object of type CO2FromElectricity
        CO2Footprint co2Footprint1 = new CO2Footprint(91, 110.68, 0.32, 4, true, true, true, false, 12);
        footPrint.add(co2Footprint1);
        CO2Footprint co2Footprint2 = new CO2Footprint(110, 140.68, 0.42, 4, false, true, true, false, 10);
        footPrint.add(co2Footprint2);
        CO2Footprint co2Footprint3 = new CO2Footprint(100, 125.68, 0.39, 4, false, true, false, true, 11);
        footPrint.add(co2Footprint3);
        CO2Footprint co2Footprint4 = new CO2Footprint(150, 120.68, 0.45, 4, false, true, false, true, 15);
        footPrint.add(co2Footprint4);
        CO2Footprint co2Footprint5 = new CO2Footprint(170, 140.68, 0.49, 4, true, true, true, false, 15);
        footPrint.add(co2Footprint5);
        
        double co2FromGas, co2FromElectricity, co2FromWaste; 
        double co2FromRecycle, co2FromnewBulbs;
        double co2FootPrint;
        CO2Footprint data; 
        
        System.out.println("|         Pounds of CO2         |       Pounds of CO2    |               |");
        System.out.println("|         Emitted From          |       Reduced From     |               |");
        System.out.println("|  Gas  |  Electricity | Waste  |  Recycling | New Bulbs | CO2 Footprint |");
        System.out.println("| ======|==============|========|============|===========|===============|");
        for(int index = 0; index < footPrint.size(); index++)
        {
            data = footPrint.get(index);
            co2FromGas = data.calcCO2FromGasoline();
            co2FromElectricity = data.calcCO2FromElectricity();
            co2FromWaste = data.calcCO2FromWaste();
            co2FromRecycle= data.calcCO2ReducedFromRecycling();
            co2FromnewBulbs = data.calcCO2ReducedFromBulbs();
            co2FootPrint = co2FromGas+co2FromElectricity+co2FromWaste-co2FromRecycle-co2FromnewBulbs;
            System.out.printf("|%7.2f|  %7.2f     | %7.2f| %7.2f    | %7.2f   | %7.2f       |\n", co2FromGas,co2FromElectricity,co2FromWaste,co2FromRecycle, co2FromnewBulbs, co2FootPrint);
        }
    }
}
