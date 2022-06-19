
/**
 * The purpose of this program is to illustrate the use of the for loop
 * as a counter.
 * 
 * FLVS 2007
 * @author B. Jordan 
 * @version 04/02/2007
 */
public class CountingWithForLoops
{
    public static void main(String [] args)
    {
        int theTerminator = 990;   //initialize the terminating condition
        int count = 1;
        
        for(int counter = 99; count <=20; counter=counter+99)     //test the terminating condition
        {
            System.out.println("99 * " + count + " = " + counter);
            count++;
            
        }//end of for loop  
    }//end of main method
}//end of class
