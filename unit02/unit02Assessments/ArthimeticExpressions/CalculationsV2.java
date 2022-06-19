
/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * 
 * @author Sreeya Gambhirrao
 * @version 10/3/21
 */
public class CalculationsV2
{
    public static void main(String[ ] args)
    {
        // Addition
        System.out.println("4 + 8 = " + (4+8));
        //System.out.println(4 + 8);
        
        System.out.println("23.51 + 8.9325 = " + ( 23.51 + 8.9325));
        System.out.println();
        
        // Subtraction
        System.out.println("9 - 33 = " + (9-33));
        //System.out.println(9 - 33);
        System.out.println("98.6 - 47.0038 = " + (98.6 - 47.0038));
        System.out.println();
        
        // Multiplication
        System.out.println("15 * 3 * 201 = " + (15 * 3* 201));
        //System.out.println(15 * 3 * 201); 
        System.out.println("3.14 * 5.0 * 5.0 = " + (3.14 * 5.0 * 5.0));
        System.out.println();
        
        // Division
        System.out.println("48/8 = " + (48/8));
        //System.out.println(48 / 8);
        System.out.println("212.0 / 32.0 = " + (212.0 / 32.0));
        System.out.println();
         
        // Modulus operator
        System.out.println("23 % 15 = " + (23 % 15));
        //System.out.println(23 % 15);
        System.out.println("3298.7 % 243.1 = " + (3298.7 % 243.1));
        System.out.println();
        
        // Word Problems
        System.out.println("15 divided by 2.5 times -2 plus 10 / 5 = " + ((15/2.5)*-2 +(10/5)));
        //System.out.println((15/2.5)*-2 +(10/5));
        System.out.println();
        
        System.out.println("234 minus (234 divided by 6 modulus 12) + 3 = " +(234-(234/6%12)+3));
        //System.out.println(234-(234/6%12)+3);
        System.out.println();
        
        System.out.println("(46.2 divided by 11) minus 3 plus 24 modulus (17 minus 2 times 3) = " + ((46.2/11)-3+24%(17-2*3)));
        //System.out.println((46.2/11)-3+24%(17-2*3));
        System.out.println();
        
        System.out.println("480 divided by 10 divided by 12 plus 200 *.5 minus 20 modulus 8 = " + (480/10/12+200*0.5-20%8));
        //System.out.println(480/10/12+200*0.5-20%8);
        System.out.println();
               
    } // end of main method
} // end of class
