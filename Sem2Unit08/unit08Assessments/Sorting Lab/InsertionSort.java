 

/**
 * Demonstrates Insertion Sort on an array of integers.
 */
public class InsertionSort {
    private DynamicArrayChart chart;
    
    public InsertionSort() {
        /* Create an array of integers named array with 1-20 elements. 
         * Element values must be from 1-50. */
        int[] intArray = new int[20];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        intArray[3] = 4;
        intArray[4] = 5;
        intArray[5] = 6;
        intArray[6] = 7;
        intArray[7] = 8;
        intArray[8] = 9;
        intArray[9] = 10;
        intArray[10] = 11;
        intArray[11] = 12;
        intArray[12] = 13;
        intArray[13] = 14;
        intArray[14] = 15;
        intArray[15] = 16;
        intArray[16] = 17;
        intArray[17] = 18;
        intArray[18] = 19;
        intArray[19] = 20;
        intArray[20] = 21;
     
        /* Create a new DynamicArrayChart and assign it to variable chart. */
        DynamicArrayChart obj1 = new DynamicArrayChart("Insertion Sort", intArray, true, 800);
     
     
        /* Set array to null. */
        for(int i=0; i<intArray.length; i++){
            intArray[i] = -1;
        }
     
        /* Call the runSort() method. */
        
        //obj1.runSort(intArray);
    }
    
    private void runSort(int[] array) {
        /* Implement the Insertion Sort algorithm.
         * All queries and modifications to the original array can be done with
         * method calls on the chart object. */
        
        int n = array.length;
         
        for(int i = 1; i < n; i++)
        {
            int key = array[i];
            int j = i -1;
            
            while((j > -1) && (array[j] > key))
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
    
    public static void main(String[] args) {
        new InsertionSort();
    }
}
