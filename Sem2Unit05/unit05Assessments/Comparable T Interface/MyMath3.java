
/**
 * This is a child class of Homework class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/18/2022
 */
public class MyMath3 extends Homework3
{
        /**
     * Constructor for objects of class MyMath3
     */
    public MyMath3()
    {
        // initialise instance variables
        super();
    }

    public void createAssignment(int p)
    {
        setPagesRead(p);
        setType("Math");
    }
    
    public String toString()
    {
        return getType() + " - Must Read " + getPagesRead() + " pages.";
    }
}
