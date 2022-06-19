
/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * FLVS 2021
 * @author Sreeya Gambhirrao
 * @version 10/10/2021
 */
public class CalculationsV5
{
    public static void main(String[ ] args)
    {
        // Addition
        int iNum1 = 4;
        int iNum2 = 8;
        System.out.println("Addition");
        System.out.print(iNum1 + " plus " + iNum2 + " = ");
        System.out.println(iNum1 + iNum2);
        
        double dNum1 = 23.51;
        double dNum2 = 8.9325;
        System.out.print(dNum1 + " plus " + dNum2 + " = ");
        System.out.println(dNum1 + dNum2);
        System.out.println();
        
        // Subtraction
        iNum1 = 9;
        iNum2 = 33;
        System.out.println("Subtraction");
        System.out.print(iNum1 + " minus " + iNum2 + " = ");
        System.out.println(iNum1 - iNum2);
        
        dNum1 = 98.6;
        dNum2 = 47.0038;
        System.out.print(dNum1 + " minus " + dNum2 + " = ");
        System.out.println(dNum1 - dNum2);
        System.out.println();
        
        // Multiplication
        iNum1 = 15;
        iNum2 = 3;
        int iNum3 = 201;
        System.out.println("Multiplication");
        System.out.print(iNum1 + " times " + iNum2 + " times " + iNum3 + " = "); 
        System.out.println(iNum1 * iNum2 * iNum3);
        
        dNum1 = 3.14;
        dNum2 = 5.0;
        double dNum3 = 5.0;
        System.out.print(dNum1 + " times " + dNum2 + " times " + dNum3 + " = ");
        System.out.println(dNum1 * dNum2 * dNum3);
        System.out.println();
        
        // Division
        iNum1 = 48;
        iNum2 = 8;
        System.out.println("Division");
        System.out.print(iNum1 + " divided by " + iNum2 + " = ");
        System.out.println(iNum1/iNum2);
        
        dNum1 = 212.0;
        dNum2 = 32.0;
        System.out.print(dNum1 + " divided by " + dNum2 + " = ");
        System.out.println(dNum1 / dNum2);
        System.out.println();
         
        // Modulus operator
        iNum1 = 23;
        iNum2 = 15;
        System.out.println("Modulus");
        System.out.print(iNum1 + " modulus " + iNum2 + " = ");
        System.out.println(iNum1 % iNum2);
        
        dNum1 = 3298.7;
        dNum2 = 243.1;
        System.out.print(dNum1 + " modulus " + dNum2 + " = ");
        System.out.println(dNum1 % dNum2);
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
