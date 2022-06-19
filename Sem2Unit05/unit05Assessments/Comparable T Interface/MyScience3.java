
/**
 * This is a child class of Homework class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/18/2022
 */
public class MyScience3 extends Homework3
{
    /**
     * Constructor for objects of class MyScience3
     */
    public MyScience3()
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
}
