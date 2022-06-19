
/**
 * This program prompts the user to enter a positive integer value and calculates the 
 * fibonacci value.
 *
 * @author Sreeya Gambhirrao
 * @version 2/19/2022
 */

import java.util.Scanner;
class Fibonacci
{
    Fibonacci()
    {
    }
    
    //Calculations Method
    /**
     * 
     * @return the function, 0, and 1
     */
    public int fOfFibonacci(int x)
    {
        if(x == 0)
        {
            return 0;
        } else if(x == 1)
        {
           return 1; 
        } else
        {
            return fOfFibonacci(x-1)+fOfFibonacci(x-2);
        } 
    }
}


public class FibonacciNumbers
{
    public static void main(String[] args)
    {
        Scanner in;
        in = new Scanner(System.in);
        
        String choice = "C";
        int intValue;
        int fibonacciValue;
        
        while (choice.equalsIgnoreCase("C")) {
            System.out.print("Please enter an integer value to calculate Fibonacci:  ");
            intValue = in.nextInt();
            
            if (intValue > 0) {
                Fibonacci fiboObject = new Fibonacci();
                fibonacciValue = fiboObject.fOfFibonacci(intValue);
                
                System.out.println("Fibonacci Value: " + fibonacciValue);
                System.out.println();
            } else {
                System.out.println("You entered invalid number. Please enter a positive number.");
            }
                
            System.out.println("[C] Do you want continue?");
            System.out.println("[Q] Quit");    
            choice = in.next();
        }
        
        System.out.println("Qutting now, come back if you need more fibonacci!");
    }
}
