
/**This program converts an amount of money from a specific 
 * country into the equivalent currency of another country 
 * when the user enters and exchange rate.
 *
 * 
 *
 * @author Sreeya Gambhirrao
 * @version 11/12/2021
 */
import java.util.Scanner;
public class CurrencyConversionV2
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
        double remainingEuros = 0;     // local variable for euros remaining after purchases
        
        Scanner in;
        in = new Scanner(System.in);
        
        System.out.println("This program converts an amount of money");
        System.out.println("from a specific country into the equivalent");
        System.out.println("currency of another country given the current");
        System.out.println("exchange rate.");
        System.out.println();
        
        // Printing total dollars
        System.out.println("Started with " + startingUsDollars + " dollars");
        System.out.println();
        
        System.out.println("In Mexico:");
        
        //Scanner Class
        System.out.println("Please enter an exchange rate for this country: ");
        double decimalValue = in.nextDouble();
        System.out.println("Exchange Rate: 1 dollar = " + decimalValue + " pesos");
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
        System.out.println("In Japan:");
        
        //Scanner Class
        System.out.println("Please enter an exchange rate for this country: ");
        double decimalValue2 = in.nextDouble();
        System.out.println("Exchange Rate: 1 dollar = " + decimalValue2 + " yen");
        System.out.println();
        
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
        System.out.println("In France:");
        
        //Scanner Class
        System.out.println("Please enter an exchange rate for this country: ");
        double decimalValue3 = in.nextDouble();
        System.out.println("Exchange Rate: 1 dollar = " + decimalValue3 + " eruos");
        System.out.println();
        
        totalEuros = remainingDollars * 0.862028;
        System.out.println(remainingDollars + " American Dollars" + " = " + totalEuros + " euros ");
        
        //1 USD = 0.862028 yen
        euroSpent = dollarsSpentInFrance * 0.862028;
        remainingEuros = totalEuros - euroSpent;

        System.out.print("Dollars Spent in France: " + dollarsSpentInFrance);
        System.out.println("       Euros Spent = " + euroSpent + " euros");
        System.out.println();
        
        //Back Home
        System.out.println("Back to US:");
        
        remainingDollars = remainingEuros / 0.862028;
        System.out.println("Returned with = " + remainingDollars + " American Dollars");
        
            
    } // end of main method
} // end of class     
