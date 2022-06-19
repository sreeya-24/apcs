
/**
 * This program calculates gross waste emission, waste reduction, and the net waste reduction
 * of six households.
 *
 * @author Sreeya Gambhirrao
 * @version 1/22/2022
 */
import java.util.ArrayList;
public class CO2FromWasteTester
{
    public static void main(String[] args)
    {
        //Creating a an array list
        ArrayList<CO2FromWaste> householdEmissions = new ArrayList<CO2FromWaste>();
        
        //adding elements into the array list
        householdEmissions.add(new CO2FromWaste(1, true, true, true, true));
        householdEmissions.add(new CO2FromWaste(3, true, false, true, true));
        householdEmissions.add(new CO2FromWaste(4, false, false, false, false));
        householdEmissions.add(new CO2FromWaste(1, true, true, true, true));
        householdEmissions.add(new CO2FromWaste(1, true, true, true, true));
        householdEmissions.add(new CO2FromWaste(1, false, true, true, false));
        
        //new object of type CO2FromWaste
        CO2FromWaste data;
        
        //get the calculations
        for(int index = 0; index < householdEmissions.size(); index++)
        {
            data = householdEmissions.get(index);
            data.calcGrossWasteEmission();
            data.calcWasteReduction();
            data.calcNetWasteReduction();
        }
        
        //printing out results
        System.out.println("       |       |                                                 |          Pounds of CO2                                      |");
        System.out.println("       |       |           Household Waste Recycled              |   Total           |                    |      Net           |");
       

        System.out.println("       | Index | Household  | Paper  | Plastic  | Glass  | Cans  | Gross Emissions   |   Waste Reduction  |     Waste Reduction|");
        System.out.println("       -------------------------------------------------------------------------------------------------------------------------");
        for(int index = 0; index < householdEmissions.size(); index++)
        {
            data = householdEmissions.get(index);
            System.out.printf("       |%5d  | %5d      | %6b | %8b | %6b | %5b | %12.1f      | %18.1f | %18.1f |\n", index, data.getNumberOfPeople(), data.getPaperRecycled(), data.getPlasticRecycled(), data.getGlassRecycled(), data.getCansRecycled(), data.getGrossWasteEmission(), data.getWasteReduction(), data.getNetWasteReduction());
        }
        
        System.out.println("       -------------------------------------------------------------------------------------------------------------------------");
        
    }
} 
