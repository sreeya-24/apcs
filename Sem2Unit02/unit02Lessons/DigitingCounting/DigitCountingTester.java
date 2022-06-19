
/**
 * Write a description of class DigitCountingTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class DigitCounting
{
    DigitCounting()
    {
        
    }
    
    public int numOfDigits(int num)
    {
        if(num <= 9)
        {
            return 1;
        } else 
        {
            return 1 + numOfDigits(num/10);
        }
    }
}

public class DigitCountingTester
{
    public static void main(String[] args)
    {
        DigitCounting digits = new DigitCounting();
        
        int nOfDigits = digits.numOfDigits(43125);
        System.out.println("Number of Digits: " + nOfDigits);
    }
}
