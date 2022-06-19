
/**
 * This function calculates three different piecewise calculations using the recursive method.
 *
 * @author Sreeya Gambhirrao
 * @version 2/13/2022
 */
class Recursions
{
    //Constructor
    Recursions()
    { 
    }
    
    //Calculations Methods
     /**
     * This method calculates the first piecewise function.
     *
     * @param  x 
     * @return the function and -7
     */
    public int fOfCalc1(int x)
    {
        if(x<=10)
        {
            System.out.println(x + " <= 10, therefore... f(" + x + ") = -7");
            return -7;
        } else
        {
           System.out.println(x + " > 10, therefore... f(" + x + ") = f(" + x + "-4) + 2 = f(" + (x - 4) + ") + 2"); 
           return fOfCalc1(x-4) + 2;
        }
    }
    
    /**
     * This method calculates the second piecewise function.
     *
     * @param  x 
     * @return the function and 20
     */
    public int fOfCalc2(int x)
    {
        if(x<=25)
        {
            System.out.println(x + " <= 25, therefore... f(" + x + ") = 20");
            return 20;
        } else
        {
           System.out.println(x + " > 25, therefore... f(" + x + ") = f(" + x + "/12 + 5) - 3 = f(" + (x/12 + 5) + ") - 3"); 
           return fOfCalc2((x/12)+5) - 3;
        }
    }
    
    /**
     * This method calculates the fourth piecewise function.
     *
     * @param  x 
     * @return the function and -100
     */
    public int fOfCalc3(int x)
    {
        if(x>20)
        {
            System.out.println(x + " > 20, therefore... f(" + x + ") = -100");
            return -100;
        } else
        {
           System.out.println(x + " <= 20, therefore... f(" + x + ") = f(" + x + "* 2) - 4 = f(" + (x * 2) + ") - 4"); 
           return fOfCalc3(x*2) - 4;
        }
    }
}

//main method
public class RecursionsTester
{
    public static void main(String[] args)
    {
        //Declaration of variable
        int x;
        
        //Create new object
        Recursions recursiveCalcs = new Recursions();
        
        //Call methods and print them
        x = 25;
        System.out.println("Problem 1:  x = " + x);
        System.out.println("f(" + x + ") = " + recursiveCalcs.fOfCalc1(x));
        System.out.println();
        
        x = 30;
        System.out.println("Problem 2:  x = " + x);
        System.out.println("f(" + x + ") = " + recursiveCalcs.fOfCalc2(x));
        System.out.println();
        
        x = 500;
        System.out.println("Problem 3:  x = " + x);
        System.out.println("f(" + x + ") = " + recursiveCalcs.fOfCalc3(x));
        System.out.println();
    }
}
