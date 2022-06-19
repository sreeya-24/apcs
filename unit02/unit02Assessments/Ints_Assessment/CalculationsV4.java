
/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * FLVS 2021
 * @author Sreeya Gambhirrao
 * @version 10/10/2021
 */
public class CalculationsV4
{
    public static void main(String[ ] args)
    {
        // Addition
        int iNum1 = 4;
        int iNum2 = 8;
        System.out.println("Addition");
        System.out.print(iNum1 + " plus " + iNum2 + " = ");
        System.out.println(iNum1 + iNum2);
        System.out.println(23.51 + 8.9325);
        System.out.println();
        
        // Subtraction
        iNum1 = 9;
        iNum2 = 33;
        System.out.println("Subtraction");
        System.out.print(iNum1 + " minus " + iNum2 + " = ");
        System.out.println(iNum1 - iNum2);
        System.out.println(98.6 - 47.0038);
        System.out.println();
        
        // Multiplication
        iNum1 = 15;
        iNum2 = 3;
        int iNum3 = 201;
        System.out.println("Multiplication");
        System.out.print(iNum1 + " times " + iNum2 + " times " + iNum3 + " = "); 
        System.out.println(iNum1 * iNum2 * iNum3);
        System.out.println(3.14 * 5.0 * 5.0);
        System.out.println();
        
        // Division
        iNum1 = 48;
        iNum2 = 8;
        System.out.println("Division");
        System.out.print(iNum1 + " divided by " + iNum2 + " = ");
        System.out.println(iNum1/iNum2);
        System.out.println(212.0 / 32.0);
        System.out.println();
         
        // Modulus operator
        iNum1 = 23;
        iNum2 = 15;
        System.out.println("Modulus");
        System.out.print(iNum1 + " modulus " + iNum2 + " = ");
        System.out.println(iNum1 % iNum2);
        System.out.println(3298.7 % 243.1);
        System.out.println();
        
        
        iNum1 = 50;
        iNum2 = 5;
        iNum3 = 2;
        int iNum4 = 10;
        System.out.print(iNum1 + " divided by " + iNum2 + " times " + iNum3 + " plus " + iNum4 + " = ");
        System.out.println(iNum1 / iNum2 * iNum3 + iNum4);
        
        iNum1 = 20;
        iNum2 = 2;
        iNum3 = 5;
        iNum4 = 2;
        System.out.print(iNum1 + " times " + iNum2 + " minus " + iNum3 + " modulus " + iNum4 + " = ");
        System.out.println(iNum1 * iNum2 - iNum3 % iNum4);
        
        
               
    } // end of main method
} // end of class