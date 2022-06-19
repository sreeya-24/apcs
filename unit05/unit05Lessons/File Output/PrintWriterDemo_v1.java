
/**
 * Write a description of class PrintWriterDemo_v1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
public class PrintWriterDemo_v1
{
   public static void main(String[] args) throws IOException
   {
       PrintWriter outFile = new PrintWriter (new File("helloWorld.txt"));
       double randNum;
       //Random randNum = new Random() * 100;
       for(int loop = 0; loop <= 10; loop++)
       {
           randNum = Math.random() * 1000;
           outFile.println(randNum + " Hello World Sreeya");
       }
       outFile.close();
       
   }
}
