 

/**
 * Demonstrates Selection Sort on an array of integers.
 */
public class SelectionSort {
    private DynamicArrayChart chart;
        
    public SelectionSort() {
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
        DynamicArrayChart obj1 = new DynamicArrayChart("Selection Sort", intArray, false, 800);
     
        /* Set array to null. */
        for(int i=0; i<intArray.length; i++){
            intArray[i] = -1;
        }
     
        /* Call the runSort() method. */
        
        //obj1.runSort(intArray);
    }
    
    public void runSort(int[] array) {
        /* Implement the Selection Sort algorithm.
         * All queries and modifications to the original array can be done with
         * method calls on the chart object. */
        
        for(int i = 0; i < array.length-1; i++)
        {
            int index = i;
            
            for(int j = i +1; j< array.length; j++)
            {
                if(array[j] < array[index])
                {
                    index = j;
                }
            }
            
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }

    }
    
    public static void main(String[] args) {
        new SelectionSort();
    }
}
