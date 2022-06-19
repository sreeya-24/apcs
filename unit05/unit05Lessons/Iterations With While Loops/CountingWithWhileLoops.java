
/**
 * Write a description of class CountingWithWhileLoops here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CountingWithWhileLoops
{
    public static void main(String [] args)
    {
        int counter = -2;
        int theTerminator = 10;
        
        while(counter <= theTerminator)
        {
            System.out.println("counter = " + counter);
            counter++;
        }
    }
}
