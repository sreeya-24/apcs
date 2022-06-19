
/**
 * This program prints the ASCII characters that correspond to ASCII values, and
 * prints the ASCII values that correspond to specific ASCII characters.
 * 
 * Notice that (int) is used to cast a character literal to its corresponding ASCII value, and
 * that (char) is used to cast an ASCII value to its corresponding character literal.
 * 
 * FLVS 2007
 * @author B. Jordan
 * @version 01/19/07
 */
public class ShowASCII
{
    public static void main(String[ ] args)
    {   
        //cast a character literal to its integer ASCII value
        /*System.out.println("The ASCII code for " + 'A' + " is " + (int)'A');
        System.out.println("The ASCII code for " + '9' + " is " + (int)'9');
        System.out.println();
        System.out.println("The ASCII code for " + '8' + " is " + (int)'8');
        System.out.println("The ASCII code for " + '2' + " is " + (int)'2');
        
        System.out.println("******************");
        char letterA = 'A';
        char aDash = '-';
        char blankSpace = ' '; //there is a blank space between quotes
        char eighthDigit = '8';
        System.out.println(letterA);
        System.out.println("The ASCII code for " + 'A' + " is " + (int)'A');
        System.out.println("The ASCII code for " + '-' + " is " + (int)'-');
        System.out.println("The ASCII code for " + ' ' + " is " + (int)' ');
        System.out.println("The ASCII code for " + '8' + " is " + (int)'8');
        System.out.println('A'+'B');
        System.out.println("******************");
        */
        //cast an integer ASCII value to its corresponding character literal
        System.out.println("48 is the ASCII code for " + (char)48);
        System.out.println("57 is the ASCII code for " + (char)57);
        System.out.println("65 is the ASCII code for " + (char)65);
        System.out.println();
        
    }//end of main method
}//end of class
