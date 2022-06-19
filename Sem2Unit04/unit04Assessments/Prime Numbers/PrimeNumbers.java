
/**
 * This program asks the user to enter a number and calculates the prime numbers from 1 to that number.
 *
 * @author Sreeya Gambhirrao
 * @version 04/16/2022
 */
public class PrimeNumbers
{
    // instance variables - replace the example below with your own
    private int upperLimit;

    /**
     * Constructor for objects of class PrimeNumbers
     */
    public PrimeNumbers(int limit)
    {
        // initialise instance variables
        upperLimit = limit;
    }
    
    public int getLimit()
    {
        return upperLimit;
    }
    
    public String calcPrime()
    {
        String primeNumbers = "";
        int num = 0;
        for(int i = 0; i <= getLimit(); i++)
        {
            int counter = 0;
            
            for(num = i; num >= 1; num--)
            {
                if(i%num == 0)
                {
                    counter += 1;
                }
            }
            
            if(counter == 2)
            {
                primeNumbers = primeNumbers + i + " ";
            }
        }
        
        return primeNumbers;
    }
}
