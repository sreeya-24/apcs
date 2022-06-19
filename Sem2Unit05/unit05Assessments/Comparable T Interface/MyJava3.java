
/**
 * This is a child class of Homework class.
 *
 * @author Sreeya Gambhirrao
 * @version 04/18/2022
 */
public class MyJava3 extends Homework3
{
    /**
     * Constructor for objects of class MyJava3
     */
    public MyJava3()
    {
        // initialise instance variables
        super();
    }

    public void createAssignment(int p)
    {
        setPagesRead(p);
        setType("Java");
    }
    
    public String toString()
    {
        return getType() + " - Must Read " + getPagesRead() + " pages.";
    }
}
