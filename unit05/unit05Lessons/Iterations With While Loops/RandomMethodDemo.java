
/**
 * Write a description of class RandomMethodDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class RandomMethodDemo
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        double randomNumber;
        int counter2 = 0;
System.out.println("Please enter the number of times random number generator should generate: ");
int counter = in.nextInt();

 while(counter2 <= counter)
 {
 randomNumber = Math.random();
 System.out.println(randomNumber);
 counter2 ++;
 }
 } 
 }

