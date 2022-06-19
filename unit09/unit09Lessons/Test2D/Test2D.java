
/**
 * Write a description of class test2D here.
 * 
 * FLVS 2009
 * @author R. Enger 
 * @version 5/31/2009
 */
public class Test2D
{
    static final int ROWS = 5;
    static final int COLS = 5;

    public static void curveTest(Integer[][] scores, int testNum, int value)
    {
        int col = testNum -1;
        for(int row = 0; row < ROWS; row++)
        {
            scores[row][col] += 5;
        }
      
    }
    public static void printScores(Integer[][] scores)
    {
        for(int row = 0; row < ROWS; row ++)
         {
           for(int col = 0; col < COLS; col ++)
           {
             System.out.print(scores[row][col] + " ");
           }
           System.out.println();
        }
      
    }



    public static void main(String[] args)
    {
        //Integer[] testScores = new Integer[ROWS][COLS];
        Integer [][] testScores = {  {98,  100, 75, 89,  77},
                                   {100,   95, 97, 85,  80},
                                    {67,   77, 79, 80,	89},
                                    {100,  99, 95, 87,	95},
                                    {100,  95, 90, 85, 100} };
    
         System.out.println("Original table of scores: ");
         printScores(testScores);
         System.out.println();
         System.out.println();
         curveTest(testScores, 4, 5);
         System.out.println("Table of scores after curving Test 4 by 5 pts: ");
         printScores(testScores);
         System.out.println();
    }

}
