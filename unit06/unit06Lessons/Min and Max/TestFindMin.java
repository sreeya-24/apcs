
/**
 * TestFindMin.
 * 
 * FLVS 2009
 * @author R. Enger 
 * @version 5/23/2009
 */

public class TestFindMin
{
    public static void main(String[] args)
    {
        
        Integer[] numbers = {3, 99, -1, 5, -10};

        Integer min = Integer.MAX_VALUE;
        
        for(int i = 0; i < numbers.length; i ++)
        {
            if (numbers[i] < min)
                min = numbers[i];
        }

        System.out.println("Minimum value is " + min);
       
    }
    
}

