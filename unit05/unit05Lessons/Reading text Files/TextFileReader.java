import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class TextFileReader
{
   public static void main(String[] args) throws IOException
   {
      String token = "";
      int sumOfToken = 0;
      Scanner inFile = new Scanner(new File("data1.txt"));
      while (inFile.hasNextInt())
      {
         token = inFile.next();
         //sumOfToken = sumOfToken + Integer.parseInt(token);
         System.out.println (token);
      }
      inFile.close();
      //System.out.println("Sum of token = " + sumOfToken);
    }//end of main method
}//end of class 