 

/**
 * Provides iterative and recursive methods for a variety of uses.
 */
public class Util {
    /**
     * Calculates the factorial of a number iteratively.
     * @param n Number to be processed.
     * @return Factorial of number specified.
     */
    public static long iterativeFactorial(int n) {
        /* Add code here. Fix placeholder return statement. */
        int fact = 1;
        for(int i = 1; i <= n; i++)
        {
            fact = fact * i;
        }
        return fact;
    }
    
    /**
     * Calculates the factorial of a number recursively.
     * @param n Number to be processed.
     * @return Factorial of number specified.
     */
    public static long recursiveFactorial(int n) throws IllegalArgumentException {
        /* Add code here. Fix placeholder return statement. */
        if(n < 0)
        {
            throw new IllegalArgumentException();
        }else if(n == 0)
        {
            return 1;
        } else
        {
            return(n * recursiveFactorial(n-1));
        }
    }
    
    /**
     * Calculates the sum of the digits in a number iteratively.
     * @param n Number to be processed.
     * @return Sum of the number's digits.
     */
    public static int iterativeDigitSum(long n) {
        /* Add code here. Fix placeholder return statement. */
        int sum = 0;
        while(n!=0)
        {
            n = n/10;
            sum = sum + (int)n % 10;
        }
        
        return sum;
    }
    
    /**
     * Calculates the sum of the digits in a number recursively.
     * @param n Number to be processed.
     * @return Sum of the number's digits.
     */
    public static int recursiveDigitSum(long n) {
        /* Add code here. Fix placeholder return statement. */
        if(n == 0)
        {
            return 0;
        } else
        {
            return ((int)n % 10 + recursiveDigitSum((int)n/10));
        }
    }
    
    /**
     * Calculates the nth value of the modern Fibonacci sequence iteratively.
     * @param n Index of the Fibonacci sequence to be calculated.
     * @return The value at index n of the Fibonacci sequence.
     */
    public static int iterativeFibonacci(int n) {
        /* Add code here. Fix placeholder return statement. */
        if(n<=1)
        {
            return n;
        } 
        
        int fib = 1;
        int prevFib =1; 
        
        for(int i = 2; i < n; i++)
        {
            int temp = fib;
            fib+=prevFib;
            prevFib = temp;
        }
        
        return fib;
    }
    
    /**
     * Calculates the nth value of the modern Fibonacci sequence recursively.
     * @param n Index of the Fibonacci sequence to be calculated.
     * @return The value at index n of the Fibonacci sequence.
     */
    public static long recursiveFibonacci(int n) {
        /* Add code here. Fix placeholder return statement. */
        if( n<= 1)
        {
            return n;
        } else 
        {
            return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
        }
    }
    
    /**
     * Iteratively generates a string made of n copies of a supplied input 
     * string separated by a comma and a space. 
     * @param inputString String to be repeated.
     * @param count Number of times to repeat the input string.
     * @return New constructed string.
     */
    public static String iterativeStringGen(String inputString, int count) {
        /* Add code here. Fix placeholder return statement. */
        String repeatedString = "";
        while(count > 0)
        {
            repeatedString += inputString;
            count--;
        }
        return repeatedString;
    }

    /**
     * Recursively generates a string made of n copies of a supplied input 
     * string separated by a comma and a space. 
     * @param inputString String to be repeated.
     * @param count Number of times to repeat the input string.
     * @return New constructed string.
     */
    public static String recursiveStringGen(String inputString, int count) {
        /* Add code here. Fix placeholder return statement. */
        if(count < 0)
        {
            return "";
        } else if(count == 1)
        {
            return inputString;
        } else
        {
            return inputString + recursiveStringGen(inputString, count - 1);
        }
        
    }
    
    /**
     * Calculates the sum of all numbers in an array iteratively.
     * @param array Array to be processed.
     * @return Sum of elements in the array.
     */
    public static long iterativeArraySum(int[] array) {
        /* Add code here. Fix placeholder return statement. */
        int element = 0;
        for(int i = 0; i < array.length; i++)
        {
            element = array[i];
        }
        element =+ element;
        
        return element;
        
    }
    
    /**
     * Calculates the sum of all numbers in an array recursively.
     * @param array Array to be processed.
     * @return Sum of elements in the array.
     */
    public static long recursiveArraySum(int[] array) {
        return recursiveArraySumHelper(array, 0);
    }
    
    /**
     * Provides the recursive processing needed by recursiveArraySum().
     * @param array Array to be processed.
     * @param index Current index being processed.
     * @return Sum of elements in the array.
     */
    private static long recursiveArraySumHelper(int[] array, int index) {
        /* Add code here. Fix placeholder return statement. */
        if(index >= array.length)
        {
            return 0;
        } else
        {
            return recursiveArraySumHelper(array,index) + recursiveArraySumHelper(array,index + 1);
        }
    }
    
    /**
     * Iteratively counts the number of even numbers in an array.
     * @param array Array to be processed.
     * @return Number of even numbers in the array.
     */
    public static int iterativeCountOnlyEvens(int[] array) {
        /* Add code here. Fix placeholder return statement. */
        int size = 0;
        int evenCount = 0;
        for(int i = 0; i < size; i++)
        {
            if(array[i] % 2 == 0)
            {
                evenCount++;
            }
        }
        return evenCount;
    }
    
    /**
     * Recursively counts the number of even numbers in an array.
     * @param array Array to be processed.
     * @return Number of even numbers in the array.
     */
    public static int recursiveCountOnlyEvens(int[] array) {
        return recursiveCountOnlyEvensHelper(array, 0);
    }
    
    /**
     * Provides the recursive processing needed by recursiveCountOnlyEvens().
     * @param array Array to be processed.
     * @param index Current index being processed.
     * @return Sum of elements in the array.
     */
    private static int recursiveCountOnlyEvensHelper(int[] array, int index) {
        /* Add code here. Fix placeholder return statement. */
        if(index >= array.length)
        {
            return 0;
        } else if(array[index]%2 == 0)
        {
            return 1 + recursiveCountOnlyEvensHelper(array,index+1);
        } 
        
        return 1 + recursiveCountOnlyEvensHelper(array,index+1);
    }
}
