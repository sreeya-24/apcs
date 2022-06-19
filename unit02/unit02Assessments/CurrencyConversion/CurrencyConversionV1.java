/**
 * The CurrencyConversion class converts an amount of money from a specific
 * country into the equivalent currency of another country given the current 
 * exchange rate.
 * 
 *
 * CSA/FLVS 2007
 * @author Maria Vieta Jacquard 
 * @version 01/19/07
 * 
 * CSA/FLVS 2021
 * @author Sreeya Gambhirrao
 * @version 10/31/2021
 */
public class CurrencyConversionV1
{   
    public static void main(String [ ] args)
    {
        double startingUsDollars = 2500.00;      // local variable for US Dollars
        double pesosSpent = 5210.25;             // local variable for Mexican pesos spent
        double totalPesos = 0;                   // local variable for total pesos
        double remainingPesos = 0;               // local variable for pesos remaining after purchases
        double dollarsSpentInMexico = 478.00;    // local variable for dollars spent in Mexico
        //remaining variables below here
        double remainingDollars = 0;             // local variable for remaining dollars after each country
        double totalYen = 0;                     // local variable for total yen
        double dollarsSpentInJapan = 824.00;     // local variable for dollars spent in Japan
        double yenSpent = 0;                     // local variable for Yen spent
        double remainingYen = 0;                 // local variable for yen remaining after purchases
        double dollarsSpentInFrance = 1100.00;   // local variable for dollars spent in France
        double totalEuros = 0;                   // local variable for total euros
        double euroSpent = 0;                    // local variable for euros spent
        double remainingEuros = 0;               // local variable for euros remaining after purchases
        
        // purpose of program
        System.out.println('8' + '2');
        System.out.println("128" + "32");
        
        System.out.println("This program converts an amount of money");
        System.out.println("from a specific country into the equivalent");
        System.out.println("currency of another country given the current");
        System.out.println("exchange rate.");
        System.out.println();
        
        // Printing total dollars
        System.out.println("Started with " + startingUsDollars + " dollars");
        System.out.println();
        
        // U.S to Mexico
        //Convert total dollars to pesos, 1USD = 20.5829 pesos
        totalPesos = 2500.00 * 20.5829;
        System.out.println(startingUsDollars + " American Dollars " + " = " + totalPesos + " Mexican pesos ");
        
        
        //Print equivalent pesos
        System.out.print("Dollars Spent in Mexico = "+ dollarsSpentInMexico);
        pesosSpent = dollarsSpentInMexico * 20.5829;
        System.out.println("      Pesos Spent = "+ pesosSpent + " pesos");
        System.out.println();
        
        //Remaning Pesos
        remainingPesos = totalPesos - pesosSpent;
        
        //Converting remaining pesos to dollars, 1USD = 20.5829 pesos
        remainingDollars = remainingPesos / 20.5829;
        System.out.println("Remaining Dollars after Mexico = " + remainingDollars);
        System.out.println();
        
        // Convert remaining dollars to Yen, 1 USD = 113.6459 Yen
        totalYen = remainingDollars * 113.6459;
        System.out.println(remainingDollars + " American Dollars" + " = " + totalYen + " Japanese yen ");
        
        //Remaining yen
        //1 USD = 113.6459 Yen
        yenSpent = dollarsSpentInJapan * 113.6459;
        remainingYen = totalYen - yenSpent;
        
        System.out.print("Dollars Spent in Japan: " + dollarsSpentInJapan); 
        System.out.println("        Yen Spent = " + yenSpent + " yen");
        System.out.println();

        //Converting remaining yen to dollars, 1 USD = 113.6459 Yen
        remainingDollars = remainingYen / 113.6459;
        System.out.println("Remaining Dollars after Japan = " + remainingDollars);
        System.out.println();
        
        // Convert remaining dollars to Euros, 1 USD = 0.862028 yen
        totalEuros = remainingDollars * 0.862028;
        System.out.println(remainingDollars + " American Dollars" + " = " + totalEuros + " euros ");
        
        //1 USD = 0.862028 yen
        euroSpent = dollarsSpentInFrance * 0.862028;
        remainingEuros = totalEuros - euroSpent;

        System.out.print("Dollars Spent in France: " + dollarsSpentInFrance);
        System.out.println("       Euros Spent = " + euroSpent + " euros");
        System.out.println();
        
        remainingDollars = remainingEuros / 0.862028;
        System.out.println("Returned with = " + remainingDollars + " American Dollars");
        
            
    } // end of main method
} // end of class     

