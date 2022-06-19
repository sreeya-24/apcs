
/**
 * This class extends from the Homework2 class and implements processing.
 *
 * @author Sreeya Gambhirrao
 * @version 04/17/2022
 */
public class MyScience2 extends Homework2 implements Processing
{
    /**
     * Constructor for objects of class MyScience2
     */
    public MyScience2()
    {
        // initialise instance variables
        super();
    }

    public void createAssignment(int p)
    {
        setPagesRead(p);
        setType("Science");
    }
    
    public String toString()
    {
        return getType() + " - Must Read " + getPagesRead() + " pages.";
    }
    
    public void doReading()
    {
        System.out.println("Before Reading:");
        System.out.println(toString());
        System.out.println("After Reading:");
        int x = getPagesRead() - 3;
        System.out.println(getType() + " - Must Read " + x + " pages");
    }
}
